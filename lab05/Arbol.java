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

    public Node<T> minimo(Node<T> nodoActual) {
        if (nodoActual.getIzquierda() == null) {
            return nodoActual;
        } else {
            return minimo(nodoActual.getIzquierda());
        }
    }

    public Node<T> maximo(Node<T> nodoActual) {
        if (nodoActual.getDerecha() == null) {
            return nodoActual;
        } else {
            return maximo(nodoActual.getDerecha());
        }
    }

    public Node<T> predecesor(Node<T> nodoElegido) {
        if (nodoElegido.getIzquierda() != null) {
            return maximo(nodoElegido.getIzquierda());
        } else {
            System.out.println("No tiene predecesor");
            return null;
        }
    }

    public Node<T> sucesor(Node<T> nodoElegido) {
        if (nodoElegido.getDerecha() != null) {
            return minimo(nodoElegido.getDerecha());
        } else {
            System.out.println("No tiene sucesor");
            return null;
        }
    }

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

    
}
