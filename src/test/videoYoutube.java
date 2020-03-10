package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class videoYoutube {

	static WebDriver driver;
	static WebDriverWait wait;
	
//	buscar un video en youtube

	public static void main(String[] args) throws InterruptedException {
		
		

		//		*navegar a la url
		navegarUrl("https://www.youtube.com/");
//		*Buscar el video 
		buscarVideo("ZEUS, Destripando la Historia");
		//		-introducir el nombre del video en el buscador 
		//		-hacer click en la lupa
		//		-seleccinar el video de la lista
		clickCancion("ZEUS, Destripando la Historia");
		Thread.sleep(4000);
		ValidarVideo();
		cerrarpag();
		
	}


	
	private static void navegarUrl(String url) {
		 
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30,  TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 15);
		driver.get(url);
	
	}
	
	private static void buscarVideo(String nombreCancion) {
		
		WebElement buscadorYutu = driver.findElement(By.xpath("//input[@id=\"search\"]"));
		buscadorYutu.click();
		buscadorYutu.sendKeys(nombreCancion);
		WebElement botonBuscar = driver.findElement(By.xpath("//button[@id=\"search-icon-legacy\"]"));
		botonBuscar.click();
		
	}

	
	private static void clickCancion(String selecCancion) {
		 
		WebElement cancionYutu  = driver.findElement(By.xpath("//a[@title=\"ZEUS | Destripando la Historia | Canción\"]")); 
				
		cancionYutu.click();
	}
	
	private static void ValidarVideo() {
		
		WebElement tituloVideo = driver.findElement(By.xpath("//h1[@class=\"title style-scope ytd-video-primary-info-renderer\"]"));
		
		if(tituloVideo.isDisplayed())
			
			System.out.println("Se encontro el elemento de la validacion.");

		else {
			System.out.println("No se encontro el elemento.");
			System.exit(-1);
		
	   }
		
	}
	
	private static void cerrarpag() {
		
		driver.close();
		driver.quit();
	
}


}
