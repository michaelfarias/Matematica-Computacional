package br.ufc.crateus.matematicacomputacional.integracaonumerica;

public class IntegracaoNumerica {

	private static float funcao(double x) {
		// return (float) ((float) 1 / x);

		return (float) Math.pow(Math.E, x);

		// return (float) (0.2 + 25 * x - 200 * Math.pow(x, 2) + 675 *
		// Math.pow(x, 3) - 900 * Math.pow(x, 4)
		// + 400 * Math.pow(x, 5));
	}

	public static void simpson13(float b, float a, int n) {
		float h = (b - a) / n;

		float soma = funcao(a);

		int i;
		for (i = 1; i < n - 2; i += 2)
			soma += 4 * funcao(h * i) + 2 * funcao(h * (i + 1));

		soma += 4 * funcao(h * i) + funcao(b);

		System.out.println("valor: " + (soma * h) / 3);

	}

	public static void trapezio(float b, float a, int n) {

		float h = (b - a) / n;

		float soma = funcao(a);

		int i;
		for (i = 1; i < n; i++)
			soma += 2 * funcao(h * i);

		soma += funcao(b);

		System.out.println("valor: " + (h * soma) / 2);
	}

	public static void main(String[] args) {

		// integral de e^x [0,1] REGRA COMPOSTA
		// IntegracaoNumerica.trapezio(1, 0, 10);

		// 0.2 + 25x - 200x^2 + 675x^3 - 900x^4 + 400^5 REGRA COMPOSTA
		// IntegracaoNumerica.trapezio(0.8f, 0, 10);

		/* integral de 1/x [3, 3.6] REGRA SIMPLES */
		// IntegracaoNumerica.trapezio(3.6f, 3, 1);

		// 0.2 + 25x - 200x^2 + 675x^3 - 900x^4 + 400^5 REGRA COMPOSTA
		// IntegracaoNumerica.simpson13(0.8f, 0, 4);

		// integral de e^x [0,1]
		// IntegracaoNumerica.simpson13(1, 0, 10);

	}
}
