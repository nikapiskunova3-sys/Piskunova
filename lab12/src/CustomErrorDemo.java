class InvalidAgeException extends RuntimeException {
    public InvalidAgeException(String description) {
        super("Ошибка возраста: " + description);
    }
}

class InvalidNameException extends Exception {
    public InvalidNameException(String description) {
        super("Ошибка имени: " + description);
    }
}

public class CustomErrorDemo {

    private void checkAge(int age) {
        if (age < 0) {
            throw new InvalidAgeException("Возраст не может быть отрицательным");
        }

        if (age > 150) {
            throw new InvalidAgeException("Возраст слишком велик");
        }

        if (age < 18) {
            throw new InvalidAgeException("Требуется возраст 18+");
        }

        System.out.println("Возраст " + age + " лет - допустим");
    }

    private void checkName(String name) throws InvalidNameException {
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidNameException("Имя не может быть пустым");
        }

        if (name.length() < 2) {
            throw new InvalidNameException("Имя слишком короткое");
        }

        if (name.length() > 50) {
            throw new InvalidNameException("Имя слишком длинное");
        }

        System.out.println("Имя '" + name + "' - корректно");
    }

    public void validateData() {
        System.out.println("=== Валидация персональных данных ===");

        // Проверка возраста (RuntimeException)
        try {
            checkAge(25);
            checkAge(-5);
        } catch (InvalidAgeException ageError) {
            System.out.println(ageError.getMessage());
        }

        // Проверка имени (Checked Exception)
        try {
            checkName("Александр");
            checkName("");
        } catch (InvalidNameException nameError) {
            System.out.println(nameError.getMessage());
        }

        System.out.println("\nВалидация завершена");
    }

    public static void main(String[] args) {
        CustomErrorDemo validator = new CustomErrorDemo();
        validator.validateData();
    }
}
