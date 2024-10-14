
import java.util.Scanner;
import java.util.*;

public class RemasteredPrioruty {
    // make global processes list
    List<Process> processList = new ArrayList<>();

    // methid for creating pprocess
    void createProcess(int n) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < n; i++) {
            System.out.println("Enter pid bt arrival priority");
            int pid = sc.nextInt();
            int bt = sc.nextInt();
            int arrival = sc.nextInt();
            int priority = sc.nextInt();

            // using this values make list oject
            processList.add(new Process(pid, bt, arrival, priority));
        }

        // we have process created at this time now sort them by their arrival time
        processList.sort(Comparator.comparingInt(p -> p.arrival));
        // now our process has been sorted as per arrivak time
    }

    // methid for managing algo
    void performPriorityScheduling() {
        int n = processList.size();

        // define necessary arrays for calculation
        int waiting[] = new int[n];
        int tat[] = new int[n];
        int completion[] = new int[n];

        int systemTime = 0;

        while (!processList.isEmpty()) {
            // find process that has highr=est priority and he is arrived
            Process selected = null;

            for (Process p : processList) {
                if (p.arrival <= systemTime) {
                    // in this case we have to consider it as acceptable
                    if (selected == null && p.priority < selected.priority) {
                        // int this case we have to uodate our selection
                        selected = p;
                    } else if (selected.priority == p.priority) {
                        // in this case consider arrriva i=time of the processes
                        if (selected.arrival < p.arrival) {
                            // do nothing
                        } else {
                            selected = p;
                        }
                    }
                }
            }

            // loop will give us single process at thay=t system time which has highest
            // priority cinsidering arrival time cases and same priority cases
            if (selected != null) {
                // now completed time for this process is process burst time plus current system
                // time this make sense as you knnow you attended diploma classes of os
                systemTime += selected.bt;
                // we know completion time is time at ehich process completes so system + burst
                // will gave us process end timee
                completion[selected.pid - 1] = systemTime;
                // for tat we know complete minus arrival will mnage it
                tat[selected.pid - 1] = completion[selected.pid - 1] - selected.arrival;
                ;
                // now you also know waiting is tat - burst time
                waiting[selected.pid - 1] = tat[selected.pid - 1] - selected.bt;

                // now our one proceess work is done so remove it so it not make madhe madhe of
                // another processes
                processList.remove(selected);
            } else {
                //if no process is  selected we have ti make or=ur system time to be updated at next process arrival time instead of incrementing and maximizing the iterations
                systemTime = processList.stream().min(Comparator.comparingInt(p-> p.arrival)).get().arrival;
            }

            //now all done remaining things can be dine at oerfirmance time 
        }

    }

    public static void main(String args[]) {
        // make storage ontainer which has list of processes using process template
        RemasteredPrioruty rp = new RemasteredPrioruty();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number if processes");
        int n = sc.nextInt();

        rp.createProcess(n);
        rp.performPriorityScheduling();
    }
}

class Process {
    int pid, bt, arrival, priority;

    Process(int pid, int bt, int arrival, int priority) {
        this.pid = pid;
        this.bt = bt;
        this.arrival = arrival;
        this.priority = priority;
    }
}
