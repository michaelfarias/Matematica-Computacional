package br.ufc.crateus.matematicacomputacional.sistemaslineares;

public class Gaus {

	private static void gaus(float a[][], float b[]) {
		a = eliminacaoGaussiana(a, b);
		b = triangularSuperior(a, b);

		for (int i = 0; i < b.length; i++)
			System.out.println(Math.round(b[i]));

	}

	private static float[][] eliminacaoGaussiana(float a[][], float b[]) {

		float m;
		int k, j, i;

		for (k = 0; k < a.length - 1; k++)
			for (i = k + 1; i < a.length; i++) {
				m = a[i][k] / a[k][k];
				a[i][k] = 0;
				for (j = k + 1; j < a.length; j++)
					a[i][j] -= m * a[k][j];
				b[i] -= m * b[k];
			}

		return a;
	}

	private static float[] triangularSuperior(float a[][], float b[]) {

		float x[] = new float[a.length];
		int n = a.length, k, j;
		float s = 0f;
		x[n - 1] = (b[n - 1] / a[n - 1][n - 1]);

		for (k = n - 2; k >= 0; k--) {
			s = 0;
			for (j = k + 1; j < n; j++)
				s += a[k][j] * x[j];

			x[k] = (b[k] - s) / a[k][k];

		}

		return x;
	}

	public static void main(String[] args) {
		float sistema[][] = new float[3][3];
		sistema[0][0] = 3f;
		sistema[0][1] = 2f;
		sistema[0][2] = 4f;
		sistema[1][0] = 1f;
		sistema[1][1] = 1f;
		sistema[1][2] = 2f;
		sistema[2][0] = 4f;
		sistema[2][1] = 3f;
		sistema[2][2] = -2f;

		// sistema[0][0] = 1f;
		// sistema[0][1] = 2f;
		// sistema[0][2] = -1f;
		// sistema[1][0] = 2f;
		// sistema[1][1] = -1f;
		// sistema[1][2] = 1f;
		// sistema[2][0] = 1f;
		// sistema[2][1] = 1f;
		// sistema[2][2] = 1f;

		float b[] = { 1f, 2f, 3f };

		// float b[] = { 2f, 3f, 6f };

		Gaus.gaus(sistema, b);

	}
}
