package kruskal;

import javax.swing.*;

public class MainKruskal {

    private static final int INF = Integer.MAX_VALUE;

    private static final String[][] matrixPath = {
            {"-", "B", "C", "D", "E", "F", "G", "H", "I"},
            {"A", "-", "C", "D", "E", "F", "G", "H", "I"},
            {"A", "B", "-", "D", "E", "F", "G", "H", "I"},
            {"A", "B", "C", "-", "E", "F", "G", "H", "I"},
            {"A", "B", "C", "D", "-", "F", "G", "H", "I"},
            {"A", "B", "C", "D", "E", "-", "G", "H", "I"},
            {"A", "B", "C", "D", "E", "F", "-", "H", "I"},
            {"A", "B", "C", "D", "E", "F", "G", "-", "I"},
            {"A", "B", "C", "D", "E", "F", "G", "H", "-"}
    };

    private static final int[][] distancesMatrix = {
            {0, 6, INF, 10, INF, INF, 8, INF, INF},
            {6, 0, 11, INF, 15, INF, INF, 13, INF},
            {INF, 11, 0, INF, INF, INF, INF, 4, INF},
            {10, INF, INF, 0, 6, INF, INF, INF, INF},
            {INF, 15, INF, 6, 0, 2, INF, INF, INF},
            {INF, INF, INF, INF, 2, 0, 4, INF, 6},
            {8, INF, INF, INF, INF, 4, 0, 5, 5},
            {INF, 13, 4, INF, INF, INF, 5, 0, 7},
            {INF, INF, INF, INF, INF, 6, 5, 7, 0}
    };

    public static void main(String[] args) {
        KruskalStructure[] structures = new KruskalStructure[100];
        treeCreate(structures);
        applyKruskalAlgorithm(structures);
        kruskalPrint(structures);

    }

    public static void treeCreate(KruskalStructure[] structures)  {
        String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
        int buff = 0;
        int minorValue = 0;

        // Pasamos la matriz principal a una lista con una estructura que nos permite pasar de matriz
        // a arbol en un array para trabajarlo despues
        for (int i = 0; i < distancesMatrix.length ; i++) {
            for (int j = 0; j < distancesMatrix.length; j++) {

                if (distancesMatrix[i][j] == INF || distancesMatrix[i][j] == INF) {
                    continue;
                }

                if (distancesMatrix[i][j] == 0) {
                    continue;
                }

                structures[buff] = new KruskalStructure(
                        letters[i],
                        letters[j],
                        distancesMatrix[i][j]
                );

                buff++;
            }
        }

        // Organizamos el "arbol" de menor a mayor para trabajarlo despues
        KruskalStructure temp;
        for (int i = 0; i < structures.length; i++) {
            for (int j = 0; j < (i + 1); j++) {
                if (structures[i] == null || structures[j] == null) {
                    continue;
                }

                if(structures[j].getValue() > structures[i].getValue()) {
                    temp = structures[j];
                    structures[j] = structures[i];
                    structures[i] = temp;
                }
            }
        }
    }

    // En este metodo se aplica el algoritmo Kruskal literalmente.
    private static void applyKruskalAlgorithm(KruskalStructure[] structures) {
        KruskalStructure nullStructure = null;
        // Se aplica la iteracion para comparar valor por valor y asi determinar que no existan ciclos
        for (int i = 0; i < structures.length; i++) {
            for (int j = 0; j < structures.length; j++) {
                if (structures[i] == null || structures[j] == null) {
                    continue;
                }
                if(structures[j].getNode().equals(structures[i].getNext())) {
                    structures[j] = nullStructure;
                    continue;
                }
                if (structures[j].getNext().equals(structures[i].getNode())) {
                    structures[j] = nullStructure;
                    continue;
                }
            }
        }
        /*
         * TODO
         * Al correr el programa y intentar ver si funciona como deberia
         * se evidencia que existe un pequeño error, ya que toma el ultimo valor del array de estructuras
         * el cual no debe estar y tiene que pasar por los condicionales para que sea borrado.
         *
         * Quisiera sea aclarada esta duda. (Por favor borrar este comentario para correr el programa)
         */
    }

    private static void kruskalPrint(KruskalStructure[] structures) {
        StringBuilder sb = new StringBuilder();
        sb.append("Rutas de a ingresar: ");
        sb.append('\n');
        for (KruskalStructure structure : structures) {
            if (structure != null) {
                sb.append(structure.getNode()).append(" to ").append(structure.getNext()).append(": ")
                        .append(structure.getValue()).append('\n');
            }
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }



}
