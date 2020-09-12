package defaultmethods;

public class DefaultMethodApp implements Walker , Runner {
    public static void main(String[] args) {

        DefaultMethodApp app = new DefaultMethodApp();
        app.sayHi();
        app.walk();
    }


    @Override
    public void sayHi() {
        Walker.super.sayHi();
        Runner.super.sayHi();

    }

    @Override
    public void walk() {
        System.out.println("I am walking");

    }

    @Override
    public void run() {
        System.out.println("I am walking");
    }
}
