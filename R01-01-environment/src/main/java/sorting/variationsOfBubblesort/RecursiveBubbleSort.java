package sorting.variationsOfBubblesort;

import static util.Util.swap;

import sorting.AbstractSorting;

public class RecursiveBubbleSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * Implementação recursiva do bubble sort. Você deve implementar apenas esse
	 * método sem usar nenhum outro método auxiliar (exceto
	 * Util.swap(array,int,int)). Para isso, tente definir o caso base do
	 * algoritmo e depois o caso indutivo, que reduz o problema para uma entrada
	 * menor em uma chamada recursiva. Seu algoritmo deve ter complexidade
	 * quadrática O(n^2).
	 */
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex >= 0 && rightIndex < array.length && leftIndex < rightIndex) {

			boolean trocou = false;

			for (int i = leftIndex + 1; i <= rightIndex; i++) {
				if (array[i - 1].compareTo(array[i]) > 0) {
					swap(array, i - 1, i);
					trocou = true;
				}
			}
			if (trocou) {
				sort(array, leftIndex, rightIndex - 1);
			}
		}
	}
}
