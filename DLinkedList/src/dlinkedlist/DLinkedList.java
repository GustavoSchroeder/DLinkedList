package dlinkedlist;

/**
 *
 * @author gschroeder
 * @param <E>
 */
public class DLinkedList<E> {

    protected int numElements; //numero de elementos
    protected DNode<E> head; //cabeca da lista
    protected DNode<E> tail; // rabo da lista
    protected DNode<E> iterador;

    public DLinkedList() {
        numElements = 0;
        head = tail = iterador = null;
    }

    public boolean isEmpty() {
        if (numElements == 0) {
            return true;
        }
        return false;
    }

    public int numElements() {
        return numElements;
    }

    public DNode<E> getFirst() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException();
        }
        return head;
    }

    public DNode<E> getLast() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException();
        }
        return tail;
    }

    public void insertFirst(E element) {
        DNode<E> nodo = new DNode<E>(element);
        if (isEmpty()) {
            head = tail = nodo;
        } else {
            head.setPrevious(nodo);
            nodo.setNext(head);
            head = nodo;
        }
        numElements++;
    }

    public void insertLast(E element) {
        DNode<E> nodo = new DNode<E>(element);
        if (isEmpty()) {
            head = tail = nodo;
        } else {
            tail.setNext(nodo);
            nodo.setPrevious(tail);
            tail = nodo;
        }
        numElements++;
    }

    public void insertAnyPos(E element, int pos) {

        if (head == null) {
            insertFirst(element);
        } else {
            DNode<E> anterior = getNode(pos - 1);
            DNode<E> proxima = getNode(pos + 1);
            DNode<E> novoNode = new DNode<E>(element);
            novoNode.setNext(proxima);
            novoNode.setPrevious(anterior);
            anterior.setNext(novoNode);
            proxima.setPrevious(novoNode);
        }
        numElements++;
    }

    public E removeFirst() throws UnderflowException {
        E element = head.getElement();
        if (isEmpty()) {
            throw new UnderflowException();
        } else if (head == tail) {
            head = tail = null;
        } else {
            head = head.getNext();
            head.setPrevious(null);
        }
        numElements--;
        return element;
    }

    public E removeLast() throws UnderflowException {
        E element = tail.getElement();
        if (isEmpty()) {
            throw new UnderflowException();
        } else if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.getPrevious();
            tail.setNext(null);
        }
        numElements--;
        return element;
    }

    public E removeAnyPos(int pos) throws UnderflowException {
        E elementRemoved = getNode(pos).getElement();
        if (isEmpty()) {
            throw new UnderflowException();
        } else if (head == tail) {
            head = tail = null;
        } else {
            DNode<E> anterior = getNode(pos - 1);
            DNode<E> proximo = getNode(pos + 1);
            anterior.setNext(proximo);
            proximo.setPrevious(anterior);
        }
        numElements--;
        return elementRemoved;
    }

    public DNode<E> find(E element) {
        DNode<E> current = head;
        while (element != current.getElement()) {
            if (current.getNext() != null) {
                current = current.getNext();
            } else {
                return null;
            }
        }
        return current;
    }

    public void merge(DLinkedList<E> list, int n) {
        //concatena uma lista sobre a lista corrente
        for (int i = 0; i < list.numElements(); i++) {
            insertLast(list.getNode(i).getElement());
        }
    }

    public DNode<E> next() {
        if (iterador == null) {
            iterador = head;
        } else if (iterador.getNext() == null) {
            iterador = head;
        } else {
            iterador = iterador.getNext();
        }
        return iterador.getNext();
    }

    public void revert() throws Exception {
        DLinkedList<E> list = new DLinkedList<E>();
        int aux = numElements;
        while (head != null) {
            list.insertFirst(removeLast());
        }
        System.out.println(list.numElements());
        for (int i = 0; i < aux; i++) {
            insertFirst(list.removeFirst());
        }
    }

    public int findKey(E key) throws Exception {
        DNode<E> current = head;
        int cont = 0;
        while (current != null) {
            if (current.getElement() == key) {
                return cont;
            }
            current = current.getNext();
            cont++;
        }
        throw new Exception("Chave nao foi encontrada!");
    }

    public String toString() {
        String str = "\nExibindo a lista: ";
        DNode<E> current = head;
        while (current != null) {
            str += current.getElement() + " - ";
            current = current.getNext();
        }
        return str;
    }

    public DNode<E> getNode(int pos) {
        DNode<E> current = head;
        for (int i = 0; i < pos; i++) {
            current = current.getNext();
        }
        return current;
    }
}
