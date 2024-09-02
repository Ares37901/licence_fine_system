package com.portal.tvlicence.web;


public class accessibilityDTO {

    private boolean dark;
    private boolean large;


    public boolean isDark() {
        return dark;
    }

    public void setDark(boolean dark) {
        this.dark = dark;
    }

    public boolean isLarge() {
        return large;
    }

    public void setLarge(boolean large) {
        this.large = large;
    }

    // Default constructor is needed for JSON parsing
    public accessibilityDTO() {

    }

}

