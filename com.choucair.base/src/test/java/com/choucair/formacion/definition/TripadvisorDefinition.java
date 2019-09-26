package com.choucair.formacion.definition;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.choucair.formacion.steps.TripadvisorStep;
import net.thucydides.core.annotations.Steps;

import java.awt.*;

public class TripadvisorDefinition {

    private String casoPrueba;
    @Steps
    TripadvisorStep tripadvisorStep;

    @Given("^ingreso a tripadvisor caso \"([^\"]*)\"$")
    public void ingreso_a_tripadvisor_caso(String idCaso)  {
        this.casoPrueba = idCaso;
        tripadvisorStep.abriUrl();
        tripadvisorStep.leerCSV("001");


    }

    @When("^selecciono, filtro e imprimo los items$")
    public void selecciono_filtro_e_imprimo_los_items() throws AWTException, InterruptedException {
        tripadvisorStep.seleccionarDestino();
       tripadvisorStep.seleccionarFotos();
       tripadvisorStep.imprimirConsola();

    }

    @Then("^diligenciamiento de la oponión excelente$")
    public void diligenciamiento_de_la_oponión_excelente() throws InterruptedException, AWTException {
      tripadvisorStep.escribirCalificacion();
    }
}
