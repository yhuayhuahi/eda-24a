import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;

import java.util.HashMap;
import java.util.Map;

public class Arbol<T extends Comparable<T>> {
    
    private Node<T> raiz;

    public Arbol(Node<T> raiz) {
        this.raiz = raiz;
    }
    public Node<T> getRaiz() {
        return this.raiz;
    }
    public void setRaiz(Node<T> raiz) {
        this.raiz = raiz;
    }

    // Metodo para insertar nodos al arbol siguiendo las condiciones del BST
    public String insertar(Node<T> nodoActual, Node<T> nodoNuevo) {
        int valor = nodoActual.getDato().compareTo(nodoNuevo.getDato());
        if (valor == 0) {
            return "El nodo ya existe";
        } else if (valor > 0) {
            if (nodoActual.getIzquierda() == null) {
                nodoActual.setIzquierda(nodoNuevo);
                return "Nodo insertado con exito I";
            } else {
                insertar(nodoActual.getIzquierda(), nodoNuevo);
            }
        } else {
            if (nodoActual.getDerecha() == null) {
                nodoActual.setDerecha(nodoNuevo);
                return "Nodo insertado con exito D";
            } else {
                insertar(nodoActual.getDerecha(), nodoNuevo);
            }
        } 
        return "No se pudo insertar el nodo";
    }
    
    // Metodo para buscar un nodo en el arbol
    public Node<T> buscar(Node<T> nodoActual, T valor) {
        if (nodoActual == null) {
            System.out.println("Nodo no encontrado");
            return null;
        } else {
            if (nodoActual.getDato().compareTo(valor) == 0) {
                System.out.println("Nodo encontrado");
                return nodoActual;
            } else if (nodoActual.getDato().compareTo(valor) > 0) {
                return buscar(nodoActual.getIzquierda(), valor);
            } else {
                return buscar(nodoActual.getDerecha(), valor);
            }
        }
    }

    // Metodo para buscar el elemento con el valor minimo en el arbol
    public Node<T> minimo(Node<T> nodoActual) {
        if (nodoActual.getIzquierda() == null) {
            return nodoActual;
        } else {
            return minimo(nodoActual.getIzquierda());
        }
    }

    // Metodo para buscar el elemento con el valor maximo en el arbol
    public Node<T> maximo(Node<T> nodoActual) {
        if (nodoActual.getDerecha() == null) {
            return nodoActual;
        } else {
            return maximo(nodoActual.getDerecha());
        }
    }

    // Metodo para buscar el predecesor de un nodo
    public Node<T> predecesor(Node<T> nodoElegido) {
        if (nodoElegido.getIzquierda() != null) {
            return maximo(nodoElegido.getIzquierda());
        } else {
            System.out.println("No tiene predecesor");
            return null;
        }
    }

    // Metodo para buscar el sucesor de un nodo
    public Node<T> sucesor(Node<T> nodoElegido) {
        if (nodoElegido.getDerecha() != null) {
            return minimo(nodoElegido.getDerecha());
        } else {
            System.out.println("No tiene sucesor");
            return null;
        }
    }

    // Metodo para eliminar un nodo del arbol, usa otros metodos auxiliares
    public void eliminar(Node<T> nodoActual, T valor) {
        if (nodoActual == null) {
            System.out.println("Nodo no encontrado");
        } else {
            if (nodoActual.getDato().compareTo(valor) == 0) {
                if (nodoActual.getIzquierda() == null && nodoActual.getDerecha() == null) {
                    nodoActual = null;
                } else if (nodoActual.getIzquierda() == null) {
                    nodoActual = nodoActual.getDerecha();
                } else if (nodoActual.getDerecha() == null) {
                    nodoActual = nodoActual.getIzquierda();
                } else {
                    Node<T> predecesor = predecesor(nodoActual);
                    nodoActual.setDato(predecesor.getDato());
                    eliminar(nodoActual.getIzquierda(), predecesor.getDato());
                }
            } else if (nodoActual.getDato().compareTo(valor) > 0) {
                eliminar(nodoActual.getIzquierda(), valor);
            } else {
                eliminar(nodoActual.getDerecha(), valor);
            }
        }
    }

    // Metodo para construir un arbol a partir de los arrays inorder y preorder
    public Node<T> construirArbol(T[] inorder, T[] preorder) {
        Map<T, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return construirArbolHelper(preorder, 0, preorder.length - 1, inorderMap, 0, inorder.length - 1);
    }

    //Metodo auxiliar de construirArbol
    private Node<T> construirArbolHelper(T[] preorder, int preInicio, int preFin, Map<T, Integer> inorderMap, int inInicio, int inFin) {
        if (preInicio > preFin || inInicio > inFin) {
            return null;
        }

        T rootVal = preorder[preInicio];
        Node<T> root = new Node<>(rootVal);
        int inRoot = inorderMap.get(rootVal);
        int numsLeft = inRoot - inInicio;

        root.setIzquierda(construirArbolHelper(preorder, preInicio + 1, preInicio + numsLeft, inorderMap, inInicio, inRoot - 1));
        root.setDerecha(construirArbolHelper(preorder, preInicio + numsLeft + 1, preFin, inorderMap, inRoot + 1, inFin));

        return root;
    }

    // Metodo para agregar los nodos del arbol. Esto para graficar con la libreria GraphStream
    public void agregarNodosAlGraph(Node<T> nodo, Graph graph) {
        if (nodo == null) {
            return;
        }

        // Agregar el nodo actual al grafo
        String nodoId = nodo.getDato().toString();
        if (graph.getNode(nodoId) == null) {
            graph.addNode(nodoId);
            graph.getNode(nodoId).setAttribute("ui.label", nodoId);
        }

        // Agregar el subárbol izquierdo
        if (nodo.getIzquierda() != null) {
            String izquierdaId = nodo.getIzquierda().getDato().toString();
            if (graph.getNode(izquierdaId) == null) {
                graph.addNode(izquierdaId);
                graph.getNode(izquierdaId).setAttribute("ui.label", izquierdaId);
            }
            graph.addEdge(nodoId + izquierdaId, nodoId, izquierdaId);
            agregarNodosAlGraph(nodo.getIzquierda(), graph);
        }

        // Agregar el subárbol derecho
        if (nodo.getDerecha() != null) {
            String derechaId = nodo.getDerecha().getDato().toString();
            if (graph.getNode(derechaId) == null) {
                graph.addNode(derechaId);
                graph.getNode(derechaId).setAttribute("ui.label", derechaId);
            }
            graph.addEdge(nodoId + derechaId, nodoId, derechaId);
            agregarNodosAlGraph(nodo.getDerecha(), graph);
        }
    }
}
/*
         A
        / \
       B   C
      / \   \
     D   E   F
*/ 