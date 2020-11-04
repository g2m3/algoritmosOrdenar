package objetos;

import java.util.ArrayList;
import java.util.Comparator;

public class Persona implements Comparable<Persona> {
    public int cedula, edad;

    public Persona(int d, int e) {
        this.cedula = d;
        this.edad = e;
    }

    @Override
    public int compareTo(Persona o) {
        int resultado = 0;
        if (this.edad < o.edad) {
            resultado = -1;
        } else if (this.edad > o.edad) {
            resultado = 1;
        } else {
            if (this.cedula < o.cedula) {
                resultado = -1;
            } else if (this.cedula > o.cedula) {
                resultado = 1;
            } else {
                resultado = 0;
            }
        }
        return resultado;
    }

    public String toString(){
        return cedula+" y " + edad;
    }
    
    public static void main(String arg[]) {
        Persona p1 = new Persona(11214499, 35);
        Persona p2 = new Persona(11219474, 30);
        
        if (p1.compareTo(p2) < 0) {
            System.out.println("La persona p1: es menor.");
        } else if (p1.compareTo(p2) > 0) {
            System.out.println("La persona p1: es mayor.");
        } else {
            System.out.println("La persona p1 es igual a la persona p2");
        }

        
        ArrayList<Persona> personas = new ArrayList<>();
        personas.add(p1);
        personas.add(p2);
        
        for (Persona persona : personas) {
            System.out.println("Persona: " + persona.cedula);
        }
        
        personas.sort(new Comparator() {
                @Override
                public int compare(Object o1, Object o2) {
                    Persona i1 = (Persona) o1;
                    Persona i2 = (Persona) o2;
                    return i1.compareTo(i2);
                }
            });
        
        
        for (Persona persona : personas) {
            System.out.println("Persona: " + persona.cedula);
        }
                
    }

}
