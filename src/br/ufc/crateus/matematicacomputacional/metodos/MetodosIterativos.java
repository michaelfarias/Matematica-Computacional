package br.ufc.crateus.matematicacomputacional.metodos;

public class MetodosIterativos {

	// x^3 - 9x + 3
	private static double funcao(double x) {
		return Math.pow(x, 3) - 9 * x + 3;

		// return Math.pow(Math.E, x) - x - 2;
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

			int k = 1;

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
			int k = 1;
			double M = funcao(a);

			while ((b - a) > e1) {

				double x = (a * funcao(b)) - (b * funcao(a)) / (funcao(b) - funcao(a));

				if (Math.abs(funcao(x)) < e2) {
					System.out.println("escolha y = " + x);
					break;
				}

				if (M * funcao(x) > 0)
					a = x;

				else
					b = x;
				k++;

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

			System.out.println("então faça y = " + x2);

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

		// MetodosIterativos.bisseccao(0, 1, 0.001);

		// MetodosIterativos.posicaoFalsa(0, 1, 0.0005, 0.0005);

		// MetodosIterativos.secante(0, 1, 0.0005, 0.0005);

		// MetodosIterativos.newton(0.5, 0.0001, 0.0001);
	}

}
