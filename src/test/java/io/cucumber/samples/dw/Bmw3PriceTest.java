package io.cucumber.samples.dw;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(features = {"classpath:features/search_bmw_3_gt.feature"}
, glue = {"io.cucumber.samples.dw.steps"}
, tags = "@BMW3GT"
)
public class Bmw3PriceTest {

}
