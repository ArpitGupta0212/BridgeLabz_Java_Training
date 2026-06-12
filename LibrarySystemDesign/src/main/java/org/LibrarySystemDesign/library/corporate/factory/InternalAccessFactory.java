package org.LibrarySystemDesign.library.corporate.factory;

public class InternalAccessFactory implements AccessProviderFactory{
    public String createToken() {
        return "IntranetToken";
    }
    public String createVpnProfile() {
        return "Office_VPN";
    }

}
