package edu.escuelaing.arem.ASE.app;

/**
 * @author Nicolas Cardenas
 * @version 1.0V
 */
public class LinkedList {
    private Item first;
    private Item last;

    /**
     * @author Nicolas Cardenas
     * @version 1.0V
     */
    private class Item {
        
        private Double value;
        private Item next;
        
        /**
         * 
         * @param value valor con el cual se crea el item
         */
        private Item (Double value) {
            this.value = value;
        }
        
        /**
         * 
         * @return retorna la referencia del siguiente item
         */
        private Item getNext() {
            return this.next;
        }

        /**
         * 
         * @param item la referencia del siguiente item
         */
        private void setNext(Item item) {
            this.next = item;
        }

        /**
         * @return Double valor del Item
         */
        private Double getValue() {
            return value;
        }

        /**
         * 
         * @param value asignacion del valor a un item
         */
        private void setValue(Double value) {
            this.value = value;
        }
    }
    
    /**
     * Constructor de LinkedList
     */
    public LinkedList(){
        this.first = this.last = new Item(0.0);
    }

    /**
     * retorna el valor en la primera posicion de la lista
     * @return Double valor en la lista
     */
    public Double getFirst() {
        return first.getValue();
    }

    /**
     * cambia el primer valor de la lista
     * @param value valor a insertar
     */
    public void setFirst(Double value) {
        this.first = new Item(value);
    }

    /**
     * retorna el valor en la ultima posicion de la lista
     * @return Double valor en la lista
     */
    public Double getLast() {
        return last.getValue();
    }

    /**
     * cambia el ultimo valor de la lista
     * @param value valor a inserta
     */
    public void setLast(Double value) {
        this.last = new Item(value);
    }

    /**
     * retorna el siguiete elemento de la lista
     * @return Item elemento de la lista
     */
    public Item next(){
        return this.first.getNext();
    }

    /**
     * agrega un elemento a la lista en la ultima posicion
     * @param value valor a insertar
     */
    public void add(Double value){
        Item item = new Item(value);
        this.last.setNext(item);
        this.last = item;
    }

    /**
     * remueve el ultimo valor de la lista
     */
    public void remove() {
        Item newFirst = this.first.getNext();
        this.first = newFirst;
    }

    /**
     * retorna el valos de la media de la lista
     * @return valor de la media
     */
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

    /**
     * retorna el valor de la desviacion estandar de la lista
     * @return desviacion estandar
     */
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
