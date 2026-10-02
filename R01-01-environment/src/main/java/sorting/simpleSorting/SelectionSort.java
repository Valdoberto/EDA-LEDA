package sorting.simpleSorting;

import sorting.AbstractSorting;
import static util.Util.swap;

/**
 * The selection sort algorithm chooses the smallest element from the array and
 * puts it in the first position. Then chooses the second smallest element and
 * stores it in the second position, and so on until the array is sorted.
 */
public class SelectionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex >= 0 && rightIndex < array.length && leftIndex <= rightIndex){

			for (int i = leftIndex; i < rightIndex; i++){
				int menor = i;
				for(int v = i + 1; v <= rightIndex; v++){
					if (array[v].compareTo(array[menor]) < 0){
						menor = v;
					}
				}
				swap(array, i , menor);
			}
		}
	}
}
