package com.baeldung.springsoap;

import com.example.consumingwebservice.wsdl.GetCountryResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
public class CountryController {
    private CountryClient countryClient;
    private Random random = new Random();
    private List<String> strings = Arrays.asList("UK", "Poland", "Spain");

    public CountryController(final CountryClient countryClient) {
        this.countryClient = countryClient;
    }

    @GetMapping("/")
    public GetCountryResponse getCountry() {
        return countryClient.getCountry(strings.get(random.nextInt(3)));
    }
}
