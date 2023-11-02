package listadoblecircular;

public class ListaDobleCircular {

    public static void main(String[] args) {
        // TODO code application logic here
        
        ListaDoble lista = new ListaDoble();
        
        lista.inserta(new Persona(2, "Alex"));
        
        System.out.println(lista.toString());
        
        lista.inserta(new Persona(1, "Juan"));
        lista.inserta(new Persona(4, "Alberto"));
        lista.inserta(new Persona(3, "Cesar"));
        lista.inserta(new Persona(5, "Cesar"));
        
        System.out.println(lista.toString());
        
        System.out.println(lista.existe(5));
        
    }
    
}
