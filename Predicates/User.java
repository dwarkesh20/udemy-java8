package java8.Predicates;

public class User {
    private String name;
    private String pass;

    public User(String name, String password) {
        this.name = name;
        this.pass = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return pass;
    }

}
