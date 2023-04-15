package nz.ac.auckland.se281;

import java.util.ArrayList;

public class Person {
    private String userName;
    private String age;
    private LifePolicy lifePolicy;
    private ArrayList<HomePolicy> homePolicyArraylist;
    private ArrayList<CarPolicy> carPolicyArraylist;
    private int ammountOfPolicies;

    public Person(String userName, String age) {
        this.userName = userName;
        this.age = age;
        this.lifePolicy = null;
        homePolicyArraylist = new ArrayList<>();
        carPolicyArraylist = new ArrayList<>();
        this.ammountOfPolicies = 0;
    }

    public void incrementPoliciesCount() {
        this.ammountOfPolicies += 1;
    }

    public int getPoliciesCount() {
        return this.ammountOfPolicies;
    }

    public String getUserName() {
        return this.userName;
    }

    public LifePolicy getLifePolicy() {
        return this.lifePolicy;
    }

    public ArrayList<HomePolicy> getHomePolicyArraylist() {
        return this.homePolicyArraylist;
    }

    public ArrayList<CarPolicy> getCarPolicyArraylist() {
        return this.carPolicyArraylist;
    }

    public String getAge() {
        return this.age;
    }

    public void setLifePolicy(LifePolicy lifePolicy) {
        this.lifePolicy = lifePolicy;
    }

    public void addHomePolicy(HomePolicy homePolicy) {
        this.homePolicyArraylist.add(homePolicy);
    }

    public void addCarPolicy(CarPolicy carPolicy) {
        this.carPolicyArraylist.add(carPolicy);
    }
}
