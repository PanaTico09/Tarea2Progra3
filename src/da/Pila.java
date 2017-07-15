package da;

/**
 *
 * @author Johan Herrera
 * @param <T>
 */
public class Pila<T extends Comparable<T>> {

    private Nodo<T> cabeza;
    private Nodo<T> ultimo;
    private int size;
    private char header;

    public Pila() {
        this.cabeza = null;
        this.ultimo = null;
        this.size = 0;
        this.header = 0;
    }

    public Nodo<T> getCabeza() {
        return cabeza;
    }

    public void setCabeza(Nodo<T> cabeza) {
        this.cabeza = cabeza;
    }

    public Nodo<T> getUltimo() {
        return ultimo;
    }

    public void setUltimo(Nodo<T> ultimo) {
        this.ultimo = ultimo;
    }

    public char getHeader() {
        return header;
    }

    public void setHeader(char header) {
        this.header = header;
    }

    public boolean estaVacio() {
        return cabeza == null;
    }

    public int size() {
        return size;
    }

    /**
     * <h1>Push</h1>
     * <p>
     * Verifica si el proceso que se desea añadir esta entre [1 - 5], de ser asi
     * añade el proceso a la pila.
     * </p>
     *
     * @param proceso
     * @return boolean con el resultado de la operacion.
     */
    public boolean push(int proceso) {
        Nodo nuevo = new Nodo(proceso);
        if (proceso <= 5 && proceso > 0) {
            if (estaVacio()) {
                cabeza = nuevo;
                ultimo = nuevo;
            } else {
                ultimo.setSiguiente(nuevo);
                nuevo.setAnterior(ultimo);
                ultimo = nuevo;
            }
            size++;
            return true;
        } else {
            System.out.println("El proceso no puede ser mayor a 5 ni menor a 1.");
            return false;
        }
    }

    /**
     * <h1>Pop</h1>
     * <p>
     * Remueve el ultimo nodo de la pila. Y guarda el nodo removido.
     * </p>
     *
     * @return int con el valor del nodo removido.
     */
    public int pop() {
        if (!estaVacio()) {
            Nodo aux = ultimo;
            ultimo = ultimo.getAnterior();
            size--;
            if (ultimo == null) {
                cabeza = null;
            }
            return (int) aux.getDato();
        } else {
            return -1;
        }
    }

    /**
     * <h1>Peek</h1>
     * <p>
     * Devuelve el valor del ultimo nodo de la pila.
     * </p>
     *
     * @return T: con el dato.
     */
    public T peek() {
        if (!estaVacio()) {
            return ultimo.getDato();
        } else {
            return null;
        }
    }

    /**
     * <h1>sizePila</h1>
     * <p>
     * Calcula el size de la pila.
     * </p>
     *
     * @param pila
     *
     * @return int con el tamaño de la pila.
     */
    public int sizePila(Pila pila) {
        if (!estaVacio()) {
            Pila pilaAux = pila;
            Nodo aux = pilaAux.cabeza;
            int cont = 0;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
                pilaAux.push((int) pilaAux.peek());
                pilaAux.pop();
                cont++;
            }
            return cont;
        }
        return 0;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Nodo aux = cabeza;
        if (!estaVacio()) {
            int cont = 0;
            builder.append("(");
            if (getHeader() != 0) {
                builder.append(getHeader()).append(": ");
            }
            while (cont < size) {
                builder.append(aux.getDato());
                builder.append(", ");
                aux = aux.getSiguiente();
                ++cont;
            }
            builder.append(")");
            return builder.toString();
        } else {
            if (getHeader() != 0) {
                builder.append(getHeader()).append(": ");
            }
            return "(La Pila " + builder.toString() + "esta vacia.)";
        }
    }
}
