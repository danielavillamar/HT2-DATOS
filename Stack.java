import java.util.ArrayList;
public class Stack<E> implements iStack<E>{
	ArrayList<E> stack = new ArrayList<E>(); 
	

	@Override
	public void push(E item) {
		stack.add(item);
		// TODO Auto-generated method stub
		
	}

	@Override
	public E pop() {
		// TODO Auto-generated method stub
		E top=stack.get(stack.size()-1);
		stack.remove(stack.size()-1);

		return top;
	}

	@Override
	public E peek() {
		// TODO Auto-generated method stub
		E top=stack.get(stack.size()-1);
		return top;
	}

	@Override
	public boolean empty() {
		if (stack.size()==0) {
			return true;
		}
		else {
		return false;
		}
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		int size=stack.size();
		return size;
	}

}
