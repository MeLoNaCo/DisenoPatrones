package org.example.Descuento;

public class Estudiante implements Descuento{
    @Override
    public double descuento(){
        return 0.1;
    }

    @Override
    public String tipoDescuento(){
        return "Cupon";
    }
}
