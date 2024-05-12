public class SegundoAlgoritmo {
    public static void main(String[] args) {
        int[] miArray = {1,2,3,4,5};

        System.out.println("Arreglo original:");
        for (int a: miArray)
            System.out.print(a + " - ");
            
        System.out.println();
        
        System.out.println("Arreglo Modificado:");
        for(int a: rotarIzquierdaArray(miArray, 2))
            System.out.print(a + " - ");
    }

    public static int[] rotarIzquierdaArray(int[] A, int d) {
        int[] Aiz = new int[A.length];

        int[] subArray = new int[d];
        for (int i=0; i<d; i++) {
            subArray[i] = A[i];
        }

        int a=0;
        for (int i=d; i<A.length; i++) {
            Aiz[a] = A[i];
            a++;
        }

        for (int b: subArray) {
            Aiz[a] = b;
            a++;
        }
        
        return Aiz;
    }
}
