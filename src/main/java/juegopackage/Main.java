/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegopackage;

import java.io.*;
import com.opencsv.*;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;
import java.util.ArrayList;
import java.util.List;
import InterfacesBingo.*;
/**
 *
 * @author daray
 */
public class Main {
    protected static List<String[]> jugadores= null;
  public static void main(String[] args) throws FileNotFoundException, IOException, CsvValidationException, CsvException{
      
      Bingo.cargarJugadores();
      
      //Jugador_Interfaz.main(args);
     generarCartonesInterfaz.main(args);
     
  }
   
  
    
      
    
  }
  
  
  

  

