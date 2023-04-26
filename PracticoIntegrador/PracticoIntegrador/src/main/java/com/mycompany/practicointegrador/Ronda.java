package com.mycompany.practicointegrador;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Ronda {

    int punto;
    int bono;

    public Ronda() {

    }

    public int getBono() {
        return bono;
    }

    public void setBono(int bono) {
        this.bono = bono;
    }

    public int getPunto() {
        return punto;
    }

    public void setPunto(int punto) {
        this.punto = punto;
    }

    public void resultadoRonda1(ArrayList<Persona> Pe, ArrayList<Partido> Pa, ArrayList<Pronostico> Pr, String archivo) {
        ArrayList<Pronostico> TempPr = new ArrayList<>();
        ArrayList<Partido> TempPa = new ArrayList<>();
        int cantPart = Pe.size();
        int[] puntajes = new int[cantPart];
        String[] cadena = new String[cantPart];

        for (int a = 0; a < cantPart; a++) {
            puntajes[a] = 0;
        }

        for (Pronostico s : Pr) {                                               //Pronosticos solo de la ronda 1
            if (s.ronda == 1) {
                TempPr.add(s);
            }

        }
        for (Partido t : Pa) {                                                  //Partidos solo de la ronda 1
            if (t.Ronda == 1) {
                TempPa.add(t);
            }
        }

        for (Partido t : TempPa) {                                              //Verificacion de acierto
            for (Pronostico s : TempPr) {
                if (t.ID_partido == s.Npartido) {
                    if (t.resultadoLocal() == s.getEquipoGanador()) {
                        puntajes[s.Nparticipante - 1] = puntajes[s.Nparticipante - 1] + punto;
                    }
                }
            }
        }

        for (int a = 0; a < cantPart; a++) {                                    //Asignacion de puntos extra
            int PuntajeIdeal = punto * cantPart;
            if (puntajes[a] == PuntajeIdeal) {
                puntajes[a] = puntajes[a] + bono;
            }
            System.out.println("Puntaje Ronda 1 - Jugador " + Pe.get(a).getNombre() + ": " + puntajes[a]);
            cadena[a] = "Ronda 1;" + Pe.get(a).getNombre() + ";" + puntajes[a];
        }

        try {
            FileWriter escritura = new FileWriter(archivo);
            for (int a = 0; a < cantPart; a++) {
                escritura.append(cadena[a]);
                escritura.append("\n");
            }
            escritura.flush();
            escritura.close();

        } catch (IOException exr1) {
            System.out.println("Error al escribir el resultado de la ronda 1.");
            exr1.printStackTrace();
        }

    }

    public void resultadoRonda2(ArrayList<Persona> Pe, ArrayList<Partido> Pa, ArrayList<Pronostico> Pr, String archivo) {
        ArrayList<Pronostico> TempPr = new ArrayList<>();
        ArrayList<Partido> TempPa = new ArrayList<>();
        int cantPart = Pe.size();
        int[] puntajes = new int[cantPart];
        String[] cadena = new String[cantPart];

        for (int a = 0; a < cantPart; a++) {
            puntajes[a] = 0;
        }

        for (Pronostico s : Pr) {                                               //Pronosticos solo de la ronda 2
            if (s.ronda == 2) {
                TempPr.add(s);
            }

        }
        for (Partido t : Pa) {                                                  //Partidos solo de la ronda 2
            if (t.Ronda == 2) {
                TempPa.add(t);
            }
        }

        for (Partido t : TempPa) {                                              //Verificacion de acierto
            for (Pronostico s : TempPr) {
                if (t.ID_partido == s.Npartido) {
                    if (t.resultadoLocal() == s.getEquipoGanador()) {
                        puntajes[s.Nparticipante - 1] = puntajes[s.Nparticipante - 1] + punto;
                    }
                }
            }
        }

        for (int a = 0; a < cantPart; a++) {                                    //Asignacion de puntos extra
            int PuntajeIdeal = punto * cantPart;
            if (puntajes[a] == PuntajeIdeal) {
                puntajes[a] = puntajes[a] + bono;
            }
            System.out.println("Puntaje Ronda 2 - Jugador " + Pe.get(a).getNombre() + ": " + puntajes[a]);
            cadena[a] = "Ronda 2;" + Pe.get(a).getNombre() + ";" + puntajes[a];
        }
        try {
            FileWriter escritura = new FileWriter(archivo);
            for (int a = 0; a < cantPart; a++) {
                escritura.append(cadena[a]);
                escritura.append("\n");
            }
            escritura.flush();
            escritura.close();

        } catch (IOException exr1) {
            System.out.println("Error al escribir el resultado de la ronda 2.");
            exr1.printStackTrace();
        }

    }

    public void resultadoRonda3(ArrayList<Persona> Pe, ArrayList<Partido> Pa, ArrayList<Pronostico> Pr, String archivo) {
        ArrayList<Pronostico> TempPr = new ArrayList<>();
        ArrayList<Partido> TempPa = new ArrayList<>();
        int cantPart = Pe.size();
        int[] puntajes = new int[cantPart];
        String[] cadena = new String[cantPart];

        for (int a = 0; a < cantPart; a++) {
            puntajes[a] = 0;
        }

        for (Pronostico s : Pr) {                                               //Pronosticos solo de la ronda 3
            if (s.ronda == 3) {
                TempPr.add(s);
            }

        }
        for (Partido t : Pa) {                                                   //Pronosticos solo de la ronda 3
            if (t.Ronda == 3) {
                TempPa.add(t);
            }
        }

        for (Partido t : TempPa) {                                              //Verificacion de acierto
            for (Pronostico s : TempPr) {
                if (t.ID_partido == s.Npartido) {
                    if (t.resultadoLocal() == s.getEquipoGanador()) {
                        puntajes[s.Nparticipante - 1] = puntajes[s.Nparticipante - 1] + punto;
                    }
                }
            }
        }

        for (int a = 0; a < cantPart; a++) {                                    //Asignacion de puntos extra
            int PuntajeIdeal = punto * cantPart;
            if (puntajes[a] == PuntajeIdeal) {
                puntajes[a] = puntajes[a] + bono;
            }
            System.out.println("Puntaje Ronda 3 - Jugador " + Pe.get(a).getNombre() + ": " + puntajes[a]);
            cadena[a] = "Ronda 3;" + Pe.get(a).getNombre() + ";" + puntajes[a];
        }
        try {
            FileWriter escritura = new FileWriter(archivo);
            for (int a = 0; a < cantPart; a++) {
                escritura.append(cadena[a]);
                escritura.append("\n");
            }
            escritura.flush();
            escritura.close();

        } catch (IOException exr1) {
            System.out.println("Error al escribir el resultado de la ronda 3.");
            exr1.printStackTrace();
        }
    }

    public void resultadoTotal(ArrayList<Persona> Pe, ArrayList<Partido> Pa, ArrayList<Pronostico> Pr, String archivo) {
        ArrayList<Pronostico> TempPr1 = new ArrayList<>();                      //Repito las funciones individuales de cada ronda
        ArrayList<Pronostico> TempPr2 = new ArrayList<>();                      //para implementar la funcion de puntos extra por cada
        ArrayList<Pronostico> TempPr3 = new ArrayList<>();                      //ronda acertada correctamente.
        ArrayList<Partido> TempPa1 = new ArrayList<>();
        ArrayList<Partido> TempPa2 = new ArrayList<>();
        ArrayList<Partido> TempPa3 = new ArrayList<>();
        int cantPart = Pe.size();
        int[] puntajes1 = new int[cantPart];
        int[] puntajes2 = new int[cantPart];
        int[] puntajes3 = new int[cantPart];
        int[] puntajes = new int[cantPart];
        String[] cadena = new String[cantPart];

        for (int a = 0; a < cantPart; a++) {
            puntajes[a] = 0;
            puntajes1[a] = 0;
            puntajes2[a] = 0;
            puntajes3[a] = 0;
        }
        
        for (Pronostico s : Pr) {                                               
            if (s.ronda == 1) {
                TempPr1.add(s);
            }

        }
        for (Partido t : Pa) {
            if (t.Ronda == 1) {
                TempPa1.add(t);
            }
        }

        for (Partido t : TempPa1) {
            for (Pronostico s : TempPr1) {
                if (t.ID_partido == s.Npartido) {
                    if (t.resultadoLocal() == s.getEquipoGanador()) {
                        puntajes1[s.Nparticipante - 1] = puntajes1[s.Nparticipante - 1] + punto;
                    }
                }
            }
        }

        for (int a = 0; a < cantPart; a++) {
            int PuntajeIdeal = punto * cantPart;
            if (puntajes1[a] == PuntajeIdeal) {
                puntajes1[a] = puntajes1[a] + bono;
            }
        }

        for (Pronostico s : Pr) {
            if (s.ronda == 2) {
                TempPr2.add(s);
            }

        }
        for (Partido t : Pa) {
            if (t.Ronda == 2) {
                TempPa2.add(t);
            }
        }

        for (Partido t : TempPa2) {
            for (Pronostico s : TempPr2) {
                if (t.ID_partido == s.Npartido) {
                    if (t.resultadoLocal() == s.getEquipoGanador()) {
                        puntajes2[s.Nparticipante - 1] = puntajes2[s.Nparticipante - 1] + punto;
                    }
                }
            }
        }

        for (int a = 0; a < cantPart; a++) {
            int PuntajeIdeal = punto * cantPart;
            if (puntajes2[a] == PuntajeIdeal) {
                puntajes2[a] = puntajes2[a] + bono;
            }
        }

        for (Pronostico s : Pr) {
            if (s.ronda == 3) {
                TempPr3.add(s);
            }

        }
        for (Partido t : Pa) {
            if (t.Ronda == 3) {
                TempPa3.add(t);
            }
        }

        for (Partido t : TempPa3) {
            for (Pronostico s : TempPr3) {
                if (t.ID_partido == s.Npartido) {
                    if (t.resultadoLocal() == s.getEquipoGanador()) {
                        puntajes3[s.Nparticipante - 1] = puntajes3[s.Nparticipante - 1] + punto;
                    }
                }
            }
        }

        for (int a = 0; a < cantPart; a++) {
            int PuntajeIdeal = punto * cantPart;
            if (puntajes3[a] == PuntajeIdeal) {
                puntajes3[a] = puntajes3[a] + bono;
            }
        }

        for (int a = 0; a < cantPart; a++) {           
            puntajes[a] = puntajes1[a] + puntajes2[a] + puntajes3[a];
            System.out.println("Puntaje Total - Jugador " + Pe.get(a).getNombre() + ": " + puntajes[a]);
            cadena[a] = "Puntaje total;" + Pe.get(a).getNombre() + ";" + puntajes[a];
        }

        try {
            FileWriter escritura = new FileWriter(archivo);
            for (int a = 0; a < cantPart; a++) {
                escritura.append(cadena[a]);
                escritura.append("\n");
            }
            escritura.flush();
            escritura.close();

        } catch (IOException exr1) {
            System.out.println("Error al escribir el resultado final.");
            exr1.printStackTrace();
        }

    }

}
