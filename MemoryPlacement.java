import java.util.*;

public class MemoryPlacement {
    // globals lists for processes and memory blocks
    private List<MemoryBlock> blocks = new ArrayList<>();
    private List<Process> processList = new ArrayList<>();

    // create empty memory storage to be allocated by processes
    void inatializeMemory() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter no of memory blocks");
        int n = s.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter size of block");
            int size = s.nextInt();
            blocks.add(new MemoryBlock(size));
        }

    }

    void inatializeProcess() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the nn of processes");
        int size = s.nextInt();
        for (int i = 0; i < size; i++) {
            System.out.println("Enter process id and size");
            int id = s.nextInt();
            int psize = s.nextInt();
            processList.add(new Process(id, psize));
        }
    }

    private void resetMemory() {
        for (MemoryBlock memory : blocks) {
            memory.isAllocated = false;
        }
    }

    // algorithms
    public void firstFit() {
        // reset the memory
        resetMemory();
        for (Process p : processList) {
            boolean allocation = false;
            for (MemoryBlock block : blocks) {
                if (block.size >= p.size) {
                    // means process can accomodate this place
                    // mmakr llocated as true
                    allocation = true;
                    block.isAllocated = true;
                    break;
                }
            }
            if (!allocation) {
                // means process is not allocated
                System.out.println("unable to allocate process");
            }
        }
    }

    // implementfor bestFiy
    public void bestFitt() {
        // reset the memory
        resetMemory();
        for (Process p : processList) {
            MemoryBlock bestBlock = null;
            for (MemoryBlock memory : blocks) {
                if (!memory.isAllocated && memory.size >= p.size) {
                    if (bestBlock == null || memory.size < bestBlock.size) {
                        bestBlock = memory;
                    }
                }
            }
            if (bestBlock != null) {
                System.out.println("process " + p.id + " allocate to " + bestBlock.size);
            } else {
                System.out.println("process nit allocated to any block");
            }
        }
    }

    //for worst fit
    public void worstFit(){
        resetMemory();
        for (Process p : processList) {
            MemoryBlock bestBlock = null;
            for (MemoryBlock memory : blocks) {
                if (!memory.isAllocated && memory.size >= p.size) {
                    if (bestBlock == null || memory.size > bestBlock.size) {
                        bestBlock = memory;
                    }
                }
            }
            if (bestBlock != null) {
                System.out.println("process " + p.id + " allocate to " + bestBlock.size);
            } else {
                System.out.println("process nit allocated to any block");
            }
        }
    }

    public static void main(String[] args) {
        MemoryPlacement memoryPlacement = new MemoryPlacement();
        memoryPlacement.inatializeMemory();
    }
}

// make memory block templpate
class MemoryBlock {
    int size;
    boolean isAllocated;

    public MemoryBlock(int size) {
        this.size = size;
        this.isAllocated = false;
    }
}

class Process {
    int id;
    int size;

    public Process(int id, int size) {
        this.id = id;
        this.size = size;
    }
}
