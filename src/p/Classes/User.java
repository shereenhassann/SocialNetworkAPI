package p.Classes;
import p.Controllers.*;
import java.util.ArrayList;

public class User {
    private Integer userID;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String gender;
    private String country;



    public ArrayList<User> permittedUsers  = new ArrayList<>();
    private ArrayList<User> premiumUsers = new ArrayList<>();
     public boolean loggedIn = false;
    public boolean isPremium = false;


    ArrayList<String> notificationsList = new ArrayList<>();
     public ArrayList<User> requests = new ArrayList<>();

    public User(){}

    public void addPermittedUserRequest(User userToAdd, boolean addOrAccept) {
        if (!userToAdd.equals(this)) {
            if (!addOrAccept) {
                this.requests.add(userToAdd);
                System.out.println("Request sent successfully.");
            }
            else
                userToAdd.requests.add(this);
        }else
            System.out.println("\n!!!You can\'t add yourself as a friend!!!\n");
    }




    public void likePage(Page pageToLike){}
    private boolean verifySignUp(String data){return true;}
    public void editAccount(String attributeToBeManaged, String update){}
    public boolean isPermittedUser(User user){
        if(this.permittedUsers.contains(user))
            return true;
        return false;
    }
    private void updateNotificationsList(String notification){}

   //message related
    public void sendMessage(Media media){}
    public void receiveMessage(Message message){}

    //group related
    public void joinGroup(Group groupToJoin){}
    public boolean isMember(User user, Group group){
        if(group.getMembers().contains(user))
            return true;
        return false;
    }


    //postRelated
    public void likePost(Post postToLike)
    {
        postToLike.incrementLikers(this);
    }


    //setters and getters


    public Integer getUserID() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public ArrayList<User> getFriendRequests() {
        return this.requests;
    }

    public void addPermittedUser(User user) {
        this.permittedUsers.add(user);
    }

    public ArrayList<User> getPermittedUsers()
    {
        return this.permittedUsers;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setUserID(int id) {
        this.userID = id;
    }
}
