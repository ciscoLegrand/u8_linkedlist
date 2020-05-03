/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds;

import java.util.Iterator;
 
/**
 * Array dinámico redimensionable
 * permite todo tipo de elemntos, incluídos <tt>null</tt>
 * El Iterator esta proporcionado por esta clase {@link #iterator() iterator}
 * @author cisco gonzalez
 * @version 1.0
 * @param <T>
 */
public class DynArray<T> implements Iterable<T>{

    /**
     * Array de objetos
     */
    private T[] elementos;

    /**
     * numero de elementos en el array
     */
    private int numeroElementos;

    /**
     * Constructor por defecto <tt>DynArray</tt>
     * se establece un tamaño inicial de 10 espacios
     */
    public DynArray() {
        elementos=(T[]) new Object[10];
    }

    /**
     * Constructor que permite indicar la capacidad inicial de <tt>DynArray<tt>
     * en caso de que se establezca un valor negativo lanza una excepcion
     * @param pTamaño indica el tamaño con el que inicializar el array
     * @throws NegativeArraySizeException si el tamaño especificado es negativo
     */
    public DynArray(int pTamaño) throws NegativeArraySizeException{ 
       if(pTamaño<1) throw new NegativeArraySizeException("Tamaño no válido: " + pTamaño);
       this.elementos= (T[]) new Object[pTamaño];
       this.numeroElementos= 0;
    }

    /**
     * Constructor que permite inicializar <tt>DynArray</tt> 
     * a partir de un array de objetos
     * @param pObj array con el que inicializar el <tt>DynArray</tt>
     */
    public DynArray(T[]  pObj){
        this.elementos= pObj;
        this.numeroElementos= pObj.length;
    }

    /**
     * Constructor que nos permite inicializar el <tt>DynArray</tt> 
     * a partir de otro objeto <tt>DynArray</tt>
     * @param pObj objeto con el que inicializar el <tt>DynArray</tt>
     */
    public DynArray(DynArray <? extends T> pObj) {
        numeroElementos = pObj.numeroElementos;
        elementos = (T[]) new Object[numeroElementos]; //Creamos el nuevo arreglo 
        for(int i = 0; i != numeroElementos; ++i) //Copiamos los elementos de la anterior lista en la nueva
        this.elementos[i] = (T) pObj.get(i);
    }

    /**
     * Devuelve la capacidad del <tt>DynArray</tt>
     * @return la capacidad del <tt>DynArray</tt>
     */
    private int getLength(){
        return this.elementos.length;
    }

    /**
     * devuelve el número de elementos contenidos en el <tt>DynArray</tt>
     * @return el numero de elementos que contiene el <tt>DynArray</tt>
     */
    public int size(){  
        return this.numeroElementos;
    }
    
    /**
     * indica si <tt>DynArray</tt> está vacío o no
     * @return <tt>true</tt> si está vacío y false si contiene algun elemento
     */
    public boolean isEmpty(){
        return size() == 0 ? true : false;
    }

    /**
     * Vacía el <tt>DynArray</tt> y vuelve a 0 el numero de elemttos
     */
    public void clear(){
           numeroElementos=0;
    }
    
    /**
     * devuelve el objeto localizado en la posición indicada del <tt>DynArray</tt>
     * @param pIndex indica la posicion que queremos buscar
     * @return el objeto localizado en la posicion indicada
     * @throws IndexOutOfBoundsException si {@code pIndex} está fuera de rango
     */
    public T get(int pIndex) throws IndexOutOfBoundsException{
        if(pIndex<0 || pIndex >=  this.numeroElementos) throw new IndexOutOfBoundsException("Posicion no valida");
        return this.elementos[pIndex];
    }
    
    /**
     * Añade al final del <tt>DynArray</tt> un elemento que indicamos como parametro
     * @param pObj elemento a añadir en la posicion siguiente del ultimo elemento <tt>DynArray</tt>
     */
    public void add(Object pObj){  
        add(size(),pObj);
    }
    
    /**
     * Añade un elemento al <tt>DynArray</tt> en la posicion indicada
     * @param pIndex indice de la posicion en la que añadir el elemento
     * @param pObj elemento a añadir 
     * @throws IndexOutOfBoundsException si {@code pIndex} está fuera de rango
     */
    public void add(int pIndex,Object pObj)throws IndexOutOfBoundsException{
        if(pIndex>0&&elementos[pIndex-1]==null) 
            throw new IndexOutOfBoundsException("No se puede insertar en la posicion " + pIndex + "porque el espacio anterior esta vacío");
        else if(pIndex<0||pIndex>size()) 
            throw new IndexOutOfBoundsException("Posicion no valida");
        else ampliarArray();      
        T[] copia = (T[]) reordenarElementos(pIndex);        
        copia[pIndex] = (T) pObj;     
        numeroElementos++;
        elementos = (T[]) copia;         
    }

    /**
     * Reemplaza el elemento en la posicion indicada con el elemento especificado
     * @param pIndex indice del elemeneto a reemplazar
     * @param pObj elemento que se almacena en la posicion indicada
     * @throws IndexOutOfBoundsException si {@code pIndex} está fuera de rango
     */
    public void set(int pIndex,Object pObj) throws IndexOutOfBoundsException{
        if(pIndex<0||pIndex>size()) throw new IndexOutOfBoundsException("Posicion no valida " + pIndex);
        this.elementos[pIndex]= (T) pObj;
    }
    
    /**
     * devuelve el elemento situado en la posición indicada y lo elimina
     * del <tt>DynArray</tt> 
     * @param pIndex indice del elemento a eliminar
     * @return el elemento que se ha eliminado
     * @throws IndexOutOfBoundsException si {@code pIndex} está fuera de rango
     */
    public T remove(int pIndex) throws IndexOutOfBoundsException​{
        if(pIndex<0||pIndex>=this.numeroElementos) throw new IndexOutOfBoundsException("Posicion no valida " + pIndex);
        Object elemento= this.elementos[pIndex];
        for(int i=pIndex; i<size()-1; i++) 
            this.elementos[i] = this.elementos[i+1]; 
        this.elementos[--this.numeroElementos]=null;
        return (T) elemento;
    }

    /**
     * Elimina el elemento del <tt>DynArray</tt> 
     * Devuelve un valor <tt>true</tt> si la operacion tiene exito y 
     * <tt>false</tt> si el elemento no se encuentra en el <tt>DynArray</tt>
     * @param pObj indica el elemento a eliminar
     * @return <tt>true</tt> si elimina el elemento 
     * <tt>false</tt> si no lo encuentra
     * @throws NullPointerException si el elemento {@code pObj} no se 
     * encuentra en el array
     */
    public boolean delete(Object pObj) throws NullPointerException{
        boolean delete= indexOf(pObj) == -1 ? false : true ; 
        if(indexOf(pObj)!=-1) remove(indexOf(pObj));        
        return delete;
    }
    
    /**
     * Devuelve la ​posición​ en la que se encuentra el elemento indicado
     * o -1 en caso de no encontrarlo
     * @param pObj indica el elemento a buscar
     * @return <tt>la posicion del elemento</tt> o <tt>-1</tt> en caso 
     * de no encontrarlo
     */
    public int indexOf(Object pObj){
        int coincidencia=-1;        
        for (int i = 0; i < size(); i++) 
            if(this.elementos[i].equals(pObj)) coincidencia=i;                
        return coincidencia;
    }
    
    /**
     * Devuelve un una representacion del objeto en forma de String.
     * el método {@code toString} devuelve generalmente un string 
     * que "textualmente representa" este objeto. el resultado debe 
     * ser conciso pero una representacon informativa facil para la persona
     * que lo lee
     * @return  un String que representa el objeto
     */
    @Override
    public String toString(){
        if(isEmpty()) return "No hay elementos.";
        String toStr= "[ ";
        for (int i = 0; i < size(); i++) 
            toStr +=(i==0) ? "" + this.elementos[i] : ", " + this.elementos[i]; 

        return toStr + " ]";
    }

    /**
     * Comprueba que no hay mas capacidad para almacenar un nuevo elemento 
     * en el <tt>DynArray</tt> e incrementa el tamaño del <tt>DynArray</tt> 
     * en un ​50%​
     * @return el <tt>DynArray</tt> ampliado en un 50%
     */
    private T[] ampliarArray(){
        if(this.elementos.length==size()) {
            T[] copia = (T[]) new Object[getLength()+(getLength()*50)/100];
            System.arraycopy(elementos, 0, copia, 0, elementos.length);
            elementos = (T[]) copia;
        }
        return elementos;
    }

    /**
     * Ordena y desplaza los elementos del <tt>DynArray</tt> para que no 
     * queden huecos y posiciones vacias.
     * @param pIndex indice de la posicion desde la que desplazar elementos
     * @return el <tt>DynArray</tt> ordenado
     */
    private Object[] reordenarElementos(int pIndex){        
        Object[] copia= this.elementos;
        if (size() < getLength()){            
            int i;            
            for (i=size(); i>pIndex; i--)
                copia[i] = this.elementos[i-1];  
        } 
        this.elementos = (T[]) copia;
        return elementos;
    }

    @Override
    public Iterator<T> iterator(){
        return new Iterator(){
            private int posNextElem=0;
            
            @Override
            public boolean hasNext(){
                return (posNextElem<numeroElementos);
            }
            @Override
            public T next(){
                return (T) elementos[posNextElem++];
            }
        };
    }
    
//    // iterator en clase    
//    class DynArrayIt implements Iterator<T>{
//        private int posNextElement=0;
//        
//        @Override
//        public boolean hasNext(){
//            return (posNextElement< numeroElementos);
//        }
//        @Override
//        public T next(){
//            return elementos[posNextElement++];
//        }
//    }
//    @Override
//    public Iterator<T> iterator() {
////        return new DynArrayIt<>(this); // para implementar con la lase DynArrayIt
//        return new DynArrayIt(); // para implementar con la clase interna DynarrayIt
//    }
    
    
    
    

}
