/*
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 */

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int tam;


    private class Node {
        Item item;
        Node next;
    }

    // construct an empty deque
    public Deque() {
        first = null;
        last = null;
        tam = 0;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return tam == 0;
    }

    // return the number of items on the deque
    public int size() {
        return tam;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Es null");
        }
        else {
            Node oldfirst = first;
            first = new Node();
            first.item = item;
            if (isEmpty())
                last = first;
            else
                first.next = oldfirst;
            tam++;
        }
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Es null");
        }
        else {
            Node oldlast = last;
            last = new Node();
            last.item = item;
            last.next = null;
            if (isEmpty())
                first = last;
            else
                oldlast.next = last;
            tam++;
        }
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("Lista vacia");
        }
        tam--;
        Item item = first.item;
        first = first.next;
        if (isEmpty())
            last = null;
        return item;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("Lista vacia");
        }
        tam--;
        Item item;
        if (first.next == null) {
            item = first.item;
            first = null;
        }
        else {
            Node aux = first;
            while (aux.next.next != null) {
                aux = aux.next;
            }
            item = aux.next.item;
            aux.next = null;
            if (isEmpty())
                last = null;
        }
        return item;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() { /* not supported */
            throw new UnsupportedOperationException("not supported");
        }

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    // unit testing (required)
    public static void main(String[] args) {
        Deque<String> cola = new Deque<String>();


     /*   for (int i = 0; i < 6; i++) {
            String line = StdIn.readString();
        /*    if (i % 2 == 0) {
                cola.addFirst(line);
            }
            else {
                cola.addLast(line);
            } ///
            cola.addLast(line);
            StdOut.println(line);
        }

        StdOut.println(cola.isEmpty());
        StdOut.println();

        for (int i = 0; i < 4; i++) {
            String line = StdIn.readString();
            cola.addFirst(line);
            StdOut.println(line);
        }      */

        String a = "Esta";
        String b = "es";
        String c = "una";
        String d = "prueba";
        String e = "1. ";

        StdOut.println("Insertando al final: " + b);
        cola.addLast(b);
        StdOut.println("Insertando al principio: " + a);
        cola.addFirst(a);

        StdOut.println("Insertando al final: " + c);
        cola.addLast(c);
        StdOut.println("Insertando al final: " + d);
        cola.addLast(d);
        StdOut.println("Insertando al principio: " + e);
        cola.addFirst(e);

        for (String s : cola)
            StdOut.println(s);

        StdOut.println();
        StdOut.println();

        StdOut.println(cola.size());
        StdOut.println(cola.removeFirst());
        StdOut.println("Insertando al principio: " + a);
        cola.addFirst(a);
        StdOut.println(cola.removeLast());
        StdOut.println("Insertando al final: " + d);
        cola.addLast(d);

        StdOut.println();

        for (String s : cola)
            StdOut.println(s);

        StdOut.println(cola.removeFirst());
        StdOut.println(cola.removeLast());

        StdOut.println(cola.isEmpty());
        StdOut.println();

        for (String s : cola)
            StdOut.println(s);
    }

}
