package com.mycompany.practicointegrador;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PracticoIntegrador {

    public static void main(String[] args) {

        ArrayList<String[]> DB_Pronosticos = new ArrayList<>();

        /*
         * *********************************************************************
         * Lectura de la base de datos donde se encuentran almacenados los 
         * pronosticos.
         * ********************************************************************
         */
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/practicointegrador";
            String username = "root";
            String password = "";

            Connection con = DriverManager.getConnection(url, username, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from pronosticos");
            while (rs.next()) {

                String Temporal[] = new String[]{
                    Integer.toString(rs.getInt(1)),
                    Integer.toString(rs.getInt(2)),
                    rs.getString(3),
                    rs.getString(4),
                    Boolean.toString(rs.getBoolean(5)),
                    Boolean.toString(rs.getBoolean(6)),
                    Boolean.toString(rs.getBoolean(7)),
                    rs.getString(8),
                    Integer.toString(rs.getInt(9)),
                    Integer.toString(rs.getInt(10))
                };

                DB_Pronosticos.add(Temporal);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e + "\nNo entro");
        }

/////////////////////////MUESTRO PRONOSTICOS DEL GRUPO C////////////////////////
//        for (String[] Result : DB_Pronosticos) {
//            System.out.println(Result[0] + "\t" + Result[1] + "\t"
//                    + Result[2] + "\t" + Result[3] + "\t" + Result[4]
//                    + "\t" + Result[5] + "\t" + Result[6] + "\t" + Result[7]
//                    + "\t" + Result[8] + "\t" + Result[9]);
//        }
////////////////////////////////////////////////////////////////////////////////        
        /*
         * *********************************************************************
         * Lectura del archivo .csv donde se encuentran almacenados los resulta- 
         * dos de los partidos del grupo C.
         * ********************************************************************
         */
        ArrayList<String[]> ResultadosGrupoC = new ArrayList<>();
        String UbicacionResultados_C = "C:\\Users\\pablo\\OneDrive\\Documentos\\Java\\"
                + "PracticoIntegrador\\_ResultadoPartidos.csv";

        try {
            for (String lectura : Files.readAllLines(Paths.get(UbicacionResultados_C))) {
                String Resultados_C[] = lectura.split(";");
                ResultadosGrupoC.add(Resultados_C);
            }
        } catch (IOException ex) {
            System.out.println("\nNo se pudo leer el archivo de alumnos.");
        }

//////////////////////////MUESTRO RESULTADOS DEL GRUPO C////////////////////////
//        for (String[] Result : ResultadosGrupoC) {
//            System.out.println(Result[0] + "\t" + Result[1] + "\t" + 
//                    Result[2] + "\t" + Result[3] + "\t" + Result[4]+ "\t" + 
//                    Result[5]  );
//        }
////////////////////////////////////////////////////////////////////////////////
        /*
         * *********************************************************************
         * Verificacion del archivo de resultados con el numero correcto de 
         * campos y verificacion de goles en cantidad entera.
         * ********************************************************************
         */
        int x = 0;
        float GolNoInt;
        for (String[] Result2 : ResultadosGrupoC) {
            if (Result2.length != 6) {
                System.out.println("Error en linea: " + x);
            }
            GolNoInt = (float) ((Float.parseFloat(Result2[2])) % 1);
            if (GolNoInt != 0) {
                System.out.println("Valor de gol de linea: " + x + " de equipo local no es un numero entero.");
            }
            GolNoInt = (float) (Float.parseFloat(Result2[3]) % 1);
            if (GolNoInt != 0) {
                System.out.println("Valor de gol de linea: " + x + " de equipo visitante no es un numero entero.");
            }
            x++;
        }

        /*
         * *********************************************************************
         * Creacion de partidos. 
        * ********************************************************************
         */
        ArrayList<Partido> Partidos = new ArrayList<>();
        for (String[] Result3 : ResultadosGrupoC) {
            Partidos.add(new Partido(Result3));
        }

        /*
         * *********************************************************************
         * Carga de pronosticos . 
        * ********************************************************************
         */
        ArrayList<Pronostico> Pronosticos = new ArrayList<>();
        for (String[] Result4 : DB_Pronosticos) {
            Pronosticos.add(new Pronostico(Result4));
        }

        /*
         * *********************************************************************
         * Carga de participantes. 
        * ********************************************************************
         */
        ArrayList<Persona> Participantes = new ArrayList<>();
        int y = 0, y_ant = 0;
        for (String[] Result5 : DB_Pronosticos) {
            y = Integer.parseInt(Result5[8]);
            if (y != y_ant) {
                y_ant = y;
                Participantes.add(y - 1, new Persona(Result5[2]));
            }
        }
//////////////////////////MUESTRO LISTA DE PARTICIPANTES////////////////////////        
//        for (Persona Result6 : Participantes) {
//            System.out.println(Result6.getNombre());
//        }
////////////////////////////////////////////////////////////////////////////////
        /*
         * *********************************************************************
         * Resultado de los pronosticos. 
        * ********************************************************************
         */

        Ronda RRonda = new Ronda();

////////////////////////////////////////////////////////////////////////////////
//////////////// Cantidad de puntos por pronostico acertado.////////////////////
        int PuntosPorAcierto = 1;
        RRonda.setPunto(PuntosPorAcierto);
////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////////
//////////////// Bono de puntos extra por ronda perfecta///.////////////////////
        int bono = 0;
        RRonda.setBono(bono);
////////////////////////////////////////////////////////////////////////////////


        String SalidaResultados_C = "C:\\Users\\pablo\\OneDrive\\Documentos\\Java\\"
                + "PracticoIntegrador\\_SalidaDatos.csv";

        Scanner entrada = new Scanner(System.in);
        System.out.println("Indique de que ronda se quiere obtener los resultados:"
                + " \"1\", \"2\", \"3\" o \"T\" todas:");                           
        String valor = entrada.nextLine();

        switch (valor) {
            case "1" -> {
                RRonda.resultadoRonda1(Participantes, Partidos, Pronosticos, SalidaResultados_C);
                break;
            }
            case "2" -> {
                RRonda.resultadoRonda2(Participantes, Partidos, Pronosticos, SalidaResultados_C);
                break;
            }

            case "3" -> {
                RRonda.resultadoRonda3(Participantes, Partidos, Pronosticos, SalidaResultados_C);
                break;
            }
            case "t" -> {
                RRonda.resultadoTotal(Participantes, Partidos, Pronosticos, SalidaResultados_C);
                break;
            }
            default -> {
                System.out.println("Comando incorrecto.");
                break;
            }
        }

    }
}
