package nz.ac.auckland.se281;

import java.util.ArrayList;

import nz.ac.auckland.se281.Main.PolicyType;

public class InsuranceSystem {
  ArrayList<Person> peopleList = new ArrayList();
  

  public InsuranceSystem() {
    // Only this constructor can be used (if you need to initialise fields).
  }

  public void printDatabase() {
    int numberOfProfiles = peopleList.size();
    if(numberOfProfiles == 0){
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage("0","s",".");

    }
    else if(numberOfProfiles == 1){

      MessageCli.PRINT_DB_POLICY_COUNT.printMessage("1",".");
    }
    else{
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage((Integer.toString(numberOfProfiles)), "s", ":" );

    }

    // TODO: Complete this method.
  }

  public void createNewProfile(String userName, String age) {
    // TODO: Complete this method.
    
    Person newPerson = new Person(userName, age);
    peopleList.add(newPerson);
  }

  public void loadProfile(String userName) {
    // TODO: Complete this method.
  }

  public void unloadProfile() {
    // TODO: Complete this method.
  }

  public void deleteProfile(String userName) {
    // TODO: Complete this method.
  }

  public void createPolicy(PolicyType type, String[] options) {
    // TODO: Complete this method.
  }
}
