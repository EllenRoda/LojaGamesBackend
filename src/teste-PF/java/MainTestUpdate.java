import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/*public class MainTestUpdate {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            driver.get("http://localhost:4200/products");
            driver.manage().window().maximize();

            // Aguarda a tabela ou lista de produtos carregar
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("table"))); // Ajuste conforme seu HTML

            // Localiza o produto que você quer atualizar (exemplo: Produto Teste)
            WebElement produtoLinha = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[td[contains(text(),'Produto Teste')]]")));

            // Clica no botão Editar da linha do produto (ajuste o XPath conforme seu front-end)
            WebElement btnEditar = produtoLinha.findElement(By.xpath(".//button[contains(text(),'Editar')]"));
            btnEditar.click();

            // Espera o formulário de edição abrir (pode usar um campo que só existe no form)
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("proNome")));

            // Atualiza os campos desejados
            WebElement campoNome = driver.findElement(By.name("proNome"));
            campoNome.clear();
            campoNome.sendKeys("Produto Teste Atualizado");

            WebElement campoPrecoVenda = driver.findElement(By.name("proPrecoVenda"));
            campoPrecoVenda.clear();
            campoPrecoVenda.sendKeys("50");

            WebElement campoDescricao = driver.findElement(By.name("proDescricao"));
            campoDescricao.clear();
            campoDescricao.sendKeys("Mouse Sem Fio Atualizado");

            // Atualizar a Data, se quiser
            WebElement dataInput = driver.findElement(By.name("proDataCadastro"));
            dataInput.clear();
            dataInput.sendKeys("06/23/2025");

            // Atualizar da Data
            WebElement dataInput = driver.findElement(By.name("proDataAtualizacao"));
            dataInput.sendKeys("06/23/2025");

            // Clica no botão Salvar / Atualizar
            WebElement btnSalvar = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Salvar') or contains(text(),'Atualizar')]")));
            btnSalvar.click();

            // Só pra ver o resultado
            Thread.sleep(4000);

            try {
                // Código que pode lançar exceção
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}*/
