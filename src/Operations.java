import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Operations {

    public static int[] getData(String fileName){
        try{
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            List<Integer> salaries = new ArrayList<>();

            reader.readLine();

            String line;
            while ((line = reader.readLine()) != null){
                String[] splitted = line.split(",");
                salaries.add(Integer.parseInt(splitted[6]));
            }

            int[] resultArray = salaries.stream().mapToInt(Integer::intValue).toArray();
            return resultArray;


        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void reverseArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static int findMax(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array must not be empty or null");
        }

        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        return max;
    }



}
