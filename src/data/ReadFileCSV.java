package data;

import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ReadFileCSV {
    /*
    esta clase nos sirve para leer archivo csv y almacenar sus datos en un array 2D
    */
    private String path; // para el path del archivo
    private BufferedReader lector; // para leer el archivo
    private String linea;   // para recibir la linea de cada fila
    private final ArrayList<List<Integer>> data = new ArrayList<>(); // almacenar los datos de cada linea leida
    
    // constructor donde definirmos el path del archivo
    public ReadFileCSV(String path){
        this.path = path;
    }
    
    // metodo que nos regresara el Array 2D con los datos del archivo csv
    public ArrayList<List<Integer>> getData(){
        // try por cualquie error
        try {
            // definimos nuestro objeto BufferReader que es el que nos ayudara a leer el archivo
            this.lector = new BufferedReader(new FileReader(this.path));
            // contador para las filas leidas
            int count = 0;
            // while para iterar todas las lineas de nuetro archivo csv
            while ((this.linea = this.lector.readLine()) != null) {    
                // creamos un array a partir de la primera linea leida donde separamoslos datos por comas
                String[] parts = this.linea.split(",");
                // agregamos una lista donde almacenaremos los datos a nuestra lista 2D
                this.data.add(new ArrayList<>());
                // iteramos todos los objetos de nuestro array de la linea leida
                for (String part : parts) {
                    // almacenamos los datos iterados en la lista que se almaceno en la lista 2D
                    this.data.get(count).add(Integer.parseInt(part));
                }
                // incrementamos el contador de filas leidas
                count++;
            }
            // retornamos la lista 2D
            return this.data;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return null;
    }
    
}
