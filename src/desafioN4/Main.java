package desafioN4;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

		Calculadora c = new Calculadora();

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				c.empilha(Integer.parseInt(JOptionPane.showInputDialog("Valores: ")));
			}
			String operador = JOptionPane.showInputDialog("Operador Unit�rio: ");
			c.calcular(operador);
		}
		String operador = JOptionPane.showInputDialog("Operador Bin�rio: ");
		c.calcular(operador);
		System.out.println(c.desempilha());
	}
}
