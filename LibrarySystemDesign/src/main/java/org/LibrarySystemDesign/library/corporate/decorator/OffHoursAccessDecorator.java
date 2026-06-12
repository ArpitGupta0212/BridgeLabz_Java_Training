package org.LibrarySystemDesign.library.corporate.decorator;

public class OffHoursAccessDecorator implements AccessPrivilege {
    private AccessPrivilege decorated;

    public OffHoursAccessDecorator(AccessPrivilege base) {
            this.decorated = base;
    }
    public String getPrivileges(){
        return decorated.getPrivileges() + " + OffHours";
    }
}
