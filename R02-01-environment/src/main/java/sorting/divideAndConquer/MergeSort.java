package sorting.divideAndConquer;

import sorting.AbstractSorting;
import java.util.*;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (array.length > 1 && leftIndex < rightIndex) {
			int middle = (leftIndex + rightIndex) / 2;
			sort(array, leftIndex, middle);
			sort(array, middle + 1, rightIndex);
			merge(array, leftIndex, middle, rightIndex);
		}
	}

	private void merge(T[] array, int leftIndex, int middle, int rightIndex) {
	
		LinkedList<T> left = new LinkedList<>();
		LinkedList<T> right = new LinkedList<>();

		for (int i = leftIndex; i <= middle; i++) {
			left.add(array[i]);
		}
		for (int i = middle + 1; i <= rightIndex; i++) {
			right.add(array[i]);
		}


		LinkedList<T> result = new LinkedList<>();

		while (left.size() > 0 && right.size() > 0) {
			if (left.getFirst().compareTo(right.getFirst()) <= 0) {
				result.add(left.removeFirst());
			} else {
				result.add(right.removeFirst());
			}
		}

		result.addAll(left); 
		result.addAll(right);

		
		int k = leftIndex;
		for (T item : result) {
			array[k++] = item;
		}
	}
}