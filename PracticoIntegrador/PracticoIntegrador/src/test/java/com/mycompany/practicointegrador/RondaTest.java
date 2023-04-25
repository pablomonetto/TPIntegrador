package com.mycompany.practicointegrador;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class RondaTest {

    public RondaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of resultadoRonda1 method, of class Ronda.
     */
    @Test
    public void testResultadoRonda1() {

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
        
        /*
         * *********************************************************************
         * Creacion de partidos. 
        * ********************************************************************
         */
        ArrayList<Partido> Pa = new ArrayList<>();
        for (String[] Result3 : ResultadosGrupoC) {
            Pa.add(new Partido(Result3));
        }

        /*
         * *********************************************************************
         * Carga de pronosticos . 
        * ********************************************************************
         */
        ArrayList<Pronostico> Pr = new ArrayList<>();
        for (String[] Result4 : DB_Pronosticos) {
            Pr.add(new Pronostico(Result4));
        }

        /*
         * *********************************************************************
         * Carga de participantes. 
        * ********************************************************************
         */
        ArrayList<Persona> Pe = new ArrayList<>();
        int y = 0, y_ant = 0;
        for (String[] Result5 : DB_Pronosticos) {
            y = Integer.parseInt(Result5[8]);
            if (y != y_ant) {
                y_ant = y;
                Pe.add(y - 1, new Persona(Result5[2]));
            }
        }
        
        System.out.println("resultadoRonda1");
        
        
       
        String archivo = "C:\\Users\\pablo\\OneDrive\\Documentos\\Java\\"
                + "PracticoIntegrador\\_SalidaDatos.csv";
        Ronda instance = new Ronda();
        instance.setPunto(1);
        instance.resultadoRonda1(Pe, Pa, Pr, archivo);
        instance.resultadoRonda2(Pe, Pa, Pr, archivo);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}
