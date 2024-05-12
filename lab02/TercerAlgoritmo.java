public class TercerAlgoritmo {
    public static void main(String[] args) {
        int base = 5;
        trianguloRecursivo(base, 1);
    }

    public static void trianguloRecursivo(int base, int var) {
        if (base == var){
            for (int i=0; i<base; i++)
                System.out.print("*");        
        } 
        else {
            for (int i=0; i<var; i++)
                System.out.print("*");
            System.out.println();
            trianguloRecursivo(base, var+1);        
        }
    }
}
