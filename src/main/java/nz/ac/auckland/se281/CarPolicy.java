package nz.ac.auckland.se281;

public class CarPolicy extends Policy {
    private String makeAndModel;
    private String liscensePlate;
    private boolean breakdownCoverage;

    protected CarPolicy(int sumInsured, String makeAndModelString, String liscensePlate, Boolean breakdownCoverage,
            int age) {
        this.sumInsured = sumInsured;

        this.makeAndModel = makeAndModelString;
        this.liscensePlate = liscensePlate;
        this.breakdownCoverage = breakdownCoverage;

        if (age < 25) {
            premium = (double) sumInsured * (15.0 / 100.0);
        } else {
            premium = (double) sumInsured * (10.0 / 100.0);
        }

        if (breakdownCoverage) {
            premium += 80.0;
        }
    }

    public String getmakeAndModel() {
        return makeAndModel;
    }

    public String getLiscensePlate() {
        return liscensePlate;
    }

    public boolean isBreakdownCoverage() {
        return breakdownCoverage;
    }

    // Car Policy (<MAKE_AND_MODEL>, Sum Insured: $<SUM_INSURED>, Premium:
    // $<BASE_PREMIUM> -> $<DISCOUNTED_PREMIUM>)

    @Override
    public void printPolicyDetails() {
        String makeAndModel = this.getmakeAndModel();
        String sumInsured = Integer.toString(this.getSumInsured());
        String basePremium = Integer.toString(getPremiumInt());
        String discountedPremium = Integer.toString(getDiscountedPremium());
        MessageCli.PRINT_DB_CAR_POLICY.printMessage(makeAndModel, sumInsured, basePremium, discountedPremium);
    }

}
