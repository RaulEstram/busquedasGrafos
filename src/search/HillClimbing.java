package search;

import java.util.*;
import javax.swing.JOptionPane;

public class HillClimbing {

    private boolean meta = false; // propiedad para saber si ya llegamos al final
    private String steps = "";  // propiedad para almacenar todos los pasos realizados para el usuario
    private final ArrayList<List<Integer>> visited = new ArrayList<>(); // lista para registrar el historial de procedimeintos

    private final ArrayList<List<Integer>> nodes;  // lista 2D para los nodos
    private final ArrayList<List<Integer>> distances;  // lista 2D para las "distancias" entre los nodos

    // constructor donde inicializamos nuestras listas 2D para los nodos y las distancias
    public HillClimbing(ArrayList<List<Integer>> nodes, ArrayList<List<Integer>> distances) {
        this.nodes = nodes;
        this.distances = distances;
    }

    // metodo que realizara todo el procedimiento de busqueda
    public void search(int first, int end, String direccion) {
        //  si el first y end son el mismo significa que no hay una distancia como tal y podriamos decir que llegamos a la meta
        if (first == end) {
            // agregamos a la propiedad steps que llegamos al final del procedimiento
            this.steps += "\n\nLlegamos al Nodo " + first + " \nFin del proceso";
            // definimos a meta como true para decir que ya llegamos al final o a la meta
            this.meta = true;
        }
        // si ya llegamos a la meta ya no realizamos los siguientes pasos, esto porque utilizaremos recursividad
        if (meta) {
            return;
        }

        // usamos try por cualquie error en el codigo a la hora de ejecucion
        try {

            // si nuestra lista para el historial esta vacia significa que apenas empieza el proceso
            if (this.visited.isEmpty()) {
                // si apenas comienda el proceso, agregamos el primer paso
                this.addVisitedNode(first, this.getDistancia(first, end), 0);
                // agregamos a la propiedad steps este paso 
                String step = "Nodo Con el que empezamos: " + first + "\n\n"
                        + "Nodo:\t\t" + first + "\n"
                        + "Valor:\t\t" + this.getDistancia(first, end) + "\n"
                        + "Antecesor:\t0\n";
                this.steps += step;
            }

            // busqueda por sentido horario
            if ("horario".equals(direccion.toLowerCase())) {
                /* 
                obtenemos los subnodos del nodo first
                guardamos los pasos en steps y seleccionamos  el mas cercano al nodo end
                 
                definimos algunos Strings que nos ayudaran a darle formato a los pasos 
                que hace el programa para mostrarlos al usuario final
                 */
                String step = "\n\nNodo Actual: " + first;
                String nodo = "\n\nNodo:\t\t";
                String revisado = "\nRevisado:\t";
                String antecesor = "\nAntecesor:\t";
                // definimos algunas variables que nos ayudaran al control del nodo con la menor distancia
                int menor = 2147483647;
                int node = 2147483647;
                //creamos una lista
                List<Integer> nodeList = new ArrayList<>();
                // en la lista almacenaremos los subnodos el nodo first
                nodeList = this.nodes.get(first - 1);
                // utilizamos un for para iterar los subnodos del nodo first
                for (int i = 1; i < nodeList.size(); i++) {
                    // utilizaremos un if para obtener el subnodo con la menor distancia al nodo end
                    if (this.getDistancia(nodeList.get(i), end) < menor) {
                        // iremos remplazando el valor de menor y node con los valores del nodo con la distancia mas chica
                        menor = this.getDistancia(nodeList.get(i), end);
                        node = nodeList.get(i);
                    }
                    // realizmos nuestros areglos en nuestras variables strings para definir los pasos realizados para el usuario
                    nodo += "" + this.nodes.get(nodeList.get(i) - 1).get(0) + "\t";
                    revisado += "" + this.getDistancia(nodeList.get(i), end) + "\t";
                    antecesor += "" + first + "\t";
                }

                // agregamos a la propiedad steps, el paso realizado de comparacion de la distancia de los subnodos de first
                this.steps += step + nodo + revisado + antecesor + "\n\nNodo Seleccionado: " + node + "\n";
                // agregamos a nuestro historial la informaicon del nodo con la menor distancia
                this.addVisitedNode(node, this.getDistancia(node, end), first);
                // utilizamos la recursividad para llamar de nuevo a esta funcion
                search(node, end, direccion);

            } else if ("antihorario".equals(direccion.toLowerCase())) {
                // busqueda por sentido antihorario

                /* 
                obtenemos los subnodos del nodo first
                guardamos los pasos en steps y seleccionamos  el mas cercano al nodo end

                definimos algunos Strings que nos ayudaran a darle formato a los pasos 
                que hace el programa para mostrarlos al usuario final
                 */
                String step = "\n\nNodo Actual: " + first;
                String nodo = "\n\nNodo:\t\t";
                String revisado = "\nRevisado:\t";
                String antecesor = "\nAntecesor:\t";
                // definimos algunas variables que nos ayudaran al control del nodo con la menor distancia
                int menor = 2147483647;
                int node = 2147483647;
                //creamos una lista
                List<Integer> nodeList = new ArrayList<>();
                // en la lista almacenaremos los subnodos el nodo first
                nodeList = this.nodes.get(first - 1);
                // utilizamos un for para iterar los subnodos del nodo first
                for (int i = nodeList.size() - 1; i > 0; i--) {
                    // utilizaremos un if para obtener el subnodo con la menor distancia al nodo end
                    if (this.getDistancia(nodeList.get(i), end) < menor) {
                        // iremos remplazando el valor de menor y node con los valores del nodo con la distancia mas chica
                        menor = this.getDistancia(nodeList.get(i), end);
                        node = nodeList.get(i);
                    }
                    // realizmos nuestros areglos en nuestras variables strings para definir los pasos realizados para el usuario
                    nodo += "" + this.nodes.get(nodeList.get(i) - 1).get(0) + "\t";
                    revisado += "" + this.getDistancia(nodeList.get(i), end) + "\t";
                    antecesor += "" + this.nodes.get(nodeList.get(i) - 1).get(2) + "\t";
                }

                // agregamos a la propiedad steps, el paso realizado de comparacion de la distancia de los subnodos de first
                this.steps += step + nodo + revisado + antecesor + "\n\nNodo Seleccionado: " + node + "\n";
                // agregamos a nuestro historial la informaicon del nodo con la menor distancia
                this.addVisitedNode(node, this.getDistancia(node, end), first);
                // utilizamos la recursividad para llamar de nuevo a esta funcion
                search(node, end, direccion);
            }

        } catch (Exception e) {
            // si obtenemos cualquier error lo mostramos al usuario
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    // metodo para agregar nodo que visitemos, le pararemos el nodo, el estado y el predecessor
    private void addVisitedNode(int node, int visited, int predecessor) {
        // creamos una lista
        ArrayList<Integer> visitedNode = new ArrayList<>();
        // agregamos los datos pertinenetes
        visitedNode.add(node);
        visitedNode.add(visited);
        visitedNode.add(predecessor);
        // agregamos la lista a la lista que tiene todo el historial
        this.visited.add(visitedNode);
    }

    // metodo para saber si un nodo ya fue visitado o revisado 
    private boolean isVisited(int node) {
        // iteramso sobre la lista que tiene el historial de los pasos
        for (int i = 0; i < this.visited.size(); i++) {
            // si se encuentra el nodo ingresado con un 1 en su estado, regresa un true, de que ya fue visitado o revisado
            List<Integer> visitedNode = this.visited.get(i);
            if (visitedNode.get(0) == node) {
                return true;
            }
        }
        return false;
    }
    /* 
    este metodo nos sirve para obtener las distancias entre un nodo y otro
    para evitar cualquier error al obtener la distancia usamos un try catch para saber
    exactamente cual es la combinacion adecuada que nos da la distancia
    */
    private Integer getDistancia(int start, int end) {
        try {
            int distance;
            try {
                distance = this.distances.get(start - 1).get(end - 1);
            } catch (Exception e) {
                distance = this.distances.get(end - 1).get(start - 1);
            }
            return distance;
        } catch (Exception e) {
            // si obtenemos cualquier error lo mostramos al usuario
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return 0;
    }
    
    // este metodo nos regresa los pasos realizados en este procedimiento
    public String getSteps() {
        return steps;
    }
    
    // este metodos nos va a servir para iterar nuestros historial y de esta forma obtener la ruta
    public String getRute() {
        String rute = "Ruta: ";
        for (int i = 0; i < this.visited.size(); i++) {
            rute += "" + this.visited.get(i).get(0) + " ";
        }
        return rute;
    }

}
