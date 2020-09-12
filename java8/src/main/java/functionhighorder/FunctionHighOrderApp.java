package functionhighorder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionHighOrderApp {

    private Function<String, String> convertToUpperCase = x -> x.toUpperCase();
    private Function<String, String> convertToLowerCase = x -> x.toLowerCase();


    public void print(Function<String, String> function, String value) {
        System.out.println(function.apply(value));
    }

    public Function<String, String> show(String message) {
        return (String x) -> message + x;
    }

    public void filter(List<String> list, Consumer<String> consumer, int length, String str) {
        list.stream().filter(this.setFilterLogic(length)).forEach(consumer);
        list.stream().filter(this.setFilterLogic(str)).forEach(consumer);
    }

    public Predicate<String> setFilterLogic(int length) {
        return text -> text.length() < length;
    }

    public Predicate<String> setFilterLogic(String string) {
        return text -> text.contains(string);
    }


    public static void main(String[] args) {

        /*Sample1*/
        FunctionHighOrderApp app = new FunctionHighOrderApp();
        app.print(app.convertToUpperCase, "Hi Master");
        app.print(app.convertToLowerCase, "Hi Master");

        /*Sample2*/
        String apply = app.show("Hi Buddy").apply("Hi Again");
        System.out.println("apply = " + apply);

        /*Sample3*/
        List<String> list = new ArrayList<>();
        list.addAll(Arrays.asList("1234", "12345", "123456", "1234567"));
        app.filter(list, System.out::println, 6, "");
        app.filter(list, System.out::println, 0, "56");

    }
}
