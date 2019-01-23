package com.softwaredevelopmentstuff.httpserver.model;

public class Vendor {
    private String name;
    private String countryOfRegistration;
    private String registrationNumber;

    public Vendor(String name, String countryOfRegistration, String registrationNumber) {
        this.name = name;
        this.countryOfRegistration = countryOfRegistration;
        this.registrationNumber = registrationNumber;
    }

    public Vendor() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryOfRegistration() {
        return countryOfRegistration;
    }

    public void setCountryOfRegistration(String countryOfRegistration) {
        this.countryOfRegistration = countryOfRegistration;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }
}
