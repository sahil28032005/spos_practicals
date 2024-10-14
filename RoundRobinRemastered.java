import java.util.*;

public class RoundRobinRemastered {
    List<Process> processList = new ArrayList<>();

    void createProcesses(int n) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < n; i++) {
            System.out.println("enter pid bt at");
            int pid = sc.nextInt();
            int bt = sc.nextInt();
            int at = sc.nextInt();

            // create process instance
            processList.add(new Process(pid, bt, at));
        }
    }

    void performRoundRobin(int quantom) {
        int n = processList.size();

        int[] waiting = new int[n];
        int[] tat = new int[n];
        int[] remainingTime = new int[n];

        // inatialize remaining time for each process
        for (int i = 0; i < n; i++) {
            remainingTime[i] = processList.get(i).bt;
        }
        // now we have remaining time of all processes
        int systemTime = 0;
        boolean allDone = false;

        while (!allDone) {
            allDone = true;
            for (int i = 0; i < n; i++) {
                Process p = processList.get(i);
                // check weather process is in our r=criteria; as we want its arrival time <=
                // system
                if (p.at <= systemTime && remainingTime[i] > 0) {
                    // in this case we have process whoose execution we have to carry
                    allDone = false;
                    // check weather remaining time is greater than or less that quantom o =r equal
                    // also allowed in if block
                    if (remainingTime[i] >= quantom) {
                        // now add one quantom to systemtime minus quantim from remainig time array

                        systemTime += quantom;
                        remainingTime[i] -= quantom;

                    } else {
                        // process completed his executiom
                        // find current time
                        systemTime += remainingTime[i];
                        // caculate waiting time as previous code we made as sys minus burst minus
                        // arrival
                        waiting[i] = systemTime - p.bt - p.at;
                        // for tat know it is current minus arrival
                        tat[i] = systemTime - p.at;
                        //nark remaining time as 0 for that process
                        remainingTime[i] = 0;
                    }
                }
            }
        }

        //main task is done now print results and do ant=other stuff
    }

    public static void main(String arg[]) {
        RoundRobinRemastered rb = new RoundRobinRemastered();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of processes");
        int n = sc.nextInt();

        System.out.println("Enter the time quantom");
        int quantom = sc.nextInt();

        // send process craetion
        rb.createProcesses(n);

        // do main allgo
        rb.performRoundRobin(quantom);
    }
}

class Process {
    int pid, bt, at;

    Process(int pid, int bt, int at) {
        this.pid = pid;
        this.bt = bt;
        this.at = at;
    }

}
