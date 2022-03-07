//package estructura;
import javax.swing.JOptionPane;

public class MainClass {

	public static void main(String[] args) {
		
		PileStructure pile = new PileStructure();
		int opc = 0;
		
		while (opc != 4) {
			opc = Integer.parseInt(JOptionPane.showInputDialog(
					"Bienvenido, ingrese la opcion\n" +
					"\n1. Adicionar\n" +
					"2. Eliminar\n" + 
					"3. Buscar\n" + 
					"4. Salir"
				));
			
			switch (opc) {
				case 1:
					pile.addData(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el dato de la pila")));
					break;
				case 2:
					pile.removeData();
					break;
				case 3:
					pile.searchData(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el dato que desea buscar")));
					break;
				case 4:
					continue;
				default:
					break;
					
			
			}
			
		}
		JOptionPane.showMessageDialog(null, "�Gracias por usar el programa! :D");
		
		

	}

}
