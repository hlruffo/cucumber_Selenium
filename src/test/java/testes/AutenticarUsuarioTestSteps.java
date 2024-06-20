package testes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class AutenticarUsuarioTestSteps {
	
	WebDriver driver;
	
	@Dado("Acessar a página de autenticação")
	public void passo1() {
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver-win64\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://hlruffo-002-site1.ctempurl.com/");
	}
	
	@E("Informar o email de acesso {string}")
	public void passo2(String email) {
		 driver.findElement(By.xpath("//*[@id=\"Email\"]")).sendKeys(email);
		}
	
	@E("Informar a senha de acesso {string}")
	public void passo3(String senha) {
		driver.findElement(By.xpath("//*[@id=\"Senha\"]")).sendKeys(senha);
	}
	
	@Quando("Solicitar o acesso à minha conta de usuário")
	public void passo4() {
		driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/form/div[3]/input")).click();
	}
	
	@Então("Sistema autentica meu usuário com sucesso")
	public void passo5() {
		String mensagem = driver.findElement(By.xpath("/html/body/nav/div/a/strong")).getText();
		assertEquals(mensagem,"Aplicativo de Finanças");
		try {
			File arquivo = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(arquivo, new File("Evidência - Autenticação de usuário com sucesso.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.close();
	}	
	
	@Então("Sistema não autentica usuario")
	public void sistema_não_autentica_usuario() {
	    String mensagem = driver.findElement(By.xpath("/html/body/div[1]/strong")).getText();
	    assertEquals(mensagem, "Acesso Negado! Usuário inválido.");
	    try {
			File arquivo = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(arquivo, new File("Evidência - Autenticação de usuário falha.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.close();
	}
	@Então("Mensagens de validação são exibidas")
	public void mensagens_de_validação_são_exibidas() {
	    String mensagem = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/form/div[1]/span/span")).getText();
	    assertEquals(mensagem, "Por favor, informe o email de acesso.");
	    try {
			File arquivo = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(arquivo, new File("Evidência - Validação de campos.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.close();
	}
}
