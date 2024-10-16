
// import java.util.*;
// import java.util.Queue;
// import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.*;

class practice {
    int pages[];
    int capacity;

    public practice(int pages[], int capacity) {
        this.capacity = capacity;
        this.pages = pages;
    }

    // functionnwwhich simulates fifo
    void fifo() {
        int pageFault = 0;
        Scanner sc = new Scanner(System.in);
        Queue<Integer> pagesQueue = new LinkedList<>();
        System.out.println("enter how many pages you want to insert ");
        int count = sc.nextInt();

        System.out.println("enter pages spacce seperated");

        // as here we have already our pages
        for (int page : pages) {
            // check weather page present in queue or not
            if (pagesQueue.contains(page)) {
                System.out.println("Page already found in cache memory");
            } else {
                // in this section we come means page not found
                pageFault += 1;
                // first check weather capacity==queue size
                if (pagesQueue.size() == capacity) {
                    // in this case we have to decide replacer page
                    pagesQueue.poll(); // this line removes page which entered first in queue

                }
                pagesQueue.add(page);// this is compulsory step as we have to add page inside frame buffer
            }
        }

    }
}

public class PageReplacementRemastered {
    // private int pages[];
    // private int capacity;

    // // constructor
    // public PageReplacementRemastered(int pages[], int capacity) {
    // this.pages = pages;
    // this.capacity = capacity;
    // }

    // // algo simulation fifo
    // public void simulation() {
    // Queue<Integer> frame = new LinkedList<>();
    // int pageFaults = 0;

    // for (int page : pages) {
    // if (!frame.contains(page)) {
    // // here fault occured
    // if (frame.size() == capacity) {
    // // we have ti replace page
    // frame.poll(); // removed oldest page
    // }
    // frame.add(page);
    // pageFaults++;
    // System.out.println("fault occured");
    // } else {
    // System.out.println("page akready in memory");
    // }
    // }

    // }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter pages space seperated");
        int numPages = sc.nextInt();
        int[] pages = new int[numPages];

        for (int i = 0; i < numPages; i++) {
            pages[i] = sc.nextInt();
        }

        // take capacity of frame from user
        System.out.println("enter capacity of the frame");
        int capacity = sc.nextInt();

        // call main executor
        // PageReplacementRemastered rem = new PageReplacementRemastered(pages,
        // capacity);
        // rem.simulation();

    }
}

class OptimalPageReplacement {
    int predictToBeReplaced(int currentIndex, int pages[], Set<Integer> frame) {

        // make loop that iterates from next idndex from current
        int futureOccurance = -1;
        for (int i = currentIndex + 1; i < pages.length; i++) {
            for (int page : frame) {
                // check weather any of the page in frame occures in next list compare
                // ccordingly
                if (page == pages[i]) {
                    // means we found page occurance in future array
                    // change future occurance
                    futureOccurance = i;
                    break; //no sense to serch again
                }
            }
        }
        return 0;
    }

    void optimalSimulation(int pages[], int capacity) {
        Set<Integer> frame = new HashSet<>();
        int pageFaults = 0;

        for (int i = 0; i < pages.length; i++) {
            // check weather page is already present inside memory
            if (frame.contains(pages[i])) {
                // page already found no need to do anythinf
                System.out.println("page is alerady found in memory");
            } else {
                // page fault occured
                // check weather frame has spsace or frame is full
                if (frame.size() == capacity) {
                    // in this case we have to predict which page have to replace
                    int pageGonnaReplace = predictToBeReplaced(i, pages, frame);
                }
            }
        }
    }
}
