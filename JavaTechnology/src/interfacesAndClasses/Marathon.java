package interfacesAndClasses;

class Student {
    int time;
    String name;

    Student(String name, int time) {
        this.name = name;
        this.time = time;
    }
}

class Result {
    Student[] st;

    Result(Student[] st) {
        this.st = st;
    }

    Result sort() {

        Result sort = this;
        for (int i = st.length - 1; i > 0; i--) {
            for (int j = 1; j <= i; j++) {
                if (sort.st[j - 1].time > sort.st[j].time) {
                    Student t = sort.st[j - 1];
                    sort.st[j - 1] = sort.st[j];
                    sort.st[j] = t;
                }
            }
        }
        return sort;

    }

    Result reverseSort() {
        Result sort = this;
        for (int i = st.length - 1; i > 0; i--) {
            for (int j = 1; j <= i; j++) {
                if (sort.st[j - 1].time < sort.st[j].time) {
                    Student t = sort.st[j - 1];
                    sort.st[j - 1] = sort.st[j];
                    sort.st[j] = t;
                }
            }
        }
        return sort;

    }

    Student winner() {
        Student stud = st[0];
        for (int i = 0; i < st.length; i++) {
            if (st[i].time < stud.time)
                stud = st[i];
        }
        return stud;
    }

    Student[] threeWinners() {
        Result threeWinners = this;
        threeWinners.sort();
        Student[] stud = new Student[3];
        for (int i = 0; i < 3; i++) {
            stud[i] = st[i];
        }
        return stud;
    }

    double[] averages() {
        double avg = 0;
        for (int i = 0; i < this.st.length; i++) {
            avg += this.st[i].time;
        }
        avg = avg / this.st.length;
        double res[] = {avg, this.st.length};
        return res;
    }
}

public class Marathon {
    public static void main(String[] args) {
        int[] t = {1, 4, 3, 7, 2, 5, 6, 8, 10, 6};
        String n[] = {"vadim", "vitaliy", "misha", "rasul", "ilvar", "firzyar", "zarina", "nastyz", "aygul", "aliya"};
        Student[] st = new Student[n.length];
        for (int i = 0; i < n.length; i++) {
            st[i] = new Student(n[i], t[i]);
        }
        Result res = new Result(st);
        res.sort();
        System.out.println("SORT");
        for (int i = 0; i < res.st.length; i++) {
            System.out.println(res.st[i].name + " ran " + res.st[i].time + " minutes");
        }
        res.reverseSort();
        System.out.println("REVERSE SORT");
        for (int i = 0; i < res.st.length; i++) {
            System.out.println(res.st[i].name + " ran " + res.st[i].time);
        }
        Student win = res.winner();
        System.out.println("WINNER " + win.name + " ran " + win.time);
        Student[] threeWinners = res.threeWinners();
        System.out.println("THREE WINNERS ");
        for (int i = 0; i < 3; i++) {
            System.out.println(threeWinners[i].name + " ran " + threeWinners[i].time);
        }
        double[] d = res.averages();
        System.out.println("AVERAGE TIME  " + d[0] + "\n" + "NUMBER OF PARTICIPANTS " + d[1]);
    }
}

