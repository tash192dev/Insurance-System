package nz.ac.auckland.se281;

import java.util.ArrayList;

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

    // Car Policy (<MAKE_AND_MODEL>, Sum Insured: $<SUM_INSURED>, Premium:
    // $<BASE_PREMIUM> -> $<DISCOUNTED_PREMIUM>)

    @Override
    public void printPolicyDetails() {
        // TODO Auto-generated method stub
        String makeNModel = this.getMakeNModel();
        String sumInsured = Integer.toString(this.getSumInsured());
        String basePremium = Integer.toString(getPremiumInt());
        String discountedPremium = Integer.toString(getDiscountedPremium());
        MessageCli.PRINT_DB_CAR_POLICY.printMessage(makeNModel, sumInsured, basePremium, discountedPremium);
    }

}
