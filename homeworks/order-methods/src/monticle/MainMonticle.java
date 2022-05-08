package monticle;

import javax.swing.*;
import java.util.Random;
import java.util.StringJoiner;

public class MainMonticle {
    
    private static final Random RANDOM = new Random();
    
	public static void main(String[] args) {
	    //int[] vector = new int[30];
	    int[] vector = {5, 8, 6, 1, 4, 7, 3, 9, 2, 0};


	    //for (int i = 0; i < (vector.length - 1) ; i++) vector[i] = RANDOM.nextInt(vector.length);

		StringBuilder stringBuilder = new StringBuilder('\n');
		stringBuilder.append("Tenga en cuenta que esto funciona con un metodo random").append('\n');
		stringBuilder.append("* Vector original: ").append('\n');
        stringBuilder.append(monticleToString(vector)).append('\n');
        simpleOrder(vector, vector.length - 1);
		stringBuilder.append("* Vector a modo arbol: ").append('\n');
		stringBuilder.append(monticleToString(vector)).append('\n');
		monticleOrder(vector, vector.length - 1);
		stringBuilder.append("* Vector ordenado: ").append('\n');
		stringBuilder.append(monticleToString(vector)).append('\n');
		informationPane("Ordenamiento por monticulos", stringBuilder.toString());


        
	}
	
	private static void simpleOrder(int[] vector, int size) {
	    int temp;
		int fatherPosition = ((size - 1) / 2);
	    for (int i = fatherPosition ; i >= 0 ; i--) {
	        if ((2 * i + 1) > size || (2 * i + 2) > size) {
	            continue;
	        }

	        if (vector[(2 * i + 1)] > vector[i]) {
	            temp = vector[i];
	            vector[i] = vector[(2 * i + 1)];
	            vector[(2 * i + 1)] = temp;
	        }
	        
	        if (vector[(2 * i + 2)] > vector[i]) {
	            temp = vector[i];
	            vector[i] = vector[(2 * i + 2)];
	            vector[(2 * i + 2)] = temp;
	        }
	    }

		if (vector[0] > vector[size]) {
			temp = vector[0];
			vector[0] = vector[size];
			vector[size] = temp;
		}
	}

	private static void monticleOrder(int[] vector, int fatherPosition) {
		for (int i = fatherPosition; i >= 0 ; i--) {
			simpleOrder(vector, i);
		}
	}
	
	private static String monticleToString(int[] vector) {
	    StringJoiner joiner = new StringJoiner(", ", "[", "]");
	    for (int value : vector) {
	        joiner.add(String.valueOf(value));
	    }
	    return joiner.toString();
	}

	private static void informationPane(String title, String text) {
		JOptionPane.showMessageDialog(
				null,
				text,
				title,
				JOptionPane.INFORMATION_MESSAGE
		);
	}
}
