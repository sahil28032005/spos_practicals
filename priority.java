import java.util.Arrays;
import java.util.Comparator;

public class priority {

    public static void main(String[] args) {
        int bt[] = { 11, 28, 2, 10, 16 };
        int at[] = { 0, 5, 12, 2, 9 };
        int pr[] = { 2, 0, 3, 1, 4 };
        int n = 5;
        Process process[] = new Process[n];
        // mke process templates using this structure
        for (int i = 0; i < n; i++) {
            process[i] = new Process(at[i], bt[i], pr[i]);
        }
        // this make our processes
        Arrays.sort(process, new Comparator<Process>() {
            @Override
            public int compare(Process p1, Process p2) {
                if(p1.arrival == p2.arrival){
                    return p1.priority - p2.priority; //if comes - or smaller value then p1 becomes first order
                }
                else{
                    return p1.arrival - p2.arrival; //if comes - or smaller value
                }
            }
        });

        //this will sort process vial priority
        Arrays.stream(process).forEach(p-> System.out.println("arrival: " + p.arrival+" " + p.burst+" " + p.priority));
    }
}

class Process {
    int arrival, burst, priority;

    public Process(int arrival, int burst, int priority) {
        this.arrival = arrival;
        this.burst = burst;
        this.priority = priority;
    }

    // try to sort that array using their arrival times and priority

}
