import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static User regOrLogIn(Scanner sc, Investments investments) {
        User createUser = new User();
        boolean flag = true;
        boolean flag1 = true;
        String userNickname = "";
        String userEmail = "";
        String userPassword = "";
        int userInvestmentsPercent = 0;
        int userQuantityMoneyBox = 0;
        int userMoneyBoxPercent = 0;
        int userPillowPercent = 0;
        int userPocketMoneyPercent = 0;
        int allPercent = 0;
        int userAllMoney = 0;

        System.out.println("Добро пожаловать! Это консольное приложение подскажет как правильно распреоделять твои " +
                "деньги, ну или просто поможет удобнее распреоделять ваши деньги!\nЕсли у вас нет профиля напишите 1" +
                ", если у вас уже есть профиль напишете 2");
        while (flag) {
            int choseRegistration = sc.nextInt();
            sc.nextLine();
            if (choseRegistration == 1) {
                while (true) {
                    try {
                        System.out.println("Введите свой никнейм: ");
                        userNickname = sc.nextLine();
                        break;
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
                while (true) {
                    try {
                        System.out.println("Введите свой email: ");
                        userEmail = sc.nextLine();
                        break;
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
                //Viktor.Sinitsyn@homecredit.ru
                //ruslan.nevzorov@homecredit.ru
                while (true) {
                    try {
                        System.out.println("Введите свой пароль: ");
                        userPassword = sc.nextLine();
                        break;
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
                while (flag1) {
                    while (true) {
                        try {
                            System.out.println("Введите процент который вы бы хотели откладывать в инвестиции: ");
                            userInvestmentsPercent = sc.nextInt();
                            allPercent += userInvestmentsPercent;
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Вы ввели не число. Попробуйте ещё раз.");
                        }
                    }
                    while (true) {
                        try {
                            System.out.println("Введите cколько у вас копилок: ");
                            userQuantityMoneyBox = sc.nextInt();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Вы ввели не число. Попробуйте ещё раз.");
                        }
                    }
                    while (true) {
                        try {
                            System.out.println("Введите процент который вы бы хотели откладывать в копилки: ");
                            userMoneyBoxPercent = sc.nextInt();
                            allPercent += userMoneyBoxPercent;
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Вы ввели не число. Попробуйте ещё раз.");
                        }
                    }
                    while (true) {
                        try {
                            System.out.println("Введите процент который вы бы хотели откладывать в подушку: ");
                            userPillowPercent = sc.nextInt();
                            allPercent += userPillowPercent;
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Вы ввели не число. Попробуйте ещё раз.");
                        }
                    }
                    while (true) {
                        try {
                            System.out.println("Введите процент который вы бы хотели откладывать на корманные расходы: ");
                            userPocketMoneyPercent = sc.nextInt();
                            allPercent += userPocketMoneyPercent;
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Вы ввели не число. Попробуйте ещё раз.");
                        }
                    }
                    while (true) {
                        try {
                            System.out.println("Введите сколько у вас всего свободных денег в данный момент: ");
                            userAllMoney = sc.nextInt();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Вы ввели не число. Попробуйте ещё раз.");
                        }
                    }
                    if (allPercent != 100) {
                        flag1 = true;
                        System.out.println("Общая сумма процентов должна получится 100!");
                    } else {
                        flag1 = false;
                    }
                }
                createUser = new User(userNickname, userEmail, userPassword, userInvestmentsPercent,
                        userQuantityMoneyBox, userMoneyBoxPercent, userPillowPercent, userPocketMoneyPercent,
                        userAllMoney);
                investments.addUser(createUser);
                flag = false;
            } else if (choseRegistration == 2) {
                while (true) {
                    try {
                        System.out.println("Напишите ваш никнейм: ");
                        userNickname = sc.nextLine();
                        break;
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
//                while (true) {
//                    try {
//                        System.out.println("Напишите ваш email: ");
//                        userEmail = sc.nextLine();
//                        break;
//                    } catch (Exception e) {
//                        System.out.println(e);
//                    }
//                }
                while (true) {
                    try {
                        System.out.println("Напишите ваш пароль: ");
                        userPassword = sc.nextLine();
                        break;
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }

                createUser = investments.checkUser(userNickname, userPassword);
                flag = false;

            } else {
                System.out.println("Выберите либо регистрацию нажав 1, либо авторизацию нажав 2");
            }
        }
        return createUser;
    }

    public static void choseStrategy(Scanner sc, double allMoney, double investmentsOnUse, double investments, double
            moneyBox, double pillow, double pocketMoney, double allInvestments, double allMoneyBox, double allPillow,
                                     double allPocketMoney, double writeMoney, boolean flag) {
        while (true) {
            System.out.println("1) Инвестиции 50%, Копилки 30%, Подушка 10%, Карманные расходы 10%");
            System.out.println("2) Инвестиции 50%, Копилки 40%, Подушка 10%");
            System.out.println("3) Расчитать свои проценты");
            byte writeChoseDeposit = sc.nextByte();
            if (writeChoseDeposit == 1) {
                System.out.println("Введите количество ваших копилок: ");
                byte countMoneyBox = sc.nextByte();
                System.out.println("На инвестиции " + (investmentsOnUse = (writeMoney / 2)) + "₽");
                System.out.println("В ваши " + countMoneyBox + " копилку/копилки " +
                        (moneyBox = (((writeMoney / 100) * 30)) / countMoneyBox) + "₽");
                moneyBox *= countMoneyBox;
                System.out.println("В подушку " + (pillow = ((writeMoney / 100) * 10)) + "₽");
                System.out.println("На карманные расходы " + (pocketMoney = ((writeMoney / 100) * 10))
                        + "₽");
                allMoney += writeMoney;
                allInvestments += (investmentsOnUse + investments);
                allMoneyBox += moneyBox;
                allPillow += pillow;
                allPocketMoney += pocketMoney;
            } else if (writeChoseDeposit == 2) {
                System.out.println("Введите количество ваших копилок: ");
                byte countMoneyBox = sc.nextByte();
                System.out.println("На инвестиции " + (investmentsOnUse = (writeMoney / 2)) + "₽");
                System.out.println("В ваши " + countMoneyBox + " копилку/копилки " +
                        (moneyBox = (((writeMoney / 100) * 40)) / countMoneyBox) + "₽");
                moneyBox *= countMoneyBox;
                System.out.println("В подушку " + (pillow = ((writeMoney / 100) * 10)) + "₽");
                allMoney += writeMoney;
                allInvestments += (investmentsOnUse + investments);
                allMoneyBox += moneyBox;
                allPillow += pillow;
                System.out.println("Всего денег : " + allMoney + "₽");
            } else if (writeChoseDeposit == 3) {
                while (true) {
                    System.out.println("Напишите сколько процентов вы хотите вкладывать в инвестиции: ");
                    byte chosePercentInvestments = sc.nextByte();
                    System.out.println("Напишите сколько процентов вы хотите вкладывать в копилки:");
                    byte chosePercentMoneyBox = sc.nextByte();
                    System.out.println("Напишите сколько процентов вы хотите вкладывать в подушку:");
                    byte chosePercentPillow = sc.nextByte();
                    System.out.println("Напишите сколько процентов вы хотите оставить на карманные " +
                            "расходы:");
                    byte chosePercentPocketMoney = sc.nextByte();
                    if (chosePercentInvestments + chosePercentPillow + chosePercentPocketMoney +
                            chosePercentMoneyBox != 100) {
                        System.out.println("Всего должно получиться 100 процентов!");
                    } else {
                        System.out.println("На инвестиции " + (investmentsOnUse = (writeMoney / 100 *
                                chosePercentInvestments)) + "₽");
                        System.out.println("В копилки " + (moneyBox = ((writeMoney / 100) *
                                chosePercentMoneyBox)) + "₽");
                        System.out.println("В подушку " + (pillow = ((writeMoney / 100) *
                                chosePercentPillow)) + "₽");
                        System.out.println("На карманные расходы " + (pocketMoney = ((writeMoney / 100) *
                                chosePercentPocketMoney)) + "₽");
                        allMoney += writeMoney;
                        allInvestments += (investmentsOnUse + investments);
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
    }


    public static void main(String[] args) {
        Investments investmentsClass = new Investments();
        Scanner sc = new Scanner(System.in);
        User user = regOrLogIn(sc, investmentsClass);
        boolean flag = true;
        // планирую заменить на HashMap
        double allMoney = 0, investmentsOnUse = 0, investments = 0, moneyBox = 0, pillow = 0, pocketMoney = 0;
        double allInvestments = 0, allMoneyBox = 0, allPillow = 0, allPocketMoney = 0;

//        user = new User("Polos", "Egorb5162@gmail.com", "1234a", 10,
//                1, 50, 10, 30, 1000000);
        investmentsClass.addUser(user);


        while (true) {
            System.out.println("1) Произвести расчёт депозита. 2) Узнать общее количество денег. 3) Вывести список " +
                    "пользователей.");
            try {
                byte writeChose = sc.nextByte();
                sc.nextLine();
                if (writeChose != 1 && writeChose != 2 && writeChose != 3) {
                    System.out.println("Выберите 1 или 2 или 3!");
                }
                switch (writeChose) {
                    case 1:
                        System.out.println("Введите сумму вложения: ");
                        double writeMoney = sc.nextDouble();
                        System.out.println("Выберите стратегию вложения:");
                        choseStrategy(sc, allMoney, investmentsOnUse, investments, moneyBox, pillow, pocketMoney,
                                allInvestments, allMoneyBox, allPillow, allPocketMoney, writeMoney, flag); //
                        break;

                    case 3:
                        System.out.println(investmentsClass.getUsersArrayList());
                        break;

                    case 4:
                        System.out.println("Введите свой никнейм");
                        String nickname = sc.nextLine();
                        investmentsClass.getUser(nickname);
                        System.out.println();

                        break;

                    case 2:
                        System.out.println("Всего денег у вас на счетах: " + allMoney + "₽");
                        System.out.println("Хотите выбрать какую-то определённую категорию? " +
                                " Пересчетать самому.\n 1) Выбрать категорию. 2) Подсчитать самому. 3) Вернуться назад");
                        byte writeChoseAnyCategory = sc.nextByte();
                        if (writeChoseAnyCategory == 3) {
                            System.out.println("Возвращаю вас к выбору!");
                            break;
                        } else if (writeChoseAnyCategory == 1) {
                            System.out.println("1) Инвестиции. 2) Копилка. 3) Подушка. 4) Карманные расходы. 5) Всё" +
                                    " сразу.");
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
                                    System.out.println("В инвестициях: " + (investmentsOnUse + investments) + "₽");
                                    System.out.println("В копилке: " + moneyBox + "₽");
                                    System.out.println("В подушке: " + pillow + "₽");
                                    System.out.println("На корманных расходах: " + pocketMoney + "₽");

                            }
                            break;
                        } else if (writeChoseAnyCategory == 2) {
                            System.out.println("Напишите сколько денег у вас в инвестициях: ");
                            investmentsOnUse = sc.nextDouble();
                            System.out.println("Напишите сколько денег у вас в инвестиционном портфеле: ");
                            investments = sc.nextDouble();
                            allInvestments = (investments + investmentsOnUse);
                            System.out.println("Напишите количество копилок, а после напишите их названия || " +
                                    "пример: \"Название\", после количество денег в ней, названий должно быть столько" +
                                    " же сколько и копилок!");
                            byte countMoneyBox = sc.nextByte();
                            double countMoney = 0;
                            HashMap<String, Double> calledMoneyBoxMas = new HashMap<>();
                            sc.nextLine();
                            for (int i = 0; i < countMoneyBox; i++) {
                                System.out.println("Напишите название копилки: ");
                                String calledMoneyBox = sc.next();
                                System.out.println("Напишите количество денег в копилке: ");
                                double moneyInMoneyBox = sc.nextDouble();
                                countMoney += moneyInMoneyBox;
                                calledMoneyBoxMas.put(calledMoneyBox, moneyInMoneyBox);
                            }
                            allMoneyBox = countMoney;
                            System.out.println("Напишите сколько денег у вас в подушке: ");
                            allPillow = sc.nextDouble();
                            System.out.println("Напишите сколько денег у вас в корманных расходах: ");
                            allPocketMoney = sc.nextDouble();
                            System.out.println("Всего в инвестициях: " + allInvestments);
                            for (Map.Entry<String, Double> entry : calledMoneyBoxMas.entrySet()) {
                                System.out.println(entry.getValue() + "₽., в копилке на " + entry.getKey());
                            }
                            System.out.println("Всего в копилках: " + allMoneyBox + "₽");
                            System.out.println("Всего в подушке: " + allPillow + "₽");
                            System.out.println("Всего в корманных расходах: " + allPocketMoney + "₽");
                            System.out.println("Всего денег: " + (allMoney = (allInvestments + allMoneyBox + allPillow +
                                    allPocketMoney)));
                        }
                }
                System.out.println("Желаете продолжить? 1) Да. 2) Нет.");
                byte writeChoseToContResume = sc.nextByte();
                if (writeChoseToContResume == 1) {
                    continue;
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Ошибка! Нужно писать текст только там где просят!");
            }
        }
    }
}