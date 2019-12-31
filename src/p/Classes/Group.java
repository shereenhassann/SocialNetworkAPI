package p.Classes;

import p.Interfaces.AddPost;

import java.util.ArrayList;

public class Group implements AddPost {

    private Integer groupID;
    private ArrayList<User> members = new ArrayList<>();
    private ArrayList<User> admins = new ArrayList<>();
    private ArrayList<Post> posts = new ArrayList<>();
    private String name, state;
    private ArrayList<String> availableStates = new ArrayList<>();

    Group(){
        availableStates.add("public");
        availableStates.add("private");
        availableStates.add("secret");
    }
    Group(String name, User adminUser){
        availableStates.add("public");
        availableStates.add("private");
        availableStates.add("secret");

        this.name = name;
        this.admins.add(adminUser);
    }

    //manage group





    //posts
    public void editPost(User admin, Post toManage, Media newContent){
        if(this.admins.contains(admin) && this.posts.contains(toManage))
            (this.posts.get(toManage.getPostID())).setContent(newContent);
    }

    public void addPost(Post toAdd)
    {
        if(this.members.contains(toAdd.getAuthorUser()) || this.admins.contains(toAdd.getAuthorUser())) {
            this.posts.add(toAdd);
            System.out.println("User [" + toAdd.getAuthorUser().getUsername() + "] published post to the group successfully.");
        }
        else
            System.out.println("Post can't be added.");
    }




    //getters
    public ArrayList<User> getMembers() {
        return members;
    }

    public ArrayList<User> getAdmins() {
        return admins;
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

    public String getName() {
        return name;
    }

    public String getState() {
        return state;
    }

    public Integer getGroupID() {
        return groupID;
    }

    @Override
    public void addPost(Media media, User user) {

    }
}
