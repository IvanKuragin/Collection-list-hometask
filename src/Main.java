import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<String> shopList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int addSum = 0;
        int listSum = 1;

        while (true) {
            System.out.println("Выберите операцию:");
            System.out.println("1. Добавить");
            System.out.println("2. Показать");
            System.out.println("3. Удалить");
            System.out.println("4. Найти");
            System.out.println("5. Завершить программу");
            String input = scanner.nextLine();
            int option = Integer.parseInt(input);
            if (option == 1) {
                while (true) {
                    System.out.println("Какую покупку хотите добавить?");
                    String input1 = scanner.nextLine();
                    shopList.add(input1);
                    System.out.println("Вы добавили " + input1);
                    addSum++;
                    System.out.println("Итого в списке покупок: " + addSum);
                    break;
                }
            }
            if (option == 2) {
                System.out.println("Ваш список покупок:");
                for (String shop : shopList) {
                    System.out.println((listSum++) + ". " + shop);
                }
            }
            if (option == 3) {
                while (true) {
                    int sum = 1;
                    System.out.println("Список покупок:");
                    for (String shop : shopList) {
                        System.out.println((sum++) + ". " + shop);
                    }
                    System.out.println("Какую хотите удалить? Введите номер или название?");
                    String input2 = scanner.nextLine();
                    boolean isInt = isInt(input2);
                    if (isInt) {
                        int removalChoice = Integer.parseInt(input2);
                        shopList.remove(removalChoice - 1);
                        System.out.println("Покупка " + (removalChoice - 1) + " удалена, список покупок:");
                    } else {
                        shopList.remove(input2);
                        System.out.println("Покупка " + (input2) + " удалена, список покупок:");
                    }
                    int sum2 = 1;
                    for (String shop : shopList) {
                        System.out.println((sum2++) + ". " + shop);
                    }
                    break;
                }
            }
            if (option == 4) {
                while (true) {
                    System.out.println("Введите текст для поиска:");
                    String input3 = scanner.nextLine();
                    String lowInput3 = input3.toLowerCase();
                    for (int i = 0; i < shopList.size(); i++) {
                        String shop = shopList.get(i);
                        String lowShop = shop.toLowerCase();
                        if (lowShop.contains(lowInput3)) {
                            System.out.println("Найдено:");
                            System.out.println((shopList.indexOf(shop) + 1) + ". " + shop);
                        }
                    }
                    break;
                }
            }
            if (option == 5) {
                break;
            }
        }
    }

    public static boolean isInt(String input2) {
        try {
            int removalChoice = Integer.parseInt(input2);
            if (removalChoice != 0) {
                return true;
            }
        } catch (NumberFormatException error) {
        }
        return false;
    }
}
