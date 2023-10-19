/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegopackage;
import InterfacesBingo.*;
import com.opencsv.exceptions.CsvException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
/**
 *
 * @author daray
 */
public class Bingo {
  private static ArrayList<Jugador> jugadoresRegistrados = new ArrayList<>();
  private static ArrayList<Carton> cartonesGenerados = new ArrayList<>();
  private static String modoDeJuego;
  private static String premio;
  private static Tombola tombola;
  
  public Bingo() throws IOException, IOException, FileNotFoundException, CsvException{
    cargarJugadores();
    tombola = Tombola.getInstance();
  }
 
  public static void cargarJugadores() throws IOException, FileNotFoundException, CsvException{
    List<String[]> jugadores = RegistroDeJugadores.cargarJugadores();
    for(String[] jugador: jugadores){
       Jugador guardarJugador = new Jugador(jugador[0],jugador[1],jugador[2]);
       jugadoresRegistrados.add(guardarJugador);
     }
    
  }
  
  public static void registrarJugador(String pNombre,String pCorreo, String pCedula) throws IOException{
      boolean cedulaRepetida = jugadoresRegistrados.stream().anyMatch(jugador -> jugador.getCedula().equals(pCedula));
      if (cedulaRepetida){
        System.out.println("se repite la cedula ");
      }else{
        Jugador nuevoJugador = new Jugador(pNombre,pCorreo,pCedula);
        RegistroDeJugadores.registrarJugador(nuevoJugador);
        jugadoresRegistrados.add(nuevoJugador);
      }
  }  
  
  public static void generarCartones(int pCantidadCartones){
      if (pCantidadCartones > 500 || pCantidadCartones < 0){
        System.out.print("Cantidad invalida");
      }else{
      while(pCantidadCartones != 0){
        Carton nuevoCarton = new Carton();
        cartonesGenerados.add(nuevoCarton);
        pCantidadCartones-=1;
      }
      }   
      
  }
  
  public static void consultarCarton(String pIdentificador){
    Carton cartonEncontrado = null;
    Jugador jugadorAsociado = null;
    for(Carton carton : cartonesGenerados){
      if (carton.getIdentificador().equals(pIdentificador)){
        cartonEncontrado = carton;
        jugadorAsociado = carton.getJugadorAsignado();
      }
    }
  }
  
  public static void iniciarJuego(String pModoDeJuego, String pPremio){
    setModoDeJuego(pModoDeJuego);
    setPremio(pPremio);
    juegoEnCursoInterfaz juego = new juegoEnCursoInterfaz();
    juego.mostrarVentana();
  }
  
  public static int cantarNumero(){
    int numero = tombola.sacarNumero();
    return numero;
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  public static void setModoDeJuego(String pModoDeJuego){
    modoDeJuego = pModoDeJuego;
  }
  
  public static void setPremio(String pPremio){
    premio = pPremio;
  }
  
  public static String getModoDeJuego(){
    return modoDeJuego;
  }
  
  public static String getPremio(){
    return premio;
  }
  
  
  
}
