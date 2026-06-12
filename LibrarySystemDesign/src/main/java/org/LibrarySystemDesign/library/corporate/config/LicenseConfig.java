package org.LibrarySystemDesign.library.corporate.config;

public class LicenseConfig {
    private static LicenseConfig instance ;
    private String enterpriseLicenseKey = "CORP-TECH-SECURE";
    private LicenseConfig(){

    }
    public static LicenseConfig getInstance(){
        if(instance == null) {
            instance = new LicenseConfig();
        }
        return instance;
    }
    public String getEnterpriseLicenseKey() {
        return enterpriseLicenseKey;
    }
}
