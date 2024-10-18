package passwordgenerator;

import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator {

    // Символы, из которых будет генерироваться пароль
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_+=<>?";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Запрос длины пароля от пользователя
        System.out.println("Введите желаемую длину пароля (от 8 до 12 символов): ");
        int length = scanner.nextInt();

        // Проверка, что длина пароля в допустимом диапазоне
        while (length < 8 || length > 12) {
            System.out.println("Неверная длина. Введите длину пароля от 8 до 12 символов: ");
            length = scanner.nextInt();
        }

        // Генерация пароля
        String password = generatePassword(length, random);
        System.out.println("Ваш случайный пароль: " + password);

        scanner.close();
    }

    // Метод генерации случайного пароля
    private static String generatePassword(int length, Random random) {
        StringBuilder password = new StringBuilder(length);

        // Гарантируем, что пароль содержит хотя бы один символ каждого типа
        password.append(UPPERCASE.charAt(random.nextInt(UPPERCASE.length())));
        password.append(LOWERCASE.charAt(random.nextInt(LOWERCASE.length())));
        password.append(DIGITS.charAt(random.nextInt(DIGITS.length())));
        password.append(SPECIAL_CHARACTERS.charAt(random.nextInt(SPECIAL_CHARACTERS.length())));

        // Генерируем оставшиеся символы из всех допустимых категорий
        String allCharacters = UPPERCASE + LOWERCASE + DIGITS + SPECIAL_CHARACTERS;
        for (int i = 4; i < length; i++) {
            password.append(allCharacters.charAt(random.nextInt(allCharacters.length())));
        }

        // Перемешиваем символы, чтобы не было предсказуемой последовательности
        return shuffleString(password.toString(), random);
    }

    // Метод для перемешивания символов в строке
    private static String shuffleString(String input, Random random) {
        char[] characters = input.toCharArray();
        for (int i = 0; i < characters.length; i++) {
            int randomIndex = random.nextInt(characters.length);
            char temp = characters[i];
            characters[i] = characters[randomIndex];
            characters[randomIndex] = temp;
        }
        return new String(characters);
    }
}
