package sample;
import java.util.Iterator;


class SortedList<E extends Comparable<? super E>> extends List<E> {

    public void insert(E data) {
        //calls the recursive version of the function

        Node<E> temp = new Node<E>(data);


        if (head == null || data.compareTo(head.data) < 0) {
            //if list is empty then add the data to the first position of the list
            temp.next = head;
            head = temp;
        }
        else {
            //call recursive insertion function
            recursiveInsert(temp, head);
        }
    }
    private void recursiveInsert(Node<E> temp, Node<E> curr){
        //recursive solution to insertion
        //if next element is not empty continue
        if (curr.next != null){
            //if data is smaller than the next item then insert here
            if (temp.data.compareTo(curr.next.data) < 0){
                //insert data
                temp.next = curr.next;
                curr.next = temp;
            }
            //else search next item
            else{
                recursiveInsert(temp,curr.next);
            }
        }
        //if next element in the list is empty append the data there
        else{
            curr.next = temp;
        }

    }

    public Iterator<E> iterator() {
        //From the Iterator used on the iterative sorted list on professor's website
        return new Iterator<E>() {
            public boolean hasNext() {
                return curr != null;
            }

            public E next() {
                E temp = curr.data;
                curr = curr.next;
                return temp;
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }

            private Node<E> curr = (Node<E>) head;
        };
    }

    public void remove(E data) {

        //calls the recursive version of the function
        if (head != null) {
            if (data.compareTo(head.data) == 0) {
                head = head.next;
            }
            else {
                recursiveRemove(data,head);
            }
        }
    }
    private Node recursiveRemove(E data,Node<E> head){
        //recursively remove item
        if (head.next != null){ // check if list is empty
            Node<E> curr = head;

            if(data.compareTo(curr.next.data)== 0){
                //if the next element is what you're searching for
                curr.next = curr.next.next; //remove it from the list
            }
            else{
                //else try the next item
                return recursiveRemove(data, curr.next);
            }
        }
        return null;
    }



    public E retrieve(int index) {
        //calls the recursive version of the function

        return recursiveRetrieve(head,index,0);
    }
    private E recursiveRetrieve(Node<E> curr, int index, int count){
        //recursively retrieves data
        if (count == index){
            //base case -> if this is the item at the index return it
            //System.out.println("Object at index " + index + " is " + curr.data);
            return curr.data;
        }
        if(curr.next != null){
            //search next item in list
            //increment count
            count ++;
            return recursiveRetrieve(curr.next,index,count);
        }
        else{
            //in case index is out
            throw new IndexOutOfBoundsException();
        }
    }
    public boolean search(E data) {
        //calls the recursive version of the function
        return recursiveSearch(data,head);

    }
    private boolean recursiveSearch(E data, Node<E> curr){
        //recursively linear searches data
        if(curr != null) {
            if (data.compareTo(curr.data) == 0) {
                //base case - if this is the item then return true
                //System.out.println("Object " + data + " is in the list");
                return true;
            }
            if (curr.next != null) {
                //else search next item
                return recursiveSearch(data, curr.next);
            }
        }
        else{
            //if not in list return false
            return false;
        }
        return false;
    }
}
