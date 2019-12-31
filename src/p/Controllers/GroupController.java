package p.Controllers;

import p.Classes.*;

import java.util.ArrayList;

public class GroupController {

    ArrayList<Group> groups = new ArrayList<>();

    private void addMember(User admin, User toAdd, Group group)
    {
        if(group.getAdmins().contains(admin) && !group.getMembers().contains(toAdd))
        {
            group.getMembers().add(toAdd);
            System.out.println("Admin[" + admin.getUsername() + "] added [" + toAdd.getUsername() + "] to the group successfully.");
        }
        else
            System.out.println("Member can't be added.");
    }
    private void addAdmin(User admin, User user, Group group)
    {
        if(group.getAdmins().contains(admin))
        {
            group.getAdmins().add(user);
            System.out.println("Admin[" + admin.getUsername() + "] added [" + admin.getUsername() + "] as admin to the group successfully.");

        }
        else
            System.out.println("Admin can't be added.");
    }
    private void deleteMember(User admin, User toDelete, Group group)
    {
        if(group.getAdmins().contains(admin) && group.getMembers().contains(toDelete)) {
            group.getMembers().remove(toDelete);
            System.out.println("Admin[" + admin.getUsername() + "] removed [" + toDelete.getUsername() + "] from the group successfully.");

        }
        else
            System.out.println("Member can't be deleted.");
    }

}
