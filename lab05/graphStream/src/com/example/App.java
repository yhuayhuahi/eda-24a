package graphStream.src.com.example;

import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.w3c.dom.Node;

public class App {
    public static void main(String[] args) {
        // Configurar el sistema de propiedades para usar el paquete de visualización Swing
        System.setProperty("org.graphstream.ui", "swing");

        // Crear los arrays inorder y preorder
        Character[] inorder = {'D', 'B', 'E', 'A', 'F', 'C'};
        Character[] preorder = {'A', 'B', 'D', 'E', 'C', 'F'};

        // Crear una instancia de la clase Arbol y construir el árbol
        Arbol<Character> arbol = new Arbol<>(null);
        Node<Character> raiz = arbol.construirArbol(inorder, preorder);
        arbol.setRaiz(raiz);

        // Crear el grafo y agregar los nodos del árbol
        Graph tree = new SingleGraph("Tree");
        arbol.agregarNodosAlGraph(raiz, tree);

        // Aplicar estilos al grafo
        tree.setAttribute("ui.stylesheet", "node { text-background-mode: plain; text-background-color: yellow; text-alignment: center; }");
        tree.setAttribute("ui.quality");
        tree.setAttribute("ui.antialias");

        // Mostrar el grafo
        tree.display();
    }
}
