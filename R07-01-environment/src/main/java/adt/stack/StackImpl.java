package adt.stack;

public class StackImpl<T> implements Stack<T> {

	protected T[] array;
	protected int top;

	@SuppressWarnings("unchecked")
	public StackImpl(int size) {
		array = (T[]) new Object[size];
		top = -1;
	}

	@Override
	public T top() {
		T resposta = null;
		if (!isEmpty()) {
			resposta = array[top];
		}
		return resposta;
	}

	@Override
	public boolean isEmpty() {
		return top == -1;
	}

	@Override
	public boolean isFull() {
		return top + 1 == array.length;
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if (isFull()) {
			throw new StackOverflowException();
		}
		array[++top] = element;
	}

	@Override
	public T pop() throws StackUnderflowException {
		if (isEmpty()) {
			throw new StackUnderflowException();
		}
		T elemento = array[top];
		array[top] = null;
		top--;

		return elemento;
	}

}