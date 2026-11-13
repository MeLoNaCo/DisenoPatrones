package org.example.Clases;

import org.example.CanalVenta.CanalVenta;
import org.example.Descuento.Descuento;
import org.example.Pago.MetodoPago;

import java.util.List;

public class Pedido {
    private int id;
    private Cliente cliente;
    private List<DetallePedido> detallePedido;
    private CanalVenta canalVenta;
    private Descuento descuento;
    private MetodoPago metodoPago;

    public Pedido(int id, Cliente cliente, List<DetallePedido> detallePedido, CanalVenta canalVenta, Descuento descuento, MetodoPago metodoPago){
        this.id = id;
        this.cliente = cliente;
        this.detallePedido = detallePedido;
        this.canalVenta = canalVenta;
        this.descuento = descuento;
        this.metodoPago = metodoPago;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<DetallePedido> getDetallePedido() {
        return detallePedido;
    }

    public void setDetallePedido(List<DetallePedido> detallePedido) {
        this.detallePedido = detallePedido;
    }

    public CanalVenta getCanalVenta() {
        return canalVenta;
    }

    public void setCanalVenta(CanalVenta canalVenta) {
        this.canalVenta = canalVenta;
    }

    public Descuento getDescuento() {
        return descuento;
    }

    public void setDescuento(Descuento descuento) {
        this.descuento = descuento;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id: " + getId() +
                ", cliente: " + cliente.getNombre()+
                ", detallePedido: " + getDetallePedido()+
                ", canalVenta: " + canalVenta.canal() +
                ", descuento: " + descuento.tipoDescuento() +
                ", metodoPago: " + metodoPago.metodo() +
                '}';
    }
}
