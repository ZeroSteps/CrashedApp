package ru.ship.chat.provider;

public class UserProvider {
    private String name;

    private static UserProvider mInstance;

    public static UserProvider getInstance() {
        if (mInstance == null) {
            mInstance = new UserProvider();
        }
        return mInstance;
    }

    private UserProvider() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
