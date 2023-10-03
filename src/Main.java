import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static HashMap<String, Double> getHashMap() {
        HashMap<String, Double> allVariables = new HashMap<>();
        allVariables.put("allMoney", 0.0);
        allVariables.put("investments", 0.0);
        allVariables.put("moneyBox", 0.0);
        allVariables.put("pillow", 0.0);
        allVariables.put("pocketMoney", 0.0);
        allVariables.put("allInvestments", 0.0);
        allVariables.put("allMoneyBox", 0.0);
        allVariables.put("allPillow", 0.0);
        allVariables.put("allPocketMoney", 0.0);
        allVariables.put("flat", 0.0);
        return allVariables;
    }

    public static void main(String[] args) {
        Investments investmentsClass = new Investments();
        Scanner sc = new Scanner(System.in);
        User user = regOrLogIn(sc, investmentsClass);
        boolean flag = true;
        HashMap<String, Double> allVariables = getHashMap();
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
                        choseStrategy(sc, writeMoney, allVariables, flag);
                        break;

                    case 2:
                        System.out.println("Всего денег у вас на счетах: " + allVariables.get("allMoney") + "₽");
                        System.out.println("Хотите выбрать какую-то определённую категорию? " +
                                " Пересчетать самому.\n 1) Выбрать категорию. 2) Подсчитать самому. 3) Вернуться назад");
                        byte writeChoseAnyCategory = sc.nextByte();
                        checkAllMoneyAndCategory(sc, writeChoseAnyCategory, allVariables);
                        break;

                    case 3:
                        System.out.println("Введите свой никнейм");
                        String nickname = sc.nextLine();
                        investmentsClass.getUser(nickname);
                        System.out.println();
                        break;

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
                sc.nextLine();
            }
        }
    }

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

        System.out.println("Добро пожаловать! Это консольное приложение подскажет как правильно распреоделять ваши " +
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
                            sc.nextLine();
                        }
                    }
                    while (true) {
                        try {
                            System.out.println("Введите cколько у вас копилок: ");
                            userQuantityMoneyBox = sc.nextInt();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Вы ввели не число. Попробуйте ещё раз.");
                            sc.nextLine();
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
                            sc.nextLine();
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
                            sc.nextLine();
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
                            sc.nextLine();
                        }
                    }
                    while (true) {
                        try {
                            System.out.println("Введите сколько у вас всего свободных денег в данный момент: ");
                            userAllMoney = sc.nextInt();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Вы ввели не число. Попробуйте ещё раз.");
                            sc.nextLine();
                        }
                    }
                    if (allPercent != 100) {
                        flag1 = true;
                        System.out.println("Общая сумма процентов должна получится 100!");
                        allPercent = 0;
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

    public static void choseStrategy(Scanner sc, double writeMoney, HashMap<String, Double> allVariables, boolean flag) {
        while (true) {
            System.out.println("1) Инвестиции 50%, Копилки 40%, Подушка 10%, Корманные расходы 10%");
            System.out.println("2) Инвестиции 50%, Копилки 40%, Подушка 10%");
            System.out.println("3) Квартира 100%");
            System.out.println("4) Расчитать свои проценты");
            byte writeChoseDeposit = sc.nextByte();
            if (writeChoseDeposit == 1) {
                System.out.println("Введите количество ваших копилок: ");
                byte numberOfBanks1 = sc.nextByte();
                allVariables.put("investments", (Math.round(100 * (writeMoney / 2))) / 100.0);
                allVariables.put("moneyBox", (Math.round((100 * ((writeMoney / 100)) * 30) / numberOfBanks1)) / 100.0);
                allVariables.put("pillow", (Math.round(100 * (writeMoney / 10))) / 100.0);
                allVariables.put("pocketMoney", (Math.round(100 * (writeMoney / 10))) / 100.0);
                allVariables.put("allInvestments", allVariables.get("allInvestments") +
                        allVariables.get("investments"));
                allVariables.put("allMoneyBox", allVariables.get("allMoneyBox") + allVariables.get("moneyBox"));
                allVariables.put("allPillow", allVariables.get("allPillow") + allVariables.get("pillow"));
                allVariables.put("allPocketMoney", allVariables.get("allPocketMoney") +
                        allVariables.get("pocketMoney"));
                System.out.println("На ивестиции: " + allVariables.get("investments") + "₽");
                System.out.println("В каждую копилку: " + allVariables.get("moneyBox") + "₽");
                System.out.println("В подушку: " + allVariables.get("pillow") + "₽");
                System.out.println("На карманные расходы: " + allVariables.get("pocketMoney") + "₽");
                allVariables.put("allMoney", allVariables.get("allMoney") + allVariables.get("investments") +
                        allVariables.get("moneyBox") + allVariables.get("pillow") + allVariables.get("pocketMoney"));
                System.out.println("Всего денег: " + allVariables.get("allMoney") + "₽");
            } else if (writeChoseDeposit == 2) {
                System.out.println("Введите количество ваших копилок: ");
                byte numberOfBanks2 = sc.nextByte();
                allVariables.put("investments", (Math.round(100 * (writeMoney / 2)) / 100.0));
                allVariables.put("moneyBox", (Math.round((100 * ((writeMoney / 100) * 40)) / numberOfBanks2)) / 100.0);
                allVariables.put("pillow", (Math.round(100 * (writeMoney / 10))) / 100.0);
                allVariables.put("allInvestments", allVariables.get("allInvestments") +
                        allVariables.get("investments"));
                allVariables.put("allMoneyBox", allVariables.get("allMoneyBox") + allVariables.get("moneyBox"));
                allVariables.put("allPillow", allVariables.get("allPillow") + allVariables.get("pillow"));
                System.out.println("На ивестиции: " + allVariables.get("investments") + "₽");
                System.out.println("В каждую копилку: " + allVariables.get("moneyBox") + "₽");
                System.out.println("В подушку: " + allVariables.get("pillow") + "₽");
                allVariables.put("allMoney", allVariables.get("allMoney") + allVariables.get("investments") +
                        allVariables.get("moneyBox") + allVariables.get("pillow"));
                System.out.println("Всего денег: " + allVariables.get("allMoney") + "₽");
            } else if (writeChoseDeposit == 3) {
                allVariables.put("flat", (Math.round(writeMoney * 100) / 100.0));
                allVariables.put("allMoney", allVariables.get("allMoney") + allVariables.get("flat"));
                System.out.println("Всего денег: " + allVariables.get("allMoney") + "₽");
                System.out.println("Отличный выбор!");
            } else if (writeChoseDeposit == 4) {
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
                        allVariables.put("allInvestments", allVariables.get("allInvestments") +
                                allVariables.get("investments"));
                        allVariables.put("allMoneyBox", allVariables.get("allMoneyBox") + allVariables.get("moneyBox"));
                        allVariables.put("allPillow", allVariables.get("allPillow") + allVariables.get("pillow"));
                        allVariables.put("allPocketMoney", allVariables.get("allPocketMoney") +
                                allVariables.get("pocketMoney"));
                        System.out.println("На инвестиции " + allVariables.get("investments") + "₽");
                        System.out.println("В копилки " + +allVariables.get("moneyBox") + "₽");
                        System.out.println("В подушку " + allVariables.get("pillow") + "₽");
                        System.out.println("На карманные расходы " + allVariables.get("pocketMoney") + "₽");
                        allVariables.put("allMoney", allVariables.get("allMoney") + allVariables.get("moneyBox") +
                                allVariables.get("pillow") + allVariables.get("pocketMoney"));
                        System.out.println("Всего денег : " + allVariables.get("allMoney") + "₽");
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

    public static void checkAllMoneyAndCategory(Scanner sc, byte writeChoseAnyCategory, HashMap<String, Double>
            allVariables) {
        if (writeChoseAnyCategory == 3) {
            System.out.println("Возвращаю вас к выбору!");
        } else if (writeChoseAnyCategory == 1) {
            System.out.println("1) Инвестиции. 2) Копилка. 3) Подушка. 4) Карманные расходы. 5) Арнеда квартиры 6) Всё"
                    + " сразу.");
            byte writeChoseCategory = sc.nextByte();
            switch (writeChoseCategory) {
                case 1:
                    System.out.println("В инвестициях: " + allVariables.get("allInvestments") + "₽");
                    break;
                case 2:
                    System.out.println("В копилке: " + allVariables.get("allMoneyBox")+ "₽");
                    break;
                case 3:
                    System.out.println("В подушке: " + allVariables.get("allPillow") + "₽");
                    break;
                case 4:
                    System.out.println("В корманных расхдах: " + allVariables.get("allPocketMoney") + "₽");
                    break;
                case 5:
                    System.out.println("На аренду квартиры: " + allVariables.get("flat") + "₽");
                    break;
                case 6:
                    System.out.println("В инвестициях: " + (allVariables.get("allInvestments")) + "₽");
                    System.out.println("В копилке: " + allVariables.get("allMoneyBox") + "₽");
                    System.out.println("В подушке: " + allVariables.get("allPillow") + "₽");
                    System.out.println("На корманных расходах: " + allVariables.get("allPocketMoney") + "₽");
                    System.out.println("На аренду квартиры: " + allVariables.get("flat") + "₽");
                    break;
            }
        } else if (writeChoseAnyCategory == 2) {
            System.out.println("Напишите сколько денег у вас в инвестициях: ");
            allVariables.put("allInvestments", sc.nextDouble());
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
            allVariables.put("allMoneyBox" , countMoney);
            System.out.println("Напишите сколько денег у вас в подушке: ");
            allVariables.put("allPillow", sc.nextDouble());
            System.out.println("Напишите сколько денег у вас в корманных расходах: ");
            allVariables.put("allPocketMoney", sc.nextDouble());
            System.out.println("Напишите сколько денег у вас на квартиру: ");
            allVariables.put("flat", sc.nextDouble());
            System.out.println("Всего в инвестициях: " + allVariables.get("allInvestments"));
            for (Map.Entry<String, Double> entry : calledMoneyBoxMas.entrySet()) {
                System.out.println(entry.getValue() + "₽., в копилке на " + entry.getKey());
            }
            System.out.println("Всего в копилках: " + allVariables.get("allMoneyBox") + "₽");
            System.out.println("Всего в подушке: " + allVariables.get("allPillow") + "₽");
            System.out.println("Всего в корманных расходах: " + allVariables.get("allPocketMoney") + "₽");
            System.out.println("Всего на аренду квартиру: " + allVariables.get("flat") + "₽");
            allVariables.put("allMoney", allVariables.get("allInvestments") + allVariables.get("allMoneyBox") +
                    allVariables.get("allPillow") + allVariables.get("allPocketMoney") + allVariables.get("flat"));
            System.out.println("Всего денег: " + allVariables.get("allMoney") + "₽");
        }
    }
}