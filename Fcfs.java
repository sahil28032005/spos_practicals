import java.util.Arrays;
import java.util.Comparator;

public class Fcfs {
    // calculating waiting time for each process in normal approch
    static void findWaitingTime(int n, int bt[], int wt[], int at[]) {
        wt[0] = 0;

        for (int i = 1; i < n; i++) {
            wt[i] = (wt[i - 1] + bt[i - 1]) - at[i];
        }
    }

    // find averageFinalResults for add
    static void finalAns(int n, int wt[], int bt[], int at[]) {
        // get waiting time for all process to be set

        // make empty array fir turnAround time of size n
        int tat[] = new int[n];
        findWaitingTime(n, bt, wt, at);

        // finding turnarounf tme for each process
        turnAround(n, bt, tat, wt);

        // try to print all values
        for (int i = 0; i < n; i++) {
            System.out.println("waiting time of process no i+1 is " + wt[i]);
        }

        // calculating average waiting time
        float awt = 0;
        for (int i = 0; i < n; i++) {
            awt += wt[i];
        }
        System.out.println("avg waiting time: " + awt / n);
    }

    // for calculating turnAriund time
    static void turnAround(int n, int bt[], int tat[], int wt[]) {
        // the idea is calculate as waiting time + execution time
        // tat-wt+bt

        for (int i = 0; i < n; i++) {
            tat[i] = wt[i] + bt[i];
        }

    }

    public static void main(String[] args) {
        System.out.println("this is testing");
        // define process with their burst time
        int n = 3;
        // int bt[] = { 24, 3, 4 };
        int bt[] = { 6, 2, 8, 3, 4 };
        int wt[] = new int[n];
        int tat[] = new int[n];
        int at[] = { 2, 5, 1, 0, 4 };

        int arr[][] = { { 24, 0 }, { 3, 0 }, { 4, 0 }};
       

        //tester arr
        int arrt[][] = { { 6, 2 }, { 2, 5 }, { 8, 1 }, { 3, 0 }, { 4, 4 } };
        new FcfsWithArrival().findWaitingTime(3, arr, wt);
        int tatanother[] = new int[3];
        new FcfsWithArrival().getFinalResults(wt, tatanother, 3);
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[1], b[1]);
            }
        });

        // that will sort array accori=dingky
        // print the array afteer sorting
        for (int row[] : arr) {
            System.out.println(Arrays.toString(row));
        }
        // finalAns(n, wt, bt, at);
    }
}

class FcfsWithArrival {
    void findWaitingTime(int n, int arr[][], int wt[]) {
        // calculate waiting time as
        wt[0] = 0;
        for (int i = 1; i < n; i++) {
            wt[i] = (arr[i - 1][0] + wt[i - 1]) - arr[i - 1][1];
        }
    }

    void getFinalResults(int wt[], int tat[], int n) {
        // try to print all values
        for (int i = 0; i < n; i++) {
            System.out.println("waiting time of process no i+1 is " + wt[i]);
        }

        // calculating average waiting time
        float awt = 0;
        for (int i = 0; i < n; i++) {
            awt += wt[i];
        }
        System.out.println("avg waiting time: " + awt / n);
    }
}

class Sjf {

}