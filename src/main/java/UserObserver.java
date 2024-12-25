public class UserObserver implements OrderObserver {
    private User user;

    public UserObserver(User user) {
        this.user = user;
    }

    @Override
    public void update(String message) {
        user.notify(message);
    }
}