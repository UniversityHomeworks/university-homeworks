package methods.binary;

import javax.swing.JOptionPane;
import java.util.Random;
import java.util.StringJoiner;

public class BinaryMethod {

    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        // Vector asignado
        int[] vector = new int[20];
        // Valores del menu
        int option = 0;

        // Metodo que asigna valores aleatorios al vector
        randomized(vector);
        // Metodo que ordena el vector
        orderVector(vector);

        // Menu para realizar varias acciones sin terminar el programa hasta que se indique
        while (option != 4) {
            option = Integer.parseInt(
                    JOptionPane.showInputDialog("Digite la opcion a realizar\n" +
                            "1. Revisar el vector\n" +
                            "2. Re-definir automaticamente los valores del vector\n" +
                            "3. Buscar un valor en el vector" +
                            "\n4. Salir del programa")
            );

            switch (option) {
                case 1:
                    // Imprimir vectores
                    printInformation(
                            "¡Vector!",
                            "Vista del vector\n \n" + parseVector(vector)
                    );
                    break;
                case 2:
                    // Re-asignacion de valores
                    randomized(vector);
                    orderVector(vector);
                    printInformation("Actualizado", "¡Informacion actualizada!\n" + parseVector(vector));
                    break;
                case 3:
                    // Realizacion de busqueda
                    int value;
                    value = Integer.parseInt(
                            JOptionPane.showInputDialog("Digite el numero que desea buscar")
                    );
                    searchData(value, vector);
                    break;
                case 4:
                    // Finalizacion del programa
                    printInformation("Adios", "Gracias por usar\nRealizado por Jonathan Narvaez");
                    continue;
                default:
                    // Caso del condicional en caso (redundancia) que el dato no sea acorde al menu
                    printInformation("¡Error!", "Informacion digitada es incorrecta");
                    break;
            }
        }
    }

    private static void searchData(int value, int[] vector) {
        // "Intencion" idea literal pasada a codigo sin modificar o optimizar
        int left = 0;
        int right = vector.length - 1;
        int middle = (left + right) / 2;
        StringBuilder stringBuilder = new StringBuilder("Estos son los cambios al buscar el dato").append('\n');
        // Unico ciclo que corre si y solo si los apuntadores de los costados son distintos al valor medio
        // cumpliendo con la condicion general
        while (middle != right && middle != left) {
            stringBuilder.append("--------------------").append('\n')
                    .append("Dato Izquierdo: ").append(left).append('\n')
                    .append("Dato Derecho: ").append(right).append('\n')
                    .append("Dato Mediano: ").append(middle).append('\n')
                    .append("--------------------").append('\n');
            // Condicion que evalua si el valor buscado es menor
            if (value < vector[middle]) {
                //Cambio de posiciones siguiendo el algoritmo
                right = middle;
                middle = (left + right) / 2;
                continue;
            }
            // Condicion que evalua si el valor buscado es mayor
            if (value > vector[middle]) {
                //Cambio de posiciones siguiendo el algoritmo
                left = middle;
                middle = (left + right) / 2;
                continue;
            }

            // Condicion extra que evalua si el valor buscado ya está en la posicion media
            if (vector[middle] == value) {
                // En caso de que la condicion así se cumpla, este se encarga de romper
                // el ciclo para permitir imprimir los cambios y así mismo determine
                // el valor buscado con su posicion
                break;
            }
        }
        printInformation(
                "Cambios!!!",
                stringBuilder.toString()
        );
        stringBuilder.delete(0, stringBuilder.length());

        // Evalua si el vamor está en la posicion izquierda final (Rompe el metodo para no continuar)
        if (vector[left] == value) {
            printInformation(
                    "Valor ubicado!!",
                    "El valor buscado es: " + vector[left] + " en posicion: " + left
            );
            return;
        }

        // Evalua si el vamor está en la posicion derecha final (Rompe el metodo para no continuar)
        if (vector[right] == value) {
            printInformation(
                    "Valor ubicado!!",
                    "El valor buscado es: " + vector[right] + " en posicion: " + right
            );
            return;
        }

        // Evalua si el vamor está en la posicion media final (Rompe el metodo para no continuar)
        if (vector[middle] == value) {
            printInformation(
                    "Valor ubicado!!",
                    "El valor buscado es: " + vector[middle] + " en posicion: " + middle
            );
            return;
        }
        // Si todas las condiciones son falsas se concluye que el valor nunca se encontró
        printInformation(
                "Valor no encontrado",
                "El valor no fue ubicado"
        );
    }

    private static void orderVector(int[] vector) {
        // Metodo de ordenamiento burbuja, para usos basicos
        int temp;
        for (int i = 0; i < vector.length; i++) {
            for (int j = 0; j < (i + 1); j++) {
                if (vector[i] < vector[j]) {
                    temp = vector[i];
                    vector[i] = vector[j];
                    vector[j] = temp;
                }
            }

        }
    }

    private static String parseVector(int[] vector) {
        StringJoiner stringJoiner = new StringJoiner(",", "[", "]");
        for (int value : vector) {
            stringJoiner.add(String.valueOf(value));
        }
        return stringJoiner.toString();
    }

    private static void printInformation(String title, String text) {
        JOptionPane.showMessageDialog(
                null,
                text,
                title,
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    private static void randomized(int[] vector) {
        for(int i = 0 ; i < vector.length ; i++)
            vector[i] = RANDOM.nextInt(vector.length - 1);
    }

}
