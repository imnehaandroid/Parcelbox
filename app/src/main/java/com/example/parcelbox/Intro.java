package com.example.parcelbox;

public class Intro {
    private String id;
    private String efirstName;
    private String elastName;
    private String eAddress;
    private String eCity;

    public Intro(){

    }

    public Intro(String efirstName, String elastName, String eAddress, String eCity) {
        this.efirstName = efirstName;
        this.elastName = elastName;
        this.eAddress = eAddress;
        this.eCity = eCity;
    }



    public String getEfirstName() {
        return efirstName;
    }

    public String getElastName() {
        return elastName;
    }

    public String geteAddress() {
        return eAddress;
    }

    public String geteCity() {
        return eCity;
    }
}
