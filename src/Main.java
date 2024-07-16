import java.util.Scanner;

class Калькулятор {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Введите пример в формате 'a+b', 'a-b', 'a*b', 'a/b': ");
            String input = scanner.nextLine();

            String[] parts = input.split("");
            if (parts.length != 3) {
                throw new IllegalArgumentException("Неверный формат.");
            }

            int a = Integer.parseInt(parts[0]);
            int b = Integer.parseInt(parts[2]);

            if (a < 1 || a > 10 || b < 1 || b > 10) {
                throw new IllegalArgumentException("Числа должны быть в диапазоне от 1 до 10.");
            }

            int result;
            switch (parts[1]) {
                case "+":
                    result = a + b;
                    break;
                case "-":
                    result = a - b;
                    break;
                case "*":
                    result = a * b;
                    break;
                case "/":
                    if (b == 0) {
                        throw new ArithmeticException("Деление на ноль невозможно.");
                    }
                    result = a / b; // Отбрасывание остатка
                    break;
                default:
                    throw new IllegalArgumentException("Неверный оператор.");
            }

            System.out.println("Результат: " + result);

        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}
