/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds;

import ds.LinkedList.ListNode;
import java.util.Iterator;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cisco
 */
public class LinkedListTest {
    
    public LinkedListTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of iterator method, of class LinkedList.
     */
    @Test
    public void testLinkedListDefault() {
        System.out.println("1-> crear linked list sin parametros " );
        LinkedList instance = new LinkedList();
        System.out.println(instance.toString());
        assertEquals(0,instance.size());
        assertTrue(instance.isEmpty());
    }
     @Test
     public void testIsEmpty(){
        LinkedList instance = new LinkedList();
        System.out.println(instance.toString());
        assertTrue(instance.isEmpty());
        instance.add(instance.new ListNode("primer nodo"));
        assertFalse(instance.isEmpty());
     }
    @Test
    public void testAaddUnElemento(){
        System.out.println("2-> añadir un elemento");
        LinkedList instance = new LinkedList();
        instance.add(instance.new ListNode("primer nodo"));
        assertFalse(instance.isEmpty());
        assertEquals(1,instance.size());
        instance.add(instance.new ListNode("segundo nodo"));
        assertEquals(2,instance.size());
    }
            
    @Test
    public void testSize(){
        System.out.println("3-> comprobar tamaño de linkedlist"); 
        LinkedList instance = new LinkedList();
        instance.add(instance.new ListNode("primer nodo"));
        assertEquals(1,instance.size());
        instance.add(instance.new ListNode("segundo nodo"));
        assertEquals(2,instance.size());
        instance.add(instance.new ListNode("tercer nodo"));
        assertEquals(3,instance.size());
    }
    @Test
    public void testIndexOf(){
        System.out.println("5-> devuelve la ​posición en la que se encuentra la cadena o -1 si no la encuentra");
        LinkedList instance = new LinkedList();
        instance.add(instance.new ListNode("primer nodo"));
        instance.add(instance.new ListNode("segundo nodo"));
        instance.add(instance.new ListNode("tercer nodo"));
        int expResult = 1;        
        assertEquals(expResult, instance.indexOf("segundo nodo"));         
        int expResult2 = -1;        
        assertEquals(expResult2, instance.indexOf("hola"));  
    }
    @Test
    public void testRemove(){
        System.out.println("6-> devuelve la cadena de la posición indicada y la elimina del array"); 
        LinkedList instance = new LinkedList();
        instance.add(instance.new ListNode("primer nodo"));
        instance.add(instance.new ListNode("segundo nodo"));
        instance.add(instance.new ListNode("tercer nodo"));
        assertEquals(3,instance.size());
        assertTrue(instance.delete("primer nodo"));
        assertEquals("segundo nodo",instance.get(0).getData());//falla, incompleto el metodo remove
        assertEquals(2,instance.size());
    }
    @Test
    public void testDelete(){
        System.out.println("4-> comprobar borrado de nodos de la lista, depende de indexOf y remove"); 
        LinkedList instance = new LinkedList();
        instance.add(instance.new ListNode("primer nodo"));
        instance.add(instance.new ListNode("segundo nodo"));
        instance.add(instance.new ListNode("tercer nodo"));
        assertEquals(3,instance.size());
        assertTrue(instance.delete("primer nodo"));
        assertEquals(2,instance.size());
    }
    @Test
    public void testGet(){
        System.out.println("7-> devuelve el nodo localizado en la posición indicada"); 
        LinkedList instance = new LinkedList();
        ListNode primerNodo = instance.new ListNode("primer nodo");
        ListNode segundoNodo = instance.new ListNode("primer nodo");
        ListNode tercerNodo = instance.new ListNode("primer nodo");
        instance.add(primerNodo);
        instance.add(segundoNodo);
        instance.add(segundoNodo);
        assertEquals(primerNodo.toString(),instance.get(0).toString());
        assertEquals(tercerNodo.toString(),instance.get(2).toString());
    }
    @Test (expected = java.lang.IndexOutOfBoundsException.class)
    public void testGetException(){
        System.out.println("8-> lanza excepcion con get"); 
        LinkedList instance = new LinkedList();
         instance.add(instance.new ListNode("primer nodo"));
        instance.get(4);
    }
    @Test 
    public void testInsert(){
        System.out.println("9-> inserta un nuevo nodo en la posicion indicada"); 
        LinkedList instance = new LinkedList();
        ListNode nuevaEntrada = instance.new ListNode("nueva entrada");
        instance.add(instance.new ListNode("primer nodo"));
        instance.add(instance.new ListNode("segundo nodo"));
        instance.add(instance.new ListNode("tercer nodo"));
        System.out.println("after add 3 el: "+instance.size());//borrar prueba
        instance.insert(nuevaEntrada, 1);
        System.out.println("after insert pos 1 newEl: "+instance.size());//borrar prueba
        assertEquals(4,instance.size());
        assertEquals(nuevaEntrada.toString(), instance.get(1).toString()); //falla, no ingresa la nueva entrada
    }
    @Test (expected = java.lang.IndexOutOfBoundsException.class)
    public void testInsertException(){
        System.out.println("10-> lanza excepcion con insert"); 
        LinkedList instance = new LinkedList(); 
        ListNode nuevaEntrada = instance.new ListNode("nueva entrada");
        instance.insert(nuevaEntrada, -1);
    }
    @Test 
    public void testSet(){
        System.out.println("12-> lanza excepcion con set");
        LinkedList instance = new LinkedList();        
        instance.add(instance.new ListNode("primer nodo"));
        instance.add(instance.new ListNode("segundo nodo"));
        instance.add(instance.new ListNode("tercer nodo"));
        instance.set(0, "nueva entrada");
        assertEquals("nueva entrada",instance.get(0).toString());
    }
    @Test (expected = java.lang.IndexOutOfBoundsException.class)
    public void testSetException(){
        System.out.println("12-> lanza excepcion con set");
        LinkedList instance = new LinkedList();
        instance.set(1,"hola");
    }
}
