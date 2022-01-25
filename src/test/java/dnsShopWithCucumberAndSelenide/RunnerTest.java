package dnsShopWithCucumberAndSelenide;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/features/dnsShop.feature",
        glue = "dnsShopWithCucumberAndSelenide"
)

public class RunnerTest {
}