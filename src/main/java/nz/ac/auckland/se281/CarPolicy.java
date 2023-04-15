package nz.ac.auckland.se281;

public class CarPolicy extends Policy {
    private String makeNModel;
    private String liscensePlate;
    private boolean breakdownCoverage;

    protected CarPolicy(int sumInsured, String makeNmodelString, String liscensePlate, Boolean breakdownCoverage,
            int age) {
        super(sumInsured);
        this.makeNModel = makeNmodelString;
        this.liscensePlate = liscensePlate;
        this.breakdownCoverage = breakdownCoverage;

        if (age < 25) {
            premium = sumInsured * (15 / 100);
        } else {
            premium = sumInsured * (10 / 100);
        }

        if (breakdownCoverage) {
            premium += 80;
        }
    }

    public String getMakeNModel() {
        return makeNModel;
    }

    public String getLiscensePlate() {
        return liscensePlate;
    }

    public boolean isBreakdownCoverage() {
        return breakdownCoverage;
    }

}
