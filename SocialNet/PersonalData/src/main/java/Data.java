public class Data {
    private String name = new String();
    private  int age;
    private int password;

    Data(String name, int age,  int password) {
        this.name = name;
        this.age = age;
        this.password = password;
    }

    Data(String name, int password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public int getPassword() {
        return password;
    }
}
