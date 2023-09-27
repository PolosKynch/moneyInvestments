import java.util.ArrayList;

public class Investments {
    private ArrayList<User> usersArrayList;

    public Investments() {
        this.usersArrayList = new ArrayList<>();
    }

    public void addUser(User createUser) {
        usersArrayList.add(createUser);
    }

    public ArrayList<User> getUsersArrayList() {
        return usersArrayList;
    }


    public User checkUser(String nickname, String password) {
        for (User user: usersArrayList) {
            if (user.getNickname().equals(nickname) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public User getUser(String nickname) {
        int a = 0;
        for (int i = 0; i < usersArrayList.size(); i++) {
            if (usersArrayList.get(i).equals(nickname)) {
                a = i;
                break;
            }
        }
        return usersArrayList.get(a);
    }
}
