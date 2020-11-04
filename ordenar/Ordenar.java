package ordenar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import objetos.Persona;

public class Ordenar { 
    static ArrayList<Persona> personas = new ArrayList<>();
    
    public static void main(String[] args) {
        Ordenar prueba = new Ordenar();
        prueba.iniciar();
        
        prueba.ordenadorCollectionComparable();
    }
    
    private void iniciar(){
        personas.add(new Persona(11214499, 35));
        personas.add(new Persona(11219474, 30));
        personas.add(new Persona(10219474, 20));
    }
    
    private void ordenadoNatural(){
        ArrayList<String> al = new ArrayList<String>(); 
        al.add("Perro"); 
        al.add("Gato"); 
        al.add("Friends"); 
        al.add("Águila"); 
        al.add("Pez"); 
  
        Collections.sort(al); 
        // en orden descendente 
        //Collections.sort(al, Collections.reverseOrder()); 
        
        System.out.println("Luego de usar" + 
                           " Collection.sort() :\n" + al);
    }
    
    private void enviandoOrdenadorDesdeClase(){
        personas.sort(new ClaseOrdenadora());
        System.out.println("Ordenado con Comparator 1: " + personas);
    }
    
    private void ordenadorDirecto(){
        personas.sort(new Comparator() {
                @Override
                public int compare(Object o1, Object o2) {
                    Persona a = (Persona) o1;
                    Persona b = (Persona) o2;
                    return a.cedula - b.cedula; 
                }
            });
        System.out.println("Ordenado con Comparator 2: " + personas);
    }
    
    private void ordenadorCollectionComparator(){
        Collections.sort(personas,  new Comparator() {
                @Override
                public int compare(Object o1, Object o2) {
                    Persona a = (Persona) o1;
                    Persona b = (Persona) o2;
                    return a.cedula - b.cedula; 
                }
            });
        System.out.println("Ordenado con Collections.sort y Comparator: " + personas);
    }
    
    private void ordenadorCollectionComparable(){ // O NATURAL
        Collections.sort(personas);
        System.out.println("Ordenado con Collections.sort y su orden natural: " + personas);
    }
}

class ClaseOrdenadora implements Comparator<Persona> 
{     
    @Override
    public int compare(Persona a, Persona b) 
    { 
        return a.cedula - b.cedula; 
    } 
} 