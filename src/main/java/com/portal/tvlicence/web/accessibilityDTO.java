package com.portal.tvlicence.web;


public class AccessibilityDTO {

    private boolean dark;
    private boolean large;

// getters and setters for accessibility controls
    public boolean getDark() {
        return dark;
    }

    public void setDark(boolean dark) {
        this.dark = dark;
    }

    public boolean getLarge() {
        return large;
    }

    public void setLarge(boolean large) {
        this.large = large;
    }

    // Default constructor is needed for JSON parsing
    public AccessibilityDTO() {

    }

}

