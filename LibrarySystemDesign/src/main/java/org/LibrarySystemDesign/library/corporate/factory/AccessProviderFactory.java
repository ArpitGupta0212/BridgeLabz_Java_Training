package org.LibrarySystemDesign.library.corporate.factory;

public interface AccessProviderFactory {
    String createToken();

    String createVpnProfile();
}
