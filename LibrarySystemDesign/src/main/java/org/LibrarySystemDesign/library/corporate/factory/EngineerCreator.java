package org.LibrarySystemDesign.library.corporate.factory;

public class EngineerCreator extends UserRoleCreator {
    public UserRole createUserRole() {
        return new EngineerRole();
    }
}
