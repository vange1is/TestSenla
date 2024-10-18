package currencyconverter;

import java.util.Scanner;

public class ConverterApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CurrencyRates currencyRates = new CurrencyRates();
        CurrencyConverter converter = new CurrencyConverter(currencyRates);

        System.out.println("Добро пожаловать в программу конвертации валют!");
        System.out.println("Доступные валюты: USD, EUR, GBP, JPY, RUB");

        System.out.print("Введите сумму в валюте (например, 100 USD): ");
        double amount = scanner.nextDouble();
        String fromCurrency = scanner.next().toUpperCase();

        System.out.println("Выберите валюту для конвертации (USD, EUR, GBP, JPY, RUB): ");
        String toCurrency = scanner.next().toUpperCase();

        double result = converter.convert(amount, fromCurrency, toCurrency);
        if (result != -1) {
            System.out.printf("%.2f %s = %.2f %s\n", amount, fromCurrency, result, toCurrency);
        } else {
            System.out.println("Ошибка: введена неверная валюта.");
        }

        scanner.close();
    }
}
