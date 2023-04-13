package nz.ac.auckland.se281;

public abstract class Policy extends Object {

    protected int sumInsured;
    protected int premium;

    protected Policy(int sumInsured, int premium) {
        this.sumInsured = sumInsured;
        this.premium = premium;
    }

}
