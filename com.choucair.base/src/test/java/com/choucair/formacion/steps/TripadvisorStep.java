package com.choucair.formacion.steps;
import au.com.bytecode.opencsv.CSVReader;
import com.choucair.formacion.pageobjects.TripadvisorPage;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TripadvisorStep {
    private static CSVReader reader;
    private static String[]datos;

    TripadvisorPage tripadvisorPage;

    public void leerCSV(String casoPrueba){
        try {
            reader = new CSVReader(new FileReader("src/test/resources/Datadriven/DtsDriven.csv"));
            String[] fila;
            while ((fila = reader.readNext())!=null){
                System.out.println(fila[0]);
                if (casoPrueba.equals(fila[0].trim())){
                    datos = fila;
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void abriUrl() {
        tripadvisorPage.open();
    }

    public void seleccionarDestino() throws AWTException, InterruptedException {
        tripadvisorPage.seleccionarDestino(datos[1]);
    }

    public void seleccionarFotos() {
        tripadvisorPage.seleccionarImagenes();
    }

    public void imprimirConsola()  {
       tripadvisorPage.imprimirConsolaOpninion();
    }
    public void escribirCalificacion() throws AWTException, InterruptedException {
        tripadvisorPage.clickOpinion();
        tripadvisorPage.excelente();
        tripadvisorPage.escribirOpinion(datos[2],datos[3],datos[4],datos[5],datos[6],datos[7]);
        tripadvisorPage.iniciarSesion(datos[8],datos[9]);

    }

}
