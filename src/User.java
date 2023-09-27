public class User {
    private String nickname;
    private String email;
    private String password;
    private int investmentsPercent;
    private int quantityMoneyBox;
    private int moneyBoxPercent;
    private int pillowPercent;
    private int pocketMoneyPercent;
    private int allMoneyUser;

    public User(String nickname, String email, String password, int investmentsPercent, int quantityMoneyBox,
                int moneyBoxPercent, int pillowPercent, int pocketMoneyPercent, int allMoneyUser) {
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.investmentsPercent = investmentsPercent;
        this.quantityMoneyBox = quantityMoneyBox;
        this.moneyBoxPercent = moneyBoxPercent;
        this.pillowPercent = pillowPercent;
        this.pocketMoneyPercent = pocketMoneyPercent;
        this.allMoneyUser = allMoneyUser;
    }



    public User(String nickname, String email, String password) {
        this.nickname = nickname;
        this.email = email;
        this.password = password;
    }

    public User() {

    }


    public String getNickname() {
        return nickname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getInvestmentsPercent() {
        return investmentsPercent;
    }

    public int getQuantityMoneyBox() {
        return quantityMoneyBox;
    }

    public int getMoneyBoxPercent() {
        return moneyBoxPercent;
    }

    public int getPillowPercent() {
        return pillowPercent;
    }

    public int getPocketMoneyPercent() {
        return pocketMoneyPercent;
    }

    public int getAllMoneyUser() {
        return allMoneyUser;
    }

    @Override
    public String toString() {
        return "User{" +
                "nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", investmentsPercent=" + investmentsPercent +
                ", quantityMoneyBox=" + quantityMoneyBox +
                ", moneyBoxPercent=" + moneyBoxPercent +
                ", pillowPercent=" + pillowPercent +
                ", pocketMoneyPercent=" + pocketMoneyPercent +
                ", allMoneyUser=" + allMoneyUser +
                '}';
    }
}
