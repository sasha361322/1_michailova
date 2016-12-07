import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {

    public static void worst(List<Integer> arr){
        int max=0,length=0;
        for (int i=0; i < arr.size(); i++){
            for (int j=i; j < arr.size(); j++){
                int tmp_max=0,tmp_length=0;
                for (int k = i; k <= j; k++ ){
                    tmp_max += arr.get(k);
                    tmp_length++;
                }
                if ((tmp_max>max)||((tmp_max==max)&&(tmp_length<length))){
                    max = tmp_max;
                    length = tmp_length;
                }
            }
        }
        if (max!=0)
            System.out.println("max = "+max+" length = "+length);
        else
            System.out.println("Положительных чисел нет");
    }

    public static void middle(List<Integer> arr){
        int max=0,length=0;
        for (int i=0; i < arr.size(); i++){
            int tmp_max=0,tmp_length=0;
            for (int j=i; j < arr.size(); j++){
                tmp_max += arr.get(j);
                tmp_length++;
                if ((tmp_max>max)||((tmp_max==max)&&(tmp_length<length))){
                    max = tmp_max;
                    length = tmp_length;
                }
            }
        }
        if (max!=0)
            System.out.println("max = "+max+" length = "+length);
        else
            System.out.println("Положительных чисел нет");
    }

    public static void best(List<Integer> arr){
        int temp_max=0, temp_length=0, max=0,length=0;
        for (int current:arr){
            temp_max+=current;
            if (temp_max<=0){
                temp_max = 0;
                temp_length = 0;
            }
            else{
                temp_length++;
            }
            if (temp_max>max){
                max=temp_max;
                length = temp_length;
            }
            else if ((temp_max == max)&&(temp_length<length)){
                max=temp_max;
                length = temp_length;
            }
        }
        if (max!=0)
            System.out.println("max = "+max+" length = "+length);
        else
            System.out.println("Положительных чисел нет");
    }

    public static void main(String[] args) {
        Scanner in = null;
        try {
            in = new Scanner(new File("test.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<Integer> arr = new ArrayList<Integer>();
        while (in.hasNext()){
            arr.add(in.nextInt());
        }
        worst(arr);
        middle(arr);
        best(arr);
    }
}