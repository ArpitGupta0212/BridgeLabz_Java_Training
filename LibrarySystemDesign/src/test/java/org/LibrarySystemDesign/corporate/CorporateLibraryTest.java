package org.LibrarySystemDesign.corporate;
import org.LibrarySystemDesign.library.corporate.config.LicenseConfig;
import org.LibrarySystemDesign.library.corporate.factory.*;
import org.LibrarySystemDesign.library.corporate.model.DigitalAsset;
import org.LibrarySystemDesign.library.corporate.model.EBook;
import org.junit.*;
public class CorporateLibraryTest {
    @Test
    public void LicenseConfigTest(){
        LicenseConfig config1=LicenseConfig.getInstance();
        LicenseConfig config2=LicenseConfig.getInstance();
        Assert.assertSame(config1,config2);
        Assert.assertEquals("CORP-TECH-SECURE",config1.getEnterpriseLicenseKey());
        System.out.println("SingleTon Test Passed");
    }
    @Test
    public void DigitalAssetFactoryTest(){
        DigitalAsset d1= DigitalAssetFactory.createAsset("ebook", "Java Guide");
        Assert.assertTrue(d1 instanceof EBook);
        Assert.assertEquals("Java Guide", d1.getTitle());
        System.out.println("Factory Test Passed");
    }
    @Test
    public void UserRoleTest(){
        UserRoleCreator user1=new EngineerCreator();
        UserRoleCreator user2=new ManagerCreator();
        Assert.assertEquals(3,user1.createUserRole().getDownloadLimit());
        Assert.assertEquals(10,user2.createUserRole().getDownloadLimit());
        System.out.println("Users Test Case Passed");
    }

}
