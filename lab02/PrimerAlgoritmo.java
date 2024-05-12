public class PrimerAlgoritmo {
    public static void main(String[] args) {
        int[] miArray = {1, 2, 3, 4, 5};
        
        System.out.println("Arreglo Original:");
        for(int a: miArray) {
            System.out.print(a+"-");
        }
        System.out.println();
        
        int[] miArrayInv = invertirArray(miArray);
        
        System.out.println("Arreglo Invertido");
        for(int b: miArrayInv) {
            System.out.print(b+"-");
        }
        System.out.println();    
    }

    public static int[] invertirArray(int[] A) {
        int[] Ain = new int[A.length];
        int pos = A.length-1;
        int j=0;
        for (int i=pos; i > -1; i--) {
            Ain[i] = A[j];
            j++;
        }
        return Ain;
    }
}
