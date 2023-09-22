public class User {
    private String nickname;
    private String email;
    private String password;
    private byte investmentsPercent;
    private byte quantityMoneyBox;
    private byte moneyBoxPercent;
    private byte pillowPercent;
    private byte pocketMoneyPercent;
    private int allMoneyUser;

    public User(String nickname, String email, String password, byte investmentsPercent, byte quantityMoneyBox, byte
            moneyBoxPercent, byte pillowPercent, byte pocketMoneyPercent, int allMoneyUser) {
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
