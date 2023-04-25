package com.mycompany.practicointegrador;

public class Pronostico {

    int ronda;
    String participante;
    int Npartido;
    int Nparticipante;
    ResultadoEnum equipoGanador;

    public Pronostico(String[] Pronostico) {
        Npartido = Integer.parseInt(Pronostico[9]);
        ronda = Integer.parseInt(Pronostico[1]);
        participante = Pronostico[2];
        Nparticipante = Integer.parseInt(Pronostico[8]);
        
        ResultadoEnum resultado;
        if (Boolean.parseBoolean(Pronostico[4]) == true) {
            resultado = ResultadoEnum.Ganador;
        } else if (Boolean.parseBoolean(Pronostico[5]) == true) {
            resultado = ResultadoEnum.Empate;
        } else {
            resultado = ResultadoEnum.Perdedor;
        }
        equipoGanador = resultado; 
    }

    public int getRonda() {
        return ronda;
    }

    public void setRonda(int ronda) {
        this.ronda = ronda;
    }

    public int getNpartido() {
        return Npartido;
    }

    public void setNpartido(int Npartido) {
        this.Npartido = Npartido;
    }

    public String getParticipante() {
        return participante;
    }

    public void setParticipante(String participante) {
        this.participante = participante;
    }

    public ResultadoEnum getEquipoGanador() {
        return equipoGanador;
    }

    public void setEquipoGanador(ResultadoEnum equipoGanador) {
        this.equipoGanador = equipoGanador;
    }


    
}
