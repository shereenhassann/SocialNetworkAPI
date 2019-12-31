package p.Controllers;

import p.Classes.*;

import java.util.ArrayList;
import java.util.Collection;

public class UserController {

    private static Integer counter = 0;
    private static ArrayList<User> accounts = new ArrayList<>();


    public void upgradeToPremium(String paymentMethod, Float balance, User userToAdd)
    {
        userToAdd.isPremium = true;
        balance -= 99;  //99 dollars for the subscription
        PremiumUser user = new PremiumUser(paymentMethod, balance);

    }

    public void signUp(String username, String password, String email, String phone, String gender, String country){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhone(phone);
        user.setGender(gender);
        user.setCountry(country);
        user.setUserID(counter++);
        this.accounts.add(user);
    }


    public int logIn(String username, String password)
    {
        int foundAccount= findUserAccount(username, password);
        if( foundAccount != (-1))   //user found
        {
            int id = accounts.get(foundAccount).getUserID();
            User currentUser = getUserById(id);
            if (currentUser != null) {
                System.out.println("**Welcome " + getUserById(id).getUsername() + "**");
                currentUser.loggedIn = true;
                return id;
            } else {
                System.out.println("Can't log in.\nCheck your data and try again.");

            }
        }
        return  -1;
    }

    public User searchForUser(String searchStatement) {

        User found = null;
        String searchFor = "", results = "";
        for (int i = 2; i < searchStatement.length(); i++)
            searchFor += searchStatement.charAt(i);
        //  System.out.println("searchStatement = [" + searchStatement + "], searchFor = [" + searchFor + "]");

        if (searchStatement.charAt(0) == 'u') {
            found = getUserByUsername(searchFor);
            if (found != null)
                results += "\nUsers found: \n" + found.getUsername();
            else
                results += "\nNo users found.";
        }
        System.out.println(results);
        return found;
    }


    public  Integer findUserAccount(String username, String password)
    {
        int counter = 0;
        for(int i =0; i< accounts.size(); i++) {
            if(accounts.get(i).getUsername().equals(username) && accounts.get(i).getPassword().equals(password))
                return i;
        }
        return -1; //not found
    }

    public  User getUserById(Integer id)
    {
        for(int i =0; i< accounts.size() ; i++) {
            if (accounts.get(i).getUserID() == id)
                return accounts.get(i);
        }
        return null;//not found
    }
    public  User getUserByUsername(String username)
    {
        for(int i =0; i< accounts.size() ; i++) {
            //  System.out.println("func Account "+i+": "+accounts.get(i).getUsername());
            if (accounts.get(i).getUsername().equals(username))
            { //           System.out.println("func Account "+i+": "+accounts.get(i).getUsername()+" == "+username);

                return accounts.get(i);}
        }
        return null; //not found
    }

    public boolean isLoggedIn(User user){return user.loggedIn;}


    public ArrayList<User> getAccounts() {
        return this.accounts;
    }

}
