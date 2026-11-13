package org.example.Descuento;

public class SinDescuento implements Descuento{
    @Override
    public double descuento() {
        return 0;
    }

    @Override
    public String tipoDescuento(){
        return "Sin descuento";
    }
}
