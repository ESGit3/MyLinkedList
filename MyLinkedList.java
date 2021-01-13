public class MyLinkedList {
    private int size;
    private Node start, end;
    public MyLinkedList() {
        size = 0;
        start = null;
        end = null;
    }
    public int size() {
        return size;
    };

    public boolean add(String value) {
        Node temp = new Node(value);
        if (size == 0) {
            start = temp;
            end = temp;
            size++;
        } else {
            end.setNext(temp);
            Node initialEnd = end;
            end = temp;
            end.setNext(null);
            end.setPrev(initialEnd);
            size++;
        }
        return true;
    };

    public void add(int index, String value) {
        Node temp = new Node(value);
        if (size == 0) {
            start = temp;
            end = temp;
            size++;
        } else if (index == 0) {
            start.setPrev(temp);
            Node initialStart = start;
            start = temp;
            start.setNext(initialStart);
        } else if (index == size) {
            this.add(value);
        } else {
            Node currNode = start;
            for (int i = 0; i < index; i++) {
                currNode = currNode.getNext();
            }

            Node prevNode = start;
            for (int i = 0; i < index - 1; i++) {
                prevNode = prevNode.getNext();
            }

            currNode.setPrev(temp);
            temp.setNext(currNode);
            temp.setPrev(prevNode);
            prevNode.setNext(temp);
        }
    };

    public String get(int index) {
        Node currNode = this.start;
        for (int i = 0; i < index; i++) {
            currNode = currNode.getNext();
        }
        return currNode.getData();
    };

    public String set(int index, String value) {
        Node currNode = this.start;
        for (int i = 0; i < index; i++) {
            currNode = currNode.getNext();
        }
        currNode.setData(value);
    };

    public String toString() {
        if (this.size == 0) {
            return "[]";
        }
        String temp = "[";
        Node currNode = this.start;
        temp += currNode.getData() + ", ";
        for (int i = 0; i < this.size; i++) {
            temp += currNode.getNext().getData() + ", ";
        }
        temp = temp.substring(0, temp.length() - 2) + "]";
        return temp;
    };
    //Any helper method that returns a Node object MUST BE PRIVATE!
}