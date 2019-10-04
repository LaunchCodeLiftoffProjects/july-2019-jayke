package com.aplaygroundreviewer.dto;

public class CheckboxItem {

    private int aNumber;
    private String aString;
    private boolean aBoolean;

    public CheckboxItem(int aNumber, String aString, boolean aBoolean) {
        this.aNumber = aNumber;
        this.aString = aString;
        this.aBoolean = aBoolean;
    }

    public int getaNumber() {
        return aNumber;
    }

    public void setaNumber(int aNumber) {
        this.aNumber = aNumber;
    }

    public String getaString() {
        return aString;
    }

    public void setaString(String aString) {
        this.aString = aString;
    }

    public boolean isaBoolean() {
        return aBoolean;
    }

    public void setaBoolean(boolean aBoolean) {
        this.aBoolean = aBoolean;
    }
}
