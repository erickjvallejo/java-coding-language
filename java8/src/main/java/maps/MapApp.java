package maps;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MapApp {

    private Map<Integer, String> map;

    public static void main(String[] args) {
        MapApp app = new MapApp();
        app.fillUp();
        app.printLegacyIfModeIs(true);
        app.printLegacyIfModeIs(false);
        app.putIfAbsent(1, "I am!");
        app.putIfAbsent(5, "I am!");
        app.computeIfAbsent();
        app.getOrDefault();
        app.recolectar();
        app.printLegacyIfModeIs(false);


    }

    private void recolectar() {
        System.out.println("MapApp.recolectar");
        Map<Integer, String> mapRecolected = map.entrySet()
                .stream()
                .filter(e -> e.getValue().contains("?"))
                .collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));

        mapRecolected.forEach((k, v) -> System.out.println(k + " = " + v));
    }

    private void getOrDefault() {
        System.out.println("MapApp.getOrDefault");
        String defaultValue = map.getOrDefault(6, "Default Value");
        System.out.println("defaultValue = " + defaultValue);
    }

    private void computeIfAbsent() {
        System.out.println("MapApp.computeIfAbsent");
        String s = map.computeIfPresent(3, (k, v) -> k + v);
        System.out.println(s);
    }

    private void putIfAbsent(int i, String s) {
        System.out.println("MapApp.putIfAbsent");
        map.putIfAbsent(i, s);
    }

    private void printLegacyIfModeIs(boolean legacyMode) {
        System.out.println("MapApp.printLegacyIfModeIs");

        if (legacyMode) {
            for (Map.Entry<Integer, String> e : map.entrySet()) {
                System.out.println("Key:" + e.getKey() + " Value:" + e.getValue());
            }
        } else {
            map.forEach((k, v) -> System.out.println("Key: " + k + " - Value: " + v));
            map.entrySet().stream().forEach(System.out::println);
        }

    }

    private void fillUp() {
        System.out.println("MapApp.fillUp");
        map = new HashMap<>();
        map.put(1, "Buddy");
        map.put(2, "Friend");
        map.put(3, "Stranger");
        map.put(4, "Who you are?");
    }
}
