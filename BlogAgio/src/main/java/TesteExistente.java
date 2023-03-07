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

public class TesteExistente {
	
	private WebDriver driver = new ChromeDriver();
	private String pesquisa = "Empréstimo Consignado";

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
		
		WebElement procura = driver.findElement(By.xpath("//*[@id=\"primary\"]/header/h1/span"));
		String texto1 = procura.getText();
		Assert.assertEquals(pesquisa, texto1);
	}
}
