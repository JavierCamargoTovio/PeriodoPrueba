package com.choucair.formacion.pageobjects;

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
    @FindBy(xpath = "//div[@class='brand-global-nav-action-profile-Profile__container--3inu_ brand-global-nav-action-profile-Profile__white--21kMu']//a[2]")
    WebElementFacade btnIngresar;

    @FindBy(xpath = "//div[@id='googleSignIn']//span[@id='googleBtn']")
    WebElementFacade btnGoogle;

    @FindBy(xpath = "//input[@id='identifierId']")
    WebElementFacade email;

    @FindBy(xpath = "//div[@id='identifierNext']")
    WebElementFacade btnSiguiente;

    @FindBy(xpath = "//span[contains(text(),'Siguiente')]")
    WebElementFacade btnSiguiente2;

    @FindBy(xpath = "//input[@name='password']")
    WebElementFacade btnPass;

    @FindBy(xpath = "//span[@class='ui_column is-4-mobile brand-quick-links-QuickLinkTileItem__quickLinkTileItem--zKAkR brand-quick-links-QuickLinkTileItem__customizedColForTablet--1ql_j brand-quick-links-commonStyles__order-hotels--2paOG']//div//div//div//a[@class='brand-quick-links-QuickLinkTileItem__link--1k5lE']")
    WebElementFacade visible;

    @FindBy(xpath = "//div[@class='brand-trip-search-geopill-TripSearchGeoPill__pillWrap--2_fwr']//div[1]//span")
    WebElementFacade ciudad;

    @FindBy(xpath = "//input[@placeholder='¿Adónde?']")
    WebElementFacade txtCiudad;

    @FindBy(xpath = "//div[@id='taplc_resp_rr_photo_mosaic_0']//div//div//div[2]//div[2]//div[2]//span[2]")
    WebElementFacade vistaPagina;

    @FindBy(xpath = "//span//div//a[@href='/Restaurants-g681278-Quibdo_Choco_Department.html']")
    WebElementFacade selecionarRestaurante;

    @FindBy(xpath = "//div[@class='label filterName']//a[contains(text(),'Restaurantes')]")
    WebElementFacade filtrarRestaurante;

    @FindBy(xpath = "//div[@class='prw_rup prw_restaurants_restaurant_filters']//div[8]//div[@class='text'][contains(text(),'Más')]")
    //div[@id='jfy_filter_bar_cuisine']//div[@class='text'][contains(text(),'Más')]
            WebElementFacade filtrarMasComida;

    @FindBy(xpath = "//div[@class='label'][contains(text(),'Parrilla')]")
    WebElementFacade filtrarParrilla;

    @FindBy(xpath = "//div[@class='filtersOverlayFoot']//child::div[@class='applyButton ui_button primary']")
    WebElementFacade btnParrilla;

    @FindBy(xpath = "//div[@id='component_2']//div[2]/div//div//div//span//a[text()='1. Pollo Arabe Quibdo']")
    WebElementFacade seleccionarLoFiltrado;

    @FindBy(xpath = "//span[@class='ui_overlay ui_modal no_padding fullscreen']/div[2]")
    WebElementFacade cerrarIframeFotos;

    @FindBy(xpath = "//label[@class='row_label label'][contains(text(),'Regular')]")
    WebElementFacade filtrarOpinionRegualar;

    @FindBy(xpath = "//div[@class='ui_column is-9']//span[@class='noQuotes']")
    WebElementFacade tituloOpinion;

    @FindBy(xpath = "//div[@class='prw_rup prw_reviews_text_summary_hsx']//div//child::p")
    WebElementFacade descripcionOpnion;

    @FindBy(xpath = "//div[@class='block_header block_title']//div//child::a")
    WebElementFacade btnEscribirOpnion;

    @FindBy(xpath = "//div[@class='question rating bigRating labelAndInput required complete']//select//child::option[@value='5']")
    WebElementFacade lblCalificacion;


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
        // System.out.println(getDriver().getWindowHandle());
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
    public  void clickOpinion(){
        waitFor(btnEscribirOpnion).isVisible();
        btnEscribirOpnion.click();
    }

    public void excelente() {
        int y = getDriver().findElement(By.xpath("//span[@id='bubble_rating']")).getLocation().getY();
        int x = getDriver().findElement(By.xpath("//span[@id='bubble_rating']")).getLocation().getX();
        System.out.println("coordenadas:"+x+","+y+"");
        new Actions(getDriver()).moveByOffset(x+145,y+32).click().build().perform();
    }

    public void escribirOpinion() {//throws InterruptedException, AWTException {
       /* waitFor(btnEscribirOpnion).isVisible();
        btnEscribirOpnion.click();
        Point coordinates = getDriver().findElement(By.id("bubble_rating")).getLocation();
        Robot robot = new Robot();
        robot.mouseMove(coordinates.getX()+1151,coordinates.getY()+2483);
        Thread.sleep(300);
        new Actions(getDriver()).click().release().perform();

        int y = getDriver().findElement(By.xpath("//div[@class='easyClear bigRatingParent']")).getLocation().getY();
        int x = getDriver().findElement(By.xpath("//div[@class='easyClear bigRatingParent']")).getLocation().getX();
        System.out.println("coordenadas:"+x+","+y+"");
        new Actions(getDriver()).moveByOffset(x+145,y+32).click().release().perform();

        */
       $("//div[@id='REVIEW_TITLE']//input[@name='ReviewTitle']").sendKeys("Hollla");
    }

        public void iniciarSesion() {
        btnIngresar.click();
        waitForPresenceOf("//iframe[@id='overlayRegFrame']");
        getDriver().switchTo().frame(getDriver().findElement(By.id("overlayRegFrame")));
        btnGoogle.click();
        getDriver().switchTo().defaultContent();
        System.out.println(getDriver().getWindowHandle());
        ArrayList<String> tabs = new ArrayList<String>(getDriver().getWindowHandles());
        System.out.println(tabs);
        getDriver().switchTo().window(tabs.get(1));
        System.out.println(getDriver().getWindowHandle());
        email.sendKeys("javiecamargo22@gmail.com");
        btnSiguiente.click();
        btnPass.sendKeys("camargo029207");
        waitFor(3);
        btnSiguiente2.click();
        getDriver().switchTo().window(tabs.get(1));
        ciudad.click();
    }
}


