package collections;

import java.util.*;

public class TreeLinkedHashSet {
    public static void main(String[] args) {
        Random random = new Random();
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        int n;
        int min = -50;
        int max = 50;
        for (int i = 0; i < 50; i++) {
            n = random.nextInt(max - min + 1);
            hashSet.add(n);
            treeSet.add(n);
            linkedHashSet.add(n);
        }
        System.out.println("Hash set: \n" + hashSet);
        System.out.println("Tree set: \n" + treeSet);
        System.out.println("Linked hash set : \n" + linkedHashSet);

        HashSet<Integer> hashSet1 = new HashSet<>(List.of(1, 2, 3, 4, 5, 7, 8, 9, 10));
        System.out.println("Hash set1: \n" + hashSet1);
        System.out.println("Hash set1 in Tree set?: " + treeSet.containsAll(hashSet1));
        treeSet.removeAll(hashSet1);
        System.out.println("Tree set after remove: \n" + treeSet);
    }
}
