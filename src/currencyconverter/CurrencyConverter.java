package currencyconverter;
public class CurrencyConverter {
    private final CurrencyRates rates;

    public CurrencyConverter(CurrencyRates rates) {
        this.rates = rates;
    }

    public double convert(double amount, String fromCurrency, String toCurrency) {
        double fromRate = rates.getRate(fromCurrency);
        double toRate = rates.getRate(toCurrency);

        if (fromRate == -1 || toRate == -1) {
            return -1; // Возвращаем -1 в случае некорректной валюты
        }

        // Конвертация валюты
        double amountInBase = amount / fromRate;
        return amountInBase * toRate;
    }
}