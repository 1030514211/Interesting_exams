import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public  class Main{
    //有重复的数组转换成无重复的集合
    public static List<Integer> f(int[] str){
        List<Integer> list = new ArrayList<Integer>();
        for (int i=0; i<str.length; i++) {
            if(!list.contains(str[i])) 
                list.add(str[i]);
        }
        return list;
    }

    //最大值
    public static int getMax(int[] arr) {     
        int max = arr[0];  
        for (int x = 1; x < arr.length; x++) {  
            if (arr[x] > max)  
                max = arr[x];     
        }  
        return max;       
    } 

    public static void main(String[] args){
        Scanner in1 = new Scanner(System.in);
        while(in1.hasNextLine()){
            String arr1[] =in1.nextLine().split("\\s+");
            int[] num1 = new int[arr1.length];
            for(int i = 0 ;i<arr1.length;i++)
                num1[i] = Integer.parseInt(arr1[i]);
            List<Integer> list1 = f(num1);

            String arr2[] =in1.nextLine().split("\\s+");
            int[] num2 = new int[arr2.length];
            for(int i = 0 ;i<arr2.length;i++)
                num2[i] = Integer.parseInt(arr2[i]);

            if(arr1.length!=arr2.length){
                System.out.println("Input Error");
            }
            int len = list1.size();
            //票数vote，候选人ID是list1，权重quan
            int[] vote = new int[len];
            int[] quan = new int[len];
            for(int j = 0;j<list1.size();j++)
                for(int i = 0 ;i<arr1.length;i++){
                    if(num1[i]==list1.get(j)){
                        vote[j] +=1;
                        quan[j] += num2[i];
                    }
                }
            int max = getMax(quan);
            int voteMax =getMax(vote);
            int num11 = 0;
            int num22 = 0;
            for(int j = 0;j<list1.size();j++){
                if(quan[j]==max )
                    num11 +=1;
            if(vote[j]==voteMax )
                num22 +=1;}

            for(int i = 0;i<list1.size();i++){
                if(num11==1 && quan[i]== max ){
                    System.out.println(list1.get(i));
                    return;
                }
                if(num11 > 1){
                    if(num22 ==1 && vote[i]==voteMax)
                        System.out.println(list1.get(i));
                    else
                        System.out.println("No Winner");
                    return;
                }
            }
            System.out.println("No Winner");
        }
        in1.close();
    }   
}