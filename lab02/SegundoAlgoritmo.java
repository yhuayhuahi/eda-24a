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

        // Subarreglo para los primeros elementos hasta
        // el indice 'd'.
        int[] subArray = new int[d];
        for (int i=0; i<d; i++) {
            subArray[i] = A[i];
        }

        // El resto de elementos de la lista se guardan
        // en el arreglo 'Aiz'
        int a=0;
        for (int i=d; i<A.length; i++) {
            Aiz[a] = A[i];
            a++;
        }

        // Se concatena el subarreglo al final de 'Aiz'
        for (int b: subArray) {
            Aiz[a] = b;
            a++;
        }
        return Aiz;
    }
}
