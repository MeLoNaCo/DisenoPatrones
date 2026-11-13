package org.example.Descuento;

public class Cupon implements Descuento{
    @Override
    public double descuento(){
        return 0.3;
    }

    @Override
    public String tipoDescuento(){
        return "Cupon";
    }
}
