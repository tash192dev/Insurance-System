package nz.ac.auckland.se281;

public class HomePolicy extends Policy {
    private boolean isRental;
    private String address;

    public HomePolicy(int sumInsured, String address, Boolean isRental) {
        super(sumInsured);
        this.isRental = isRental;
        this.address = address;

        if (isRental) {
            this.premium = (2 / 100) * (sumInsured);
        } else {
            this.premium = (1 / 100) * (sumInsured);
        }

    }

    public boolean isRental() {
        return isRental;
    }

    public String getAddress() {
        return address;
    }

}
