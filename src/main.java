import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        Scanner in = null;
        try {
            in = new Scanner(new File("test.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<Integer> arr = new LinkedList<Integer>();
        while (in.hasNext()){
            arr.add(in.nextInt());
        }
        int max=0, length=0, temp_max=0, temp_length=0;
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
            else if ((temp_max == max)||(temp_length<length)){
                max=temp_max;
                length = temp_length;
            }
        }
        if (max!=0)
            System.out.println("max = "+max+" length = "+length);
        else
            System.out.println("Положительных чисел нет");
    }
}