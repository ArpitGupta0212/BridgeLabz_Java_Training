package org.LibrarySystemDesign.library.corporate.model;

public class EBook implements DigitalAsset{
    private String title;
    public EBook(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }
}
