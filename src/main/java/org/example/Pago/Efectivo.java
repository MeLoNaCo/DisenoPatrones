package org.example.Pago;

public class Efectivo implements MetodoPago{
    @Override
    public String metodo(){
        return "Efectivo";
    }
}
