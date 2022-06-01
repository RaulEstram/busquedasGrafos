package search;

import java.util.*;
import javax.swing.JOptionPane;

public class DepthFirstSearch {

    private boolean meta = false; // propiedad que utilizamos para asegurarnos de que llegamos al nodo objetivo

    private String steps = "";

    private final ArrayList<List<Integer>> nodes; // propiedad que utilizaremos para manejar nuestros nodos

    private final ArrayList<List<Integer>> visited = new ArrayList<>(); // lista para registrar el historial de procedimeintos

    // constructor, aqui sera donde le pasemos nuestra lista 2D con nuestros nodos
    public DepthFirstSearch(ArrayList<List<Integer>> nodes) {
        this.nodes = nodes;
    }

    /*
    Este metodo sera el encargado de realizar todo el procedimiento de la busqueda
    y nos regresara un string con todo el historial de los pasos
    realizados para encontrar la respuesta
     */
    public void search(int first, int end, String direction) {
        /* 
        si el elemento desde el que buscamos (first) es igual al que tenemos que 
        llegar, significa que hemos llega a nuestra meta, por lo tanto hemos 
        llegado a nuestro objetivo por lo que saldremos de este metodo, para esto
        definimos la propiedad meta como true, para proceder a una comprobacion,
        de si meta es true, terminemos la ejecucion del metodo.
         */
        if (first == end) {
            for (int i = this.visited.size() - 1; i >= 0; i--) {
                if (this.visited.get(i).get(0) == first && this.visited.get(i).get(0) == end) {
                    ArrayList<Integer> newState = new ArrayList<>();
                    newState.add(first);
                    newState.add(1);
                    newState.add(this.visited.get(i).get(2));
                    this.visited.set(i, newState);
                }
            }

            // agregamos a la propiedad steps que llegamos al final del procedimiento
            if (!this.meta) {
                this.steps = this.steps + "\n\nLlegamos al Nodo " + first + " Final del proceso";
            }
            this.meta = true;
        }
        if (meta) {
            return;
        }

        /* 
        si nuestra lista visited que nos va a servir para regristrar todos los movimientos
        esta vacia, significa que apenas vamos a empezar con el procedimiento, por esto
        agregamos como primer registro el nodo con el que empieza la busqueda.
        
        En caso de que no este vacio, eso significa que estamos en medio del procedimiento,
        en este caso tenemos que cambiar el estado del nodo que estamos revisando,
        de un 0 que significa que no hemos revisado a un 1 que lo estamos revisando o que esta revisado
         */
        if (this.visited.isEmpty()) {
            this.addVisitedNode(first, 1, 0);
            // agregamos a la propiedad steps este paso 
            String step = "Nodo Actual: " + first + "\n\n"
                    + "Nodo:\t\t" + first + "\n"
                    + "Revisado:\t0\n"
                    + "Antecesor:\t0\n";
            this.steps += step;
        } else {
            /* 
            usamos un for para iterar inversamente nuestro array que tiene el registro de todos los movimientos
            esto para asegurarnos de cambiar el estado del nodo adecuado
             */
            for (int i = this.visited.size() - 1; i > 0; i--) {
                if (this.visited.get(i).get(0) == first) {
                    // creacion del nuevo estado para el nodo
                    ArrayList<Integer> newState = new ArrayList<>();
                    newState.add(first);
                    newState.add(1);
                    newState.add(this.visited.get(this.visited.size() - 1).get(2));
                    // aqui es donde "actualizamos" el estado
                    this.visited.set(i, newState);
                    // salimos del for para no iterar de mas
                    break;
                }
            }

        }
        // uzamos un try por cualquier error posible
        try {

            // obtenemos los subnodos de nuestro nodo base que le pasamos como first la funcion
            List<Integer> node = this.nodes.get(first - 1);

            /*
            rectificamos en que direccion se realizara la busqueda, si esta
            en sentido horario realizara la busqueda de una forma, mientras que si
            esta en sentido antihorario realizara la busqueda de otra forma
             */
            if ("horario".equals(direction.toLowerCase())) {
                // busqueda en sentido horario

                /* 
                agregamos a nuestra lista que sirve de registro los subnodos del nodo first 
                que le pasamos al metodo si es que no estan en la lista, el estado que se les
                pasa es 0 porque no se van a revisar todavia.
                 */
                // for para iterar los subnodos
                for (int i = node.size(); i > 0; i--) {
                    // se verifica que no esten en la lista de registros de procedimientos
                    if (!this.visited(node.get(i - 1))) {
                        // si no estan, se agregan a la lista
                        this.addVisitedNode(node.get(i - 1), 0, node.get(0));
                    }
                }

                // guardamos los pasos realizados hasta ahora en la propiedad steps
                String step = "\n\nNodo Actual: " + first;
                String nodo = "\n\nNodo:\t\t";
                String revisado = "\nRevisado:\t";
                String antecesor = "\nAntecesor:\t";
                for (int i = 0; i < this.visited.size(); i++) {
                    nodo += "" + this.visited.get(i).get(0) + "\t";
                    revisado += "" + this.visited.get(i).get(1) + "\t";
                    antecesor += "" + this.visited.get(i).get(2) + "\t";
                }
                this.steps += step + nodo + revisado + antecesor;

                /*
                emplearemos la recursividad para llamar de nevo a esta funcion para el ultimo elemento
                de nuestra lista de registros, pero tenemos que comprobar que si estado sea 0, 
                de que no a sido revisado
                 */
                // for para iterar desde el final los elementos registrados
                for (int i = this.visited.size() - 1; i > 0; i--) {
                    // verificamos que su estado sea 0
                    if (this.visited.get(i).get(1) == 0) {
                        // realizamos la recursividad para el elemento con estado 0
                        search(this.visited.get(i).get(0), end, direction);
                    }
                }

            } else if ("antihorario".equals(direction.toLowerCase())) {
                // busqueda en sentido antihorario

                /* 
                agregamos a nuestra lista que sirve de registro los subnodos del nodo first 
                que le pasamos al metodo si es que no estan en la lista, el estado que se les
                pasa es 0 porque no se van a revisar todavia.
                 */
                // for para iterar los subnodos
                for (int i = 0; i < node.size(); i++) {
                    // se verifica que no esten en la lista de registros de procedimientos
                    if (!this.visited(node.get(i))) {
                        // si no estan, se agregan a la lista
                        this.addVisitedNode(node.get(i), 0, node.get(0));
                    }
                }

                // guardamos los pasos realizados hasta ahora en la propiedad steps
                String step = "\n\nNodo Actual: " + first;
                String nodo = "\n\nNodo:\t\t";
                String revisado = "\nRevisado:\t";
                String antecesor = "\nAntecesor:\t";
                for (int i = 0; i < this.visited.size(); i++) {
                    nodo += "" + this.visited.get(i).get(0) + "\t";
                    revisado += "" + this.visited.get(i).get(1) + "\t";
                    antecesor += "" + this.visited.get(i).get(2) + "\t";
                }
                this.steps += step + nodo + revisado + antecesor;

                /*
                emplearemos la recursividad para llamar de nevo a esta funcion para el ultimo elemento
                de nuestra lista de registros, pero tenemos que comprobar que si estado sea 0, 
                de que no a sido revisado
                 */
                // for para iterar desde el final los elementos registrados
                for (int i = 0; i < this.visited.size(); i++) {
                    // verificamos que su estado sea 0
                    if (this.visited.get(i).get(1) == 0) {
                        // realizamos la recursividad para el elemento con estado 0
                        search(this.visited.get(i).get(0), end, direction);
                    }
                }
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
    private boolean visited(int node) {
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

    // metodo para regresar todo el historial de los pasos realizados con el formato adecuado 
    public String getSteps() {
        return this.steps;
    }

    // metodo para obtener la ruta 
    public String getRute(int meta) {
        // lista para almenar la ruta 
        ArrayList<Integer> steps_rute = new ArrayList<>();
        // string para almacenar la ruta de forma arreglada para el usuario final
        String rute = "Ruta: ";
        // try por cualquier error
        try {
            // iteremos nuestra lista que tiene le historial de pasos
            for (int i = this.visited.size() - 1; i >= 0; i--) {
                // si el nodo es la meta entramos al if
                if (this.visited.get(i).get(0) == meta) {
                    // agregamos el valor meta a nuestra lista steps_rute
                    steps_rute.add(meta);
                    /* 
                    cambiamos el meta por el predecesor del nodo, de esta forma cuando se este iterando
                    ahora buscara el predecesor en lugar del meta y asi sucesivamente hasta
                    que tengamos la lista con todos los nodos que se utilizan para llegar
                    al nodo meta
                     */
                    meta = this.visited.get(i).get(2);
                }
            }
            
            // for para iterar la lista y darle un formato para el usuario final
            for (int i = steps_rute.size() - 1; i >= 0; i--) {
                rute += "" + steps_rute.get(i) + " ";
            }
        } catch (Exception e) {
            // si obtenemos cualquier error lo mostramos al usuario
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        // regresamos la ruta para el usuario final
        return rute;
    }

}
