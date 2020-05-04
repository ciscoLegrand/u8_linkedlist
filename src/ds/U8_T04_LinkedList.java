/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds;

/**
 *
 * @author cisco
 */
public class U8_T04_LinkedList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        LinkedList<String> instance = new LinkedList();
        instance.add("primer nodo");
        instance.add("segundo nodo");
        instance.add("tercer nodo");
        instance.add("cuarto nodo");
        instance.add("quinto nodo");
        instance.add("sexto nodo");
//        System.out.println(instance.toString());
//        instance.set(0, "1");
//        instance.set(3, "4");
//        System.out.println(instance.toString());
//        System.out.println("elementos: " + instance.size());
//        System.out.println("get 3: " + instance.get(3) + "\nremove el valor de la pos 3 : ");
//        instance.remove(3);
//        System.out.println("get 3: " + instance.get(3));
//        System.out.println("get 0: " + instance.get(0));
//        instance.delete("1");
//        System.out.println("eliminamos el valor 1: " + instance.get(0) + " tamaño " + instance.size());
////        System.out.println(instance.toString());
        int cont=0;
        for(String s : instance){
            ++cont;
            System.out.println(""+cont +" "+s);
        }
        System.out.println("###############################");
        test1();
    }

    public static void test1() {
        LinkedList<String> l1 = new LinkedList<>();
        System.out.println("l1[" + l1.size() + "]: " + l1);
        System.out.println("Añadimos elementos:");
        l1.add("hi");
        l1.add("bye");
        System.out.println("l1[" + l1.size() + "]: " + l1);
        System.out.println("Recorremos con for-each:");
        for (String s : l1) {
            System.out.println(s);
        }
        System.out.println("Nueva lista:");
        LinkedList<Integer> l2 = new LinkedList<Integer>();
        l2.add(3);
        l2.add(-5);
        l2.add(8);
        System.out.println("l2[" + l2.size() + "]: " + l2);
//        System.out.println("Añadimos 4 en la posición 2");
//        l2.add(2, 4);
        System.out.println("l2[" + l2.size() + "]: " + l2);
        System.out.println("Eliminamos el valor de la posición 1");
        l2.remove(1);
        System.out.println("l2[" + l2.size() + "]: " + l2);
        System.out.println("Eliminamos el valor 4");
        l2.delete(4);
        System.out.println("l2[" + l2.size() + "]: " + l2);
        System.out.println("Cambiamos el segundo elemento");
        l2.set(1, 99);
        System.out.println("l2[" + l2.size() + "]: " + l2);
        System.out.println("Generamos excepción");
        try {
            l2.set(100, 0);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
