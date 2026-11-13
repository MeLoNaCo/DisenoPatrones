package org.example.Clases;

public class Producto implements Cloneable{
    private int id;
    private String nombre;
    private Categoria categoria;
    private double precio;


    public Producto(int id, String nombre, Categoria categoria, double precio){
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
    }

    @Override
    public Producto clone(){
        try{
            return (Producto) super.clone();//clonacion supericial
        }catch(CloneNotSupportedException e){
            throw new RuntimeException(e);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria.name();
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
