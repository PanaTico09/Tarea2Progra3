package tarea2;

import da.Lista;
import da.Pila;

/**
 *
 * @author Johan Herrera
 */
public class Tarea2 {

    public static void main(String[] args) {
        Pila<Integer> p1 = new Pila();
        Pila<Integer> p2 = new Pila();
        Pila<Integer> p3 = new Pila();
        Pila<Integer> p4 = new Pila();
        Pila<Integer> p5 = new Pila();
        Pila<Integer> p6 = new Pila();

        p1.push(3);
        p1.push(4);
        p1.push(2);
        p1.push(5);
        p1.push(1);
        p1.push(1);
        p1.push(5);
        p1.push(2);
        p1.push(3);
        p1.push(1);

        p2.push(4);
        p2.push(1);

        p3.push(2);
        p3.push(3);

        p4.push(5);
        p4.push(1);
        
        p5.push(4);
        p5.push(5);

        Lista<Integer> lisPilas = new Lista();
        lisPilas.addStack(p1, 'z');
        lisPilas.addStack(p2, 'L');
        lisPilas.addStack(p3, 'n');
        lisPilas.addStack(p4, 'A');
        lisPilas.addStack(p5, 'P');

        System.out.println("Tamaño de la Pila:" + p1.getHeader() + " = " + p1.sizePila(p1)); //Elegir Pila.
        System.out.println("Pila:" + p1.toString());                //Imprime la pila.
        System.out.println("Lista:" + lisPilas.toString() + "\n"); //Imprime la lista de pilas.

        System.out.println(lisPilas.nivelCriticidad(p1)); //Elegir pila.
        
        lisPilas.resolverProcesos();                        //Elegir Pila y luego despligue los procesos dentro de la misma.

        System.out.println("Tamaño de la Pila: " + p1.getHeader() + " = " + p1.sizePila(p1)); // Tamaño Pila (Elegir Pila).
        System.out.println("Tamaño de la Lista: " + lisPilas.size()); // Tamaño Lista.
        System.out.println("Pila" + p1.toString()); // Imprime la pila.
        System.out.println("Lista" + lisPilas.toString()); //Imprime la lista de pilas.

    }
}
