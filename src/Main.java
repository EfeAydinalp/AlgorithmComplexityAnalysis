import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler;
import sun.awt.windows.WPrinterJob;
import java.util.Random;
import java.io.IOException;
import java.sql.SQLOutput;
import java.text.DecimalFormat;
import java.util.Arrays;

class Main {
    public static void main(String args[]) throws IOException {

        int[] dataset = Operations.getData("C:\\Users\\Acer\\Desktop\\BBM204 AS1\\TrafficFlowDataset.csv");

        int[] sorted_dataset = Arrays.copyOfRange(dataset,0,dataset.length-1);
        Sorting.mergeSort(sorted_dataset);

        int[] reverse_dataset = Arrays.copyOfRange(sorted_dataset,0,dataset.length-1);
        Operations.reverseArray(reverse_dataset);

        // X axis data
        int[] inputAxis = {500, 1000, 2000, 4000, 8000, 16000, 32000, 64000, 128000, 250000};

        // Create sample data for linear runtime
        double[][] yAxis_Random = new double[3][10];
        double[][] yAxis_Sorted = new double[3][10];
        double[][] yAxis_Reverse = new double[3][10];
        double[][] yAxis_Search = new double[3][10];

        //insertion sort
        //yAxis[1] = new double[]{500, 1000, 2000, 4000, 8000, 16000, 32000, 64000, 128000, 250000};

        int count = 0;
        double time;

        for(int n : inputAxis){
            time = 0.0;

            for(int i = 0;i < 10;i++){
                int[] test_dataset = Arrays.copyOfRange(dataset,0,n);

                long startTime = System.currentTimeMillis();
                Sorting.insertionSort(test_dataset);
                long endTime = System.currentTimeMillis();

                time += endTime-startTime;
            }

            yAxis_Random[0][count] = time / 10;
            System.out.println("Insertion- Random:    " + n + ": " + yAxis_Random[0][count]  );
            count++;
        }

        count = 0;

        for(int n : inputAxis){
            time = 0.0;

            for(int i = 0;i < 10;i++){
                int[] test_dataset = Arrays.copyOfRange(sorted_dataset,0,n);

                long startTime = System.currentTimeMillis();
                Sorting.insertionSort(test_dataset);
                long endTime = System.currentTimeMillis();

                time += endTime-startTime;
            }

            yAxis_Sorted[0][count] = time / 10;
            System.out.println("Insertion- Sorted:    " + n + ": " + yAxis_Sorted[0][count]  );
            count++;
        }

        count = 0;

        for(int n : inputAxis){
            time = 0.0;

            for(int i = 0;i < 10;i++){
                int[] test_dataset = Arrays.copyOfRange(reverse_dataset,0,n);

                long startTime = System.currentTimeMillis();
                Sorting.insertionSort(test_dataset);
                long endTime = System.currentTimeMillis();

                time += endTime-startTime;
            }

            yAxis_Reverse[0][count] = time / 10;
            System.out.println("Insertion- Reverse:    " + n + ": " + yAxis_Reverse[0][count]  );
            count++;
        }



        //merge sort
        //yAxis[0] = new double[]{300, 800, 1800, 3000, 7000, 15000, 31000, 64000, 121000, 231000};


        count=0;

        for(int n : inputAxis) {
            time = 0.0;

            for (int i = 0; i < 10; i++) {

                int[] test_dataset = Arrays.copyOfRange(dataset, 0, n);
                long startTime = System.currentTimeMillis();
                Sorting.mergeSort(test_dataset);
                long endTime = System.currentTimeMillis();
                //System.out.println(endTime-startTime);
                //System.out.println(time);
                time += endTime-startTime;
            }
            yAxis_Random[1][count] = time / 10;
            System.out.println("Merge- Random:    " + n + ": " + yAxis_Random[1][count]  );
            count++;
        }

        count=0;

        for(int n : inputAxis) {
            time = 0.0;

            for (int i = 0; i < 10; i++) {

                int[] test_dataset = Arrays.copyOfRange(sorted_dataset, 0, n);
                long startTime = System.currentTimeMillis();
                Sorting.mergeSort(test_dataset);
                long endTime = System.currentTimeMillis();
                //System.out.println(endTime-startTime);
                //System.out.println(time);
                time += endTime-startTime;
            }
            yAxis_Sorted[1][count] = time / 10;
            System.out.println("Merge- Sorted:    " + n + ": " + yAxis_Sorted[1][count]  );
            count++;
        }


        count=0;

        for(int n : inputAxis) {
            time = 0.0;

            for (int i = 0; i < 10; i++) {

                int[] test_dataset = Arrays.copyOfRange(reverse_dataset, 0, n);
                long startTime = System.currentTimeMillis();
                Sorting.mergeSort(test_dataset);
                long endTime = System.currentTimeMillis();
                //System.out.println(endTime-startTime);
                //System.out.println(time);
                time += endTime-startTime;
            }
            yAxis_Reverse[1][count] = time / 10;
            System.out.println("Merge- Reverse:    " + n + ": " + yAxis_Reverse[1][count]  );
            count++;
        }




        //counting sort
        //yAxis[2] = new double[]{300, 800, 1800, 3000, 7000, 15000, 31000, 64000, 121000, 231000};

        count=0;

        for(int n : inputAxis) {
            time = 0.0;

            //System.out.println("n =" + n );
            for (int i = 0; i < 10; i++) {
                int[] test_dataset = Arrays.copyOfRange(dataset, 0, n);

                long startTime = System.currentTimeMillis();
                Sorting.countingSort(test_dataset, Operations.findMax(test_dataset));
                long endTime = System.currentTimeMillis();

                //System.out.println("i =" + i);
                //System.out.println(endTime-startTime);


                time += endTime-startTime;
                //System.out.println(time);
            }
            yAxis_Random[2][count] = time/10;
            System.out.println("Counting- Random:    " + n + ": " + yAxis_Random[2][count]  );
            count++;
        }

        count=0;

        for(int n : inputAxis) {
            time = 0.0;

            //System.out.println("n =" + n );
            for (int i = 0; i < 10; i++) {
                int[] test_dataset = Arrays.copyOfRange(sorted_dataset, 0, n);

                long startTime = System.currentTimeMillis();
                Sorting.countingSort(test_dataset, Operations.findMax(test_dataset));
                long endTime = System.currentTimeMillis();

                //System.out.println("i =" + i);
                //System.out.println(endTime-startTime);


                time += endTime-startTime;
                //System.out.println(time);
            }
            yAxis_Sorted[2][count] = time/10;
            System.out.println("Counting- Sorted:    " + n + ": " + yAxis_Sorted[2][count]  );
            count++;
        }

        count=0;

        for(int n : inputAxis) {
            time = 0.0;

            //System.out.println("n =" + n );
            for (int i = 0; i < 10; i++) {
                int[] test_dataset = Arrays.copyOfRange(reverse_dataset, 0, n);

                long startTime = System.currentTimeMillis();
                Sorting.countingSort(test_dataset, Operations.findMax(test_dataset));
                long endTime = System.currentTimeMillis();

                //System.out.println("i =" + i);
                //System.out.println(endTime-startTime);


                time += endTime-startTime;
                //System.out.println(time);
            }
            yAxis_Reverse[2][count] = time/10;
            System.out.println("Counting- Reverse:    " + n + ": " + yAxis_Reverse[2][count]  );
            count++;
        }

        //Search Algos

        count=0;

        for(int n : inputAxis) {
            time = 0.0;

            //System.out.println("n =" + n );
            for (int i = 0; i < 1000; i++) {
                int[] test_dataset = Arrays.copyOfRange(dataset, 0, n);

                Random random = new Random();
                int randomNumber = random.nextInt(n-1);

                long startTime = System.nanoTime();
                SearchAlgorithms.linearSearch(test_dataset,test_dataset[randomNumber]);
                long endTime = System.nanoTime();

                time += endTime-startTime;

            }
            yAxis_Search[0][count] = time/1000;
            System.out.println("linearSearch- Random:    " + n + ": " + yAxis_Search[0][count]  );
            count++;
        }

        count=0;

        for(int n : inputAxis) {
            time = 0.0;

            //System.out.println("n =" + n );
            for (int i = 0; i < 1000; i++) {
                int[] test_dataset = Arrays.copyOfRange(sorted_dataset, 0, n);

                long startTime = System.nanoTime();

                Random random = new Random();
                int randomNumber = random.nextInt(n-1);
                SearchAlgorithms.linearSearch(test_dataset,test_dataset[randomNumber]);

                long endTime = System.nanoTime();

                time += endTime-startTime;

            }
            yAxis_Search[1][count] = time/1000;
            System.out.println("linearSearch- Sorted:    " + n + ": " + yAxis_Search[1][count]  );
            count++;
        }

        count=0;

        for(int n : inputAxis) {
            time = 0.0;

            for (int i = 0; i < 1000; i++) {
                int[] test_dataset = Arrays.copyOfRange(sorted_dataset, 0, n);



                long startTime = System.nanoTime();

                Random random = new Random();
                int randomNumber = random.nextInt(n-1);
                SearchAlgorithms.binarySearch(test_dataset,test_dataset[randomNumber]);

                long endTime = System.nanoTime();

                time += endTime-startTime;

            }
            yAxis_Search[2][count] = time/1000;
            System.out.println("linearSearch- Sorted:    " + n + ": " + yAxis_Search[2][count]  );
            count++;
        }


        // Save the char as .png and show it
        showAndSaveChart("Tests On Random Data", inputAxis, yAxis_Random,"Merge Sort","Insertion Sort","Counting Sort");
        showAndSaveChart("Tests On Sorted Data", inputAxis, yAxis_Sorted,"Merge Sort","Insertion Sort","Counting Sort");
        showAndSaveChart("Tests On Reversly Sorted Data", inputAxis, yAxis_Reverse,"Merge Sort","Insertion Sort","Counting Sort");
        showAndSaveChart("Searching Algorithm Test", inputAxis, yAxis_Search,"Linear search (random data)","Linear search (sorted data)","Binary search (sorted data)");

    }


    public static void showAndSaveChart(String title, int[] xAxis, double[][] yAxis, String Series1, String Series2, String Series3) throws IOException {
        // Create Chart
        XYChart chart = new XYChartBuilder().width(800).height(600).title(title)
                .yAxisTitle("Time in Milliseconds").xAxisTitle("Input Size").build();

        // Convert x axis to double[]
        double[] doubleX = Arrays.stream(xAxis).asDoubleStream().toArray();

        // Customize Chart
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNE);
        chart.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Line);

        // Add a plot for a sorting algorithm
        chart.addSeries(Series1, doubleX, yAxis[0]);
        chart.addSeries(Series2, doubleX, yAxis[1]);
        chart.addSeries(Series3, doubleX, yAxis[2]);

        // Save the chart as PNG
        BitmapEncoder.saveBitmap(chart, title + ".png", BitmapEncoder.BitmapFormat.PNG);

        // Show the chart
        new SwingWrapper(chart).displayChart();
    }
}
