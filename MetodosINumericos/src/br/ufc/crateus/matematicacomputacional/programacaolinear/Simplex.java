package br.ufc.crateus.matematicacomputacional.programacaolinear;

public class Simplex {
	private int linhas, colunas;
	private float[][] tabela;
	private int variaveisFolga;

	public Simplex(int linha, int coluna, int variaveis) {
		this.tabela = new float[linha][coluna];
		this.linhas = linha;
		this.colunas = coluna;
		this.variaveisFolga = variaveis;

		for (int i = 0; i < linha; i++) {
			tabela[i] = new float[coluna];
		}

	}

	public void preencherTabela(float[][] dados) {
		for (int i = 0; i < tabela.length; i++) {
			System.arraycopy(dados[i], 0, this.tabela[i], 0, dados[i].length);
		}
	}

	public void print() {
		for (int i = 0; i < linhas; i++) {
			for (int j = 0; j < colunas; j++) {
				System.out.print(String.format("%.2f", tabela[i][j]) + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}

	public void calcula() {

		while (encontrarColunaEntrada() != -1) {

			int colunaPivo = encontrarColunaEntrada();

			System.out.println("pivo coluna" + colunaPivo);

			int linha = encontrarLinha(colunaPivo);

			System.out.println("pivo linha" + linha);
			dividirLinha(linha, colunaPivo);

			formarNovaTabela(linha, colunaPivo);
			print();

		}

	}

	private int encontrarColunaEntrada() {
		float min = 100000000000f;
		int c = -1;

		for (int i = 0; i < this.colunas - this.variaveisFolga - 1; i++) {
			if (tabela[0][i] < min && tabela[0][i] > 0) {
				min = tabela[0][i];
				c = i;

			}
		}

		return c;
	}

	private int encontrarLinha(int c) {

		float min = tabela[1][colunas - 1] / tabela[1][c];

		int l = 1;
		for (int j = 2; j < linhas; j++) {

			if (tabela[j][c] > 0)
				if ((tabela[j][colunas - 1] / tabela[j][c]) < min && (tabela[j][colunas - 1] / tabela[j][c]) > 0) {
					min = tabela[j][colunas - 1] / tabela[j][c];
					l = j;
				}
		}
		return l;

	}

	private void dividirLinha(int linha, int colunaPivo) {
		if (tabela[linha][colunaPivo] != 0) {
			float pivo = tabela[linha][colunaPivo];
			for (int i = 0; i < colunas; i++)
				tabela[linha][i] /= pivo;
		}

	}

	private void formarNovaTabela(int linha, int colunaPivo) {

		float p2 = tabela[linha][colunaPivo];
		for (int l = 0; l < linhas; l++) {
			float p1 = tabela[l][colunaPivo];
			float p3 = Math.abs(p1);

			if (l != linha) {
				for (int c = 0; c < colunas; c++) {
					if (p1 > 0 && p2 > 0)
						tabela[l][c] = (tabela[l][c] * p2) - (tabela[linha][c] * p3);
					else if (p1 > 0 && p2 < 0)
						tabela[l][c] = (tabela[l][c] * p2) + (tabela[linha][c] * p3);
					else if (p1 < 0 && p2 > 0)
						tabela[l][c] = (tabela[l][c] * p2) + (tabela[linha][c] * p3);

					else
						tabela[l][c] = (tabela[l][c] * p2) - (tabela[linha][c] * p3);

				}
			}

		}
	}

	public static void main(String[] args) {
		/* Exemplo 1 */
//		float[][] padronizado = { { 4, 5, 9, 11, 0, 0, 0, 0 }, { 1, 1, 1, 1, 1, 0, 0, 15 },
//				{ 7, 5, 3, 2, 0, 1, 0, 120 }, { 3, 5, 10, 15, 0, 0, 1, 100 } };

		/* Exemplo 2 */
//		 float[][] padronizado = { { 3, 5, 0, 0, 0, 0, 0, 0, 0 }, { 1, 0, 1,
//		 0, 0, 1, 0, 0, 4 },
//		 { 0, 1, 0, 1, 0, 0, 1, 0, 6 }, { 3, 2, 0, 0, -1, 0, 0, 1, 18 } };

		/* Exemplo 3 */
		 float[][] padronizado = { { 2, -1, 2, 0, 0, 0, 0 }, { 2, 1, 0, 1, 0,
		 0, 10 }, { 1, 2, -2, 0, 1, 0, 20 },
		 { 0, 1, 2, 0, 0, 1, 5 } };

		/*
		 * O construtor recebe o numero de linhas e o numero de colunas, junto
		 * com o numero de variaveis de folga
		 */
		Simplex simplex = new Simplex(4, 7, 3);
		
		simplex.preencherTabela(padronizado);
		simplex.print();
		simplex.calcula();
		simplex.print();
	}
}