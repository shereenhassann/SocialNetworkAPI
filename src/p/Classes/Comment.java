package p.Classes;

import p.Interfaces.HasPermission;

public class Comment implements HasPermission {
    @Override
    public boolean hasPermission(User user) {
        return false;
    }
}
