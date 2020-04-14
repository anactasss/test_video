import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        strict = true,
        features = "src/test/java/features",
        glue = "ru.yandex.test",
        tags = "@hometask"
)

public class CucumberRunner {
}
