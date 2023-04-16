package nz.ac.auckland.se281;

public class HomePolicy extends Policy {
    private boolean isRental;
    private String address;

    public HomePolicy(int sumInsured, String address, Boolean isRental) {
        // super(sumInsured);
        this.sumInsured = sumInsured;
        System.out.println(sumInsured);
        this.isRental = isRental;
        this.address = address;

        if (isRental) {
            this.premium = (2.0 / 100.0) * ((double) sumInsured);
            System.out.println(this.premium);
        } else {
            this.premium = (1.0 / 100.0) * ((double) sumInsured);
            System.out.println(this.premium);

        }

    }

    public boolean isRental() {
        return isRental;
    }

    public String getAddress() {
        return address;
    }

    // Home Policy (<ADDRESS>, Sum Insured: $<SUM_INSURED>, Premium: $<BASE_PREMIUM>
    // -> $<DISCOUNTED_PREMIUM>)

    @Override
    public void printPolicyDetails() {
        // TODO Auto-generated method stub
        String addressString = this.getAddress();
        String sumInsured = Integer.toString(this.getSumInsured());
        String basePremium = Integer.toString(getPremiumInt());
        String discountedPremium = Integer.toString(getDiscountedPremium());
        MessageCli.PRINT_DB_HOME_POLICY.printMessage(addressString, sumInsured, basePremium, discountedPremium);
        // String[] returnArray = { addressString, sumInsured, basePremium,
        // discountedPremium };
    }

}
