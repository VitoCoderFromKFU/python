package collections;

import java.util.*;

class Pet {
    String type;
    String family;

    Pet() {
        type = "";
        family = "";
    }

    Pet(String type, String family) {
        this.type = type;
        this.family = family;
    }

    @Override
    public String toString() {
        return ("Family: " + family + "\nType: " + type + "\n");
    }

    public String getFamily() {
        return family;
    }

    public String getType() {
        return type;
    }

}


public class First {
    public static void main(String[] args) {
        Pet[] pets = new Pet[4];
        pets[0] = new Pet("Cat", "Cat");
        pets[1] = new Pet("Dog", "Canine");
        pets[2] = new Pet("Rabbit", "Hare");
        pets[3] = new Pet("Horse", "Horse");
        LinkedList<Pet> petList = new LinkedList<Pet>(List.of(pets));
        System.out.print("As Obj  \n" + petList);

        System.out.println("\nFirst:" + petList.get(0));
        System.out.println("Last:" + petList.get(petList.size() - 1));

        Pet p = petList.remove(petList.size() - 1);
        System.out.println("Removing last and printing it: \n" + p);
        System.out.println("List after removed last:\n" + petList);

        p = petList.remove(0);
        System.out.println("Removing first and printing it:\n" + p);
        System.out.println("List after removed first:\n" + petList);

        p = petList.poll();
        System.out.println("Removing first(poll) and printing it:\n" + p);

        p = new Pet("Cavy", "Piggy");
        petList.addFirst(p);
        System.out.println("Add first and print List: \n" + petList);

        p = new Pet("I'm not pet", "Shark");
        petList.offer(p);
        System.out.println("Offer 1: \n" + petList);

        p = new Pet("Dragon", "Dragon");
        petList.offer(p);
        System.out.println("Offer 2: \n" + petList);

    }
}
