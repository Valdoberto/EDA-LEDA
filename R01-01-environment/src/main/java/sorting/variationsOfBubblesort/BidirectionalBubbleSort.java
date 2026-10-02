package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import static util.Util.swap;

/**
 * This bubble sort variation has two internal iterations. In the first, it
 * pushes big elements to the right, like the normal bubble sort does. Then in
 * the second, iterates the array backwards, that is, from right to left, while
 * pushing small elements to the left. This process is repeated until the array
 * is sorted.
 */
public class BidirectionalBubbleSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex >= 0 && rightIndex < array.length && leftIndex < rightIndex) {
			boolean troca1 = true;
			boolean troca2 = true;
			while (troca1 && troca2) {
				troca1 = false;
				troca2 = false;
				for (int i = leftIndex + 1; i <= rightIndex; i++) {
					if (array[i].compareTo(array[i - 1]) < 0) {
						swap(array, i, i - 1);
						troca1 = true;
					}

				}
				for (int j = rightIndex; j > leftIndex; j--) {
					if (array[j].compareTo(array[j - 1]) < 0) {
						swap(array, j, j - 1);
						troca2 = true;
					}
				}
			}

		}
	}
}
