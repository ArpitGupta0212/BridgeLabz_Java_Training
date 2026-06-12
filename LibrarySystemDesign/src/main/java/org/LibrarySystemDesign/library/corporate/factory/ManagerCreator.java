package org.LibrarySystemDesign.library.corporate.factory;

public class ManagerCreator extends UserRoleCreator {
    public UserRole createUserRole() {
        return new ManagerRole();
    }
}
