/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegopackage;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author daray
 */
public class RegistroDeJugadores {
    public static final String JUGADORESCSV = "jugadores.csv";
    
    public static void registrarJugador(Jugador jugador) throws FileNotFoundException, IOException{
      
    String[] nuevoJugador = {jugador.getNombre(),jugador.getCorreo(),jugador.getCedula()};
     
    try (CSVWriter writer = new CSVWriter(new FileWriter(JUGADORESCSV,true))) {
      writer.writeNext(nuevoJugador);
      writer.close();
      }
     }
  
 public static List<String[]> cargarJugadores() throws FileNotFoundException, IOException, CsvValidationException, CsvException{
   try(CSVReader reader = new CSVReader(new FileReader(JUGADORESCSV))){
     List<String[]> jugadores = reader.readAll();
     reader.close();
     return jugadores;
    }
    
 }
  
 public void prueba(){}
}
