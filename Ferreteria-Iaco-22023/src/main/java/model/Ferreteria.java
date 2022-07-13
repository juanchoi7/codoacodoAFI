package model;

public class Ferreteria {
    private int idtornillo;
    private String codigoSku;
    private String descripcion;
    private int pesoUnidad;
    private double precio;
    private int stock;

    public Ferreteria(int idtornillo, String codigoSku, String descripcion, int pesoUnidad, double precio, int stock) {
        this.idtornillo = idtornillo;
        this.codigoSku = codigoSku;
        this.descripcion = descripcion;
        this.pesoUnidad = pesoUnidad;
        this.precio = precio;
        this.stock = stock;
    }

    public Ferreteria(String codigoSku, String descripcion, int pesoUnidad, double precio, int stock) {
        this.codigoSku = codigoSku;
        this.descripcion = descripcion;
        this.pesoUnidad = pesoUnidad;
        this.precio = precio;
        this.stock = stock;
    }

    public int getIdtornillo() {
        return idtornillo;
    }

    public void setIdtornillo(int idtornillo) {
        this.idtornillo = idtornillo;
    }

    public String getCodigoSku() {
        return codigoSku;
    }

    public void setCodigoSku(String codigoSku) {
        this.codigoSku = codigoSku;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPesoUnidad() {
        return pesoUnidad;
    }

    public void setPesoUnidad(int pesoUnidad) {
        this.pesoUnidad = pesoUnidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Tornillo{" + "idtornillo=" + idtornillo + ", codigoSku=" + codigoSku + ", descripcion=" + descripcion + ", pesoUnidad=" + pesoUnidad + ", precio=" + precio + ", stock=" + stock + '}';
    }
}
