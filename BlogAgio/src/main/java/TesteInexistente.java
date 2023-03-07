import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteInexistente {
	
	private WebDriver driver = new ChromeDriver();
	private String pesquisa = "Flamengo";


	@Before
	public void inicializa() throws InterruptedException{
		driver.get("https://blogdoagi.com.br/");
		Thread.sleep(1000);
		driver.findElement(By.id("search-open")).click();
		driver.findElement(By.xpath("//*[@id=\"masthead\"]/div[1]/div[2]/form/label/input")).
		sendKeys(pesquisa);
		driver.findElement(By.xpath("//*[@id=\"masthead\"]/div[1]/div[2]/form/input")).click();
		Thread.sleep(3000);


	}
	
	@After
	public void finaliza(){
		driver.quit();
	}

	@Test
	public void pesquisar() throws InterruptedException {
		Thread.sleep(3000);
		WebElement procura = driver.findElement(By.xpath("//*[@id=\"primary\"]/section/div/form/label/input[@value=\""+pesquisa+"\"]"));
		String texto1 = procura.getAttribute("value");
		Assert.assertEquals(pesquisa, texto1);
		
		WebElement resultado = driver.findElement(By.xpath("//*[@id=\"primary\"]/section/header/h1"));
		String texto2 = resultado.getText();
		Assert.assertEquals("Nenhum resultado", texto2);
	}
}
