package net.alepuzio.springsoap.server;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import net.alepuzio.springsoap.Country;
import net.alepuzio.springsoap.Currency;



/*
 * https://spring.io/guides/gs/producing-web-service/
 * */
@Component
public class CountryRepository {
	
	private static final Map<String, Country> countries = new HashMap<String, Country>();

	@PostConstruct
	public void initDataMock() {
		Country spain = new Country();
		spain.setName("Spain");
		spain.setCapital("Madrid");
		spain.setCurrency(Currency.EUR);
		spain.setPopulation(46704314);
		countries.put(spain.getName(), spain);
		Country poland = new Country();
		poland.setName("Poland");
		poland.setCapital("Warsaw");
		poland.setCurrency(Currency.PLN);
		poland.setPopulation(38186860);
		countries.put(poland.getName(), poland);
		Country uk = new Country();
		uk.setName("United Kingdom");
		uk.setCapital("London");
		uk.setCurrency(Currency.GBP);
		uk.setPopulation(63705000);
		countries.put(uk.getName(), uk);
	}

	public Country findCountry(String name) {
		System.out.println(String.format("CountryRepository.findCountry(%s)", name));
		System.out.println(String.format("(%s) is null? %s", name, ""+(null == name)));
		System.out.println(String.format("(%s) is empty? %s", name, ""+name.isEmpty()));
		Assert.notNull(name, "The country's name must not be null");
		return countries.get(name);
	}
}