import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double allMoney = 0, investments = 0, moneyBox = 0, pillow = 0, pocketMoney = 0;
        double allInvestments = 0, allMoneyBox = 0, allPillow = 0, allPocketMoney = 0;
        System.out.println("Добро пожаловать! Что хотите сделать?");
        while (true) {
            System.out.println("1) Выберите деньги. 2) Узнать общее количество денег.");
            Scanner sc = new Scanner(System.in);
            int writeChose = sc.nextInt();
            if (writeChose != 1 && writeChose != 2) {
                System.out.println("Выберите 1 или 2!");
            }
            switch (writeChose) {
                case 1:
                    System.out.println("Введите сумму вложения: ");
                    double writeMoney = sc.nextDouble();
                    System.out.println("Выберите стратегию вложения:");
                    while (true) {
                        System.out.println("1) Инвестиции 50%, Копилки 30%, Подушка 10%, Карманные расходы 10%");
                        System.out.println("2) Инвестиции 50%, Копилки 40%, Подушка 10%");
                        int writeChoseDeposit = sc.nextInt();
                        if (writeChoseDeposit == 2) {
                            System.out.println("На инвестиции " + (investments = (writeMoney / 2)) + "₽");
                            System.out.println("В копилки " + (moneyBox = ((writeMoney / 100) * 40)) + "₽");
                            System.out.println("В подушку " + (pillow = ((writeMoney / 100) * 10)) + "₽");
                            allMoney += writeMoney;
                            allInvestments += investments;
                            allMoneyBox += moneyBox;
                            allPillow += pillow;
                            System.out.println("Всего денег : " + allMoney + "₽");
                            sc.nextLine();
                            break;
                        } else if (writeChoseDeposit == 1) {
                            System.out.println("На инвестиции " + (investments = (writeMoney / 2)) + "₽");
                            System.out.println("В копилки " + (moneyBox = ((writeMoney / 100) * 30)) + "₽");
                            System.out.println("В подушку " + (pillow = ((writeMoney / 100) * 10)) + "₽");
                            System.out.println("На карманные расходы " + (pocketMoney = ((writeMoney / 100) * 10)) + "₽");
                            allMoney += writeMoney;
                            allMoney += writeMoney;
                            allInvestments += investments;
                            allMoneyBox += moneyBox;
                            allPillow += pillow;
                            allPocketMoney += pocketMoney;
                            System.out.println("Всего денег : " + allMoney + "₽");
                            break;
                        } else {
                            System.out.println("Выберите 1 или 2!");
                        }
                    }
                    break;
                case 2:
                    System.out.println("Всего денег у вас на счетах: " + allMoney + "₽");
                    System.out.println("Хотите выбрать какую-то определённую категорию? 1) Да. 2) Нет");
                    int writeChoseAnyCategory = sc.nextInt();
                    if (writeChoseAnyCategory == 2) {
                        System.out.println("Возвращаю вас к выбору!");
                        break;
                    } else if (writeChoseAnyCategory == 1) {
                        System.out.println("1) Инвестиции. 2) Копилка. 3) Подушка. 4) Карманные расходы. 5) Всё сразу.");
                        int writeChoseCategory = sc.nextInt();
                        switch (writeChoseCategory) {
                            case 1:
                                System.out.println("В инвестициях: " + allInvestments + "₽");
                                break;
                            case 2:
                                System.out.println("В копилке: " + allMoneyBox + "₽");
                                break;
                            case 3:
                                System.out.println("В подушке: " + allPillow + "₽");
                                break;
                            case 4:
                                System.out.println("В корманных расхдах: " + allPocketMoney + "₽");
                                break;
                            case 5:
                                System.out.println("В инвестициях: " + investments + "₽");
                                System.out.println("В копилке: " + moneyBox + "₽");
                                System.out.println("В подушке: " + pillow + "₽");
                                System.out.println("На корманных расходах: " + pocketMoney + "₽");

                        }
                        break;
                    }
            }
            System.out.println("Желаете продолжить? 1) Да. 2) Нет.");
            int writeChoseToContResume = sc.nextInt();
            if (writeChoseToContResume == 1) {
                continue;
            } else {
                break;
            }
        }
    }
}
