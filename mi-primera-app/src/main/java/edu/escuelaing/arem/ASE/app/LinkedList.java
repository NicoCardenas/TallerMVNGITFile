package edu.escuelaing.arem.ASE.app;

public class LinkedList {
    private Item first;
    private Item last;

    private class Item {
        
        private Double value;
        private Item next;
        
        private Item (Double value) {
            this.value = value;
        }
        
        private Item getNext() {
            return this.next;
        }

        private void setNext(Item item) {
            this.next = item;
        }

        private Double getValue() {
            return value;
        }

        private void setValue(Double value) {
            this.value = value;
        }
    }
    
    public LinkedList(){
        this.first = this.last = new Item(0.0);
    }

    public Item getFirst() {
        return first;
    }

    public void setFirst(Item first) {
        this.first = first;
    }

    public Item getLast() {
        return last;
    }

    public void setLast(Item last) {
        this.last = last;
    }

    public Item next(){
        return this.first.getNext();
    }

    public void add(Item item){
        this.last.setNext(item);
        this.last = item;
    }

    public void remove() {
        Item newFirst = this.first.getNext();
        this.first = newFirst;
    }

    public Double mean() {
        int n = 0;
        Double sum = 0.0;
        Item temp = this.first;
        while (temp != null) {
            sum += temp.getValue();
            n +=1;
            temp = temp.getNext();
        }
        Double res = (sum/n);
        return res;
    }

    public Double  standardDeviation() {
        Double Xavg = mean();
        int n = 0;
        Item temp = this.first;
        Double sum = 0.0;
        while (temp != null) {
            sum +=  Math.pow(( temp.getValue() - Xavg), 2);
            n += 1;
            temp = temp.getNext();
        }
        Double res = Math.sqrt(sum / (n - 1) );
        return res;
    }
}
