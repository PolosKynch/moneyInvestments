import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean flag = true;
        double allMoney = 0, investments = 0, moneyBox = 0, pillow = 0, pocketMoney = 0;
        double allInvestments = 0, allMoneyBox = 0, allPillow = 0, allPocketMoney = 0;
        System.out.println("Добро пожаловать! Что хотите сделать?");
        while (true) {
            System.out.println("1) Выберите деньги. 2) Узнать общее количество денег.");
            Scanner sc = new Scanner(System.in);
            byte writeChose = sc.nextByte();
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
                        System.out.println("3) Расчитать свои проценты");
                        byte writeChoseDeposit = sc.nextByte();
                        if (writeChoseDeposit == 1) {
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
                            sc.nextLine();
                        } else if (writeChoseDeposit == 2) {
                            System.out.println("На инвестиции " + (investments = (writeMoney / 2)) + "₽");
                            System.out.println("В копилки " + (moneyBox = ((writeMoney / 100) * 40)) + "₽");
                            System.out.println("В подушку " + (pillow = ((writeMoney / 100) * 10)) + "₽");
                            allMoney += writeMoney;
                            allInvestments += investments;
                            allMoneyBox += moneyBox;
                            allPillow += pillow;
                            System.out.println("Всего денег : " + allMoney + "₽");
                            sc.nextLine();
                            System.out.println("Всего денег : " + allMoney + "₽");
                        } else if (writeChoseDeposit == 3) {
                            while (true) {
                                System.out.println("Напишите сколько процентов вы хотите вкладывать в инвестиции: ");
                                byte chosePercentInvestments = sc.nextByte();
                                System.out.println("Напишите сколько процентов вы хотите вкладывать в копилки:");
                                byte chosePercentMoneyBox = sc.nextByte();
                                System.out.println("Напишите сколько процентов вы хотите вкладывать в подушку:");
                                byte chosePercentPillow = sc.nextByte();
                                System.out.println("Напишите сколько процентов вы хотите оставить на карманные расходы:");
                                byte chosePercentPocketMoney = sc.nextByte();
                                if (chosePercentInvestments + chosePercentPillow + chosePercentPocketMoney +
                                        chosePercentMoneyBox != 100) {
                                    System.out.println("Всего должно получиться 100 процентов!");
                                } else {
                                    System.out.println("На инвестиции " + (investments = (writeMoney / 100 *
                                            chosePercentInvestments)) + "₽");
                                    System.out.println("В копилки " + (moneyBox = ((writeMoney / 100) *
                                            chosePercentMoneyBox)) + "₽");
                                    System.out.println("В подушку " + (pillow = ((writeMoney / 100) *
                                            chosePercentPillow)) + "₽");
                                    System.out.println("На карманные расходы " + (pocketMoney = ((writeMoney / 100) *
                                            chosePercentPocketMoney)) + "₽");
                                    allMoney += writeMoney;
                                    allInvestments += investments;
                                    allMoneyBox += moneyBox;
                                    allPillow += pillow;
                                    allPocketMoney += pocketMoney;
                                    System.out.println("Всего денег : " + allMoney + "₽");
                                }
                                System.out.println("Расчитать ещё раз? 1) Да. 2) Нет.");
                                byte choseContinue = sc.nextByte();
                                if (choseContinue == 1) {
                                    flag = false;
                                } else {
                                    flag = true;
                                }
                                if (flag) {
                                    break;
                                } else {
                                    continue;
                                }
                            }
                        }
                        if (flag) {
                            break;
                        } else {
                            continue;
                        }
                    }
                    break;

                case 2:
                    System.out.println("Всего денег у вас на счетах: " + allMoney + "₽");
                    System.out.println("Хотите выбрать какую-то определённую категорию? 1) Да. 2) Нет");
                    byte writeChoseAnyCategory = sc.nextByte();
                    if (writeChoseAnyCategory == 2) {
                        System.out.println("Возвращаю вас к выбору!");
                        break;
                    } else if (writeChoseAnyCategory == 1) {
                        System.out.println("1) Инвестиции. 2) Копилка. 3) Подушка. 4) Карманные расходы. 5) Всё сразу.");
                        byte writeChoseCategory = sc.nextByte();
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
            byte writeChoseToContResume = sc.nextByte();
            if (writeChoseToContResume == 1) {
                continue;
            } else {
                break;
            }
        }
    }
}
