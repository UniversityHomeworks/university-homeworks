package quicksort;

import javax.swing.*;
import java.util.Random;
import java.util.StringJoiner;

public class MainQuickSort {

    /*
     * Ejercicio realizado por:
     * - Jonathan narvaez posada
     */

    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        // Generacion de vector vacio de 30 espacios (Modificable)
        int[] vector = new int[30];

        // Insercion de valores random al vector
        for (int i = 0 ; i < vector.length ; i++) vector[i] = RANDOM.nextInt(vector.length);
        // Inicio de ordenamiento y uso de la utilidad StringBuilder para construir un texto
        // a partir de valores iniciales y así mismo para su impresion
        StringBuilder sb = new StringBuilder();
        sb.append("# Vector inicial").append('\n');
        sb .append(printVector(vector)).append('\n');
        quickOrder(vector, 0, vector.length - 1);
        sb.append("# Vector ordenado").append('\n');
        sb .append(printVector(vector)).append('\n');

        JOptionPane.showMessageDialog(
                null,
                sb.toString(),
                "QuickSort!",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    /**
     * Metodo de ordenamiento principal, encargado de tomar el vector junto con valores
     * iniciales y finales para su respectivo ordenamiento. Consiste tambien en subdividir el vector
     * en subvectores para su ordenamiento (Divide y venceras!!)
     *
     * @param vector Vector que contiene todos los datos
     * @param initial Maneja el valor inicial del vector (Considerese como el valor derecho del vector)
     * @param finalize Maneja el valor final del vector (Considerese como el valor izquierdo del vector)
     */
    private static void quickOrder(int[] vector, int initial, int finalize) {
        int pivot = vector[initial]; // Valor pivote tomado para evaluar el vector
        int i = initial; // Valor temporal del metodo para el manejo de los valores del vector (derecho)
        int j = finalize; // Valor temporal del metodo para el manejo de los valores del vector (izquierdo)
        int temp; // Valor temporal del metodo para el manejo de orden del metodo
        // Ciclo para evitar que el recorrido se cruce () -> | <- ()
        while(i < j) {
            // Recorridos internos del vector para verificar por derecha y izquierda
            while (vector[i] <= pivot && i < j) i++; // () -> . . .
            while (vector[j] > pivot) j--; // . . . <- ()
            // Evualuacion de valores y intercambio en el caso de que sea verdadero
            if (i < j) {
                temp = vector[i];
                vector[i] = vector[j];
                vector[j] = temp;
            }
        }

        // Devolucion del pivot al vector
        vector[initial] = vector[j];
        vector[j] = pivot;
        // Evaluacion del posiciones y recursividad para evaluacion de los proximos sub vectores
        if (initial < (j - 1)) quickOrder(vector, initial , (j - 1));
        if ((j + 1) < finalize) quickOrder(vector, (j + 1) , finalize);
    }


    /**
     * Metodo para impresion de vector, junto a herramienta (Clase util) de java extraida de
     * los javadoc <a href="https://docs.oracle.com/javase/8/docs/api/java/util/StringJoiner.html">StringJoiner</a>
     *
     * @param vector Vector solicitado para imprimir
     * @return Retorna en valor String la cadena decorada
     */
    private static String printVector(int[] vector) {
        StringJoiner sj = new StringJoiner(", ", "[", "]");
        for (int value :  vector) {
            sj.add(String.valueOf(value));
        }
        return sj.toString();
    }


}
