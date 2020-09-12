package defaultmethods;

public interface Walker {

    default public void sayHi() {
        System.out.println("Walker: hi, good morning!");
    }

    public void walk();
}
