import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ForPagCreate {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            driver.get("http://localhost:4200/formaPagamento");
            driver.manage().window().maximize();

            // Clica no botão Novo Produto
            WebElement novoprodutobtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[contains(text(),'Nova Forma de pagamento +')]")));
            novoprodutobtn.click();


            // Função auxiliar para selecionar mat-select
            selecionarMatSelect(driver, wait, "fpgCredito", "Crédito");
            selecionarMatSelect(driver, wait, "fpgFechamento", "10");
            selecionarMatSelect(driver, wait, "fpgStatus", "Ativo");

            // Preenche textarea de descrição
            WebElement descricao = wait.until(ExpectedConditions.elementToBeClickable(By.name("fpgDescricao")));
            descricao.sendKeys("Forma de pagamento via cartão de crédito com fechamento no (dia 06).");

            // Clica no botão Salvar
            WebElement botaoSalvar = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[contains(text(),'Salvar')]")
            ));
            botaoSalvar.click();

            Thread.sleep(2000); // só para ver o resultado antes de fechar
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    public static void selecionarMatSelect(WebDriver driver, WebDriverWait wait, String nomeCampo, String textoOpcao) {
        // Clica no mat-select
        WebElement campo = wait.until(ExpectedConditions.elementToBeClickable(By.name(nomeCampo)));
        campo.click();

        // Aguarda a opção aparecer e clica
        WebElement opcao = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//mat-option//span[normalize-space(text())='" + textoOpcao + "']")
        ));
        opcao.click();
    }
}