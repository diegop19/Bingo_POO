/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegopackage;
import com.opencsv.exceptions.CsvException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
/**
 *
 * @author daray
 */
public class Bingo {
  private static ArrayList<Jugador> jugadoresRegistrados = new ArrayList<>();
  
  public Bingo() throws IOException, IOException, FileNotFoundException, CsvException{
    cargarJugadores();
  }
 
  public static void cargarJugadores() throws IOException, FileNotFoundException, CsvException{
    List<String[]> jugadores = RegistroDeJugadores.cargarJugadores();
    for(String[] jugador: jugadores){
       Jugador guardarJugador = new Jugador(jugador[0],jugador[1],jugador[2]);
       jugadoresRegistrados.add(guardarJugador);
       System.out.println("registrao");
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
  
  public static void generarCartones(){
   
      
  }
  
  
  
  
}
