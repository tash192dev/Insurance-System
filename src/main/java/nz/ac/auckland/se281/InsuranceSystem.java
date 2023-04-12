package nz.ac.auckland.se281;

import java.text.BreakIterator;
import java.util.ArrayList;

import org.eclipse.jgit.transport.CredentialItem.Username;

import nz.ac.auckland.se281.Main.PolicyType;

public class InsuranceSystem {
  private ArrayList<Person> peopleList = new ArrayList<Person>();
  // this counter will be incremented every time a new Person in instantiated and
  // will be used as their rank attribute
  private int rankCounter = 0;
  private Person personFound;

  public InsuranceSystem() {
    // Only this constructor can be used (if you need to initialise fields).
  }

  public void printDatabase() {
    int numberOfProfiles = peopleList.size();

    switch (numberOfProfiles) {

      case 0:
        MessageCli.PRINT_DB_POLICY_COUNT.printMessage("0", "s", ".");
        break;

      case 1:
        MessageCli.PRINT_DB_POLICY_COUNT.printMessage("1", ":", "");
        String userName = peopleList.get(0).getUserName();
        String age = peopleList.get(0).getAge();
        // <SPACE><RANK><COLON><SPACE><USERNAME><COMMA><SPACE><AGE>
        MessageCli.PRINT_DB_PROFILE_HEADER_MINIMAL.printMessage("1", userName, age);
        // System.out.println("" + "1:" + " " + userName + "," + " " + age);
        break;

      default:
        MessageCli.PRINT_DB_POLICY_COUNT.printMessage((Integer.toString(numberOfProfiles)), "s", ":");
        for (int i = 0; i < numberOfProfiles; i++) {
          userName = peopleList.get(i).getUserName();
          age = peopleList.get(i).getAge();

          // rank is being declared for the first time here however userName and age were
          // already declared before which is why this has String infront of it but they
          // dont

          String rank = Integer.toString(peopleList.get(i).getRank() + 1);
          // <SPACE><RANK><COLON><SPACE><USERNAME><COMMA><SPACE><AGE>
          MessageCli.PRINT_DB_PROFILE_HEADER_MINIMAL.printMessage(rank, userName, age);

          // System.out.println("" + rank + ":" + " " + userName + "," + " " + age);
        }
        break;
    }

  }

  public boolean userNameUniqueCheck(String userNameString) {
    // makes sure that userNameString is not already being used to
    for (int i = 0; i < peopleList.size(); i++) {
      if (userNameString.compareTo(peopleList.get(i).getUserName()) == 0) {
        personFound = peopleList.get(i);
        return false;
      }
    }
    return true;
  }

  public String userNameFormatter(String userName) {

    // This method will format the userName to Title case
    // e.g.
    // danK -> Dank
    // daNk -> Dank
    // dank -> Dank
    // DaNK -> Dank
    String newUserName = userName.substring(0, 1).toUpperCase() + userName.substring(1).toLowerCase();
    return newUserName;
  }

  public void createNewProfile(String userName, String age) {
    // formatting username to Title case
    userName = userNameFormatter(userName);

    try {
      Integer.parseInt(age);
    } catch (NumberFormatException e) {
      // This catches any decimal numbers that may may be seen
      MessageCli.INVALID_AGE.printMessage(age, userName);
      return;
    }

    if ((userName.length() < 3)) {
      MessageCli.INVALID_USERNAME_TOO_SHORT.printMessage(userName);

    } else if (userNameUniqueCheck(userName) != true) {
      MessageCli.INVALID_USERNAME_NOT_UNIQUE.printMessage(userName);
    } else if ((Integer.valueOf(age) < 1)) {
      MessageCli.INVALID_AGE.printMessage(age, userName);

    } else {
      Person newPerson = new Person(userName, age, rankCounter);
      peopleList.add(newPerson);
      rankCounter++;
      MessageCli.PROFILE_CREATED.printMessage(userName, age);

    }
  }

  boolean isLoaded = false;
  Person loadedPerson;

  public void loadProfile(String userName) {

    if (isLoaded) {
      MessageCli.CANNOT_CREATE_WHILE_LOADED.printMessage(loadedPerson.getUserName());
      return;
    }

    userName = userNameFormatter(userName);

    boolean userNameFound = !userNameUniqueCheck(userName);
    if (userNameFound) {
      loadedPerson = personFound;
      isLoaded = true;
      MessageCli.PROFILE_LOADED.printMessage(userName);
      return;
    }

    MessageCli.NO_PROFILE_FOUND_TO_LOAD.printMessage(userName);

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
