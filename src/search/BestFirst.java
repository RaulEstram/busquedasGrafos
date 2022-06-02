package search;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class BestFirst {

    private boolean meta = false; // propiedad para saber si ya llegamos al final
    private String steps = "";  // propiedad para almacenar todos los pasos realizados para el usuario
    private final ArrayList<List<Integer>> visited = new ArrayList<>(); // lista para registrar el historial de procedimeintos

    private final ArrayList<List<Integer>> nodes;  // lista 2D para los nodos
    private final ArrayList<List<Integer>> distances;  // lista 2D para las "distancias" entre los nodos

    // constructor donde inicializamos nuestras listas 2D para los nodos y las distancias
    public BestFirst(ArrayList<List<Integer>> nodes, ArrayList<List<Integer>> distances) {
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

            /* 
            si nuestra lista para el historial esta vacia significa que apenas empieza el proceso
            por lo que realizaremos lo primero que debe de tener 
             */
            if (this.visited.isEmpty()) {
                // si apenas comienda el proceso, agregamos el primer paso
                this.addVisitedNode(0, first, 0, this.getDistancia(first, end), 1);
                // agregamos a la propiedad steps este paso 
                String step = "Nodo Con el que empezamos: " + first + "";
                this.steps += step;
                this.addHistorial();
                this.steps += "\nNodo Seleccionado: " + first + "";
            }

            // obtenemos los subnodos del nodo first 
            //creamos una lista
            List<Integer> nodeList = new ArrayList<>();
            // en la lista almacenaremos los subnodos el nodo first
            nodeList = this.nodes.get(first - 1);
            // definimos dos variables que nos serviran para saber que subnodo tiene el F mas chico
            int minF = 2147483647;
            int node = 2147483647;

            // procedemos a la parte que realiza los pasos mas importantes 
            // busqueda por sentido horario
            if ("horario".equals(direccion.toLowerCase())) {
                // usamos un for para iterar los subnodos y saber cual es el que tiene la F mas chica
                for (int i = 1; i < nodeList.size(); i++) {
                    if (!this.isVisited(nodeList.get(i))) {
                        // antecesor + nodo , nodo + final
                        // obtenemos el F para el subnodo iterado
                        int f = this.getDistancia(nodeList.get(0), nodeList.get(i)) + this.getDistancia(nodeList.get(i), end);
                        // si el F es mas chico que el minF, minF obtendra el valor de f y el node sera el nodo del F que remplazo minF
                        if (f < minF) {
                            minF = f;
                            node = nodeList.get(i);
                        }
                    }
                }
                /*
                para esto punto tenemos en la variable node el subnodo con el F mas chico
                por lo que procedemos a usar un for para poder guardar en nuestra lista del historial
                todo los datos necesarios de los subnodos para su posterior impresion para el usuario final
                 */
                // tenemos nuestro for para iterar
                for (int i = 1; i < nodeList.size(); i++) {
                    // comprobamos que el subnodo a iterar no este en nuestro historial
                    if (!this.isVisited(nodeList.get(i))) {
                        // si no esta en el historial, obtenemos sus valores G y H
                        int g = this.getDistancia(nodeList.get(0), nodeList.get(i));
                        int h = this.getDistancia(nodeList.get(i), end);
                        // si es el subnodo que estamos "iterando" es el mismo que el nodo con el F mas chico, lo guardaremos con un 1 en cerrado
                        if (nodeList.get(i) == node) {
                            this.addVisitedNode(nodeList.get(0), nodeList.get(i), g, h, 1);
                        } else {
                            // si el subnodo que estamos iterando, su F no es el mas chico, lo guardamos ocn un = en cerrado
                            this.addVisitedNode(nodeList.get(0), nodeList.get(i), g, h, 0);
                        }
                    }

                }
                // agregamos los pasos a steps para la el usuario final
                this.steps += "";
                this.addHistorial();
                this.steps += "\nNodo Selecionado: " + node;

                // utilizamos la recursividad para llamar de nuevo a esta funcion

                /*
                for (int i = this.visited.size() - 1; i > 0; i--) {
                    // verificamos que su estado sea 0
                    if (this.visited.get(i).get(1) == 0) {
                        // realizamos la recursividad para el elemento con estado 0
                        search(this.visited.get(i).get(0), end, direction);
                    }
                }
                 */
                this.search(node, end, direccion);

            } else if ("antihorario".equals(direccion.toLowerCase())) {
                // busqueda por sentido antihorario

                // usamos un for para iterar los subnodos y saber cual es el que tiene la F mas chica
                for (int i = nodeList.size() - 1; i > 0; i--) {
                    // comprobamos que el subnodo a iterar no este en nuestro historial
                    if (!this.isVisited(nodeList.get(i))) {
                        // antecesor + nodo , nodo + final
                        // obtenemos el F para el subnodo iterado
                        int f = this.getDistancia(nodeList.get(0), nodeList.get(i)) + this.getDistancia(nodeList.get(i), end);
                        // si el F es mas chico que el minF, minF obtendra el valor de f y el node sera el nodo del F que remplazo minF
                        if (f < minF) {
                            minF = f;
                            node = nodeList.get(i);
                        }
                    }
                }
                /*
                para esto punto tenemos en la variable node el subnodo con el F mas chico
                por lo que procedemos a usar un for para poder guardar en nuestra lista del historial
                todo los datos necesarios de los subnodos para su posterior impresion para el usuario final
                 */
                // tenemos nuestro for para iterar
                for (int i = nodeList.size() - 1; i > 0; i--) {
                    // comprobamos que el subnodo a iterar no este en nuestro historial
                    if (!this.isVisited(nodeList.get(i))) {
                        // si no esta en el historial, obtenemos sus valores G y H
                        int g = this.getDistancia(nodeList.get(0), nodeList.get(i));
                        int h = this.getDistancia(nodeList.get(i), end);
                        // si es el subnodo que estamos "iterando" es el mismo que el nodo con el F mas chico, lo guardaremos con un 1 en cerrado
                        if (nodeList.get(i) == node) {
                            this.addVisitedNode(nodeList.get(0), nodeList.get(i), g, h, 1);
                        } else {
                            // si el subnodo que estamos iterando, su F no es el mas chico, lo guardamos ocn un = en cerrado
                            this.addVisitedNode(nodeList.get(0), nodeList.get(i), g, h, 0);
                        }
                    }

                }
                // agregamos los pasos a steps para la el usuario final
                this.steps += "";
                this.addHistorial();
                this.steps += "\nNodo Selecionado: " + node;

                // utilizamos la recursividad para llamar de nuevo a esta funcion
                this.search(node, end, direccion);
            }

        } catch (Exception e) {
            // si obtenemos cualquier error lo mostramos al usuario
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    // metodo para agregar nodo que visitemos, le pararemos el nodo, el estado y el predecessor
    private void addVisitedNode(int antecesor, int nodo, int g, int h, int cerrado) {
        // creamos una lista
        ArrayList<Integer> visitedNode = new ArrayList<>();
        // agregamos los datos pertinenetes
        visitedNode.add(antecesor);
        visitedNode.add(nodo);
        visitedNode.add(g);
        visitedNode.add(h);
        visitedNode.add(g + h);
        visitedNode.add(cerrado);
        // agregamos la lista a la lista que tiene todo el historial
        this.visited.add(visitedNode);
    }

    // metodo para saber si un nodo ya esta en nuestra lista de historial
    private boolean isVisited(int node) {
        // iteramso sobre la lista que tiene el historial de los pasos
        for (int i = 0; i < this.visited.size(); i++) {
            // si se encuentra el nodo ingresado en nuestra lista de hitorial, regresa un true
            List<Integer> visitedNode = this.visited.get(i);
            if (visitedNode.get(1) == node) {
                return true;
            }
        }
        // si no se encontro el nodo intresado en el historial se regresa false 
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

    // este metodo nos sirve para irle dando formato a la propiedad steps, que es la propiedad que tiene todos los pasos realizados por la busqueda
    private void addHistorial() {
        String step = "\n\n\n\nAntecesor\tNodo\tG\t+\tH\t=\tf\tCerrado\n";
        for (int i = 0; i < this.visited.size(); i++) {
            step += "" + this.visited.get(i).get(0) + "\t"
                    + "" + this.visited.get(i).get(1) + "\t"
                    + "" + this.visited.get(i).get(2) + "\t"
                    + "+\t"
                    + "" + this.visited.get(i).get(3) + "\t"
                    + "=\t"
                    + "" + this.visited.get(i).get(4) + "\t"
                    + "" + this.visited.get(i).get(5) + "\t\n";
        }
        this.steps += step;
    }

    // este metodo nos regresa los pasos realizados en este procedimiento
    public String getSteps() {
        return steps;
    }

    // este metodos nos va a servir para iterar nuestros historial y de esta forma obtener la ruta
    public String getRute() {
        String rute = "Ruta: ";
        // simplemente es iterar nuestro historial, y los que tengan 1 en cerrado, los agregamos a la ruta que le mostraremos al usuario final
        for (int i = 0; i < this.visited.size(); i++) {
            if (this.visited.get(i).get(5) == 1) {
                rute += "" + this.visited.get(i).get(1) + " ";
            }
        }
        return rute;
    }

}
