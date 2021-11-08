import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class HeapTest {

    public static void main(String[] args) {
           
            
            
            int a[] = new int[100];
            try {
                    int i=0;
                    File input = new File("data.txt");
                    Scanner src = new Scanner(input);
                    while (src.hasNextLine()) {
                            a[i++] = src.nextInt();
                    }
                    src.close();
            } catch (FileNotFoundException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
            }
            
            Heap si = new Heap();
            int cnt = si.sequential_insertion(a);
            try {
                    PrintWriter p=new PrintWriter("output.txt");
                    p.write("Heap built using sequential insertion: ");
                    for (int i=0; i<10; i++) {
                            p.write(si.get(i) + ",");
                    }
                    p.write("...\n");
                    p.write("Number of swaps in the heap creation: " + cnt + "\n");
                    p.write("Heap after 10 removals: ");
                    for (int i=0; i<10; i++) {
                            si.remove();
                    }
                    for (int i=0; i<10; i++) {
                            p.write(si.get(i) + ",");
                    }
                    p.write("...\n\n");
                    
                    
                    Heap oi = new Heap();
                    cnt = oi.optimal_insertion(a);

                    p.write("Heap built using optimal method: ");
                    for (int i=0; i<10; i++) {
                            p.write(oi.get(i) + ",");
                    }
                    p.write("...\n");
                    p.write("Number of swaps in the heap creation: " + cnt + "\n");
                    p.write("Heap after 10 removals: ");
                    for (int i=0; i<10; i++) {
                            oi.remove();
                    }
                    for (int i=0; i<10; i++) {
                            p.write(oi.get(i) + ",");
                    }
                    p.write("...\n\n");
                    p.close();
            } 
            catch(FileNotFoundException e)
            {
                    System.out.println("File not opened for writing");
            }
    }
}