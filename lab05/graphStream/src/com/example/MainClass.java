public class MainClass {
    public static void main(String[] args) {
        // Definir los arrays inorder y preorder
        Character[] inorder = {'D', 'B', 'E', 'A', 'F', 'C'};
        Character[] preorder = {'A', 'B', 'D', 'E', 'C', 'F'};
        
        // Crear una instancia de la clase Arbol
        Arbol<Character> arbol = new Arbol<>(null);
        
        // Construir el árbol a partir de los arrays
        Node<Character> raiz = arbol.construirArbol(inorder, preorder);
        
        // Establecer la raíz del árbol
        arbol.setRaiz(raiz);
        
        // Imprimir el árbol en orden inorder para verificar
        System.out.println("Inorder traversal del árbol construido:");
        inorderTraversal(arbol.getRaiz());
    }
    
    // Método para recorrer el árbol en orden inorder
    public static <T> void inorderTraversal(Node<T> nodo) {
        if (nodo != null) {
            inorderTraversal(nodo.getIzquierda());
            System.out.print(nodo.getDato() + " ");
            inorderTraversal(nodo.getDerecha());
        }
    }
}
