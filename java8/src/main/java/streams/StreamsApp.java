package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StreamsApp {

    private List<String> list;

    public static void main(String[] args) {
        StreamsApp streams = new StreamsApp();
        streams.create();
        streams.filter();
        streams.sort();
        streams.transform();
        streams.limit();
        streams.count();
        streams.getParallel();
        streams.getSecuencial();
        streams.distinct();
        streams.match();
        streams.findAny();
        streams.findFirst();
        streams.almostAllFeatures();
    }

    private void almostAllFeatures() {
        printMessage("StreamsApp.allFeatures");

        list.stream()
                .filter(x -> x.contains("e"))
                .distinct()
                .map(x -> x.toUpperCase())
                .sorted((x, y) -> x.compareTo(y))
                .skip(1)
                .forEach(System.out::println);
    }

    private void findAny() {
        printMessage("Finding any...");
        Optional<String> any = list.stream().findAny();
        System.out.println("any = " + any.get());
    }

    private void findFirst() {
        printMessage("Finding first...");
        Optional<String> first = list.stream().findFirst();
        System.out.println("first = " + first.get());
    }

    private void match() {
        printMessage("Matching...");
        boolean r = list.stream().anyMatch(x -> x.equalsIgnoreCase("Dra"));
        System.out.println("r = " + r);

    }

    private void distinct() {
        printMessage("Distinct...");
        list.stream().distinct().forEach(System.out::println);
    }

    private void getSecuencial() {
        printMessage("Stream Secuencial");
        list.stream().sequential().forEach(System.out::println);
    }

    private void getParallel() {
        printMessage("Stream Parallel");
        list.parallelStream().forEach(System.out::println);
    }


    private void count() {
        printMessage("Counting");
        System.out.println(list.stream().count());
    }

    private void limit() {
        printMessage("Limiting");
        list.stream().limit(2).forEach(System.out::println);

    }

    private void transform() {
        printMessage("Transforming...");
        list.stream().map(String::toUpperCase).forEach(System.out::println);
    }

    private void printMessage(String message) {
        System.out.println("--------------" + message);
    }

    private void sort() {
        printMessage("Sorting...");
        list.stream().sorted().forEach(System.out::println);

    }

    private void filter() {
        printMessage("Filtering...");
        list.stream().filter(x -> x.startsWith("S")).forEach(System.out::println);
    }


    private void create() {
        printMessage("Creating...");

        list = new ArrayList<>();
        list.add("Dra");
        list.add("Dra");
        list.add("Mr.");
        list.add("Senior");
        list.add("Seniora");
        list.add("Engineer");

        list.stream().forEach(System.out::println);


    }

}
