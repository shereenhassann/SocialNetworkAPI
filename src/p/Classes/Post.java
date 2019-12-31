package p.Classes;

import p.Interfaces.AddPost;

import java.util.ArrayList;

public class Post implements AddPost {
    private Media content;
    private boolean permission;
    private User authorUser;
    private ArrayList<User> likers;
    private Integer postID;

    public Post(Media content, User authorUser)
    {
        this.content = content;
        this.authorUser = authorUser;
    }

    private boolean hasPermission(User user){
        //if user in the group return true
        //if user in the page return true
        //if user in the permittedUsers return true
        //else
        return false;
    }

    public void deletePost(){}
    public void sharePost(User user){
    }
    public void findHashtag(){}
    public void incrementLikers(User user){
        if(hasPermission(user))
            likers.add(user);
        System.out.println("user[" + user.getUsername() + "] doesn't have the permission to like this post.");
    }

    //getters
    public Media getContent()
    {
        return this.content;
    }

    public User getAuthorUser() {
        return authorUser;
    }

    public ArrayList<User> getLikers() {
        return likers;
    }

    public Integer getPostID() {
        return postID;
    }

    public void setContent(Media newContent) {
        this.content = newContent;
    }

    @Override
    public void addPost(Media media, User user) {

    }
}
