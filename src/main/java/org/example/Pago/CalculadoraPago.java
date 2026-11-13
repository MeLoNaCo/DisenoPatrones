package org.example.Pago;

import org.example.Clases.DetallePedido;
import org.example.Clases.Pedido;


public class CalculadoraPago {

    public double calcularTotal(Pedido pedido){
        double total = 0;
        for(DetallePedido detalle: pedido.getDetallePedido()){
            total+= detalle.getProducto().getPrecio() * detalle.getCantidad();
        }
        return total;
    }

    public double calcularFinal(Pedido pedido){
        double total= calcularTotal(pedido);
        double descuento = pedido.getDescuento().descuento();
        double precioFinal = total - (total*descuento);

        return precioFinal;
    }
}
