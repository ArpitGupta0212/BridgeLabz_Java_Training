package org.LibrarySystemDesign.library.corporate.factory;

import org.LibrarySystemDesign.library.corporate.model.DigitalAsset;
import org.LibrarySystemDesign.library.corporate.model.EBook;
import org.LibrarySystemDesign.library.corporate.model.VideoTutorial;


public class DigitalAssetFactory {
    public static DigitalAsset createAsset(String type, String title){
        if(type.equalsIgnoreCase("ebook")) {
            return new EBook(title);
        }
        else if(type.equalsIgnoreCase("video")) {
            return new VideoTutorial(title);
        }else{
            throw new IllegalArgumentException("Invalid asset type");
        }
    }
}
