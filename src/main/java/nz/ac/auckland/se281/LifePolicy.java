package nz.ac.auckland.se281;

public class LifePolicy extends Policy {

  protected LifePolicy(int sumInsured, int age) {
    // super(sumInsured);
    this.sumInsured = sumInsured;

    this.premium = ((1.0 + age / 100.0) / 100.0) * (double) sumInsured;

  }
  // Life Policy (Sum Insured: $<SUM_INSURED>, Premium: $<BASE_PREMIUM> ->
  // $<DISCOUNTED_PREMIUM>)

  @Override
  public void printPolicyDetails() {
    // TODO Auto-generated method stub
    String sumInsured = Integer.toString(this.getSumInsured());
    String basePremium = Integer.toString(getPremiumInt());
    String discountedPremium = Integer.toString(getDiscountedPremium());

    MessageCli.PRINT_DB_LIFE_POLICY.printMessage(sumInsured, basePremium, discountedPremium);
  }
}
