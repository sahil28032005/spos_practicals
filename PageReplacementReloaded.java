public package pageReplacement;
import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
public class PageReplacement {
    int pages[];
    int capacity;
    
    public PageReplacement(int pages[],int capacity) {
    	this.pages=pages;
    	this.capacity=capacity;
    }
    
    //actual algos fifo
    private void fifo() {
    	int pageFault=0;
    	Scanner sc=new Scanner(System.in);
    	Queue<Integer> pages=new LinkedList<>();
    	
    	System.out.println("enter how many pages you want to insert");
    	int pageCount=sc.nextInt();
    	
    	//we have pages arry which has pages alerady inserted
    	
    	//make iteration for each page
    	
    	for(int page:pages) {
    		//check weather page present in queue or not
    		if(pages.contains(page)) {
    			//no worries as we found our data in cashed memory
    			System.out.println("page is already present in memory");
    		}
    		else {
    			pageFault+=1;
                //now check weather frame is full or avaliable page store size
    			if(capacity==pages.size()) {
    				//means frame is full we have to remove some element according to algo
    				pages.poll();
    			}
    			//add that page inside queue
    			pages.add(page);
    		}
    		
    		
    	}
    }
    
    //algo for optimal page replacement
    private void optimal(int pages[],int capacity) {
    	Set<Integer> frame=new HashSet<>();
    	int pageFault=0;
    	
    	for(int i=0;i<pages.length;i++) {
    		//check weather page is already present in mmemory or not
    		if(frame.contains(pages[i])) {
    			//page already found noneed to do anything
    			System.out.println("pah=ge already present inside memory");
    		}
    		else {
    			//page fault occured
    			//check weather frame has space or full
    			if(frame.size()==capacity) {
    				//in this cas we have to predict page for replacement which not used in future
    				int pageToReplace=predict(i,pages,frame);
    			}
    		}
    	}
    	
    	
    }
    int predict(int current,int pages[],Set<Integer> frame) {
		//make loop that iterates next from current index
    	int farthee=current;
    	int pageToReplace=-1;
    	
    	for(int page:frame) {
    		//we are iterating over fram to know about tha =t pages future occurences
    		int nextUse=Integer.MAX_VALUE;
    		//scan current to pages length
    		for(int i=current;i<pages.length;i++) {
    			if(pages[i]==page) {
    				//means we founded that page somewhere in future
    				nextUse=i;
    				break;
    			}
    		}
    		// Select the page with the farthest usage in the future
    		if(nextUse>farthee){
    			farthee=nextUse;
    			pageToReplace=page;
    		}
    	}
    	
    	return pageToReplace;
	}
    
    void lruSimulation(int pages[], int capacity) {
        Set<Integer> frame = new LinkedHashSet<>();  // Stores pages in access order
        Map<Integer, Integer> lastUsed = new HashMap<>();  // Maps page to its last used index
        int pageFaults = 0;

        for (int i = 0; i < pages.length; i++) {
            int page = pages[i];

            // Check if the page is already in memory
            if (frame.contains(page)) {
                System.out.println("Page " + page + " is already found in memory.");
            } else {
                // Page fault occurred
                pageFaults++;
                
                // If the frame is full, remove the least recently used page
                if (frame.size() == capacity) {
                    int lruPage = findLRUPage(lastUsed, frame);
                    frame.remove(lruPage);
                    System.out.println("Page " + lruPage + " is replaced by page " + page);
                }

                // Add the new page to the frame
                frame.add(page);
            }

            // Update last used time for the page
            lastUsed.put(page, i);
        }

        System.out.println("Total page faults: " + pageFaults);
    }

    // Helper method to find the Least Recently Used (LRU) page
    int findLRUPage(Map<Integer, Integer> lastUsed, Set<Integer> frame) {
        int lruPage = -1;
        int oldestUse = Integer.MAX_VALUE;

        for (int page : frame) {
            int lastUseIndex = lastUsed.get(page);
            if (lastUseIndex < oldestUse) {
                oldestUse = lastUseIndex;
                lruPage = page;
            }
        }

        return lruPage;
    }

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
	}

}
 PageReplacementReloaded {
    
}
