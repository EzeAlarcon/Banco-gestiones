/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import atencionbancoprevio.Banco;
import java.util.LinkedList;
import atencionbancoprevio.Caja;
import atencionbancoprevio.Cliente;
import java.util.Collections;
import java.util.PriorityQueue;
/**
 *
 * @author Cristian
 */
public class prueba {
    
    public static void main(String[] args) {
        
            PriorityQueue<Cliente> p = new PriorityQueue();
            
            p.add(new Cliente(22323,23,"Cris"));
            p.add(new Cliente(22323,66,"Pepe"));
            p.add(new Cliente(22323,64,"Jjuan"));
            p.add(new Cliente(22323,24,"Jose"));
            
            while(!p.isEmpty()) {
                Cliente c = p.poll();
                System.out.println(""+c.getTipoTransaccion()+"-->");
        }
        
        
//        Banco b = new Banco();
//        
//        b.agregarCaja(2,"Retiro",200000);
//        b.agregarCaja(3,"Pago Servicio",200300);
//        b.agregarCaja(4,"Retiro",200000);
//        b.agregarCaja(1,"Retiro",200000);
//        
//        b.agregarCliente(1, 23, "Retiro");
//        b.agregarCliente(3, 25, "Retiro");
//        b.agregarCliente(4, 26, "Retiro");
//        b.agregarCliente(2, 45, "Pago Servicio");
//        
//        b.despacharCliente(4, 200000);
//        
//        System.out.println(b.generarReporte());
        
        
        
//
//        for (Caja c : cajas) {
//            System.out.println("Tiempo "+c.getTiempoEspera());
//        }
//        
//        Collections.sort(cajas);
//        System.out.println("despues \n");
//        for (Caja c : cajas) {
//            System.out.println("Tiempo "+c.getTiempoEspera());
//        }
//        
//        System.out.println("el menor es "+cajas.getFirst().getTiempoEspera());
        
    }
    
}
