import java.util.ArrayList;

public class Investments {
    private ArrayList<User> usersArrayList;

    public Investments() {
        this.usersArrayList = new ArrayList<>();
    }

    public void addUser(User createUser) {
        usersArrayList.add(createUser);
    }

    public User getUser(User getUserEmail) {
        User user = new User();
        for (int i = 0; i < usersArrayList.size(); i++) {
            if (usersArrayList.get(i).equals(getUserEmail)) {

            }
        }
        return null;
    }
}
