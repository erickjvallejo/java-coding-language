package optionals;

import java.util.Optional;

public class OptionalApp {

    public static void main(String[] args) {
        OptionalApp app = new OptionalApp();

        app.check(null);
        app.orElse("Test without Null");
        app.orElse(null);
        try {
            app.orElseThrow(null);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        app.isPresent("Test without null");
        app.isPresent(null);


    }

    private void check(String value) {

        try {
            Optional optional = Optional.empty();
            optional.get();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            ;
        }
    }

    private void orElse(String value) {
        Optional<String> optional = Optional.ofNullable(value);
        String x = optional.orElse("Default Value");
        System.out.println(x);
    }

    private void orElseThrow(String value) {
        Optional<String> optional = Optional.ofNullable(value);
        optional.orElseThrow(NumberFormatException::new);
    }

    private void isPresent(String value) {
        Optional<String> optional = Optional.ofNullable(value);
        System.out.println("optional = " + optional);

    }
}
