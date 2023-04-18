package nz.ac.auckland.se281;

import java.util.ArrayList;

import org.eclipse.jgit.api.RemoteSetUrlCommand;

public class Person {
    private String userName;
    private String age;
    // private LifePolicy lifePolicy;
    // private ArrayList<HomePolicy> homePolicyArraylist;
    // private ArrayList<CarPolicy> carPolicyArraylist;
    private ArrayList<Policy> policyArrayList;
    private int ammountOfPolicies;
    private Double totalPremium;
    private Boolean hasLifePolicy;
    private Boolean isLoaded;

    public Person(String userName, String age) {
        this.userName = userName;
        this.age = age;
        // this.lifePolicy = null;
        // homePolicyArraylist = new ArrayList<>();
        // carPolicyArraylist = new ArrayList<>();
        this.ammountOfPolicies = 0;
        this.policyArrayList = new ArrayList<Policy>();
        this.hasLifePolicy = false;
        this.totalPremium = 0.0;
        this.isLoaded = false;
    }

    public void setIsLoaded(Boolean isLoaded) {
        this.isLoaded = isLoaded;
    }

    public Boolean getIsLoaded() {
        return this.isLoaded;
    }

    public void setTotalPremium(Double totalPremium) {
        this.totalPremium = totalPremium;
    }

    public Integer getTotalPremium() {
        int x = this.totalPremium.intValue();
        return x;
    }

    public ArrayList<Policy> getPolicies() {
        return this.policyArrayList;
    }

    public void addPolicy(Policy policy) {
        this.policyArrayList.add(policy);
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

    public Boolean getHasLifePolicy() {
        return this.hasLifePolicy;
    }

    public void setHasLifePolicy() {
        this.hasLifePolicy = true;
    }

    // public LifePolicy getLifePolicy() {
    // return this.lifePolicy;
    // }

    // public ArrayList<HomePolicy> getHomePolicyArraylist() {
    // return this.homePolicyArraylist;
    // }

    // public ArrayList<CarPolicy> getCarPolicyArraylist() {
    // return this.carPolicyArraylist;
    // }

    public String getAge() {
        return this.age;
    }

    // public void setLifePolicy(LifePolicy lifePolicy) {
    // this.lifePolicy = lifePolicy;
    // }

    // public void addHomePolicy(HomePolicy homePolicy) {
    // this.homePolicyArraylist.add(homePolicy);
    // }

    // public void addCarPolicy(CarPolicy carPolicy) {
    // this.carPolicyArraylist.add(carPolicy);
    // }
}
