package br.ufc.crateus.matematicacomputacional.integracaonumerica;

public class IntegracaoNumerica {

	// e^x
	private static float funcao(double x) {

		 return (float) Math.pow(Math.E, x);

//		return (float) (0.2 + 25 * x - 200 * Math.pow(x, 2) + 675 * Math.pow(x, 3) - 900 * Math.pow(x, 4)
//				+ 400 * Math.pow(x, 5));
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

		// IntegracaoNumerica.trapezio(2, 1,4 );
//		IntegracaoNumerica.simpson13(0.8f, 0, 4);

	}
}
