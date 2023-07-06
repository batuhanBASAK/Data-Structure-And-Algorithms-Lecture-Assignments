import java.util.AbstractList;

public class LDLinkedList<E> extends AbstractList<E>{
    /** The reference node to head of the list. */
    private Node<E> head = null;

    /** The removal node that waiting to remove from list. */
    private Node<E> removalNode = null;

    /** The preceding node of the removal node */
    private Node<E> precedeOfRemovalNode = null;

    /** The size of the list. */
    private int size = 0;

    /**
     * Abstraction for Node in list.
     */
    private static class Node<E>{
        /** The data of node */
        private E data;
        /** The reference to the next node */
        private Node<E> next;

        /**
         * Constructor class
         * @param item The data to store.
         */
        private Node(E item){
            data = item;
            next = null;
        }

        /**
         * Constructor class
         * @param item The data to store.
         * @param nextNode The reference to the next node.
         */
        private Node(E item, Node<E> nextNode){
            data = item;
            next = nextNode;
        }
    }

    @Override
    public int size() {
        return size;
    }


    @Override
    public E get(int index) {
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException(String.valueOf(index));
        }
        Node<E> node = getNode(index);
        return node.data;
    }


    @Override
    public E set(int index, E element) {
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException(String.valueOf(index));
        }
        Node<E> node = getNode(index);
        E oldData = node.data;
        node.data = element;
        return oldData;
    }



    @Override
    public void add(int index, E element){
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException(String.valueOf(index));
        }
        if (index == 0){
            addFirst(element);
        } else {
            Node<E> node = getNode(index - 1);
            addAfter(node, element);
        }
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(String.valueOf(index));
        }
        if (removalNode == null) {
            if (index == 0) { 
                precedeOfRemovalNode = null;
                removalNode = head;
            } else {
                precedeOfRemovalNode =  getNode(index - 1);
                removalNode = precedeOfRemovalNode.next;
            }
            return removalNode.data;
        } else if (removalNode == getNode(index)) {
            // user tries to delete an item has already marked for deletion.
            // Exit function.
            return removalNode.data;
        } else {
            if (index == 0){
                removeRemoval();
                return removeFirst();
            } else {
                // The removal node may left side of the second removal node on 
                // list. Thus this could cause deleting wrong node, following node of
                // second removal node. Therefore LDLinkedList get node reference node
                // of the second removal node first, then remove the removal node.
                Node<E> node = getNode(index - 1);
                removeRemoval();
                return removeAfter(node);
            }
        }
    }




    
    /**
     * Finds the node at the position index.
     * @param index The position of node.
     * @return The node at position index.
     */
    private Node<E> getNode(int index){
        Node<E> node = head;
        for (int i = 0; i < index; i++){
            node = node.next;
        }
        return node;
    }


    /**
     * Adds new data to the front of the list.
     * @param item The new data to add.
     */
    public void addFirst(E item){
        head = new Node<E>(item, head);
        size++;
    }


    /**
     * Adds a new item after a node given.
     * @param node The preceding node.
     * @param item The data to add.
     */
    private void addAfter(Node<E> node, E item){
        node.next = new Node<E>(item, node.next);
        size++;
    }


    /**
     * Removes the removal node from list.
     */
    private void removeRemoval(){
        if (precedeOfRemovalNode == null){
            // The removal node is head pointer.
            head = head.next;
        } else {
            precedeOfRemovalNode.next = removalNode.next;
        }
        size--;
        precedeOfRemovalNode = null;
        removalNode = null;
    }


    /**
     * Removes the front node from list.
     * @return The data of the front data.
     */
    public E removeFirst(){
        Node<E> temp = head;
        head = temp.next;
        size--;
        return temp.data;
    }

    /**
     * Removes a data at position after a node given.
     * @param node The preceding node.
     * @return The removed data.
     */
    private E removeAfter(Node<E> node){
        Node<E> temp = node.next;
        node.next = temp.next;
        size--;
        return temp.data;
    }

    /**
     * Getter method for removal data.
     * @return The removal data.
     */
    public E getRemoval() {
        if (removalNode != null){
            return removalNode.data;
        } else {
            return null;
        }
        
    }

}