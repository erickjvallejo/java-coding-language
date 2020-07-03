package repetableannotations;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class RepetableAnnotationsApp {


    @Retention(RetentionPolicy.RUNTIME)
    public @interface Languages {
        Language[] value() default {};
    }

    @Repeatable(value = Languages.class)
    public @interface Language {
        String value();

        String path() default "/";
    }

    //1.7
    @Languages({
            @Language("Java"),
            @Language("GoLang"),
            @Language("Javascript")
    })
    public interface ProgrammingLanguageOld {

    }


    //1.8
    @Language("Java")
    @Language("GoLang")
    @Language("Javascript")
    public interface ProgrammingLanguageNew {

    }

    public static void main(String[] args) {
        Language[] langs = ProgrammingLanguageNew.class.getAnnotationsByType(Language.class);
        System.out.println("There is " + langs.length + " languages below");

        Languages languages = ProgrammingLanguageNew.class.getAnnotation(Languages.class);
        for (Language lang : languages.value()) {
            System.out.println(lang.value());
        }
    }
}
