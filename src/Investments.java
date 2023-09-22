import java.util.ArrayList;

public class Investments {
    private ArrayList<User> usersArrayList;

    public Investments() {
        this.usersArrayList = new ArrayList<>();
    }

    public void addUser(User createUser) {
        usersArrayList.add(createUser);
    }
}
