package br.ufc.crateus.matematicacomputacional.sistemaslineares;

public class FatoracaoLU {

	public static void fatoracao(double a[][], int p[]) {

		for (int i = 0; i < a.length; i++)
			p[i] = i;

		for (int k = 0; k < a.length - 1; k++) {
			double pv = Math.abs(a[k][k]);
			int r = k;
			for (int i = k + 1; i < a.length; i++)
				if (Math.abs(a[i][k]) > pv) {
					pv = Math.abs(a[i][k]);
					r = i;
				}
			if (pv == 0) {
				System.out.println("operação interrompida, a matriz é singular");
				break;
			}

			if (r != k) {
				p[k] = p[k] + p[r];
				p[r] = p[k] - p[r];
				p[k] = p[k] - p[r];

				for (int j = 0; j < a.length; j++) {
					a[k][j] = a[k][j] + a[r][j];
					a[r][j] = a[k][j] - a[r][j];
					a[k][j] = a[k][j] - a[r][j];
				}
			}

			for (int i = k + 1; i < a.length; i++) {
				double m = a[i][k] / a[k][k];
				a[i][k] = m;
				for (int j = (k + 1); j < a.length; j++)
					a[i][j] = a[i][j] - m * a[k][j];
			}

		}
	}

	public static double[] calcularPb(int p[], double b[]) {
		double c[] = new double[b.length];
		for (int i = 0; i < b.length; i++) {
			int r = p[i];
			c[i] = b[r];
		}

		return c;
	}

	public static void calcularLy(double a[][], double c[]) {
		for (int i = 0; i < a.length; i++) {
			double soma = 0;
			for (int j = 0; j < i; j++)
				soma += a[i][j] * c[j];
			c[i] = c[i] - soma;
		}
	}

	public static void calcularUx(double a[][], double x[]) {
		for (int i = a.length - 1; i >= 0; i--) {
			double soma = 0;
			for (int j = i + 1; j < a.length; j++)
				soma += a[i][j] * x[j];
			x[i] = (x[i] - soma) / a[i][i];
		}
	}

	public static double determinante(double a[][]) {
		double s = 1;

		for (int i = 0; i < a.length; i++)
			s *= a[i][i];

		return s * -1;
	}

	public static void main(String[] args) {
		double a[][] = new double[3][3];
		int p[] = new int[3];
		double b[] = new double[3];

		// a[0][0] = 3;
		// a[0][1] = -4;
		// a[0][2] = 1;
		// a[1][0] = 1;
		// a[1][1] = 2;
		// a[1][2] = 2;
		// a[2][0] = 4;
		// a[2][1] = 0;
		// a[2][2] = -3;
		//
		// b[0] = 9;
		// b[1] = 3;
		// b[2] = -2;

		// a[0][0] = 5;
		// a[0][1] = 1;
		// a[0][2] = -2;
		// a[1][0] = 3;
		// a[1][1] = -9.4;
		// a[1][2] = 1.8;
		// a[2][0] = 1;
		// a[2][1] = 2.2;
		// a[2][2] = 4.6;
		//
		// b[0] = 10;
		// b[1] = 22;
		// b[2] = 10;

		a[0][0] = 1;
		a[0][1] = 3;
		a[0][2] = 5;
		a[1][0] = 2;
		a[1][1] = 4;
		a[1][2] = 7;
		a[2][0] = 1;
		a[2][1] = 1;
		a[2][2] = 0;

		b[0] = 0;
		b[1] = 1;
		b[2] = -2;

		FatoracaoLU.fatoracao(a, p);

		b = FatoracaoLU.calcularPb(p, b);

		FatoracaoLU.calcularLy(a, b);
		FatoracaoLU.calcularUx(a, b);

		System.out.println("Determinante: " + FatoracaoLU.determinante(a));

		for (int i = 0; i < b.length; i++)
			System.out.println(b[i]);

	}
}
