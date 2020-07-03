package methodrefences;

import java.util.Arrays;
import java.util.Comparator;

public class MethodReferenceApp {


    public static void refStaticMethod() {
        System.out.println("refStaticMethod");
    }

    public void refInstanceMethodA() {
        String names[] = {"Lee", "Perez", "Bermont"};

        //First way to sort
        Arrays.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2);
            }
        });

        //Second way to sort
        Arrays.sort(names, (s1, s2) -> s1.compareToIgnoreCase(s2));

        //Third way to sort
        Arrays.sort(names, String::compareTo);

        System.out.println(Arrays.toString(names));

    }

    public void refInstanceMethodB(){
        System.out.println("refInstanceMethodB");
    }

    public void refConstructor(){

        //First option
        IPersona iPersona1 = new IPersona(){
            @Override
            public Persona crear(int id, String name) {
                return new Persona(id, name);
            }
        };
        Persona persona1 = iPersona1.crear(1, "Buddy");
        System.out.println(persona1);

        //Second Option
        IPersona iPersona2 = (i , name)  -> new Persona(i , name);
        Persona persona2 = iPersona2.crear(2, "John");
        System.out.println(persona2);

        //Third Option
        IPersona ipersona3 = Persona::new;
        Persona per = ipersona3.crear(3, "Joan");
        System.out.println(per);


    }

    public void run() {
        Operation op1 = () -> MethodReferenceApp.refStaticMethod();
        op1.regards();

        Operation op2 = MethodReferenceApp::refStaticMethod;
        op2.regards();


    }

    public static void main(String[] args) {
        MethodReferenceApp app = new MethodReferenceApp();
        app.run();

        app.refInstanceMethodA();

        Operation op3 = app::refInstanceMethodB;
        op3.regards();

        app.refConstructor();





    }
}
