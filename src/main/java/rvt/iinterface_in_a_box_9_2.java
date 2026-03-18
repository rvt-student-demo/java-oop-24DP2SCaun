package rvt;

import java.util.ArrayList;

public class iinterface_in_a_box_9_2 {

    public interface Packable {
         double weight();
    }

    public static class book implements Packable {

        private String author;
        private String name;
        private double weight;

        public book(String author, String name, double weight) {
            this.author = author;
            this.name = name;
            this.weight = weight;
        }

        @Override
        public double weight() {
            return this.weight;
        }

        @Override
        public String toString() {
            return this.author + ": " + this.name;
    }
}

public static class cd implements Packable {

    private String artist;
    private String name;
    private int year;

    public cd(String artist, String name, int year) {
        this.artist = artist;
        this.name = name;
        this.year = year;
    }

    @Override
    public double weight() {
        return 0.1;
    }

    @Override
    public String toString() {
        return this.artist + ": " + this.name + " (" + this.year + ")";
    }

    public static class box implements Packable {

        private double capacity;
        private ArrayList<Packable> items;

        public box(double capacity) {
            this.capacity = capacity;
            this.items = new ArrayList<>();
        }

        public void add(Packable item) {
            if (this.weight() + item.weight() <= this.capacity) {
                this.items.add(item);
            }
        }

        @Override
        public double weight() {
            double totalWeight = 0;
            for (Packable item : this.items) {
                totalWeight += item.weight();
            }
            return totalWeight;
        }

        @Override
        public String toString() {
            return "box: " + this.items.size() + " items, total weight " + this.weight() + " kg";
        }
    }

    public static void main(String[] args) {

        book book1 = new book( "Fyodor Dostoevsky", "Crime and Punishment", 2.0);
        book book2 = new book("Robert Martin", "Clean Code", 1);
        book book3 = new book("Kent Beck", "Test Driven Development", 0.5);

        cd cd1 = new cd("Pink Floyd", "Dark Side of the Moon", 1973);
        cd cd2 = new cd("Wigwam", "Nuclear Nightclub", 1975);
        cd cd3 = new cd("Rendezvous Park", "Closer to Being Here", 2012);

        System.out.println(book1);
        System.out.println(book2);
        System.out.println(book3);
        System.out.println(cd1);
        System.out.println(cd2);
        System.out.println(cd3);

        System.out.println();

        box box = new box(10);
        box.add(book1);
        box.add(book2);
        box.add(book3);
        box.add(cd1);
        box.add(cd2);
        box.add(cd3);
        System.out.println(box);

        box smallbox = new box(2);
        smallbox.add(new cd("Test Artist", "Mini Album", 2020));

        box bigbox = new box(10);
        bigbox.add(smallbox);
        bigbox.add(box);

        System.out.println(bigbox);

    }
}

}