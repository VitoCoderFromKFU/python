package interfacesAndClasses;

public class Matrix2x2 {
    private double[][] matrix = new double[2][2];

    Matrix2x2() {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                this.matrix[i][j] = 0;
            }
        }
    }

    Matrix2x2(double num) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                this.matrix[i][j] = num;
            }
        }
    }

    Matrix2x2(double a, double b, double c, double d) {
        matrix[0][0] = a;
        matrix[0][1] = b;
        matrix[1][0] = c;
        matrix[1][1] = d;
    }

    Matrix2x2(double[][] m) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                this.matrix[i][j] = m[i][j];
            }
        }

    }

    Matrix2x2 add(Matrix2x2 m) {
        Matrix2x2 res = new Matrix2x2();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                res.matrix[i][j] = m.matrix[i][j] + this.matrix[i][j];
            }
        }
        return res;
    }

    void add2(Matrix2x2 m) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                this.matrix[i][j] = m.matrix[i][j] + this.matrix[i][j];
            }
        }
    }

    Matrix2x2 sub(Matrix2x2 m) {
        Matrix2x2 res = new Matrix2x2();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                res.matrix[i][j] = this.matrix[i][j] - m.matrix[i][j];
            }
        }
        return res;
    }

    void sub2(Matrix2x2 m) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                this.matrix[i][j] = this.matrix[i][j] - m.matrix[i][j];
            }
        }
    }

    Matrix2x2 multNum(double num) {
        Matrix2x2 res = new Matrix2x2();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                res.matrix[i][j] = this.matrix[i][j] * num;
            }
        }
        return res;
    }

    void multNum2(double num) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                this.matrix[i][j] *= num;
            }
        }
    }

    Matrix2x2 mult(Matrix2x2 m) {
        Matrix2x2 res = new Matrix2x2();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                res.matrix[i][j] = 0;
                for (int k = 0; k < 2; k++) {
                    res.matrix[i][j] += this.matrix[i][k] * m.matrix[k][j];
                }
            }
        }
        return res;
    }

    void mult2(Matrix2x2 m) {
        Matrix2x2 dop = new Matrix2x2(this.matrix);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                this.matrix[i][j] = 0;
                for (int k = 0; k < 2; k++) {
                    this.matrix[i][j] += dop.matrix[i][k] * m.matrix[k][j];
                }
            }
        }
    }

    double det() {
        double res = 0;
        res = this.matrix[0][0] * this.matrix[1][1] - this.matrix[0][1] * this.matrix[1][0];
        return res;
    }

    void transpon() {
        Matrix2x2 m = new Matrix2x2(this.matrix);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                this.matrix[i][j] = m.matrix[j][i];
            }
        }
    }

    Matrix2x2 inverseMatrix() {
        Matrix2x2 res = new Matrix2x2(this.matrix);
        double det = res.det();
        if (det == 0) {
            return new Matrix2x2();
        }
        res.matrix[0][0] = this.matrix[1][1];
        res.matrix[1][1] = this.matrix[0][0];
        res.matrix[0][1] = -this.matrix[1][0];
        res.matrix[1][0] = -this.matrix[0][1];
        res.transpon();
        res.multNum2(1 / det);
        return res;
    }

    Matrix2x2 equivalentDiagonal() {

        Matrix2x2 b = new Matrix2x2(this.matrix);
        double c = b.matrix[1][0] / b.matrix[0][0];
        for (int i = 1; i >= 0; i--) {

            b.matrix[1][i] -= b.matrix[0][i] * c;
        }
        b.matrix[0][1] = 0;
        return b;
    }

    Vector2D multVector(Vector2D v) {
        Vector2D u = new Vector2D();
        u.x = v.x * this.matrix[0][0] + v.y * this.matrix[0][1];
        u.y = v.y * this.matrix[1][0] + v.x * this.matrix[1][1];
        return u;
    }

    void print() {
        for (double[] row : this.matrix) {
            for (double elem : row) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Matrix2x2 m1 = new Matrix2x2();
        System.out.println("Create empty matrix");
        m1.print();

        Matrix2x2 m2 = new Matrix2x2(4);
        System.out.println("Create matrix from one number");
        m2.print();

        Matrix2x2 m3 = new Matrix2x2(1, 2, 3, 4);
        System.out.println("Create matrix from for numbers");
        m3.print();

        double[][] a = {{1, 6}, {5, 2}};
        Matrix2x2 m4 = new Matrix2x2(a);
        System.out.println("Create matrix from mass");
        m4.print();

        Matrix2x2 add = m3.add(m4);
        System.out.println("Add:");
        add.print();

        System.out.println("Add2:");
        m3.add2(m4);
        m3.print();

        Matrix2x2 sub = m3.sub(m4);
        System.out.println("Sub:");
        add.print();

        System.out.println("sub2:");
        m3.sub2(m4);
        m3.print();

        System.out.println("MultNumber:");
        Matrix2x2 multNum = m3.multNum(8);
        multNum.print();

        System.out.println("MultNumber2:");
        m3.multNum2(8);
        m3.print();

        System.out.println("Mult:");
        Matrix2x2 mult = m3.mult(m4);
        mult.print();

        System.out.println("Mult2:");
        m3.mult2(m4);
        m3.print();

        System.out.println("Det = " + m3.det());

        System.out.println("Transpon:");
        m3.transpon();
        m3.print();

        System.out.println("Inverse matrix: ");
        Matrix2x2 inverse = m3.inverseMatrix();
        inverse.print();

        System.out.println("Eqivalent diagonal matrix: ");
        Matrix2x2 eqivalentDiag = m3.equivalentDiagonal();
        eqivalentDiag.print();


        Vector2D v = new Vector2D(2, 5);
        System.out.println("Vector: " + v.toString());
        System.out.println("MultVector");
        Vector2D res = m3.multVector(v);
        System.out.println(res.toString());


    }
}

