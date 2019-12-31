package p.Controllers;

import p.Classes.Media;
import p.Classes.User;
import p.Interfaces.AddPost;
import p.Interfaces.HasPermission;

public class PostController implements AddPost, HasPermission {

    @Override
    public void addPost(Media media, User user) {

    }

    @Override
    public boolean hasPermission(User user) {
        return false;
    }
}
