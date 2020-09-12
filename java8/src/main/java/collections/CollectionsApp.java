package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionsApp {

    private List<String> list;

    public static void main(String[] args) {
        CollectionsApp app = new CollectionsApp();
        app.create();
        app.sort();
        app.remove();
        app.print();

    }

    private void remove() {
        System.out.println("Removing mr. ");
        list.removeIf(x -> x.equalsIgnoreCase("mr."));
    }

    private void sort() {
        System.out.println("Sorting");
        list.sort((x, y) -> x.compareToIgnoreCase(y));
    }

    private void print() {
        System.out.println("Printing");
        list.forEach(System.out::println);
    }

    private void create() {
        System.out.println("Creating");
        list = new ArrayList<>(Arrays.asList("Hello", "World", "Regards", "from", "Colombia", "Dra", "Mr.", "Senior"));

    }

}
