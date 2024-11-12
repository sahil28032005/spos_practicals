import java.util.*;

public class MemoryPlacement {
    // globals lists for processes and memory blocks
    private List<MemoryBlock> blocks = new ArrayList<>();
    private List<Process> processList = new ArrayList<>();
    private int nextFitPointer = 0;

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

    // for worst fit
    public void worstFit() {
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

    // for next firt
    public void nextFit() {
        resetMemory();
        for (Process p : processList) {
            boolean allocated = false;
            int n = blocks.size();
            for(int i=0;i<n;i++){
                MemoryBlock block = blocks.get(nextFitPointer);
                //check weathre block abele tos store process
                if(){
                    
                }
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

import java.util.*;
public class MemoryPlacement {
	//superglobals variable declarations
	
//	1)making arraylist for process and memory block
	private List<MemoryBlock> blocks=new ArrayList<>();
    private List<Process> processList=new ArrayList<>();
    private int nextFitPointer=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//create empty memory storage allocated by an process
	void inatializeMemory() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no of memory blocks");
		int size=sc.nextInt();
		
		for(int i=0;i<size;i++) {
			System.out.println("enter block size");
			int bsize=sc.nextInt();
			blocks.add(new MemoryBlock(bsize));
		}
	}
	
	//intialize processes
	void inatiailizeProcesses() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of processes");
		int num=sc.nextInt();
		for(int i=0;i<num;i++) {
			System.out.println("enter the process size");
			int size=sc.nextInt();
			System.out.println("Enter process id");
			int pid=sc.nextInt();
			
			processList.add(new Process(size,pid));
		}
	} 
	
	//function for reset memory
	void releaseMemory() {
		for(MemoryBlock block:blocks) {
			block.isAllocated=false;
			//this will make block as unallocated
		}
	}
	
	//actual algorithms
	public void firstFit() {
		//reset the memory
		releaseMemory();
		for(Process p:processList) {
			boolean allocation=false;
			for(MemoryBlock block:blocks){
				if(block.size>=p.size) {
					//means process can accomodate this place
					//mark allocated as true for acknowldegement
					allocation=true;
					block.isAllocated=true;
					break;
				}
			}
			//this block means process does not allocated in ant block
			if(!allocation) {
				System.out.println("unable to allocate block for process");
			}
		}
	}
	
	//for bestFit
	private void bestFit() {
		//reset memory
		releaseMemory();
		for(Process p:processList) {
			MemoryBlock bestFit=null;
			for(MemoryBlock block:blocks) {
				if(!block.isAllocated && block.size >=p.size) {
					//now er found acceptable block for best we have nneed another condition
					if(bestFit==null && bestFit.size > block.size) {
						bestFit=block;
					}
				}
			}
			//here best block is might allocated to process so verify it
			if(bestFit!=null) {
				System.out.println("allocated to best block avaliable");
			}
			else {
				System.out.println("process not allocated to any block");
			}
		}
		
	}
	//worst fit

	private void worstFit() {
		//release memory
		releaseMemory();
		//memory was released
		for(Process p:processList) {
//			do reverse of bestFit
			//done:)
		}
	}

}


//making memory block
class MemoryBlock{
	int size;
	boolean isAllocated;
	public MemoryBlock(int size) {
		this.size=size;
		this.isAllocated=false;
	}
}

//make process template
class Process{
	int pid;
	int size;
	
	public Process(int size,int id) {
		this.size=size;
		this.pid=id;
	}
}
