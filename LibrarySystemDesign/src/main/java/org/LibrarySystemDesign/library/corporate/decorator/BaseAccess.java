package org.LibrarySystemDesign.library.corporate.decorator;

public class BaseAccess implements AccessPrivilege {
    public String getPrivileges(){
        return "Standard";
    }
}
