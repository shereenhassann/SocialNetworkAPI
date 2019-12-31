package p.Classes;

public class PremiumUser extends User {
   private String paymentMethod;
   private Float balance;


    public PremiumUser(String paymentMethod, Float balance) {
        this.balance = balance;
        this.paymentMethod = paymentMethod;
    }

    public void addAdvertisement(Media content)
    {
        Post ad = new Post(content, this);
    }
}
