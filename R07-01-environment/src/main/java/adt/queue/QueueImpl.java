package adt.queue;

public class QueueImpl<T> implements Queue<T> {

	protected T[] array;
	protected int tail;

	@SuppressWarnings("unchecked")
	public QueueImpl(int size) {
		array = (T[]) new Object[size];
		tail = -1;
	}

	@Override
	public T head() {
		T element = null;
		if (!isEmpty()) {
			element = array[0];
		}
		return element;
	}

	@Override
	public boolean isEmpty() {
		return tail == -1;
	}

	@Override
	public boolean isFull() {
		return tail + 1 == array.length;
	}

	@SuppressWarnings("unused")
	private void shiftLeft() {
		for (int i = 0; i < tail; i++){
			array[i] = array[i + 1];
		}
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (isFull()) {
			throw new QueueOverflowException();
		}
		array[++tail] = element;
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (isEmpty()) {
			throw new QueueUnderflowException();
		}
		T elemento = array[0];
		shiftLeft();
		array[tail] = null;
		tail--;
		return elemento;
	}

}