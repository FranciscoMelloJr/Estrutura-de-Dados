package lista;

import fila.Elemento;

public class ListaSimples {

	private Elemento primeiro, ultimo, atual;
	int tamanho;

	public ListaSimples() {
		primeiro = ultimo = atual = null;
	}

	public boolean estaVazio() {
		return primeiro == null;
	}

	public int comprimento() {
		return tamanho;
	}

	public void inserePrimeiro(int v) {
		Elemento novo = new Elemento(v);
		if (estaVazio()) {
			primeiro = novo;
			ultimo = novo;
			atual = novo;
			tamanho++;
		} else {
			novo.proximo = primeiro;
			primeiro = novo;
			tamanho++;
		}
	}

	public void insereUltimo(int v) {
		Elemento novo = new Elemento(v);
		if (estaVazio()) {
			primeiro = novo;
			ultimo = novo;
			atual = novo;
			tamanho++;
		} else {
			ultimo.proximo = novo;
			ultimo = novo;
			tamanho++;
		}
	}

	public void moveParaPosicao(int pos) {
		atual = primeiro;
		for (int i = 0; i < pos; i++) {
			atual = atual.proximo;
		}
	}

	public void insereNaPosicao(int v, int pos) {
		Elemento novo = new Elemento(v);
		moveParaPosicao(pos);
		novo.proximo = atual.proximo;
		atual.proximo = novo;
		tamanho++;
	}

	public int primeiro() {
		return primeiro.valor;
	}

	public int ultimo() {
		return ultimo.valor;
	}

	public int elementoNaPosicao(int pos) {
		moveParaPosicao(pos);
		return atual.valor;
	}

	public int buscaElemento(int v) {
		int cont = 0;
		atual = primeiro;
		while (atual != null && atual.valor != v) {
			atual = atual.proximo;
			cont++;
		}
		if (atual != null)
			return cont;
		return -1;
	}

	public void removePrimeiro() {
		primeiro = primeiro.proximo;
		tamanho--;
	}

	public void removeUltimo() {
		int pos;
		pos = comprimento() - 1;
		moveParaPosicao(pos);
		atual.proximo = null;
		tamanho--;
	}

	public void removeElemento(int v) {
		int pos;
		Elemento temp;
		pos = buscaElemento(v);
		if (pos > -1) {
			temp = atual.proximo;
			pos = pos - 1;
			moveParaPosicao(pos);
			atual.proximo = temp;
			tamanho--;
		}
	}

	public void removeNaPosicao(int pos) {
		Elemento temp;
		moveParaPosicao(pos);
		temp = atual.proximo;
		pos = pos - 1;
		moveParaPosicao(pos);
		atual.proximo = temp;
		tamanho--;
	}
}
