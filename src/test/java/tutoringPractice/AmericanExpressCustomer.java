package tutoringPractice;

public class AmericanExpressCustomer extends Customer{

    public AmericanExpressCustomer() {
        super(0, null, 0);
    }

    @Override
    public String toString() {
        return "AmericanExpressCustomer["+super.toString()+"]";
    }

}
