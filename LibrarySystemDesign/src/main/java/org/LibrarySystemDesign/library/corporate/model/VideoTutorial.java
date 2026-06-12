package org.LibrarySystemDesign.library.corporate.model;
import org.LibrarySystemDesign.library.corporate.model.DigitalAsset;
import org.LibrarySystemDesign.library.corporate.model.EBook;
import org.LibrarySystemDesign.library.corporate.model.VideoTutorial;
public class VideoTutorial implements DigitalAsset{
    private String title;
    public VideoTutorial(String title){
        this.title=title;
    }
    public String getTitle(){
        return title;
    }
}
