package com.isu.model;

public enum Role {
    STUDENT("Student"),
    MAGE("Mage"),
    ADMIN("Admin");

    String value;

    private Role(String val){
        this.value = val;
    }

    public String getValue(){
        return this.value;
    }
}
