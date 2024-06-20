package testes;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import helpers.ChromeHelper;
import helpers.ScreenshotHelper;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;


public class CadatrarUsuarioTestSteps {
	
	WebDriver driver;
	
	@Dado("Acessar a página de cadastro")
	public void acessar_a_página_de_cadastro() {
	    driver = ChromeHelper.create
	    		("http://hlruffo-002-site1.ctempurl.com/Account/Register");
	}

	@E("Informar no campo nome {string}")
	public void informar_no_campo_nome(String nome) {
	    driver.findElement(By.xpath("//*[@id=\"Nome\"]")).sendKeys(nome);
	}

	@E("Informar no campo email {string}")
	public void informar_no_campo_email(String email) {
	    driver.findElement(By.xpath("//*[@id=\"Email\"]")).sendKeys(email);
	}

	@E("Informar no campo senha de acesso {string}")
	public void informar_no_campo_senha_de_acesso(String senha) {
	    driver.findElement(By.xpath("//*[@id=\"Senha\"]")).sendKeys(senha);
	}

	@E("Informa no campo confirme a senha de acesso {string}")
	public void informa_no_campo_confirme_a_senha_de_acesso(String confirmarSenha) {
	    driver.findElement(By.xpath("//*[@id=\"SenhaConfirmacao\"]")).sendKeys(confirmarSenha);
	}

	@Quando("Clicar no botão Realizar Cadastro")
	public void clicar_no_botão_realizar_cadastro() {
	    driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/form/div[5]/input")).click();
	}

	@Então("Uma mensagem de cadastro com sucesso deve ser exibida")
	public void uma_mensagem_de_cadastro_com_sucesso_deve_ser_exibida() {
	    String mensagem = driver.findElement(By.xpath("/html/body/div[1]/strong")).getText();
	    assertEquals(mensagem,"Parabéns Hugo Ledertheil Ruffo, sua conta de usuário foi criada com sucesso!");
	    //assertTrue(mensagem, mensagem.contains("Parabéns"));
	    
	    ScreenshotHelper.create(driver, "Evidência - Cadastro com sucesso.png");
	    driver.quit();
	}

	@Então("Uma mensagem de cadastro negado deve ser exibida")
	public void uma_mensagem_de_cadastro_negado_deve_ser_exibida() {
	    String mensagem = driver.findElement(By.xpath("/html/body/div[1]/strong")).getText();
	    assertEquals(mensagem,"Alerta! O email informado já está cadastrado. Por favor verifique.");
	    ScreenshotHelper.create(driver, "Evidência - Cadastro negado.png");
	    driver.quit();
	}

	@Então("As mensagens de validação deverão ser exibidas")
	public void as_mensagens_de_validação_deverão_ser_exibidas() {
	    String mensagem = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/form/div[1]/span/span")).getText();
	    assertEquals(mensagem,"Por favor, informe o seu nome.");
	    ScreenshotHelper.create(driver, "Evidência - Validação de campo.png");
	    driver.quit();
	}
}
