package com.mycompany.practicointegrador;

public class Partido {
  
int Ronda;  
int ID_partido;
Equipo Equipo1;
Equipo Equipo2;
int golEquipo1;
int golEquipo2;

    public Partido(String[] Partido){ 
        this.ID_partido = Integer.parseInt(Partido[5]);
        this.Ronda = Integer.parseInt(Partido[0]);
        this.Equipo1 = new Equipo(Partido[1],"");
        this.Equipo2 = new Equipo(Partido[4],"");
        this.golEquipo1 = Integer.parseInt(Partido[2]);
        this.golEquipo2 = Integer.parseInt(Partido[3]);
    }

    public Equipo getEquipo1() {
        return Equipo1;
    }

    public void setEquipo1(Equipo Equipo1) {
        this.Equipo1 = Equipo1;
    }

    public Equipo getEquipo2() {
        return Equipo2;
    }

    public void setEquipo2(Equipo Equipo2) {
        this.Equipo2 = Equipo2;
    }

    public int getGolEquipo1() {
        return golEquipo1;
    }

    public void setGolEquipo1(int golEquipo1) {
        this.golEquipo1 = golEquipo1;
    }

    public int getGolEquipo2() {
        return golEquipo2;
    }

    public void setGolEquipo2(int golEquipo2) {
        this.golEquipo2 = golEquipo2;
    }
    
    public ResultadoEnum resultadoLocal(){
        ResultadoEnum resultado;
        if(golEquipo1 > golEquipo2){
            resultado = ResultadoEnum.Ganador;
        }else if (golEquipo1 == golEquipo2){
            resultado = ResultadoEnum.Empate;
        }
        else resultado = ResultadoEnum.Perdedor;
        return resultado;
    }

    
}
