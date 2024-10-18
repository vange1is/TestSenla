package currencyconverter;
import java.util.HashMap;
import java.util.Map;

public class CurrencyRates {
    private final Map<String, Double> exchangeRates;

    public CurrencyRates() {
        exchangeRates = new HashMap<>();
        // Устанавливаем курсы валют относительно одной базы (например, USD)
        exchangeRates.put("USD", 1.0);  // Базовая валюта
        exchangeRates.put("EUR", 0.85); // 1 USD = 0.85 EUR
        exchangeRates.put("GBP", 0.75); // 1 USD = 0.75 GBP
        exchangeRates.put("JPY", 110.0); // 1 USD = 110.00 JPY
        exchangeRates.put("RUB", 74.0);  // 1 USD = 74.00 RUB
    }

    public double getRate(String currency) {
        return exchangeRates.getOrDefault(currency, -1.0); // Если валюта не найдена, возвращаем -1
    }
}