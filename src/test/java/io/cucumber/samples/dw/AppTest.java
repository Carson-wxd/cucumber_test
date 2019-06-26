package io.cucumber.samples.dw;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
plugin = {"json:target/json-report/do.json","pretty","html:target/html-report/"}
, features = {"classpath:features/test.feature"}
, glue = {"io.cucumber.samples.dw.steps"}
, tags = "@Test"
)
public class AppTest {

}
