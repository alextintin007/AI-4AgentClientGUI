package contenidoSerializado;

import java.io.Serializable;

public class Cliente implements Serializable{
    public String nombre, apellido, direccion, telefono, correo, ciudad, pais;
    private int ID, edad, idVendedor, zipcode, plazo;
    private double monto;

    public Cliente(String nombre, String apellido, String direccion, String telefono, String correo, String ciudad, String pais, int ID, int edad, int idVendedor, int zipcode, int plazo, double monto) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.ciudad = ciudad;
        this.pais = pais;
        this.ID = ID;
        this.edad = edad;
        this.idVendedor = idVendedor;
        this.zipcode = zipcode;
        this.plazo = plazo;
        this.monto = monto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public int getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "Cliente:\n" +
                "Nombre= " + nombre +
                ", Apellido=" + apellido +
                ", Direccion=" + direccion +
                ", Telefono=" + telefono +
                "\nCorreo=" + correo +
                ", Ciudad=" + ciudad +
                ", Pais= " + pais +
                "\nID=" + ID +
                ", Edad=" + edad +
                ", IdVendedor=" + idVendedor +
                ", Zipcode=" + zipcode +
                ", Plazo=" + plazo +
                "\nMonto=" + monto;
    }
}
