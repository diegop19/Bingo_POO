
package juegopackage;

/**
 * La funcion, para determinar que los jugadores no se encuentran registrados debe de estar en el main 
 * 
 */
public class Jugador {
  private String nombre;
  private String correoElectronico;
  private String cedula;
  private static int numJugadores;
  
  public Jugador(String pNombre,String pCorreoElectronico, String pCedula){
    this.nombre = pNombre;
    this.correoElectronico = pCorreoElectronico;
    this.cedula = pCedula;
    numJugadores++;
  }
  
  public String getNombre() {
    return nombre;
  }
  
  public String getCedula() {
    return cedula;
  }
  
  public String getCorreo() {
    return correoElectronico;
  }
  
  public static int getNumJugadores() {
    return numJugadores;
  }
  
  
  
          
  
    
}
