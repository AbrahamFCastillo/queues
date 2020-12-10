/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] s;
    private int tail;

    // construct an empty randomized queue
    public RandomizedQueue() {
        s = (Item[]) new Object[1];
        tail = 0;
    }

    // Metodo de prueba
    private int tamArray() {
        return s.length;
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return tail == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return tail;
    }

    // add the item
    public void enqueue(Item item) {
        if (item != null) {
            if (tail == s.length) {
                resize(2 * s.length);
            }
            s[tail++] = item;
        }
        else {
            throw new IllegalArgumentException("Es null");
        }
    }

    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        int i;
        for (i = 0; i < tail; i++)
            if (s[i] != null) {
                copy[i] = s[i];
            }
        s = copy;
    }

    // remove and return a random item
    public Item dequeue() {
        if (tail <= 0) {
            throw new java.util.NoSuchElementException("Menor a cero");
        }
        else {
            int randomIndex = StdRandom.uniform(tail);
            while (s[randomIndex] == null) {
                randomIndex = StdRandom.uniform(tail);
            }
            Item item = s[randomIndex];
            tail--;
            if (randomIndex == tail) {
                s[randomIndex] = null;
            }
            else {
                s[randomIndex] = s[tail];
                s[tail] = null;
            }
            if ((tail > 0) && (tail == s.length / 4)) {
                resize(s.length / 2);
            }
            return item;
        }
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (tail <= 0) {
            throw new java.util.NoSuchElementException("Menor a cero");
        }
        int randomIndex = StdRandom.uniform(tail);
        while (s[randomIndex] == null) {
            //  throw new IllegalArgumentException("No existe.");
            randomIndex = StdRandom.uniform(tail);
        }
        Item item = s[randomIndex];
        return item;
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RandomArrayIterator();
    }

    private class RandomArrayIterator implements Iterator<Item> {
        //  private int randomIndex = StdRandom.uniform(tail);
        private int[] rdmIdx;
        private int i;

        public RandomArrayIterator() {
            rdmIdx = StdRandom.permutation(tail);
            i = 0;
        }

        public boolean hasNext() {
            return i < tail;
        }

        public void remove() { /* not supported */
            throw new UnsupportedOperationException("not supported");
        }

        public Item next() {
            if (hasNext()) {
                return s[rdmIdx[i++]];
            }
            else {
                throw new java.util.NoSuchElementException("Menor a cero");
            }
        }
    }

    // unit testing (required)
    public static void main(String[] args) {
        int n = 5;
        RandomizedQueue<Integer> queue = new RandomizedQueue<Integer>();
        for (int i = 0; i < n; i++)
            queue.enqueue(i);
        for (int a : queue) {
            for (int b : queue)
                StdOut.print(a + "-" + b + " ");
            StdOut.println();
        }

        StdOut.println();
        StdOut.println();

        RandomizedQueue<String> cola = new RandomizedQueue<String>();
        for (int i = 0; i < 8; i++) {
            //   String line = StdIn.readString();
            cola.enqueue(String.valueOf(i));
            StdOut.println(i);
            StdOut.println("Tamaño de la cola: " + cola.tail);
            StdOut.println("Tamaño del arreglo: " + cola.tamArray());
            StdOut.println("Posicion Tail: " + cola.tail);
        }

        StdOut.println();

        for (String s : cola)
            StdOut.println(s);

        StdOut.println();

        for (int j = 0; j < 5; j++)
            StdOut.println("Sample " + (j + 1) + ": " + cola.sample());

        StdOut.println();

        for (String s : cola)
            StdOut.println(s);

        StdOut.println();

        StdOut.println(cola.isEmpty());
        StdOut.println("Tamaño de la cola: " + cola.tail);
        StdOut.println("Tamaño del arreglo: " + cola.tamArray());
        StdOut.println("Posicion Tail: " + cola.tail);
        StdOut.println("Sale: " + cola.dequeue());
        StdOut.println("Tamaño de la cola: " + cola.tail);
        StdOut.println("Tamaño del arreglo: " + cola.tamArray());
        StdOut.println("Posicion Tail: " + cola.tail);
        StdOut.println("Sale: " + cola.dequeue());
        StdOut.println("Tamaño de la cola: " + cola.tail);
        StdOut.println("Tamaño del arreglo: " + cola.tamArray());
        StdOut.println("Posicion Tail: " + cola.tail);
        StdOut.println("Sale: " + cola.dequeue());
        StdOut.println("Tamaño de la cola: " + cola.tail);
        StdOut.println("Tamaño del arreglo: " + cola.tamArray());
        StdOut.println("Posicion Tail: " + cola.tail);
        StdOut.println("Ingresa: 'e' ");
        cola.enqueue("e");
        StdOut.println("Tamaño de la cola: " + cola.tail);
        StdOut.println("Tamaño del arreglo: " + cola.tamArray());
        StdOut.println("Posicion Tail: " + cola.tail);
        StdOut.println("Ingresa: 'f' ");
        cola.enqueue("f");

        StdOut.println();

        for (String s : cola)
            StdOut.println(s);

        StdOut.println();

        StdOut.println("Tamaño de la cola: " + cola.tail);
        StdOut.println("Tamaño del arreglo: " + cola.tamArray());
        StdOut.println("Posicion Tail: " + cola.tail);
        StdOut.println("Sale: " + cola.dequeue());

        StdOut.println();

        for (int j = 0; j < 5; j++)
            StdOut.println("Sample " + (j + 1) + ": " + cola.sample());

        StdOut.println();

        StdOut.println("Tamaño de la cola: " + cola.tail);
        StdOut.println("Tamaño del arreglo: " + cola.tamArray());
        StdOut.println("Posicion Tail: " + cola.tail);
        StdOut.println("Sale: " + cola.dequeue());
        StdOut.println("Tamaño de la cola: " + cola.tail);
        StdOut.println("Tamaño del arreglo: " + cola.tamArray());
        StdOut.println("Posicion Tail: " + cola.tail);
        StdOut.println("Sale: " + cola.dequeue());
        StdOut.println("Posicion Tail: " + cola.tail);
        StdOut.println(cola.isEmpty());
        StdOut.println("Posicion Tail: " + cola.tail);

    }

}

