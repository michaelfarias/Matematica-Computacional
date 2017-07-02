package br.ufc.crateus.matematicacomputacional.zeros;

public class MetodosIterativos {

	private static double funcao(double x) {
		return Math.pow(x, 3) - 9 * x + 3;
		// return Math.pow(x, 3) - 10;
		// return Math.pow(Math.E, x) - x - 2;

		// return 5 - x * Math.pow(Math.E, x);
	}

	// x^2 - 9
	private static double derivada(double x) {
		return 3 * Math.pow(x, 2) - 9;

	}

	public static void bisseccao(double a, double b, double e) {

		if ((b - a) < e) {
			System.out.println("então escoha qualquer y qualquer x E [" + a + ", " + b + "]");
		}

		else {

			int k = 0;

			double M = funcao(a);

			while ((b - a) > e) {

				double x = (a + b) / 2;

				if (M * funcao(x) > 0)
					a = x;

				else
					b = x;
				k++;

			}

			System.out.println("Escolha para y qualquer x E [" + a + ", " + b + "]");
			System.out.println("Numero de iterações: " + k);
		}
	}

	public static void posicaoFalsa(double a, double b, double e1, double e2) {

		if ((b - a) < e1)
			System.out.println("então escoha qualquer y qualquer x E [" + a + ", " + b + "]");
		else if (Math.abs(funcao(a)) < e2)
			System.out.println("escoha " + a + " ou " + b + " como y");
		else if (Math.abs(funcao(b)) < e2)
			System.out.println("escoha " + a + " ou " + b + " como y");

		else {
			int k = 0;
			double f = 0;
			double M = funcao(a);

			while ((b - a) > e1) {
				k++;
				double x = (a * funcao(b)) - (b * funcao(a)) / (funcao(b) - funcao(a));

				if (Math.abs(funcao(x)) < e2) {
					System.out.println("Escolha y = " + x);
					System.out.println("Numero de iterações:" + k);
					break;
				}

				if (M * funcao(x) > 0)
					a = x;

				else
					b = x;
			}

		}

	}

	public static void secante(double x0, double x1, double e1, double e2) {

		if (Math.abs(funcao(x0)) < e1)
			System.out.println("faça y = " + x0);
		else if (Math.abs(funcao(x1)) < e1 || Math.abs(x1 - x0) < e2)
			System.out.println("faça y = " + x1);

		else {
			int k = 1;

			double x2 = 0.0;

			do {

				x2 = x1 - (funcao(x1) / (funcao(x1) - funcao(x0))) * (x1 - x0);

				x0 = x1;
				x1 = x2;

				k++;
			} while (Math.abs(funcao(x2)) > e1 || Math.abs(x2 - x1) > e2);

			System.out.println("Então faça y = " + x2);
			System.out.println("Numero de iterações: " + k);

		}
	}

	public static void newton(double x0, double e1, double e2) {

		if (Math.abs(funcao(x0)) < e1)
			System.out.println("faça y = " + x0);

		else {
			int k = 0;

			double x1 = x0 - (funcao(x0) / derivada(x0));

			while (Math.abs(funcao(x1)) > e1 || Math.abs(x1 - x0) > e2) {

				x1 = x0 - (funcao(x0) / derivada(x0));
				x0 = x1;
				k++;
			}
			System.out.println("faça y = " + x1 + " - " + funcao(x1));
		}
	}

	public static void main(String[] args) {

		// MetodosIterativos.bisseccao(1, 2, 0.001);

		/* x^3-9x+3 */
		// MetodosIterativos.bisseccao(0, 1, 0.001);

		/* x^3 - 10 */
		// MetodosIterativos.bisseccao(2, 3, 0.1);

		/* x^3-9x+3 */
		// MetodosIterativos.posicaoFalsa(0, 1, 0.0005, 0.0005);

		/* 5 - xe^x */
		// MetodosIterativos.secante(1, 2, 0.00001, 0.00001);

		/* x^3-9x+3 */
		// MetodosIterativos.newton(0.5, 0.0001, 0.0001);

	}

}
