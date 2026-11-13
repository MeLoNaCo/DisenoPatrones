package org.example.Descuento;

public class PrimeraCompra implements Descuento{

    @Override
    public double descuento(){
        return 0.2;
    }

    @Override
    public String tipoDescuento(){
        return "Primera compra";
    }
}
