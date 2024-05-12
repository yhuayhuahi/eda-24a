public class TercerAlgoritmo {
    public static void main(String[] args) {
        trianguloRecursivo(5);
    }

    public static void trianguloRecursivo(int base) {
        if (base == 1) {
            System.out.println("*");
        }
        else {
            for (int i=0; i<base; i++)
                System.out.print("*");
            System.out.println();
            trianguloRecursivo(base - 1);        
        }
    }
}
