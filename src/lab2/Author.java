package lab2;

public class Author {
    private final String name;
    private String email;
    private final char gender;

    public Author(String name, String email, char gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public char getGender() {
        if (gender == 'F' || gender == 'M') {
            return gender;
        }
        else {
            return 'U';
        }
    }

    @Override
    public String toString() {
        return "Author " + "name " + name + " email " + email + " gender is " + gender;
    }
}
