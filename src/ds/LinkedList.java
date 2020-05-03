/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds;

import java.util.Iterator;

/**
 *
 * @author cisco
 */
public class LinkedList<T> implements Iterable<T> {
    private ListNode<T> head;
    private ListNode<T> tail;
    private int len;
    
    public LinkedList(){}
        
    public void add(Object pNode){
        ListNode<T> node = new ListNode(pNode);
        if(isEmpty()) {
            this.head  = node;
            this.tail =node;
            len++;
        }
        else{
            this.tail.next=node;
            this.tail = this.tail.next;
            len++;
        }
    }
    
    public boolean delete(Object pNode){
        //TODO; relacionado con remoove
        boolean delete= indexOf(pNode) == -1 ? false : true ; 
        if(indexOf(pNode)!=-1) remove(indexOf(pNode));        
        return delete;
    }
    
    public ListNode<T> get(int pIndex){
        if(pIndex<0 || pIndex >=  this.len) throw new IndexOutOfBoundsException("Posicion no valida");
        ListNode<T> node= this.head;
        for (int i = 0; i < pIndex; i++) node = node.next;
        return  node;
    }
    
    public int indexOf(Object pNode){
        // https://stackoverflow.com/questions/32656028/linkedlist-indexof-method-check
        int index = 0;
        ListNode<T> current = head;

        while (current != null) {
            if (current.equals(pNode)) {
                return index;
            }
            index++;
            current = current.next;
        }

         return -1;
    }
    
    public void insert(ListNode<T> pNode, int pIndex){
        if(pIndex<0 || pIndex >=  this.len) throw new IndexOutOfBoundsException("Posicion no valida");
        //TODO;
        ListNode<T> nodo= get(pIndex);
        ListNode<T> newNodo = pNode;
        nodo.prev=newNodo;
        newNodo.setNext(nodo);
        add(newNodo);
    }
    
    public boolean isEmpty(){
        return size() < 1 ? true : false;
    }

    @Override
    public Iterator<T> iterator() {
        //TODO:
        return new Iterator(){
            private int posNextElem=0;
            
            @Override
            public boolean hasNext(){
                return (posNextElem<len);
            }
            @Override
            public T next(){
                return (T) get(posNextElem);
            }
        };
    }
    
    public Object remove(int pIndex){
        //TODO;
        if(pIndex<0||pIndex>=this.len) throw new IndexOutOfBoundsException("Posicion no valida");
        len--;
        return this.head;
    }
    
    public int size(){
        return this.len;
    }
    
    public Object set(int pIndex, Object pNodo){
        if(pIndex<0||pIndex>=this.len) throw new IndexOutOfBoundsException("Posicion no valida" );
        ListNode nodo = get(pIndex);
        nodo.setData(pNodo);
        return nodo;
    }
    
    @Override
    public String toString() {
        if(isEmpty()) return "No hay elementos.";
        String toStr= "[ ";
        for (int i = 0; i < size(); i++) 
            toStr +=(i==0) ? "" + get(i) : ", " + get(i); 

        return toStr + " ]";
    }
    
    public class ListNode<T> {
        private  T data;
        private ListNode<T> next;
        private ListNode<T> prev;
        
         public ListNode(T pData) {
            this.data = pData;
        }
        
        public T getData(){
            return this.data;
        }
        public void setData(T pData){
            this.data= pData;
        }
        public ListNode<T> getNext(){
            return this.next;
        }
        public ListNode<T> getPrev(){
            return this.prev;
        }
        public void setNext(ListNode<T> pListNext){
            this.next=pListNext;
        }
        public void setPrev(ListNode<T> pListPrev){
            this.prev= pListPrev;
        }
        //se sobreescribe equals para usarlo en indexOf        
        @Override
        public boolean equals(Object o){
             return data.equals(o);
        }
        @Override
        public String toString() {
            return ""+ this.data;
        }        
    }
}
