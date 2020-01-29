
public interface iStack<E> {
	public void push(E item);
	//Se agrega un elemento al stack o pila
	public E pop();
	//Toma y borra el elemento on the top of the stack, o el de hasta arriba
	public E peek();
	//Toma el elemento de hasta arriba
	
	public boolean empty();
	//Un boolean que te dice si esta o no esta vacio
	public int size();
	//Devuelve un int con el tamanio de la lista.

}
