import java.util.*;

public class RemasteredFcfs {
    // make list of type process for simplicity
    List<Process> processList = new ArrayList<>();

    // methid to cearete and store processes
    void createProcess(int n) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            System.out.println("Enter process id burst time and arrivak time");
            int pid = sc.nextInt();
            int bt = sc.nextInt();
            int arrivalTime = sc.nextInt();

            // add new processs to the list
            processList.add(new Process(pid, bt, arrivalTime));
        }
    }

    void performFcfs() {
        int n = processList.size();
        int[] waiting = new int[n];
        int[] tat = new int[n];
        int[] completion = new int[n];

        // for process first conside this approach
        completion[0] = processList.get(0).arrival + processList.get(0).bt;
        tat[0] = completion[0] - processList.get(0).arrival;
        waiting[0] = tat[0] - processList.get(0).bt;

        for (int i = 1; i < n; i++) {

            // the idea is completion time for current process is either max off current
            // process arriavl tome pr previous completion time then and burst time to it
            completion[i] = Math.max(completion[i - 1], processList.get(i).arrival) + processList.get(i).bt;
            // now we have process completion time we can easily calculate turnarount time
            // by minusing arrial time of current process from it i thiml i can do it as i
            // am so smart
            tat[i] = completion[i] - processList.get(i).arrival;
            // now sahil tuzyakade tat ahe bakiche tu bagshil
            waiting[i] = tat[i] - processList.get(i).bt; // burst time minus karun tak karan to minus kelyvr tula
                                                         // remaining waiting time opop milel

        }

        // he loop zalyavar ata value print karun bagh
        System.out.println("\nProcess\tArrival\tBurst\tCompletion\tWaiting\tTurnaround");
        processList.stream().forEach(p -> {
            int index = processList.indexOf(p); // this will givve index
            System.out.printf("%d\t%d\t%d\t%d\t\t%d\t\t%d\n",
                    p.pid, p.arrival, p.bt, completion[index], waiting[index], tat[index]);
        });
    }

    // method to sort process through arrivalTime
    void sortProcessByArrivalTime() {
        processList.sort(Comparator.comparingInt(p -> p.arrival));
    }

    public static void main(String args[]) {
        RemasteredFcfs fcfs = new RemasteredFcfs();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of processes");
        int n=sc.nextInt();

        //create process by our template process calss
        fcfs.createProcess(n);

        //ata process created ahet tynna sort karun try kar
        fcfs.sortProcessByArrivalTime();

        //sort zalya
        fcfs.performFcfs();
    }
}

class Process {
    int pid, bt, arrival;

    Process(int pid, int bt, int arrival) {
        this.pid = pid;
        this.bt = bt;
        this.arrival = arrival;
    }
}
