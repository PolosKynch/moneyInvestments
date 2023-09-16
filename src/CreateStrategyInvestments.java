public class CreateStrategyInvestments {
    private int investments;
    private int moneyBox;
    private int pillow;
    private int pocketMoney;

    public CreateStrategyInvestments(int investments, int moneyBox, int pillow, int pocketMoney) {
        this.investments = investments;
        this.moneyBox = moneyBox;
        this.pillow = pillow;
        this.pocketMoney = pocketMoney;
    }

    public int getInvestments() {
        return investments;
    }

    public int getMoneyBox() {
        return moneyBox;
    }

    public int getPillow() {
        return pillow;
    }

    public int getPocketMoney() {
        return pocketMoney;
    }

    @Override
    public String toString() {
        return "CreateStrategyInvestments{" +
                "investments=" + investments +
                ", moneyBox=" + moneyBox +
                ", pillow=" + pillow +
                ", pocketMoney=" + pocketMoney +
                '}';
    }
}
