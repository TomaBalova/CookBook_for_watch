package com.example.lab1_3_watch;

public class Menu {


    private int iconResource;
    private String categoryName;
    private int photoResource;
    private int textResource;

    public Menu(int iconResource, String categoryName, int photoResource, int textResource){
        this.categoryName = categoryName;
        this.iconResource = iconResource;
        this.photoResource = photoResource;
        this.textResource = textResource;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getIconResource() {
        return iconResource;
    }

    public void setIconResource(int iconResource) {
        this.iconResource = iconResource;
    }

    public int getPhotoResource() {
        return photoResource;
    }

    public void setPhotoResource(int photoResource) {
        this.photoResource = photoResource;
    }

    public int getTextResource() {
        return textResource;
    }

    public void setTextResource(int textResource) {
        this.textResource = textResource;
    }
}
