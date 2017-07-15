/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;

import javax.swing.JOptionPane;

/**
 *
 * @author Johan Herrera
 * @param <T>
 */
public class Lista<T extends Comparable<T>> {

    private Nodo<T> cabeza;
    private int size;

    public Lista() {
        this.cabeza = null;
        this.size = 0;
    }

    public Nodo<T> getCabeza() {
        return cabeza;
    }

    public void setCabeza(Nodo<T> cabeza) {
        this.cabeza = cabeza;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return cabeza == null;
    }

    /**
     * <h1>AddStack</h1>
     * <p>
     * Agrega una pila a la lista y a esta se le asigna un caracter como
     * cabecera de pila.</p>
     *
     * @param pila
     * @param cabecera
     * @return boolean con el resultado de la operacion.
     *
     */
    public boolean addStack(Pila<T> pila, char cabecera) {
        boolean bandera = true;
        if ((abcMayus(cabecera) || abcMinus(cabecera)) && !validarCabecera(cabecera)) {
            Nodo nuevo = new Nodo(pila);
            pila.setHeader(cabecera);

            if (null == cabeza) {
                cabeza = nuevo;
            } else {
                Nodo aux = cabeza;
                while (aux.getSiguiente() != null) {
                    aux = aux.getSiguiente();
                }
                aux.setSiguiente(nuevo);
                nuevo.setAnterior(aux);
            }
            nuevo.setPila(pila);
            size++;
        } else if (!(abcMayus(cabecera) || abcMinus(cabecera))) {
            System.err.println("Debe utilizar una letra del abecedario como cabecera de la pila.");
            bandera = false;
        }
        return bandera;
    }

    /**
     * <h1>AbcMayus</h1>
     * <p>
     * Verifica si el caracter introducido es una letra del abecedario en
     * Mayuscula. De ser asi permite que esta sea agregada como cabecera de la
     * pila.</p>
     *
     * @param cabecera
     * @return boolean: el resultado de la operacion.
     */
    public boolean abcMayus(char cabecera) {
        char a = (char) 65;
        boolean bandera = false;
        for (int i = 0; i < 26; i++) {
            if (a == cabecera) {
                bandera = true;
            } else {
                a = (char) (a + 1);
            }
        }
        return bandera;
    }

    /**
     * <h1>AbcMinus</h1>
     * <p>
     * Verifica si el caracter introducido es una letra del abecedario en
     * Minuscula. De ser asi permite que esta sea agregada como cabecera de la
     * pila.</p>
     *
     * @param cabecera
     * @return boolean: el resultado de la operacion.
     */
    public boolean abcMinus(char cabecera) {
        char a = (char) 97;
        boolean bandera = false;
        for (int i = 0; i < 26; i++) {
            if (a == cabecera) {
                bandera = true;
            } else {
                a = (char) (a + 1);
            }
        }
        return bandera;
    }

    /**
     * <h1>ValidarCabecera</h1>
     * <p>
     * Si la lista no se encuentra vacia, la recorre buscando si hay similitud
     * entre la cabecera entrante y una ya asignada, sino tiene similitud
     * permite añadir la misma como cabecera de la pila, caso contrario dira que
     * no se puede tener el mismo caracter como cabecera de otra pila.</p>
     *
     * @param cabecera
     * @return boolean bandera: con el resultado de la operacion.
     */
    public boolean validarCabecera(char cabecera) {
        boolean bandera = false;
        Nodo aux = cabeza;
        if (!isEmpty()) {
            while (aux != null) {
                if (aux.getPila().getHeader() == cabecera) {
                    System.err.println("No puede añadir dos veces la misma letra para otra pila.");
                    bandera = true;
                    break;
                }
                aux = aux.getSiguiente();
            }
        }
        return bandera;
    }

    /**
     * <h1>AddToStack</h1>
     * <p>
     * Agrega un proceso a la pila seleccionada.</p>
     *
     * @param pila
     * @param proceso
     * @return boolean: el resultado de la operacion.
     */
    public boolean addToStack(Pila<T> pila, int proceso) {
        pila.push(proceso);
        return true;
    }

    /**
     * <h1>ResolverProcesos</h1>
     * <p>
     * Este metodo se encarga de resolver los procesos dentro de las pilas.
     * Ademas de que este metodo utiliza otro metodo para buscar cual pila debe
     * realizar sus procesos con una prioridad mayor alfabeticamente [A-Z][a-z].
     * Luego recorre la pila buscando los procesos que requieran una prioridad
     * mucho mayor. Es decir en el siguiente orden: [5,4,3,2,1] y los resuelve
     * en ese orden, hasta que la pila se encuentre vacia.</p>
     *
     * @return boolean: con el resultado de la operacion.
     */
    public boolean resolverProcesos() {
        if (!isEmpty()) {
            Pila temporal = new Pila();
            Nodo aux2 = cabeza;
            int numTemp, cont = 0, cont2 = 0, total = 0, num1 = 0, num2 = 0, num3 = 0, num4 = 0, num5 = 0, recorrer = 0;

            while (recorrer < size) {
                char mayPri = cabMenor();
                while (aux2.getPila().getHeader() != mayPri) {
                    aux2 = aux2.getSiguiente();
                }

                Nodo aux = aux2.getPila().getCabeza();
                while (cont < aux2.getPila().size()) {
                    if (aux.getDato().equals(5)) {
                        num5++;
                    } else if (aux.getDato().equals(4)) {
                        num4++;
                    } else if (aux.getDato().equals(3)) {
                        num3++;
                    } else if (aux.getDato().equals(2)) {
                        num2++;
                    } else if (aux.getDato().equals(1)) {
                        num1++;
                    }
                    cont++;
                    aux = aux.getSiguiente();
                }

                int sum = num1 + num2 + num3 + num4 + num5;
                aux = aux2.getPila().getUltimo();
                cont = 0;
                while (total < sum) {
                    if (num5 > 0) {
                        while (0 < num5) {
                            while (aux.getAnterior() != null) {
                                if (aux.getDato().equals(5)) {
                                    break;
                                }
                                cont2++;
                                aux = aux.getAnterior();
                            }
                            while (cont < cont2) {
                                numTemp = aux2.getPila().pop();
                                temporal.push(numTemp);
                                cont++;
                            }
                            cont = 0;
                            if (aux.getDato().equals(5)) {
                                aux2.getPila().pop();
                            }
                            while (cont < cont2) {
                                if (!temporal.estaVacio()) {
                                    numTemp = temporal.pop();
                                    aux2.getPila().push(numTemp);
                                }
                                cont++;
                            }
                            aux = aux2.getPila().getUltimo();
                            num5--;
                        }
                    } else if (num4 > 0) {
                        while (0 < num4) {
                            while (aux.getAnterior() != null) {
                                if (aux.getDato().equals(4)) {
                                    break;
                                }
                                cont2++;
                                aux = aux.getAnterior();
                            }
                            while (cont < cont2) {
                                numTemp = aux2.getPila().pop();
                                temporal.push(numTemp);
                                cont++;
                            }
                            cont = 0;
                            if (aux.getDato().equals(4)) {
                                aux2.getPila().pop();
                            }
                            while (cont < cont2) {
                                if (!temporal.estaVacio()) {
                                    numTemp = temporal.pop();
                                    aux2.getPila().push(numTemp);
                                }
                                cont++;
                            }
                            aux = aux2.getPila().getUltimo();
                            num4--;
                        }
                    } else if (num3 > 0) {
                        while (0 < num3) {
                            while (aux.getAnterior() != null) {
                                if (aux.getDato().equals(3)) {
                                    break;
                                }
                                cont2++;
                                aux = aux.getAnterior();
                            }
                            while (cont < cont2) {
                                numTemp = aux2.getPila().pop();
                                temporal.push(numTemp);
                                cont++;
                            }
                            cont = 0;
                            if (aux.getDato().equals(3)) {
                                aux2.getPila().pop();
                            }
                            while (cont < cont2) {
                                if (!temporal.estaVacio()) {
                                    numTemp = temporal.pop();
                                    aux2.getPila().push(numTemp);
                                }
                                cont++;
                            }
                            aux = aux2.getPila().getUltimo();
                            num3--;
                        }
                    } else if (num2 > 0) {
                        while (0 < num2) {
                            while (aux.getAnterior() != null) {
                                if (aux.getDato().equals(2)) {
                                    break;
                                }
                                cont2++;
                                aux = aux.getAnterior();
                            }
                            while (cont < cont2) {
                                numTemp = aux2.getPila().pop();
                                temporal.push(numTemp);
                                cont++;
                            }
                            cont = 0;
                            if (aux.getDato().equals(2)) {
                                aux2.getPila().pop();
                            }
                            while (cont < cont2) {
                                if (!temporal.estaVacio()) {
                                    numTemp = temporal.pop();
                                    aux2.getPila().push(numTemp);
                                }
                                cont++;
                            }
                            aux = aux2.getPila().getUltimo();
                            num2--;
                        }
                    } else if (num1 > 0) {
                        while (0 < num1) {
                            while (aux.getAnterior() != null) {
                                if (aux.getDato().equals(1)) {
                                    break;
                                }
                                cont2++;
                                aux = aux.getAnterior();
                            }
                            while (cont < cont2) {
                                numTemp = aux2.getPila().pop();
                                temporal.push(numTemp);
                                cont++;
                            }
                            cont = 0;
                            if (aux.getDato().equals(1)) {
                                aux2.getPila().pop();
                            }
                            while (cont < cont2) {
                                if (!temporal.estaVacio()) {
                                    numTemp = temporal.pop();
                                    aux2.getPila().push(numTemp);
                                }
                                cont++;
                            }
                            aux = aux2.getPila().getUltimo();
                            num1--;
                        }
                    }
                    aux = aux2.getPila().getUltimo();
                    cont2 = 0;
                    cont = 0;
                    total++;
                }
                if (0 == aux2.getPila().size()) {
                    char cab = aux2.getPila().getHeader();
                    JOptionPane.showMessageDialog(null, "\n" + "TODOS LOS PROCESOS DE LA PILA '" + cab + "' HAN SIDO COMPLETADOS SATISFACTORIAMENTE." + "\n");
                }
                aux2 = cabeza;
                cont = 0;
                cont2 = 0;
                total = 0;
                num1 = 0;
                num2 = 0;
                num3 = 0;
                num4 = 0;
                num5 = 0;
                recorrer++;
            }

            if (recorrer == size()) {
                JOptionPane.showMessageDialog(null, "TODOS LOS PROCESOS DE LA LISTA HAN SIDO COMPLETADOS" + "\n");
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * <h1>NivelCriticidad</h1>
     * <p>
     * Busca los mensajes para los procesos de la pila.</p>
     *
     * @param pila
     * @return String con el mensaje de la importancia de dicho proceso.
     */
    public String nivelCriticidad(Pila<T> pila) {
        if (!isEmpty() && pila.size() > 0) {
            Nodo aux = pila.getCabeza();
            int cont = 0;
            StringBuilder mensaje = new StringBuilder();
            mensaje.append("Procesos de la pila: ").append(pila.getHeader()).append("\n");
            while (cont < pila.size()) {
                if (aux.getDato().equals(5)) {
                    mensaje.append("El proceso numero: ").append(aux.getDato()).append(" es el proceso mas importante." + "\n");
                } else if (aux.getDato().equals(4)) {
                    mensaje.append("El proceso numero: ").append(aux.getDato()).append(" es el segundo proceso de mas importancia." + "\n");
                } else if (aux.getDato().equals(3)) {
                    mensaje.append("El proceso numero: ").append(aux.getDato()).append(" es el tercer proceso de mas importancia." + "\n");
                } else if (aux.getDato().equals(2)) {
                    mensaje.append("El proceso numero: ").append(aux.getDato()).append(" es uno de los procesos de menor importancia." + "\n");
                } else if (aux.getDato().equals(1)) {
                    mensaje.append("El proceso numero: ").append(aux.getDato()).append(" es el proceso menos importante." + "\n");
                }
                cont++;
                aux = aux.getSiguiente();
            }
            return mensaje.toString();
        } else if (isEmpty()) {
            return "La lista esta vacia.";
        } else {
            return "La pila se encuentra vacia.";
        }
    }

    /**
     * <h1>CabMenor</h1>
     * <p>
     * Recorre la lista buscando cual es el header(cabecera) menor, es decir la
     * cabecera que debe ser ejecutada primero. Siempre y cuando la pila al que
     * pertenece este no se encuentre vacia</p>
     *
     * @return char menor en la lista.
     */
    public char cabMenor() {
        Nodo aux = cabeza;
        char menor = 0;
        if (!isEmpty()) {
            for (int i = 0; i < size; i++) {
                if (menor == 0) {
                    menor = aux.getPila().getHeader();
                } else if (menor > aux.getPila().getHeader() && !aux.getPila().estaVacio()) {
                    menor = aux.getPila().getHeader();
                }
                aux = aux.getSiguiente();
            }
            return menor;
        } else {
            return 0;
        }
    }

    /**
     * <h1>Remove</h1>
     * <p>
     * Verifica si hay un nodo en la posicion que se desea eliminar. De ser asi
     * elimina el nodo de dicha posicion.
     * </p>
     *
     * @param index
     * @return boolean con el resultado de la operacion.
     */
    public boolean remove(int index) {
        if (isEmpty()) {
            return false;
        } else if (0 > index || index > size - 1) {
            throw new ArrayIndexOutOfBoundsException("Indice invalido");
        } else {
            if (0 == index) {
                cabeza = cabeza.getSiguiente();
            } else if (index == size - 1) {
                Nodo aux = cabeza;
                for (int i = 0; i < index - 1; i++) {
                    aux = aux.getSiguiente();
                }
                aux.setSiguiente(null);
            } else {
                Nodo aux = cabeza;
                for (int i = 0; i < index - 1; i++) {
                    aux = aux.getSiguiente();
                }
                aux.setSiguiente(aux.getSiguiente().getSiguiente());
            }
            --size;
            return true;
        }
    }

    @Override
    public String toString() {
        if (!isEmpty()) {
            StringBuilder builder = new StringBuilder();
            Nodo aux = cabeza;
            builder.append("[");
            int cont = 0;
            while (cont < size) {
                builder.append("");
                builder.append(aux.getDato());
                builder.append(" ");
                aux = aux.getSiguiente();
                ++cont;
            }
            builder.append("]");
            return builder.toString();
        } else {
            return "La lista esta vacia.";
        }
    }

}
