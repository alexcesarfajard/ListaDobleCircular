/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listadoblecircular;

/**
 *
 * @author Usuario
 */
public class ListaDoble {

    private Nodo cabeza;
    private Nodo ultimo;

    public void inserta(Persona p) {

        if (cabeza == null) {
            cabeza = new Nodo(p);
            ultimo = cabeza;
            ultimo.setSiguiente(cabeza);
            ultimo.setAnterior(ultimo);
        } else {
            if (cabeza.getDato().getId() > p.getId()) {
                Nodo aux = new Nodo(p);

                aux.setSiguiente(cabeza);
                cabeza = aux;
                ultimo.setSiguiente(cabeza);
                cabeza.setAnterior(ultimo);
            } else {
                if (p.getId() > ultimo.getDato().getId()) {
                    ultimo.setSiguiente(new Nodo(p));
                    ultimo = ultimo.getSiguiente();
                    ultimo.setSiguiente(cabeza);
                    cabeza.setAnterior(ultimo);
                } else {
                    Nodo aux = cabeza;

                    while (aux.getSiguiente().getDato().getId() < p.getId()) {
                        aux = aux.getSiguiente();
                    }

                    Nodo temp = new Nodo(p);
                    temp.setSiguiente(aux.getSiguiente());
                    temp.setAnterior(temp);
                    aux.setSiguiente(temp);
                    temp.getSiguiente().setAnterior(temp);

                }
            }
        }

    }

    public boolean existe(int id) {
        boolean existe = false;

        if (cabeza != null) {
            if (id >= cabeza.getDato().getId() && id <= cabeza.getDato().getId()) {
                
                Nodo aux = cabeza;

                while (aux != ultimo && aux.getDato().getId() <= id) {
                    aux = aux.getSiguiente();
                }
                existe = (aux.getDato().getId() == id);
            }
        } else {
            System.out.println("La lista está vacía");
        }

        return existe;
    }

    public String toString() {
        String respuesta = "Lista doble circular \n";

        if (cabeza != null) {
            Nodo aux = cabeza;

            respuesta += aux.toString() + "\n";
            aux = aux.getSiguiente();

            while (aux != cabeza) {
                respuesta += aux.toString() + "\n";
                aux = aux.getSiguiente();
            }

        } else {
            respuesta += "La lista está vacía";
        }

        return respuesta;
    }

}
