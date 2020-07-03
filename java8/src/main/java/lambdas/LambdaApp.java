package lambdas;

public class LambdaApp {

    public static void main(String[] args) {

        Operation operation = (x , b) -> x + b ;
        System.out.println(operation.sum(4,5));

    }
}
