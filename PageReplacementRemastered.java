import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class PageReplacementRemastered {
    private int pages[];
    private int capacity;

    // constructor
    public PageReplacementRemastered(int pages[], int capacity) {
        this.pages = pages;
        this.capacity = capacity;
    }

    // algo simulation
    public void simulation() {
        Queue<Integer> frame = new LinkedList<>();
        int pageFaults = 0;

        for (int page : pages) {
            if (!frame.contains(page)) {
                // here fault occured
                if (frame.size() == capacity) {
                    // we have ti replace page
                    frame.poll(); // removed oldest page
                }
                frame.add(page);
                pageFaults++;
                System.out.println("fault occured");
            } else {
                System.out.println("page akready in memory");
            }
        }

    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int numPages = sc.nextInt();
        int[] pages = new int[numPages];

        System.out.println("enter pages space seperated");

        for (int i = 0; i < numPages; i++) {
            pages[i] = sc.nextInt();
        }

        // take capacity of frame from user
        System.out.println("enter capacity of the frame");
        int capacity = sc.nextInt();

        // call main executor
        PageReplacementRemastered rem = new PageReplacementRemastered(pages, capacity);

    }
}
