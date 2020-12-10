/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */


import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation {

    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        int cadenas = 0;
        
        if (k >= 0) {
            RandomizedQueue<String> cola = new RandomizedQueue<String>();
            while ((cadenas < k) && (!StdIn.isEmpty())) {
                String line = StdIn.readString();
                cola.enqueue(line);
                //   StdOut.println(line);
                cadenas++;
            }

            if (k <= cadenas) {
                //   StdOut.println();
                for (int j = 0; j < k; j++) {
                    StdOut.println(cola.dequeue());
                }
                //  StdOut.println();
            }
            else {
                throw new java.util.NoSuchElementException("Out of bounds");
            }
        }
        else {
            throw new java.util.NoSuchElementException("Out of bounds ( < 0 )");
        }

      /*  Iterator<String> i = cola.iterator();
        //    while ((inter < k) && (i.hasNext())) {
        while (i.hasNext()) {
            String s = i.next();
            StdOut.println(s);
        }

        for (String a : cola) {
            for (String b : cola)
                StdOut.print(a + "-" + b + " ");
            StdOut.println();
        }      */


    }
}
