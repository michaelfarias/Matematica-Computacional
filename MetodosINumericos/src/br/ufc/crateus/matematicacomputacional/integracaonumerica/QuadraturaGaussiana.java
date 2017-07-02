package br.ufc.crateus.matematicacomputacional.integracaonumerica;

public class QuadraturaGaussiana {

	/* x^2 + 3x */
	private static double funcao1(double x) {
		return Math.pow(x, 2) + 3 * x;
	}

	/** 1 /x */
	private static double funcao2(double x) {
		return 1 / x;
	}

	/* 0.2 + 25x - 200x^2 + 675x^3 - 900x^4 + 400x^5 */
	private static double funcao3(double x) {
		return 0.2 + 25 * x - 200 * Math.pow(x, 2) + 675 * Math.pow(x, 3) - 900 * Math.pow(x, 4) + 400 * Math.pow(x, 5);
	}

	/** x^4 + 1 */
	private static double funcao4(double x) {
		return Math.pow(x, 4) + 1;
	}

	private static double[] getFatoresN2() {
		double vet[] = new double[2];
		vet[0] = 1.0;
		vet[1] = 1.0;
		return vet;
	}

	private static double[] getArgumentosN2() {
		double vet[] = new double[2];
		vet[0] = -0.577350269;
		vet[1] = 0.577350269;

		return vet;
	}

	private static double[] getFatoresN3() {
		double vet[] = new double[3];
		vet[0] = 0.5555556;
		vet[1] = 0.8888889;
		vet[2] = 0.5555556;

		return vet;
	}

	private static double[] getArgumentosN3() {
		double vet[] = new double[3];
		vet[0] = -0.774596669;
		vet[1] = 0.0;
		vet[2] = 0.774596669;
		return vet;
	}

	private static double[] getFatoresN4() {
		double vet[] = new double[4];
		vet[0] = 0.3478548;
		vet[1] = 0.6521452;
		vet[2] = 0.6521452;
		vet[3] = 0.3478548;
		return vet;
	}

	private static double[] getArgumentosN4() {
		double vet[] = new double[4];
		vet[0] = -0.861136312;
		vet[1] = -0.339981044;
		vet[2] = 0.339981044;
		vet[3] = 0.861136312;

		return vet;
	}

	public static double quadraturaGauss(double a, double b, int n) {

		double u, s = 0;

		double fator[] = new double[n];
		double arg[] = new double[n];

		if (n == 2) {
			fator = getFatoresN2();
			arg = getArgumentosN2();
		}
		if (n == 3) {
			fator = getFatoresN3();
			arg = getArgumentosN3();
		}
		if (n == 4) {
			fator = getFatoresN4();
			arg = getArgumentosN4();
		}

		for (int i = 0; i < n; i++) {
			/* observar qual função deseja calcular a quadratura. */
			u = ((b - a) * arg[i] + (a + b)) / 2;
			s += (funcao3(u)) * fator[i];
		}

		return s * (b - a) / 2;

	}

	public static void main(String[] args) {
		// antes de qualquer execução do algoritmo será preciso alterar a função
		// que sera utilizada no metodo da quadratura.

		System.out.println("Função 1: " + QuadraturaGaussiana.quadraturaGauss(1, 2, 4));
		System.out.println("Função 2: " + QuadraturaGaussiana.quadraturaGauss(1, 5, 3));

		/* Testar com n=2, n=3 */
		System.out.println("Função 3: " + QuadraturaGaussiana.quadraturaGauss(0, 0.8, 3));
		System.out.println("Função 3: " + QuadraturaGaussiana.quadraturaGauss(0, 0.8, 2));
		System.out.println("Função 4: " + QuadraturaGaussiana.quadraturaGauss(-1, 1, 3));

	}

}