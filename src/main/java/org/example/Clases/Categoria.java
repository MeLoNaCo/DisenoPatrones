package org.example.Clases;

public enum Categoria {
    ACOMPANAMIENTO,
    BEBIDA,
    POSTRE,
    POLLO,
    HAMBURGUESA;

    @Override
    public String toString() {
        return switch (this) {
            case ACOMPANAMIENTO -> "Acompañamiento";
            case BEBIDA -> "Bebida";
            case POSTRE -> "Postre";
            case POLLO -> "Pollo";
            case HAMBURGUESA -> "Hamburguesa";
        };
    }
}