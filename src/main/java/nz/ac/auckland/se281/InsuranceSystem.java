package nz.ac.auckland.se281;

import java.util.ArrayList;

import javax.lang.model.util.ElementScanner14;

import nz.ac.auckland.se281.Main.PolicyType;

public class InsuranceSystem {
  ArrayList<Person> peopleList = new ArrayList();
  int rankCounter = 0;

  public InsuranceSystem() {
    // Only this constructor can be used (if you need to initialise fields).
  }

  public void printDatabase() {
    int numberOfProfiles = peopleList.size();
    if (numberOfProfiles == 0) {
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage("0", "s", ".");

    } else if (numberOfProfiles == 1) {

      MessageCli.PRINT_DB_POLICY_COUNT.printMessage("1", ".");
      String userName = peopleList.get(0).userName;
      String age = peopleList.get(0).age;
      // <SPACE><RANK><COLON><SPACE><USERNAME><COMMA><SPACE><AGE>
      System.out.println("" + "1:" + " " + userName + "," + " " + age);

    } else {
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage((Integer.toString(numberOfProfiles)), "s", ":");
      for (int i = 0; i < numberOfProfiles; i++) {
        String userName = peopleList.get(i).userName;
        String age = peopleList.get(0).age;
        // <SPACE><RANK><COLON><SPACE><USERNAME><COMMA><SPACE><AGE>
        System.out.println("" + Integer.toString(numberOfProfiles + 1) + ":" + " " + userName + "," + " " + age);

      }
    }

  }

  public boolean userNameUniqueCheck(String userNameString) {
    for (int i = 0; i < peopleList.size(); i++) {
      if (userNameString == peopleList.get(i).userName) {
        return false;
      }
    }
    return true;
  }

  public String userNameFormatter(String userName) {

    // This method formats the input string to title case
    // daNk -> Dank
    // dank -> Dank

    String newUserName = userName.substring(0, 1).toUpperCase() + userName.substring(1).toLowerCase();
    System.out.println();

    return newUserName;
  }

  public void createNewProfile(String userName, String age) {
    // TODO: Complete this method.
    // formatting username to Title case
    userName = userNameFormatter(userName);

    if ((userName.length() <= 3)) {
      MessageCli.INVALID_USERNAME_TOO_SHORT.printMessage(userName);

    } else if (!userNameUniqueCheck(userName)) {
      MessageCli.INVALID_USERNAME_NOT_UNIQUE.printMessage(userName);
    } else if (Integer.valueOf(age) < 1) {
      MessageCli.INVALID_AGE.printMessage(age, userName);
    } else {
      Person newPerson = new Person(userName, age, rankCounter);
      peopleList.add(newPerson);
      rankCounter++;
      MessageCli.PROFILE_CREATED.printMessage(userName, age);

    }
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
