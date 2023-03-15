package utils;

import java.util.Random;

public class UserGenerator {
    private static final String[] SURNAMES = {"Smith", "Johnson", "Brown", "Davis", "Garcia", "Wilson", "Martinez", "Anderson", "Taylor", "Thomas", "Jackson", "White", "Harris", "Martin", "Thompson", "Moore", "Walker", "Allen", "Young", "King", "Wright", "Scott", "Green", "Baker", "Adams"};
    private static final String[] NAMES = {"Alice", "Bob", "Charlie", "David", "Emily", "Frank", "Grace", "Henry", "Isabella", "Jack", "Kate", "Liam", "Mia", "Nathan", "Olivia", "Peter", "Quinn", "Rachel", "Sophia", "Thomas", "Ursula", "Victoria", "William", "Xavier", "Yvonne", "Zachary"};
    private static final String[] DOMAINS = {"gmail.com", "yahoo.com", "hotmail.com", "outlook.com", "aol.com", "icloud.com", "protonmail.com", "mail.ru", "yandex.ru"};
    private static final Random RAND = new Random();

    public static String generateName() {
        int index = RAND.nextInt(NAMES.length);
        return NAMES[index];
    }

    public static String generatePassword() {
        int index = RAND.nextInt(SURNAMES.length);
        return SURNAMES[index];
    }

    public static String generateEmail() {
        int nameIndex = RAND.nextInt(NAMES.length);
        String name = SURNAMES[nameIndex];
        String domain = DOMAINS[RAND.nextInt(DOMAINS.length)];
        return name + "@" + domain;
    }
}
