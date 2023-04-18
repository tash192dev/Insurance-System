package nz.ac.auckland.se281;

import java.util.ArrayList;

import nz.ac.auckland.se281.Main.PolicyType;

public class InsuranceSystem {
  private ArrayList<Person> peopleList = new ArrayList<Person>();
  // this counter will be incremented every time a new Person in instantiated and
  // will be used as their rank attribute
  // private int rankCounter = 0;
  private Person personFound;
  private int personPosition;

  public InsuranceSystem() {
    // Only this constructor can be used (if you need to initialise fields).
  }

  public void policyPrinter(Person person) {
    ArrayList<Policy> policies = person.getPolicies();
    if (person.getPoliciesCount() == 0) {
      return;
    } else {
      for (Policy policy : policies) {
        policy.printPolicyDetails();
      }
    }
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

        // String totalPremiumString = String.format("%.0f",
        // peopleList.get(0).getTotalPremium());
        String totalPremiumString = Integer.toString(peopleList.get(0).getTotalPremium());
        String policiesCount = Integer.toString(peopleList.get(0).getPoliciesCount());
        // 1: Jenny, 25, 0 policies for a total of $0

        if (isLoaded) {

          if (peopleList.get(0).getPoliciesCount() != 1) {
            MessageCli.PRINT_DB_PROFILE_HEADER_LONG.printMessage("*** ", "1", userName, age, policiesCount, "ies",
                totalPremiumString);
          } else {
            MessageCli.PRINT_DB_PROFILE_HEADER_LONG.printMessage("*** ", "1", userName, age, policiesCount, "y",
                totalPremiumString);

          }
          policyPrinter(peopleList.get(0));
          return;

        }
        MessageCli.PRINT_DB_PROFILE_HEADER_LONG.printMessage("", "1", userName, age, policiesCount, "ies",
            totalPremiumString);
        break;

      default:
        MessageCli.PRINT_DB_POLICY_COUNT.printMessage((Integer.toString(numberOfProfiles)), "s", ":");
        for (int i = 0; i < numberOfProfiles; i++) {
          Person currentProfile = peopleList.get(i);
          userName = currentProfile.getUserName();
          age = currentProfile.getAge();
          // String totalPremium = String.format("%.0f",
          // currentProfile.getTotalPremium());
          String totalPremium = Integer.toString(currentProfile.getTotalPremium());

          String policyCount = Integer.toString(currentProfile.getPoliciesCount());
          // rank is being declared for the first time here however userName and age were
          // already declared before which is why this has String infront of it but they
          // dont

          String rank = Integer.toString(i + 1);

          if (currentProfile == loadedPerson) {
            if (currentProfile.getPoliciesCount() != 1) {
              MessageCli.PRINT_DB_PROFILE_HEADER_LONG.printMessage("*** ", rank, userName, age, policyCount, "ies",
                  totalPremium);
            } else {
              MessageCli.PRINT_DB_PROFILE_HEADER_LONG.printMessage("*** ", rank, userName, age, policyCount, "y",
                  totalPremium);

            }
            policyPrinter(currentProfile);
          } else {
            if (currentProfile.getPoliciesCount() != 1) {
              MessageCli.PRINT_DB_PROFILE_HEADER_LONG.printMessage("", rank, userName, age, policyCount, "ies",
                  totalPremium);
            } else {
              MessageCli.PRINT_DB_PROFILE_HEADER_LONG.printMessage("", rank, userName, age, policyCount, "y",
                  totalPremium);

            }
            policyPrinter(currentProfile);

          }
        }
        break;
    }

  }

  public boolean userNameUniqueCheck(String userNameString) {
    // makes sure that userNameString is not already being used to
    for (int i = 0; i < peopleList.size(); i++) {
      if (userNameString.compareTo(peopleList.get(i).getUserName()) == 0) {
        personFound = peopleList.get(i);
        personPosition = i;
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
    if (isLoaded) {
      MessageCli.CANNOT_CREATE_WHILE_LOADED.printMessage(userName);
      return;
    }
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
      Person newPerson = new Person(userName, age);
      peopleList.add(newPerson);
      // rankCounter++;
      MessageCli.PROFILE_CREATED.printMessage(userName, age);

    }
  }

  boolean isLoaded = false;
  Person loadedPerson;

  public void loadProfile(String userName) {

    userName = userNameFormatter(userName);

    boolean userNameFound = !userNameUniqueCheck(userName);
    if (userNameFound) {
      loadedPerson = personFound;
      isLoaded = true;
      loadedPerson.setIsLoaded(true);
      MessageCli.PROFILE_LOADED.printMessage(userName);
      return;
    }

    MessageCli.NO_PROFILE_FOUND_TO_LOAD.printMessage(userName);

  }

  public void unloadProfile() {
    if (isLoaded) {
      MessageCli.PROFILE_UNLOADED.printMessage(loadedPerson.getUserName());
      loadedPerson.setIsLoaded(false);
      isLoaded = false;
      loadedPerson = null;

      return;
    }
    MessageCli.NO_PROFILE_LOADED.printMessage();
    return;
  }

  public void deleteProfile(String userName) {

    userName = userNameFormatter(userName);

    boolean userNameFound = !userNameUniqueCheck(userName);

    if (!userNameFound) {
      MessageCli.NO_PROFILE_FOUND_TO_DELETE.printMessage(userName);
      return;
    } else if (peopleList.get(personPosition).getIsLoaded()) {
      if (loadedPerson.getUserName().compareTo(userName) == 0) {
        MessageCli.CANNOT_DELETE_PROFILE_WHILE_LOADED.printMessage(userName);
        return;
      }
    }

    peopleList.remove(personPosition);
    MessageCli.PROFILE_DELETED.printMessage(userName);
    return;

  }

  private boolean trueOrFalse(String input) {
    char c = input.charAt(0);
    if (c == 'y') {
      return true;
    } else {
      return false;

    }
  }

  private void setDiscountedPremium(Person person) {

    ArrayList<Policy> policies = loadedPerson.getPolicies();
    int policyCount = person.getPoliciesCount();
    Double multiplier;
    switch (policyCount) {
      case 1:
        multiplier = 1.0;
        break;
      case 2:
        multiplier = 0.9;
        break;
      default:
        multiplier = 0.8;
        break;
    }

    double totalPremium = 0;

    for (Policy policy : policies) {
      double basePremium = policy.getPremium();
      double discountedPremium = basePremium * multiplier;
      policy.setDiscountedPremium(discountedPremium);
      totalPremium += discountedPremium;
    }

    loadedPerson.setTotalPremium(totalPremium);

  }

  public void createPolicy(PolicyType type, String[] options) {

    if (!isLoaded) {
      MessageCli.NO_PROFILE_FOUND_TO_CREATE_POLICY.printMessage();
      return;
    }
    int sum = Integer.parseInt(options[0]);
    int age = Integer.parseInt(loadedPerson.getAge());

    switch (type) {
      case HOME:
        String address = options[1];
        Boolean rental = trueOrFalse(options[2]);
        HomePolicy homePolicy = new HomePolicy(sum, address, rental);
        // System.out.println(Integer.toString(sum));
        // System.out.println(address);
        // System.out.println(rental);
        loadedPerson.addPolicy(homePolicy);
        MessageCli.NEW_POLICY_CREATED.printMessage("home", loadedPerson.getUserName());
        break;
      case CAR:
        String makeNModel = options[1];
        String licensePlate = options[2];
        Boolean mechanicalWarranty = trueOrFalse(options[3]);
        CarPolicy carPolicy = new CarPolicy(sum, makeNModel, licensePlate, mechanicalWarranty, age);
        loadedPerson.addPolicy(carPolicy);
        MessageCli.NEW_POLICY_CREATED.printMessage("car", loadedPerson.getUserName());
        break;
      case LIFE:
        if (loadedPerson.getHasLifePolicy()) {
          MessageCli.ALREADY_HAS_LIFE_POLICY.printMessage(loadedPerson.getUserName());
          return;
        } else if (age > 100) {
          MessageCli.OVER_AGE_LIMIT_LIFE_POLICY.printMessage(loadedPerson.getUserName());
          return;
        }
        LifePolicy lifePolicy = new LifePolicy(sum, age);
        loadedPerson.addPolicy(lifePolicy);
        loadedPerson.setHasLifePolicy();
        MessageCli.NEW_POLICY_CREATED.printMessage("life", loadedPerson.getUserName());
        break;
      default:
        System.out.println("idk whats going on");
        break;
    }

    loadedPerson.incrementPoliciesCount();
    setDiscountedPremium(loadedPerson);

  }
}
