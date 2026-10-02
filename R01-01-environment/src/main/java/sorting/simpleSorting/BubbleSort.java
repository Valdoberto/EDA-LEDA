package sorting.simpleSorting;

import static util.Util.swap;

import sorting.AbstractSorting;

/**
 * The bubble sort algorithm iterates over the array multiple times, pushing big
 * elements to the right by swapping adjacent elements, until the array is
 * sorted.
 */
public class BubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex >= 0 && rightIndex < array.length && leftIndex <= rightIndex){

			int fim = 0;
			boolean trocou = true;
			while(trocou){
				trocou = false;
				for(int j = leftIndex + 1; j <= rightIndex - fim; j++){
					if(array[j - 1].compareTo(array[j]) > 0){
						swap(array, j - 1, j);
						trocou = true;
					}
				}
				fim++;
			}
		}
	}
}
