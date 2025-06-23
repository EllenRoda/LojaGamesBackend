import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainTestCreate {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            driver.get("http://localhost:4200/products");
                    driver.manage().window().maximize();

// Clica no botão Novo Produto
            WebElement btnNovoProduto = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[contains(text(),'Novo Produto')]")));
            btnNovoProduto.click();

// Preenche os inputs pelo atributo name
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("proNome"))).sendKeys("Produto Teste");
            driver.findElement(By.name("proPrecoCusto")).sendKeys("20");
            driver.findElement(By.name("proPrecoVenda")).sendKeys("40");
            driver.findElement(By.name("proMarca")).sendKeys("Logitech");
            driver.findElement(By.name("proModelo")).sendKeys("M185");
            driver.findElement(By.name("proEstoque")).sendKeys("15");
            driver.findElement(By.name("proCor")).sendKeys("Preto");
            driver.findElement(By.name("proMaterial")).sendKeys("Plástico");
            driver.findElement(By.name("proFabricante")).sendKeys("Logitech Brasil");
            driver.findElement(By.name("proDescricao")).sendKeys("Mouse");
            driver.findElement(By.name("proCategoria")).sendKeys("Periféricos");
            driver.findElement(By.name("proCodigoBarras")).sendKeys("7891234");

// Seleciona a opção do mat-select "Produto Ativo?"
            WebElement ativoSelect = driver.findElement(By.cssSelector("mat-form-field mat-select[name='ativo']"));
            ativoSelect.click();

// Seleciona "Sim" (valor true)
            WebElement opcaoSim = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//mat-option[.//span[contains(text(),'Ativo')]]")));
            opcaoSim.click();

// Data (campo de data pode ser complexo, se aceitar texto direto)
            WebElement dataInput = driver.findElement(By.name("proDataCadastro"));
            dataInput.sendKeys("6/23/2025"); // Formato pode variar conforme localidade

// Clica no botão Salvar
            WebElement btnSalvar = driver.findElement(By.xpath("/html/body/app-root/body/app-nav/mat-sidenav-container/mat-sidenav-content/app-product-create/mat-card/button[1]"));
            btnSalvar.click();

// Só pra ver o resultado antes de fechar
            Thread.sleep(4000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}