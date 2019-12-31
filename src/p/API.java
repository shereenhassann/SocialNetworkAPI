package p;

import java.util.ArrayList;
import java.util.Scanner;
import p.Classes.*;
import p.Controllers.*;
import sun.util.calendar.LocalGregorianCalendar;

import static java.lang.Float.parseFloat;


public class API {

    public static void main(String[] args) {

        System.out.println("**Welcome to NSR Social Network API**");
        while(true) {
            System.out.println("\n-----------------------------------------");
            System.out.println("Press 1 to Register. \nPress 2 to Login.\nPress 3 to Exit.");
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":     //register
                {
                    UserController userController = new UserController();
                    System.out.println("Enter username: ");
                    String name = scanner.nextLine();

                    System.out.println("Enter password: ");
                    String pass = scanner.nextLine();

                    System.out.println("Enter email: ");
                    String email = scanner.nextLine();

                    System.out.println("Enter phone number: ");
                    String phone = scanner.nextLine();

                    System.out.println("Enter gender: ");
                    String gender = scanner.nextLine();

                    System.out.println("Enter country: ");
                    String country = scanner.nextLine();

                    userController.signUp(name, pass, email, phone, gender, country);

//                    for(int i =0; i<userController.getAccounts().size(); i++)
//                        System.out.println("Account "+i+": "+userController.getAccounts().get(i).getUsername());
                    System.out.println("User created successfully.\n\n");
                    break;
                }

                case "2":   //login
                {
                    UserController userController = new UserController();
                    System.out.println("Enter username: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter password: ");
                    String pass = scanner.nextLine();

                    int id = userController.logIn(name, pass);
                    if (id == -1) {
                        break;
                    } else {
                        User currentUser = new User();
                        currentUser = userController.getUserById(id);
                        while (userController.isLoggedIn(currentUser)) {
//                            System.out.println("current user: "+currentUser.getUsername()+"\n");
                            System.out.println("Choose operation: ");
                            System.out.println("1)Send friend request.");
                            System.out.println("2)Accept friend request from:");
                            if (currentUser.getFriendRequests().size() > 0) {
                                for (int i = 0; i < currentUser.getFriendRequests().size(); i++)
                                    System.out.println("    2." + (i + 1) + ")" + currentUser.getFriendRequests().get(i).getUsername());
                            }
                            System.out.println("3)Upgrade to Premium.");
                            System.out.println("4)My friends List.");
                            System.out.println("5)Log out.");

                            choice = scanner.nextLine();

                            switch (choice.charAt(0)) {
                                case '1': {
                                    System.out.print("\nSearch for: ");
                                    String input = scanner.nextLine();
                                    User user = userController.searchForUser(input);
                                    if(user !=null) {
                                        user.addPermittedUserRequest(currentUser, false);
                                    }
                                    else
                                        System.out.println("Request can't be sent.");
//                                    System.out.println("current user: "+currentUser.getUsername()+"\n");

                                    break;
                                }
                                case '2': {
                                    if(choice.length() > 1)
                                    {   int reqIndex = Character.getNumericValue(choice.charAt(2)) - 1 ;
                                        currentUser.addPermittedUser(currentUser.getFriendRequests().get(reqIndex));
                                        currentUser.requests.remove(currentUser.getFriendRequests().get(reqIndex));
                                    }
                                    else
                                        System.out.println("You have no requests.");
                                    break;
                                }
                                case '3': {
                                    System.out.print("Enter payment method:\n1)PayPal.\n2)Credit Card.\n>>");
                                    String payment = scanner.nextLine();
                                    System.out.print("Enter balance:");
                                    String balance = scanner.nextLine();
                                    if(parseFloat(balance) < 99) {
                                        userController.upgradeToPremium(payment, parseFloat(balance), currentUser);
                                        System.out.println("YAYY!! You're now one of our premium users.");
                                    }else
                                        System.out.println("Balance should be more than 99$");
                                    break;
                                }
                                case '4': {
                                    System.out.println("\n**You friends: ");
                                    if(currentUser.permittedUsers.size() > 0) {
                                        for (int i = 0; i < currentUser.permittedUsers.size(); i++)
                                            System.out.println((i+1) + ")" + currentUser.permittedUsers.get(i).getUsername());
                                    }
                                    else
                                        System.out.println("You have no friends.");

                                    break;
                                }
                                case '5'://log out
                                {
                                    currentUser.loggedIn = false;
                                    break;
                                }

                                default:
                                    System.out.println("Invalid Input.");
                            }
                        }

                    }
                    break;
                }

                case "3":   //exit
                {
                    System.out.println("**Thank you for using NSR Social Network API**");
                    return;
                }
                default:
                    System.out.println("Invalid input");
            }

        }
    }


}
