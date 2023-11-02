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
            Nodo aux = cabeza;

            if (id >= cabeza.getDato().getId() && id <= ultimo.getDato().getId()) {
                while (aux != ultimo) {
                    //System.out.println(aux.getSiguiente().getDato().getId());

                    if (aux.getDato().getId() == id) {
                        existe = true;
                    }
                    aux = aux.getSiguiente();
                }
                if (aux.getDato().getId() == id) {
                    existe = true;
                }
            }

        } else {
            System.out.println("La lista está vacía");
        }

        return existe;
    }

    public void modifica(Persona p) {

        if (cabeza != null) {
            Nodo aux = cabeza;

            if (p.getId() >= cabeza.getDato().getId() && p.getId() <= ultimo.getDato().getId()) {
                while (aux != ultimo) {
                    //System.out.println(aux.getSiguiente().getDato().getId());

                    if (aux.getDato().getId() == p.getId()) {
                        /*System.out.println("El id que ha pasado " + p.getId() + " nombre: " + p.getNombre() +
                                " \n es igual al id: " + aux.getDato().getId() + " con el nombre " + aux.getDato().getNombre());
                         */
                        aux.getDato().setNombre(p.getNombre());

                    }
                    aux = aux.getSiguiente();
                }
                if (aux.getDato().getId() == p.getId()) {
                    System.out.println("El ultimo nodo es el que se intenta modificar");
                    aux.getDato().setNombre(p.getNombre());
                }
            }

        } else {
            System.out.println("La lista está vacía");
        }

    }

    public void elimina(int id) {

        if (cabeza != null) {
            Nodo aux = cabeza;

            if (id >= cabeza.getDato().getId() && id <= ultimo.getDato().getId()) {
                //si el id pertenece al primer nodo
                if (cabeza.getDato().getId() == id) {
                    System.out.println("El ID que pasamos es igual al primero");
                    
                    cabeza = cabeza.getSiguiente();
                    ultimo.setSiguiente(cabeza);
                    
                } else {
                    //si el id es en medio
                    while (aux != ultimo) {                        
                        if(aux.getDato().getId() == id){
                            System.out.println("Encontramos el ID");
                        }
                        aux = aux.getSiguiente();
                    }
                }
            }

        } else {
            System.out.println("La lista está vacía");
        }

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
