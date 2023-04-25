package com.mycompany.practicointegrador;

public class Equipo {
    
    String NombreEquipo;
    String Descripcion;

    public Equipo(String NombreEquipo, String Descripcion) {
        this.NombreEquipo = NombreEquipo;
        this.Descripcion = Descripcion;
    }

    public String getNombreEquipo() {
        return NombreEquipo;
    }

    public void setNombreEquipo(String NombreEquipo) {
        this.NombreEquipo = NombreEquipo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    
    
}
