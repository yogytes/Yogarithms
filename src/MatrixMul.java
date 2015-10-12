/**
 * Generates random multipliable matrices and prints the product
 * @author I069337
 *
 */

public class MatrixMul {

	public static void main(String[] args) {
		int common = 1 + (int) (Math.random() * 10);
		final Pair dim1 = new Pair(1 + (int) (Math.random() * 10), common);
		System.out.println("dimension 1 : "+dim1);
		final Pair dim2 = new Pair(common, 1 + (int) (Math.random() * 10));
		System.out.println("dimension2 : "+ dim2);

		int[][] mat1 = populateMatrix(dim1);
		int[][] mat2 = populateMatrix(dim2);
		multiplyMatrices(mat1, mat2, dim1, dim2);

	}

	private static int[][] multiplyMatrices(int[][] mat1, int[][] mat2,
			Pair dim1, Pair dim2) {
		int[][] prod = new int[dim1.getFirst()][dim2.getSecond()];
		for (int i = 0; i < dim1.getFirst(); i++) {
			for (int j = 0; j < dim2.getSecond(); j++) {
				for (int k = 0; k < dim1.getSecond(); k++) {
					prod[i][j] += mat1[i][k] * mat2[k][j];
				}
			}
		}
		printMatrix(prod, new Pair(dim1.getFirst(), dim2.getSecond()));
		return prod;

	}

	private static int[][] populateMatrix(Pair dim) {
		int[][] mat = new int[dim.getFirst()][dim.getSecond()];
		for (int i = 0; i < dim.getFirst(); i++) {
			for (int j = 0; j < dim.getSecond(); j++) {
				mat[i][j] = (int) (Math.random() * 100);
			}
		}
		printMatrix(mat, dim);
		return mat;
	}

	private static void printMatrix(int[][] arr, Pair dimensions) {
		System.out.println("***********Matrix********");
		for (int i = 0; i < dimensions.getFirst(); i++) {
			for (int j = 0; j < dimensions.getSecond(); j++) {
				System.out.print(arr[i][j] + "    ");
			}
			System.out.println();
		}
		System.out.println("*********END********");

	}

}
