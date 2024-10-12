public class Fcfs {
    // calculating waiting time for each process in normal approch
    static void findWaitingTime(int n, int bt[], int wt[],int at[]) {
        wt[0] = 0;

        for (int i = 1; i < n; i++) {
            wt[i] = (wt[i - 1] + bt[i - 1])-at[i];
        }
    }

    // find averageFinalResults for add
    static void finalAns(int n, int wt[], int bt[],int at[]) {
        // get waiting time for all process to be set

        // make empty array fir turnAround time of size n
        int tat[] = new int[n];
        findWaitingTime(n, bt, wt,at);

        // finding turnarounf tme for each process
        turnAround(n, bt, tat, wt);

        // try to print all values
        for (int i = 0; i < n; i++) {
            System.out.println("waiting time of process no i+1 is " + wt[i]);
        }
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
        int bt[] = { 10, 5, 8 };
        int wt[] = new int[n];
        int tat[] = new int[n];
        int at[] = {0,3,4};

        finalAns(n, wt, bt,at);
    }
}
