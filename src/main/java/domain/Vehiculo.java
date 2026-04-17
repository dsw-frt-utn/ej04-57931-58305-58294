package domain;

public abstract class Vehiculo {
    protected String patente;
    protected Marca marca;
    protected String modelo;
    protected int anio;
    protected double capacidadCarga;
    protected Sucursal sucursal;
    private VehiculoTipo tipo;
    private double km;

    public Vehiculo(VehiculoTipo tipo, String patente, Marca marca, String modelo, int anio, double capacidadCarga, Sucursal sucursal,double km) {
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.capacidadCarga = capacidadCarga;
        this.sucursal = sucursal;
        this.tipo = tipo;
        this.km = km;
    }

    public String getPatente() {
        return patente;
    }
    
    public VehiculoTipo getTipo(){
        return tipo;
    }
    
    public double getCapacidadCarga(){
        return capacidadCarga;
    }
    
    public int getAnio(){
        return anio;
    }
    
    public String getCodigoSucursal(){
        return sucursal.getCodigo();
    }
    
    public double calcularConsumo(double kilometros) {
        return 0;
    }

    public boolean esDe(VehiculoTipo tipo){
        return this.tipo == tipo;
    }
    
    
    
    
    @Override
    public String toString() {
        return  marca.getNombre() +" "+ modelo ;
    }

    public double getKm() {
        return km;
    }

    public void setKm(double km) {
        this.km = km;
    }
}
