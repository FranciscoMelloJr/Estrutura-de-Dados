package lista;

public class ListaDE {

		private ElementoD primeiro, ultimo, atual;
		int tamanho;

		public ListaDE() {
			primeiro = ultimo = atual = null;
		}

		public boolean estaVazio() {
			return primeiro == null;
		}

		public int comprimento() {
			return tamanho;
		}

		public void inserePrimeiro(int v) {
			ElementoD novo = new ElementoD(v);
			if (estaVazio()) {
				primeiro = novo;
				ultimo = novo;
				atual = novo;
				tamanho++;
			} else {
				novo.proximo = primeiro;
				primeiro.anterior = novo;
				primeiro = novo;
				tamanho++;
			}
		}

		public void insereUltimo(int v) {
			ElementoD novo = new ElementoD(v);
			if (estaVazio()) {
				primeiro = novo;
				ultimo = novo;
				atual = novo;
				tamanho++;
			} else {
				ultimo.proximo = novo;
				novo.anterior = ultimo;
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
			ElementoD novo = new ElementoD(v);
			moveParaPosicao(pos);
			novo.proximo = atual.proximo;
			atual.proximo = novo;
			novo.anterior = atual;
			novo.proximo.anterior = novo;
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
			ElementoD temp;
			pos = buscaElemento(v);
			if (pos > -1) {
				temp = atual.proximo;
				pos = pos - 1;
				moveParaPosicao(pos);
				atual.proximo = temp;
				temp.anterior = atual;
				tamanho--;
			}
		}

		public void removeNaPosicao(int pos) {
			ElementoD temp;
			moveParaPosicao(pos);
			temp = atual.proximo;
			pos = pos - 1;
			moveParaPosicao(pos);
			atual.proximo = temp;
			temp.anterior = atual;
			tamanho--;
		}
	}
