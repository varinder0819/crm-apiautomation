package RunnerFile;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/resources/features",
        glue ={"com/api/autonmation/stepdefinition"},
        tags = "@set2"
)

public class RunnerFile {


}