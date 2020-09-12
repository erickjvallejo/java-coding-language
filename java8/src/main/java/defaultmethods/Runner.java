package defaultmethods;

public interface Runner {

    default public void sayHi() {
        System.out.println("Runner: hi, good morning!");
    }

    public void run();
}
