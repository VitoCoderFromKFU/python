package interfacesAndClasses;

import java.util.Arrays;
import java.util.Comparator;

class Employer implements Comparable<Employer> {
    String name;
    String post;
    int payment;

    Employer() {
        name = "";
        post = "";
        payment = 0;
    }

    Employer(String name, String post, int payment) {
        this.name = name;
        this.post = post;
        this.payment = payment;
    }

    public String toString() {
        return ("Name: " + this.name + "\nPost: " + this.post + "\nPayment: " + this.payment + "\n");
    }

    @Override
    public int compareTo(Employer emp) {
        if (this.payment == emp.payment) {
            return 0;
        } else if (this.payment < emp.payment) {
            return -1;
        } else {
            return 1;
        }
    }

    public String getName() {
        return name;
    }

    public int getPayment() {
        return payment;
    }

    public String getPost() {
        return post;
    }
}

class ForComparator implements Comparator<Employer> {

    @Override
    public int compare(Employer emp1, Employer emp2) {
        return emp1.getName().compareTo(emp2.getName());
    }
}

public class Compar {
    public static void main(String[] args) {
        Employer[] employers = new Employer[5];
        employers[0] = new Employer("Vadim", "DevOps", 100);
        employers[1] = new Employer("Dasha", "Manager", 80);
        employers[2] = new Employer("Kira", "Designer", 90);
        employers[3] = new Employer("Aivaz", "Developer", 95);
        employers[4] = new Employer("Aliya", "Developer", 93);
        System.out.println("Employers: ");
        for (int i = 0; i < employers.length; i++) {
            System.out.println(employers[i]);
        }
        Arrays.sort(employers);
        System.out.println("Employers sorted by payment: ");
        for (int i = 0; i < employers.length; i++) {
            System.out.println(employers[i]);
        }
        ForComparator nc = new ForComparator();
        Arrays.sort(employers, nc);
        System.out.println("Employers sorted by name: ");
        for (int i = 0; i < employers.length; i++) {
            System.out.println(employers[i]);
        }
    }
}
