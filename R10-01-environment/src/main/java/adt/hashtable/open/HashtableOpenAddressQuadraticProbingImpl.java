package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionOpenAddress;
import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionQuadraticProbing;

public class HashtableOpenAddressQuadraticProbingImpl<T extends Storable>
		extends AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressQuadraticProbingImpl(int size,
			HashFunctionClosedAddressMethod method, int c1, int c2) {
		super(size);
		hashFunction = new HashFunctionQuadraticProbing<T>(size, method, c1, c2);
		this.initiateInternalTable(size);
	}


	@Override
	@SuppressWarnings("unchecked")
	public void insert(T element) {
		if (element != null && this.indexOf(element) == -1) {
			if (this.isFull()) {
				throw new HashtableOverflowException();
			}

			HashFunctionOpenAddress<T> function = (HashFunctionOpenAddress<T>) this.hashFunction;
			int probe = 0;
			boolean inserted = false;

			while (!inserted && probe < this.capacity()) {
				int position = function.hash(element, probe);

				if (this.table[position] == null
					|| this.deletedElement.equals(this.table[position])) {
					this.table[position] = element;
					this.elements++;
					inserted = true;
				} else {
					this.COLLISIONS++;
					probe++;
				}
			}
		}
	}

	@Override
	public void remove(T element) {
		int index = this.indexOf(element);

		if (index != -1) {
			this.table[index] = this.deletedElement;
			this.elements--;
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public T search(T element) {
		T result = null;
		int index = this.indexOf(element);

		if (index != -1) {
			result = (T) this.table[index];
		}

		return result;
	}


	@Override
	public int indexOf(T element) {
		int index = -1;

		if (element != null) {
			HashFunctionOpenAddress<T> function = (HashFunctionOpenAddress<T>) this.hashFunction;
			int probe = 0;
			boolean finished = false;

			while (!finished && probe < this.capacity()) {
				int position = function.hash(element, probe);

				if (this.table[position] == null) {
					finished = true;
				} else if (this.table[position].equals(element)) {
					index = position;
					finished = true;
				} else {
					probe++;
				}
			}
		}

		return index;
	}
}
