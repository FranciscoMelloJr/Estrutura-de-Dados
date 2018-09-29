package desafioN4;

import fila.Elemento;

public class Calculadora {

	private Elemento topo = null;

	public Calculadora() {
	}

	public void empilha(int v) {
		Elemento novo = new Elemento(v);
		if (topo == null)
			topo = novo;
		else {
			novo.proximo = topo;
			topo = novo;
		}
	}

	public int desempilha() {
		int retVal = topo.valor;
		topo = topo.proximo;
		return retVal;
	}

	public void calcular(String op) {
		switch (op) {
		case "+":
			int Val1 = this.desempilha();
			int Val2 = this.desempilha();
			this.empilha(Val2 + Val1);
			break;
		case "-":
			int Val3 = this.desempilha();
			int Val4 = this.desempilha();
			this.empilha(Val4 - Val3);
			break;
		case "/":
			int Val5 = this.desempilha();
			int Val6 = this.desempilha();
			this.empilha(Val6 / Val5);
			break;
		case "*":
			int Val7 = this.desempilha();
			int Val8 = this.desempilha();
			this.empilha(Val8 * Val7);
			break;
		}
	}
}
