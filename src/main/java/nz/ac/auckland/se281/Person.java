package nz.ac.auckland.se281;

import java.util.ArrayList;

public class Person {
  private String userName;
  private String age;
  private ArrayList<Policy> policyArrayList;
  private int ammountOfPolicies;
  private Double totalPremium;
  private Boolean hasLifePolicy;
  private Boolean isLoaded;

  public Person(String userName, String age) {
    this.userName = userName;
    this.age = age;
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

  public String getAge() {
    return this.age;
  }

}
