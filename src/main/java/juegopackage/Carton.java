/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegopackage;

/**
 *
 * @author daray
 */
import java.util.Random;
import java.util.ArrayList;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Abstraccion de la clase Carton
 * 
 * @author Diego Araya 
 * @author Mary Paz Álvarez
 * @author Raul Alfaro
 */
public class Carton {
  private String identificador;
  private int[][] carton;
  private boolean[][] cartonMarcado;
  private ArrayList<Integer> numerosGenerados;
  
  private static int contador = 0;
  
  /**
   * Constructor de la clase Carton.
   * Crea el carton (matriz y magen), el identificador 
   * y crear el estado predeterminado de el cartonMarcado.
   */
  public Carton() {
    identificador = generarIdentificador();
    
    numerosGenerados = new ArrayList<Integer>();
    numerosGenerados.add(0);
    
    carton = new int [5][5];
    rellenarCarton();
    
    cartonMarcado = new boolean [5][5];
    rellenarCartonMarcado();
    
    generarImagen();
    
    contador++;
  }
  
  /**
   * Genera el identificador alfanumerico del carton
   * 
   * @return cadena  identificador del carton
   */
  public String generarIdentificador() {
    String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String numeros = "0123456789";
    
    String identi= " ";
    Random random = new Random();
    
    for (int i = 0; i < 3; i++) {
      // genera un numero aleatorio
      int posicion= random.nextInt(letras.length()); 
      // con el numero aleatorio elige una letra en esa posicion 
      char letra = letras.charAt(posicion);
      identi = identi + letra;
    }
    
    for (int i = 0; i < 3; i++) {
      // genera un numero aleatorio
      int posicion= random.nextInt(numeros.length()); 
      // con el numero aleatorio elige una letra en esa posicion 
      char numero = numeros.charAt(posicion);
      identi = identi + numero;
    }
    
    return identi;
  }
  
  /**
   * Rellena el carton con núemeros aleatorios en las columnas correspondientes
   */
  public void rellenarCarton() {
    //B
    for(int i = 0; i < 5; i++) { 
      int numeroB = generarNumero(1, 15);
      carton[i][0] = numeroB;
    }
    
    //I
    for(int i = 0; i < 5; i++) {
      int numeroI = generarNumero(16, 30);
      carton[i][1] = numeroI;
    }
    
    //N
    for(int i = 0; i < 5; i++) {
      int numeroN = generarNumero(31, 45);
      carton[i][2] = numeroN;
    }
    
    //G
    for(int i = 0; i < 5; i++) {
      int numeroG = generarNumero(46, 60);
      carton[i][3] = numeroG;
    }
    
    //O
    for(int i = 0; i < 5; i++) {
      int numeroO = generarNumero(61, 75);
      carton[i][4] = numeroO;
    }
    
  }
  
  /**
   * Genera un numero aleatorio segun un rango dado para rellenar el carton
   * 
   * @param max  el numero mayor del rango
   * @param min  el numero menor del rango
   * @return numeroRandom  el numero generado
   */
  public int generarNumero(int max, int min) {
    int numeroRandom = (int) (Math.random() * ((max - min) + 1)) + min;
    boolean repetido = false;
    
    for(Integer numeroGenerado: numerosGenerados) {
      if(numeroGenerado == numeroRandom) {
        repetido = true;
      }
      
    }
    
    if (repetido == true) {
      return generarNumero(max, min);
    }
    
    numerosGenerados.add(numeroRandom);
    return numeroRandom;
  }
  
  /**
   * Rellena el carton marcado con false (estado predeterminado)
   */
  public void rellenarCartonMarcado() {
    for(int i = 0; i < 5; i++) {
      for(int j = 0; j < 5; j++) {
        cartonMarcado[i][j] = false;
      }
      
    }
    
  }
  
  /**
   * Marca el carton con true si el numero esta en algun carton
   * 
   * @param pNumero  El numero cantado
   */
  public void marcarCarton(int pNumero) {
    for(int i = 0; i < 5; i++) {
      for(int j = 0; j < 5; j++) {
        int numeroCarton = carton[i][j];
        if(numeroCarton == pNumero) {
          cartonMarcado[i][j] = true;
        }
        
      }
      
    }
  }
  
  /**
   * Genera la imagen del carton y la guarda en una carpeta
   */
  private void generarImagen() {
    int anchoCarton = 300; // Ancho de la imagen y de la celda del Identificador
    int altoCarton = 406; // Alto de la imagen

    BufferedImage imagen = new BufferedImage(anchoCarton, altoCarton, BufferedImage.TYPE_INT_RGB);
    Graphics graficos = imagen.getGraphics();
        
    // Medidas de las celdas
    int anchoTitulo = anchoCarton/5;
    int altoTitulo = altoCarton/7; // Mismo que el del Identificador
        
    int anchoAltoNumero = (anchoCarton-10)/5; // Tambien (altoCarton-(altoTitulo*2))/5
        
    // Color del carton
    Color VERY_LIGHT_RED = new Color(255,102,102);
        
    // Crear carton en imagen en imagen
    graficos.setColor(VERY_LIGHT_RED);
    graficos.fillRect(0, 0, anchoCarton, altoCarton);
        
    // Posicionar BINGO en el titulo
    String[] titulo = {"B","I","N","G","O"};
    graficos.setColor(Color.WHITE);
    graficos.setFont(new Font("Arial", Font.PLAIN, 24));
        
    for(int t = 0; t < 5; t++) {
      String letra = titulo[t];
      int xT = t * anchoTitulo + anchoTitulo / 2 - graficos.getFontMetrics().stringWidth(letra) / 2;
      int yT = altoTitulo / 2 + graficos.getFontMetrics().getHeight() / 4;
      graficos.drawString(letra, xT, yT);
    }
        
    int medCuad = anchoCarton - 10;
    int posicionX = 5;
    int posicionY = 58;
        
    // Crear celdas para numeros en imagen
    graficos.setColor(Color.WHITE);
    graficos.fillRect(posicionX, posicionY, medCuad, medCuad);
        
    // Lineas verticales
    graficos.setColor(VERY_LIGHT_RED);
    graficos.fillRect(posicionX, altoTitulo, 1, medCuad);
        
    for(int v = 1; v < 5; v++) {
      posicionX = posicionX + anchoAltoNumero;
      graficos.setColor(VERY_LIGHT_RED);
      graficos.fillRect(posicionX, altoTitulo, 1, medCuad);
    }
        
    // Lineas horizontales
    graficos.setColor(VERY_LIGHT_RED);
    graficos.fillRect(5, posicionY, medCuad, 1);
        
    for(int h = 1; h < 5; h++) {
      posicionY = posicionY + anchoAltoNumero;
      graficos.setColor(VERY_LIGHT_RED);
      graficos.fillRect(5, posicionY, medCuad, 1);
    }

    graficos.setColor(Color.BLACK);
    graficos.setFont(new Font("Arial", Font.PLAIN, 24));
        
    posicionX = 5;
    posicionY = 58;
    
    // Escribe los numeros en la imagen
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        String numero = Integer.toString((carton[i][j]));
        int xN= 0;
        int yN = 0;
        if(j == 0) {
          xN = posicionX + anchoAltoNumero / 2 - graficos.getFontMetrics().stringWidth(numero) / 2;
        } else {
            posicionX = posicionX + anchoAltoNumero;
            xN = posicionX + anchoAltoNumero / 2 - graficos.getFontMetrics().stringWidth(numero) / 2;
        }
                
        if(i == 0) {
          yN = posicionY + anchoAltoNumero / 2 + graficos.getFontMetrics().getHeight() / 4;
        } else {
            yN = posicionY + anchoAltoNumero / 2 + graficos.getFontMetrics().getHeight() / 4;
        }
                
        graficos.drawString(numero, xN, yN);
      }
            
      posicionX = 5;
      posicionY = posicionY + anchoAltoNumero;
    }
        
    graficos.setColor(Color.WHITE);
    graficos.setFont(new Font("Arial", Font.PLAIN, 24));
    
    // Escribe el indentificador abjo en la imagen
    String msgIdentificador = "Identificador: " + identificador;
    int xI = anchoCarton / 2 - graficos.getFontMetrics().stringWidth(msgIdentificador) / 2;
    int yI = 6 * altoTitulo + altoTitulo / 2 + graficos.getFontMetrics().getHeight() / 4;
    graficos.drawString(msgIdentificador, xI, yI);
        
    // Guarda la imagen en un archivo
    File carpeta = new File("cartones"); // Nombre de la carpeta donde se va aguardar la imagen
    String nombreImagen = identificador + ".png";
    File archivoImagen = new File(carpeta, nombreImagen); // Nombre del archivo de imagen

    try {
        carpeta.mkdir(); // Crea la carpeta si no existe
        ImageIO.write(imagen, "png", archivoImagen); // Guarda la imagen en la carpeta
    } catch (IOException e) {
        e.printStackTrace();
    }
    
  }
  
  // Métodos getter
  public String verCarton() {
    String cadena = "B  I  N  G  O\n";
    
    for(int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        String numero = Integer.toString((carton[i][j]));
        cadena += numero + " ";
      }
      
      cadena += "\n";
    }
    
    cadena+= getIdentificador() + "\n";
    return cadena;
  }
  
  public String verCartonMarcado() {
    String cadena = "B    I    N    G    O\n";
    
    for(int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        boolean cM = cartonMarcado[i][j];
        String estado = cM + "";
        cadena += estado + " ";
      }
      cadena += "\n";
    }
    
    cadena+= getIdentificador() + "\n";
    return cadena;
  }
  
  public String getIdentificador() {
    return identificador;
  }
  
  public int[][] getCarton() {
    return carton;
  }
  
  public boolean[][] getcartonMarcado() {
    return cartonMarcado;
  }
  
}

