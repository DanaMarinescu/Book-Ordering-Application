package org.loose.fis.sre.model;

public class ModelPH {
    private String name;
    private String role;

    public ModelPH(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole(){
        return role;
    }
}
