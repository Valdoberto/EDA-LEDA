package sorting.divideAndConquer.quicksort3;

import sorting.AbstractSorting;
import static util.Util.swap;
/**
 * A classe QuickSortMedianOfThree representa uma variação do QuickSort que
 * funciona de forma ligeiramente diferente. Relembre que quando o pivô
 * escolhido divide o array aproximadamente na metade, o QuickSort tem um
 * desempenho perto do ótimo. Para aproximar a entrada do caso ótimo, diversas
 * abordagens podem ser utilizadas. Uma delas é usar a mediana de 3 para achar o
 * pivô. Essa técnica consiste no seguinte:
 * 1. Comparar o elemento mais a esquerda, o central e o mais a direita do
 * intervalo.
 * 2. Ordenar os elementos, tal que: A[left] < A[center] < A[right].
 * 3. Adotar o A[center] como pivô.
 * 4. Colocar o pivô na penúltima posição A[right-1].
 * 5. Aplicar o particionamento considerando o vetor menor, de A[left+1] até
 * A[right-1].
 * 6. Aplicar o algoritmo na particao a esquerda e na particao a direita do
 * pivô.
 */
public class QuickSortMedianOfThree<T extends Comparable<T>> extends
		AbstractSorting<T> {

	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (array != null && leftIndex >= 0 && rightIndex < array.length && leftIndex < rightIndex) {
			int pivot = partition(array, leftIndex, rightIndex);
			sort(array, leftIndex, pivot - 1);
			sort(array, pivot + 1, rightIndex);
		}
	}

	public int partition(T[] array, int left, int right) {
		int result = -1;
		if (right - left == 1) {
			if (array[left].compareTo(array[right]) > 0)
				swap(array, left, right);
			result = left;
		} else {

			int mid = left + (right - left) / 2;

			if (array[mid].compareTo(array[left]) < 0)
				swap(array, left, mid);
			if (array[right].compareTo(array[left]) < 0)
				swap(array, left, right);
			if (array[right].compareTo(array[mid]) < 0)
				swap(array, mid, right);

			swap(array, mid, right - 1);
			T pivot = array[right - 1];

			int i = left;
			for (int j = left + 1; j <= right - 2; j++) {
				if (array[j].compareTo(pivot) <= 0) {
					i++;
					swap(array, i, j);
				}
			}

			swap(array, i + 1, right - 1);
			result = i + 1;
		}
		return result;
	}
}