//package estructura;
import javax.swing.JOptionPane;

public class PileStructure {
	
	private int index;
	private int pile[];
	
	public PileStructure () {
		this.index = -1;
		this.pile = new int [10];
	}
	
	public void addData(int data) {
		if (index == 9) {
			JOptionPane.showMessageDialog(null, "La pila se encuentra llena, por favor elimine un espacio");
			return;
		}
		index = index + 1;
		pile[index] = data;
		printData();
		
	}
	
	public void removeData() {
		if (index == -1) {
			JOptionPane.showMessageDialog(null, "La pila está vacia, por favor ingrese datos si los quiere eliminar");
			return;
		}
		JOptionPane.showMessageDialog(null, "Se eliminá el dato (" + pile[index] + ") de la pila");
		index = index - 1;
		printData();
	}
	
	public void searchData(int data) {
		if (index == -1) {
			JOptionPane.showMessageDialog(null, "La pila está vacia, no se pueden buscar tales datos");
			return;
		}
		
		int j;
		for (j = 0 ; j <= index ; j++) {
			if (pile[j] == data) {
				JOptionPane.showMessageDialog(null, "El dato se encontro en la pila, posicion: "+ j);
				return;
			}
		}
		
		JOptionPane.showMessageDialog(null, "El dato no se encontra en la pila");
		
	}
	
	public void printData() {
		StringBuilder stringBuilder = new StringBuilder();
		int j;
		if (index != -1) {
			for (j = 0 ; j <= index; j++) {
				stringBuilder.append('\n').append("El valor de la posicion: " + j + " es " + pile[j]);
			}
		}
		
		JOptionPane.showMessageDialog(null, "Los valores en la cola son: " + stringBuilder.toString());
		JOptionPane.showMessageDialog(null, "En la pila hay " + (9 - index) + " datos vacios");
		JOptionPane.showMessageDialog(null, "En la pila hay " + lenghtDataPairs() + " numeros pares");
		
	}
	
	public int lenghtDataPairs() {
		int lenght = 0;
		int j;
		for (j = 0 ; j <= index ; j++) {
			if ((pile[j] % 2) == 0) {
				lenght++;
			}
		}
		return lenght;
	}

}
