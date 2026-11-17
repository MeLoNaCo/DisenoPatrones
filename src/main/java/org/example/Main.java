package org.example;

import org.example.CanalVenta.CanalVenta;
import org.example.CanalVenta.Delivery;
import org.example.CanalVenta.Local;
import org.example.Clases.*;
import org.example.Descuento.Descuento;
import org.example.Descuento.PrimeraCompra;
import org.example.Descuento.SinDescuento;
import org.example.Pago.CalculadoraPago;
import org.example.Pago.Efectivo;
import org.example.Pago.MetodoPago;
import org.example.Pago.Yape;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        CanalVenta local = new Local();
        CanalVenta delivery = new Delivery();

        Descuento primeraCompra = new PrimeraCompra();
        Descuento sinDescuento = new SinDescuento();

        MetodoPago yape = new Yape();
        MetodoPago efectivo = new Efectivo();

        CalculadoraPago calc = new CalculadoraPago();

        Cliente c1 = new Cliente("Jose Julian", 1, "123456789");

        Producto papasFritasPersonales = new Producto(1, "Papas fritas personales", Categoria.ACOMPANAMIENTO,10.00);
        //Clonar papas fritas para diferentes tamaños
        Producto papasFritasMedianas = papasFritasPersonales.clone();
        papasFritasMedianas.setId(2);
        papasFritasMedianas.setNombre("Papas fritas medianas");
        papasFritasMedianas.setPrecio(15.00);

        Producto papasFritasGrandes = papasFritasPersonales.clone();
        papasFritasPersonales.setId(3);
        papasFritasGrandes.setNombre("Papas fritas grandes");
        papasFritasGrandes.setPrecio(20.00);

        Producto gaseosa = new Producto(6, "Gaseosa", Categoria.BEBIDA, 4);

        List<DetallePedido> detalle = new ArrayList<>();
        detalle.add( new DetallePedido(papasFritasPersonales, 3));
        detalle.add( new DetallePedido(papasFritasMedianas, 1));
        detalle.add( new DetallePedido(papasFritasGrandes, 1));
        detalle.add( new DetallePedido(gaseosa,6));

        Pedido p1 = new Pedido(1,c1,detalle, local, primeraCompra, efectivo);
        Pedido p2 = new Pedido(1,c1,detalle, delivery, sinDescuento, yape);
        Pedido p3 = new Pedido(1,c1,detalle, delivery, primeraCompra, yape);

        System.out.println(p1);
        System.out.println("Pago: "+calc.calcularFinal(p1));
    }
}