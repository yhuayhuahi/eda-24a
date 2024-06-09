public class MainClass {
    public static void main(String[] args) {
        Arbol<Integer> miArbol = new Arbol<>(new Node<Integer>(10));
        miArbol.insertar(miArbol.getRaiz(), new Node<Integer>(5));
        miArbol.insertar(miArbol.getRaiz(), new Node<Integer>(15));
        miArbol.insertar(miArbol.getRaiz(), new Node<Integer>(3));
        miArbol.insertar(miArbol.getRaiz(), new Node<Integer>(7));
    }
}
