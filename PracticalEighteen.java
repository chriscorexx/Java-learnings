import java.util.*;

class PracticalEighteen {
    public static void main(String[] args) {
        Collection<String> names = new ArrayList<>();

        names.add("Chris");
        names.add("John");
        names.add("David");

        System.out.println("Collection: " + names);

        names.remove("John");

        System.out.println("After Removal: " + names);

        System.out.println("Contains Chris: " + names.contains("Chris"));

        System.out.println("Size: " + names.size());
    }
}
