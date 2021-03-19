package StepDefitions;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.internal.com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File;
import junit.framework.Assert;

public class LoginStep {
	
	WebDriver driver;
	
	
	public String getDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");
        java.util.Date date = new java.util.Date();
        return dateFormat.format(date);
    }
	
	
@Given("Estando na Pagina Inicial")
public void estando_na_pagina_inicial() throws IOException {
    
	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\msilva16\\AppData\\Local\\Temp\\7zOC3F364A9\\chromedriver.exe");
	 driver = new ChromeDriver();
	 
     driver.get("http://advantageonlineshopping.com/#/");
     try {Thread.sleep(10000); }catch (Exception erro) {}
     driver.findElement(By.id("menuUser")).click();
     
     TakesScreenshot ts=(TakesScreenshot)driver;
     java.io.File source =ts.getScreenshotAs(OutputType.FILE);
     FileUtils.copyFile(source, new java.io.File("./Screenshot/TelaInicial.png"+getDate()));
     
     
     
 }

@When("Inserir usuario e senha")
public void inserir_usuario_e_senha() throws IOException {
    
	  driver.findElement(By.name("username")).sendKeys("MarianeH");
      try {Thread.sleep(4000); }catch (Exception erro) {}
      driver.findElement(By.name("password")).sendKeys("Mariane001");
      try {Thread.sleep(3000); }catch (Exception erro) {}
	
      TakesScreenshot ts=(TakesScreenshot)driver;
      java.io.File source =ts.getScreenshotAs(OutputType.FILE);
      FileUtils.copyFile(source, new java.io.File("./Screenshot/TelaLoginSenha.png"+getDate()));
      
      
}

@And("Clicar no botao confirma")
public void clicar_no_botao_confirma(){
	  driver.findElement(By.id("sign_in_btnundefined")).click();
      try {Thread.sleep(3000); }catch (Exception erro) {}
	
     
}

@Then("Validar usuario logado")
public void validar_usuario_logado() throws IOException {
   
	String perfil = driver.findElement(By.cssSelector(".containMiniTitle")).getText();
	Assert.assertEquals("MarianeH", perfil);

	 TakesScreenshot ts=(TakesScreenshot)driver;
     java.io.File source =ts.getScreenshotAs(OutputType.FILE);
     FileUtils.copyFile(source, new java.io.File("./Screenshot/TelaUsuario.png"+getDate()));
     
}


}
