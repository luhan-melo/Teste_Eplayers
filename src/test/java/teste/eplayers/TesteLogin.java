package teste.eplayers;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;




public class TesteLogin {
	
	private WebDriver driver;
	
	
	@Before
	public void ConfigurarTeste() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Chromedriver\\chromedriver.exe");
		driver = new ChromeDriver ();
		driver.manage().window().maximize();
		
		driver.get("http://localhost:4200/");
		
		//*[@id="menu"]/a[2] -> Xpath do link
		
		driver.findElement(By.xpath("//*[@id=\"menu\"]/a[2]")).click();
		
	}
	
	@Test
	public void TestarLogin() {
		
		WebElement campoEmail = driver.findElement(By.id("campo-email"));
		campoEmail.sendKeys("teste");
		WebElement campoSenha = driver.findElement(By.id("senha"));
		WebElement botao = driver.findElement(By.xpath("/html/body/app-root/app-login/main/form/div/div/div/div/button"));
		
		String[] listaEmails = {"caique@email.com","adriano@gmail.com","adriano@gmail.com"};
		String[] listaSenhas = {"senhaaleatoria","senhaaleatoria","senhadoadriano"};
		
		/*
		try {
			
			for(int contador = 0; contador < 3; contador++  ) {
				campoEmail.sendKeys(listaEmails[contador]);
				campoSenha.sendKeys(listaSenhas[contador]);
				botao.click();
				
				Thread.sleep(3000);
				
				campoEmail.clear();
				campoSenha.clear();
				
			}
			*/
			
			
			
			// Caso de teste de Email Incorreto
			campoEmail.sendKeys("caique@email.com");
			campoSenha.sendKeys("senhaaleatoria");
			botao.click();
			
			//Thread.sleep(3000);
			
			campoEmail.clear();
			campoSenha.clear();
			
			// Senha incorreta para um email cadastrado
			campoEmail.sendKeys("adriano@gmail.com");
			campoSenha.sendKeys("senhaaleatoria");
			botao.click();
			
			//Thread.sleep(3000);
			
			campoEmail.clear();
			campoSenha.clear();
			
			// Usuario correto
			
			campoEmail.sendKeys("adriano@gmail.com");
			campoSenha.sendKeys("senhadoadriano");
			botao.click();
			
			//Thread.sleep(5000);
			
			
			/*
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			*/
	}
	
	@After
	public void EncerrarTeste() {
		//driver.quit();
	}
		

}
