package nz.ac.auckland.se281;

public abstract class Policy extends Object {

  protected int sumInsured;
  protected double premium;
  protected double discountedPremium;

  protected Policy() {

  }

  public int getSumInsured() {
    return this.sumInsured;
  }

  public double getPremium() {
    return this.premium;
  }

  public int getPremiumInt() {
    int x = (int) this.premium;
    return x;
  }

  public int getDiscountedPremium() {
    int x = (int) this.discountedPremium;
    return x;
  }

  public void setDiscountedPremium(double discountedPremium) {

    this.discountedPremium = discountedPremium;

  }

  public abstract void printPolicyDetails();

}
