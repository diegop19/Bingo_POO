/*
 * 
 */
package juegopackage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 *
 * @author daray
 */
public class Tombola {
    private static Tombola instance;
    private List<Integer> numerosDisponibles;
    private Random random;

    private Tombola() {
        // Inicialización de la tómbola
        numerosDisponibles = new ArrayList<>();
        for (int i = 1; i <= 75; i++) {
            numerosDisponibles.add(i);
        }
        random = new Random();
    }

    public static Tombola getInstance() {
        if (instance == null) {
            instance = new Tombola();
        }
        return instance;
    }

    public int sacarNumero() {
        int indice = random.nextInt(numerosDisponibles.size());
        int numeroSacado = numerosDisponibles.remove(indice);
        return numeroSacado;
    }
}
