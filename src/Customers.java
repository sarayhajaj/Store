public class Customers extends User {
    private boolean clubMember;
    private int amountOfPurchase;
    private double sumOfPrice;


    public Customers(String firstName, String lastName, String users, String password, boolean clubMember) {
        super(firstName, lastName, users, password);
        this.clubMember = clubMember;
    }
    public Customers(){
        super();

    }

    @Override
    public String toString() {
        return "Customers{}";
    }

    public boolean isClubMember(){
        return clubMember;
    }

    public void setClubMember(boolean clubMember) {
        this.clubMember = clubMember;
    }

    public int getAmountOfPurchase() {
        return amountOfPurchase;
    }

    public double getSumOfPrice() {
        return sumOfPrice;
    }

    public void setAmountOfPurchase(int amountOfPurchase) {
        this.amountOfPurchase = amountOfPurchase;
    }

    public void setSumOfPrice(double sumOfPrice) {
        this.sumOfPrice = sumOfPrice;
    }
}
