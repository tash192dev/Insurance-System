package nz.ac.auckland.se281;

public class Person {
    private String userName;
    private String age;
    private int rank;

    public Person(String userName, String age, int rank) {
        this.userName = userName;
        this.age = age;
        this.rank = rank;
    }

    public String getUserName() {
        return userName;
    }

    public String getAge() {
        return age;
    }

    public Integer getRank() {
        return rank;
    }
}
