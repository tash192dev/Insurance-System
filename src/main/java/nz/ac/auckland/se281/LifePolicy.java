package nz.ac.auckland.se281;

public class LifePolicy extends Policy {

    protected LifePolicy(int sumInsured, int age) {
        super(sumInsured);
        this.premium = ((1 + age / 100) / 100) * sumInsured;

    }

}
