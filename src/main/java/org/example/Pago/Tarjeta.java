package org.example.Pago;

public class Tarjeta implements MetodoPago{
    @Override
    public String metodo(){
        return "Tarjeta";
    }
}
