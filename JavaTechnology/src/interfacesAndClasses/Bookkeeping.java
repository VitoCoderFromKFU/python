package interfacesAndClasses;


class Employers {
    String name;
    int xp;  //mounts
    int bonus;
    Employers[] emps;

    Employers() {
        this.name = "";
        this.xp = 0;
        this.bonus = 0;
        this.emps = new Employers[0];
    }

    Employers(String name, int xp) {
        this.name = name;
        this.xp = xp;
    }

    Employers(String name, int xp, Employers[] emps) {
        this.name = name;
        this.xp = xp;
        this.emps = emps;
    }
}


public class Bookkeeping extends Employers {
    Employers[] employer = new Employers[1];

    Bookkeeping(Employers emp) {
        this.employer[0] = emp;
    }

    void addBonus(Employers employer) {
        int n = employer.emps.length;
        for (int i = 0; i < employer.emps.length; i++) {
            if (employer.emps[i].xp > 6) {
                n--;
            }
        }
        if (n > 3) {
            employer.bonus = 100;
        }
    }

    public static void main(String[] args) {
        Employers[] emps = new Employers[6];
        emps[0] = new Employers("vadim", 1);
        emps[1] = new Employers("vitaly", 1);
        emps[2] = new Employers("misha", 3);
        emps[3] = new Employers("rasul", 7);
        emps[4] = new Employers("ilvar", 9);
        emps[5] = new Employers("firzyar", 6);

        Employers emp = new Employers("zarina", 24, emps);

        Bookkeeping bookkeeping = new Bookkeeping(emp);
        bookkeeping.addBonus(emp);
        System.out.println(emp.bonus);
    }
}
