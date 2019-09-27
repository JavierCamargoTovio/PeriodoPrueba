package com.choucair.formacion.pageobjects;

import com.opera.core.systems.scope.protos.ExecProtos;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;


@DefaultUrl("https://www.tripadvisor.co/")
public class TripadvisorPage extends PageObject {
    //region @FindBy
    @FindBy(xpath = "//div[@id='googleSignIn']//span[contains(text(),'Continuar con Google ')]")
    WebElementFacade btnGoogle;

    @FindBy(xpath = "//input[@id='identifierId']")
    WebElementFacade txtemail;

    @FindBy(xpath = "//div[@id='identifierNext']")
    WebElementFacade btnSiguiente;

    @FindBy(xpath = "//span[contains(text(),'Siguiente')]")
    WebElementFacade btnSiguiente2;

    @FindBy(xpath = "//input[@name='password']")
    WebElementFacade btnPass;
    @FindBy(xpath = "//div[@class='brand-trip-search-geopill-TripSearchGeoPill__pillWrap--2_fwr']//div[1]//span")
    WebElementFacade ciudad;

    @FindBy(xpath = "//input[@placeholder='¿Adónde?']")
    WebElementFacade txtCiudad;

    @FindBy(xpath = "//div[@id='taplc_resp_rr_photo_mosaic_0']//div//div//div[2]//div[2]//div[2]//span[2]")
    WebElementFacade vistaPagina;

    @FindBy(xpath = "//span//div//a[@href='/Restaurants-g681278-Quibdo_Choco_Department.html']") WebElementFacade selecionarRestaurante;

    @FindBy(xpath = "//div[@class='label filterName']//a[contains(text(),'Restaurantes')]") WebElementFacade filtrarRestaurante;

    @FindBy(xpath = "//div[@class='prw_rup prw_restaurants_restaurant_filters']//div[8]//div[@class='text'][contains(text(),'Más')]")
    WebElementFacade filtrarMasComida;

    @FindBy(xpath = "//div[@class='label'][contains(text(),'Parrilla')]") WebElementFacade filtrarParrilla;

    @FindBy(xpath = "//div[@class='filtersOverlayFoot']//child::div[@class='applyButton ui_button primary']") WebElementFacade btnParrilla;

    @FindBy(xpath = "//div[@id='component_2']//div[2]/div//div//div//span//a[text()='1. Pollo Arabe Quibdo']") WebElementFacade seleccionarLoFiltrado;

    @FindBy(xpath = "//span[@class='ui_overlay ui_modal no_padding fullscreen']/div[2]") WebElementFacade cerrarIframeFotos;

    @FindBy(xpath = "//label[@class='row_label label'][contains(text(),'Regular')]") WebElementFacade filtrarOpinionRegualar;

    @FindBy(xpath = "//div[@class='ui_column is-9']//span[@class='noQuotes']") WebElementFacade tituloOpinion;

    @FindBy(xpath = "//div[@class='prw_rup prw_reviews_text_summary_hsx']//div//child::p") WebElementFacade descripcionOpnion;

    @FindBy(xpath = "//div[@class='block_header block_title']//div//child::a") WebElementFacade btnEscribirOpnion;

    @FindBy(xpath = "//div[@id='REVIEW_TITLE']//input[@name='ReviewTitle']") WebElementFacade resumenComentarioVisita;

    @FindBy(xpath = "//div[@id='REVIEW_TEXT']//textarea") WebElementFacade comentarioVisita;

    @FindBy(xpath = "//div[@id='trip_type_table']//div[contains(text(),'Familia')]") WebElementFacade btnFamilia;

    @FindBy(xpath = "//div[@id='MEAL_TYPE']//select[@class='meal_type_class']") WebElementFacade razonVisitaComentario;

    @FindBy(xpath = "//div[@id='DATE_OF_VISIT']//select[@name='trip_date_month_year']") WebElementFacade fechaVisitaComentario;

    @FindBy(xpath = "//div[@class='answersBlock p13n_tag_cloud war_smaller_buttons']//div[@data-value='-165471']")
    WebElementFacade servicioDeMesa;

    @FindBy(xpath = "//div[@class='answersBlock p13n_tag_cloud war_smaller_buttons']//div[@data-value='-103451']")
    WebElementFacade btnestoEsParrilla;

    @FindBy(xpath = "//div[@class='answersBlock p13n_tag_cloud war_smaller_buttons']//div[@data-value='-117801']")
    WebElementFacade btTarjetaCredito;

    @FindBy(xpath = "//div[@class='answersBlock p13n_tag_cloud war_smaller_buttons']//div[@data-value='-106061']")
    WebElementFacade btnOpcionBrunch;

    @FindBy(xpath = "//div[@class='answersBlock p13n_tag_cloud war_smaller_buttons']//div[@data-value='-106041']")
    WebElementFacade btnIdealFamilia;

    @FindBy(xpath = "//div[@class='answersBlock p13n_tag_cloud war_smaller_buttons']//div[@data-value='-108611']")
    WebElementFacade btnDescapacidad;

    @FindBy(xpath = "//div[@class='p13n_tag_cloud war_smaller_buttons']//div[contains(text(),'Restaurantes elegantes')]")
    WebElementFacade btnRestauranteElegante;

    @FindBy(xpath = "//div[@class='ppr_rup ppr_priv_war_cuisine_type']//input[@id='cuisine_input']") WebElementFacade txtTipoComida;

    @FindBy(xpath = "//div[@class='question labelAndInput']//input[@id='qid393']") WebElementFacade txtRecomendacionComida;

    @FindBy(xpath = "//div[@class='question']//input[@id='noFraud']") WebElementFacade ckbAceptarCondiciones;

    @FindBy(xpath = "//div[@id='SBMT_WRP']//div[@id='SUBMIT']") WebElementFacade btnEnviarOpinion;

    @FindBy(xpath = "//span[@id='bubble_rating']")  WebElement img;

    @FindBy(id = "//span[@class='ui_bubble_rating fl bubble_50']")  WebElement etiqueta;
 //endregion

    public void seleccionarDestino(String tCiudad) throws AWTException, InterruptedException {
        ciudad.click();
        txtCiudad.sendKeys(tCiudad);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        selecionarRestaurante.click();
        filtrarRestaurante.click();
        waitFor(filtrarMasComida).isVisible();
        filtrarMasComida.click();
        waitFor(filtrarParrilla).isVisible();
        filtrarParrilla.click();
        waitFor(btnParrilla).isVisible();
        btnParrilla.click();
        waitFor(seleccionarLoFiltrado).isVisible();
        seleccionarLoFiltrado.click();
        ArrayList<String> tabs2 = new ArrayList<String>(getDriver().getWindowHandles());
        System.out.println(tabs2);
        getDriver().switchTo().window(tabs2.get(1));
        System.out.println(getDriver().getWindowHandle());
    }


    public void seleccionarImagenes() {
        waitFor(vistaPagina).isVisible();
        vistaPagina.click();
        WebElement liActual;
        for (int i = 2; i <= 8; i += 2) {
            liActual = getDriver().findElement(By.xpath("//div[@class='photos inHeroList']//child::div[" + i + "]"));
            waitFor(liActual).isVisible();
            liActual.click();
            Serenity.takeScreenshot();
        }

    }

    public void imprimirConsolaOpninion() {
        waitFor(cerrarIframeFotos).isVisible();
        cerrarIframeFotos.click();
        filtrarOpinionRegualar.click();
        String captura1 = tituloOpinion.getText();
        System.out.println("============================================================");
        System.out.println("Título del Comentario: " + captura1);
        System.out.println("************************************************************");
        String captura2 = descripcionOpnion.getText();
        System.out.println(captura2);
        System.out.println("************************************************************");
    }

    public void clickOpinion() throws AWTException {
        waitFor(btnEscribirOpnion).isVisible();
        Actions action = new Actions(getDriver());
        WebElement jjpp = getDriver().findElement(By.xpath("//div[@class='block_header block_title']//div//child::a"));
        action.contextClick(jjpp).build().perform();
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        System.out.println(getDriver().getWindowHandle());
        ArrayList<String> tabs2 = new ArrayList<String>(getDriver().getWindowHandles());
        System.out.println(tabs2);
        getDriver().switchTo().window(tabs2.get(2));
        System.out.println(getDriver().getWindowHandle());

    }

    public void excelente()  {
        Point coor = getDriver().findElement(By.xpath("//span[@id='bubble_rating']")).getLocation();
        new Actions(getDriver()).moveByOffset(coor.x+145,coor.y+32).click().build().perform();
      //clicElemt.click(img).perform();

    }

    public void escribirOpinion(String tituloComentario, String cuerpoComentario, String razonVisita,
                                String fechaVisita, String tipoComida, String comidaRecomendada) {
        resumenComentarioVisita.sendKeys(tituloComentario);
        comentarioVisita.sendKeys(cuerpoComentario);
        btnFamilia.click();
        razonVisitaComentario.click();
        razonVisitaComentario.selectByVisibleText(razonVisita);
        fechaVisitaComentario.click();
        fechaVisitaComentario.selectByVisibleText(fechaVisita);
        servicioDeMesa.click();
        btnestoEsParrilla.click();
        btTarjetaCredito.click();
        btnOpcionBrunch.click();
        btnIdealFamilia.click();
        btnDescapacidad.click();

        btnRestauranteElegante.click();
        txtTipoComida.sendKeys(tipoComida);
        txtRecomendacionComida.sendKeys(comidaRecomendada);
        ckbAceptarCondiciones.click();
        btnEnviarOpinion.click();

    }


    public void iniciarSesion(String email, String password) {
        waitForPresenceOf("//iframe[@id='overlayRegFrame']");
        getDriver().switchTo().frame(getDriver().findElement(By.id("overlayRegFrame")));
        waitFor(btnGoogle).isVisible();
        btnGoogle.click();
        System.out.println(getDriver().getWindowHandle());
        ArrayList<String> tabs = new ArrayList<String>(getDriver().getWindowHandles());
        System.out.println(tabs);
        getDriver().switchTo().window(tabs.get(3));
        System.out.println(getDriver().getWindowHandle());
        txtemail.sendKeys(email);
        btnSiguiente.click();
        btnPass.sendKeys(password);
        waitFor(btnSiguiente2).isCurrentlyVisible();
        btnSiguiente2.click();
        waitFor(30).seconds();
        getDriver().switchTo().window(tabs.get(2));

    }

}

