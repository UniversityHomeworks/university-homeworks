package floyd;

import javax.swing.*;

public class MainFloydAlgorithm {
    // Valor asigndado como infinito
    private static final int INF = Integer.MAX_VALUE;

    // Matriz original de los vertices del grafo (Matriz de recorrido)
    private static final String[][] matrixPath = {
            {"-", "B", "C", "D", "E", "F", "G", "H", "I", "J"},
            {"A", "-", "C", "D", "E", "F", "G", "H", "I", "J"},
            {"A", "B", "-", "D", "E", "F", "G", "H", "I", "J"},
            {"A", "B", "C", "-", "E", "F", "G", "H", "I", "J"},
            {"A", "B", "C", "D", "-", "F", "G", "H", "I", "J"},
            {"A", "B", "C", "D", "E", "-", "G", "H", "I", "J"},
            {"A", "B", "C", "D", "E", "F", "-", "H", "I", "J"},
            {"A", "B", "C", "D", "E", "F", "G", "-", "I", "J"},
            {"A", "B", "C", "D", "E", "F", "G", "H", "-", "J"},
            {"A", "B", "C", "D", "E", "F", "G", "H", "I", "-"}
    };

    // Matriz original de las aristas del grafo con sus respectivos valores de ruta (Matriz de distancias)
    private static final int[][] distancesMatrix = {
            /*       A  B  C  D  E  F  G  H  I  J */
            /* A */ {0, 3, INF, INF, INF, 2, INF, INF, INF, INF},
            /* B */ {3, 0, 17, 16, INF, INF, INF, INF, INF, INF},
            /* C */ {INF, 17, 0, 8, INF, INF, INF, INF, INF, INF},
            /* D */ {INF, 16, 8, 0, 11, INF, INF, INF, 4, INF},
            /* E */ {INF, INF, INF, 11, 0, 1, 6, 5, 10, INF},
            /* F */ {2, INF, INF, INF, 1, 0, 7, INF, INF, INF},
            /* G */ {INF, INF, INF, INF, 6, 7, 0, 15, INF, INF},
            /* H */ {INF, INF, INF, INF, 5, INF, 15, 0, 12, 13},
            /* I */ {INF, INF, 18, 4, 10, INF, INF, 12, 0, 9},
            /* J */ {INF, INF, INF, INF, INF, INF, INF, 13, 9, 0}
    };

    public static void main(String[] args) {
        String[] nodes = new String[2];
        // Metodo de insercion
        insertData(nodes);
        // Metodo que calcula las matrizes y determina los caminos cortos
        calculateDistances(nodes);

    }

    public static void insertData(String[] nodes) {
        StringBuilder sb = new StringBuilder();
        sb.append("Inserte el nodo inicial: \n \n");
        sb.append("\tObservaciones: \n");
        sb.append("\t1. Los nodos van desde A - J\n \n");
        nodes[0] = JOptionPane.showInputDialog(sb);

        StringBuilder sb2 = new StringBuilder();
        sb2.append("Inserte el nodo final: \n \n");
        sb2.append("\tObservaciones: \n");
        sb2.append("\t1. Los nodos van desde A - J\n \n");
        nodes[1] = JOptionPane.showInputDialog(sb2);
    }

    public static void calculateDistances(String[] nodes)  {
        String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        // Valor temporal para las sumas
        int buff;
        // Instancias nuevas para no modificar las matrices originales
        int[][] values = new int[distancesMatrix.length][distancesMatrix.length];
        String[][] path = new String[matrixPath.length][matrixPath.length];

        // Copia de las matrices originales a las copias para trabajarlas
        for (int i = 0; i < distancesMatrix.length ; i++) {
            for (int j = 0; j < distancesMatrix.length; j++) {
                values[i][j] = distancesMatrix[i][j];
                path[i][j] = matrixPath[i][j];
            }
        }

        // Recorrido principal encargado de recorrer las columnas
        for (int index = 0; index < values.length ; index++) {
            /*
             * Recorrido interior, se encarga de recorrer las filas y columnas según corresponda al recorrido
             * principal indice, esto con el fin de que el recorrido sepa de que columna se trata
             *
             */
            for (int i = 0; i < distancesMatrix.length ; i++) {
                for (int j = 0; j < distancesMatrix.length ; j++) {
                    /*
                     * Condicional ternario que se encarga de comparar los valores infinitos para no tener
                     * problemas a la hora de "sumarlos" o compararlos con algun otro numero
                     */
                    buff = (values[i][index] == INF || values[index][j] == INF)
                            ? INF :  (values[i][index] + values[index][j]);
                    /*
                     * Condicional encargado de que los valores sean menores al del array, esto para lograr cambiar
                     * las rutas y los caracteres de la ruta logrando organizar la matriz
                     */
                    if (values[i][j] > buff) {
                        values[i][j] = buff; // Asignacion de los valores comparados en la matriz
                        path[i][j] = matrixPath[i][index]; // Asignacion de los caracteres correspondientes
                    }
                }
            }
        }

        // Impresion de la matriz modificada, dejandonos mirar las aristas con ruta mas corta
        int[] temp = new int[2];
        for(int i = 0; i < letters.length ; i++) {
            if (letters[i].equalsIgnoreCase(nodes[0])) {
                temp[0] = i;
            }
            if (letters[i].equalsIgnoreCase(nodes[1])) {
                temp[1] = i;
            }

        }

        String floydValues = "Floyd - Rutas mas cortas: \n \n" +
                "%value%  ".replace("%value%", String.valueOf(values[temp[0]][temp[1]])) +
                '\n';
        JOptionPane.showMessageDialog(
                null,
                floydValues,
                "Floyd - Ruta mas corta",
                JOptionPane.INFORMATION_MESSAGE
        );

        // Impresion de la matriz modificada, dejandonos observar los vertices según su ruta mas corta
        StringBuilder floydChars = new StringBuilder();
        floydChars.append("Floyd - Recorrido: \n \n");
        for (String[] paths : path) {
            for (String line : paths) {
                floydChars.append("%value%  ".replace("%value%", line));
            }
            floydChars.append('\n');
        }
        JOptionPane.showMessageDialog(
                null,
                floydChars.toString(),
                "Floyd - Caracteres",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    private static int parseToInt(String value) {
        try {
            if (value.equalsIgnoreCase("I")) {
                return INF;
            }
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                    null,
                    "El valor digitado es incorrecto, por favor validar y digitar un valor correcto (Entero)",
                    "Caracteres no validos",
                    JOptionPane.ERROR_MESSAGE
            );
            return 0;
        }
    }
}
