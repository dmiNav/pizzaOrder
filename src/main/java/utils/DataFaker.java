package utils;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import models.User;

import java.util.Locale;

public class DataFaker {

    private Faker faker;
    private FakeValuesService fakeValuesService;

    public DataFaker() {
        faker = new Faker();
        fakeValuesService = new FakeValuesService(
                new Locale("en-GB"), new RandomService());
    }

    public User getUser() {
        return new User(
                faker.name().fullName(),
                faker.internet().emailAddress(),
                faker.address().fullAddress(),
                faker.phoneNumber().cellPhone()
        );
    }
}
