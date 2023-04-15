package nz.ac.auckland.se281;

import java.util.ArrayList;

public class Person {
    private String userName;
    private String age;
    private LifePolicy lifePolicy;
    private ArrayList<HomePolicy> homePolicyArraylist;
    private ArrayList<CarPolicy> carPolicyArraylist;

    public Person(String userName, String age) {
        this.userName = userName;
        this.age = age;
        this.lifePolicy = null;
        homePolicyArraylist = new ArrayList<>();
        carPolicyArraylist = new ArrayList<>();
    }

    public String getUserName() {
        return userName;
    }

    public LifePolicy getLifePolicy() {
        return lifePolicy;
    }

    public ArrayList<HomePolicy> getHomePolicyArraylist() {
        return homePolicyArraylist;
    }

    public ArrayList<CarPolicy> getCarPolicyArraylist() {
        return carPolicyArraylist;
    }

    public String getAge() {
        return age;
    }

    public void setLifePolicy(LifePolicy lifePolicy) {
        this.lifePolicy = lifePolicy;
    }

    public void addHomePolicy(HomePolicy homePolicy) {
        homePolicyArraylist.add(homePolicy);
    }

    public void addCarPolicy(CarPolicy carPolicy) {
        carPolicyArraylist.add(carPolicy);
    }
}
