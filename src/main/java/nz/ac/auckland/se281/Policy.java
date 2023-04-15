package nz.ac.auckland.se281;

public abstract class Policy extends Object {

    protected int sumInsured;
    protected double premium;
    protected double discountedPremium;

    protected Policy(int sumInsured) {

    }

    public double getPremium() {
        return this.premium;
    }

    public double getDiscountedPremium() {
        return this.discountedPremium;
    }

    public void setDiscountedPremium(double discountedPremium) {

        this.discountedPremium = discountedPremium;

    }

}
