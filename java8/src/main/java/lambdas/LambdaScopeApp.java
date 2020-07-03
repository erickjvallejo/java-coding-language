package lambdas;


public class LambdaScopeApp {

    private int fieldA = 0;
    private static int fieldB = 1;


    public static void main(String[] args) {
        final int localVar = 3; // only be final
        Operation operation = (a, b) -> {
            //fieldA = a + b; // I can use non static fields
            fieldB = a + b; // I can use  static fields
            fieldB += localVar;  // I can use final local variable
            return a + b;
        };
        System.out.println(operation.sum(5, 2));


    }


}
