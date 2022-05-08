package bubble;

import java.util.Scanner;
import java.util.StringJoiner;

public class BubbleAndShake {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        int[] values = {7, 3, 8, 12, 15, 23, 17, 10, 6, 11};
        int opc = 0;

        while (opc != 4) {

            System.out.println(
                    "MENU DE OPCIONES: " + "\n" + "1. Orednar por Burbuja\n2. Ordenar por Shake\n" +
                            "3. Reiniciar vector\n4. Salir"
            );
            System.out.print("\tEscriba una opcion valida: ");
            opc = SCANNER.nextInt();

            switch (opc) {
                case 1:
                    bubble(values);
                    printOrder(values);
                    values = resetValues();
                    break;
                case 2:
                    shake(values);
                    printOrder(values);
                    values = resetValues();
                    break;
                case 3:
                    values = resetValues();
                    printOrder(values);
                    break;
                case 4:
                    continue;
                default:
                    System.out.println("Escriba una opcion valida, la que usted escribio no es correcta");
                    break;
            }
        }



    }

    private static int[] resetValues() {
        return new int[]{7, 3, 8, 12, 15, 23, 17, 10, 6, 11};
    }

    private static void bubble(int[] values) {
        int temp;
        for (int i = 0 ; i < values.length ; i++) {
            for (int j = 0; j < (i + 1); j++) {
                if (values[i] < values[j]) {
                    temp = values[j];
                    values[j] = values[i];
                    values[i] = temp;
                }
            }
        }
    }

    // Todo: Contains errors
    private static void shake(int[] values) {
        int temp;
        boolean option;
        int size = 10;
        for (int i = 1 ; i <= (size - 1) ; i++) {
            option = false;
            for (int j = 0; j < (size - 1); j++) {
                System.out.println("A. " + values[j] + " vs " + values[j + 1]);
                if (values[i] > values[j + 1]) {
                    temp = values[j];
                    values[j] = values[j + 1];
                    values[j + 1] = temp;
                    option = true;
                }
                System.out.println("B. " + values[j] + " vs " + values[j + 1]);
                if (option) {
                    break;
                }
            }
        }
    }

    private static void printOrder(int[] values) {
        StringJoiner bubbleJoiner = new StringJoiner(" | ", "[ ", " ]");
        for (int value : values) {
            bubbleJoiner.add(String.valueOf(value));
        }
        System.out.println("Valores ordenados: " + bubbleJoiner);
    }
}
