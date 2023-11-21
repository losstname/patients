package com.umrwhk.patients.dto;

import com.umrwhk.patients.jpa.entity.Patient;

/**
 * Created by umrwhk(umrwhk@gmail.com)
 */
public class PatientData {
    private String pid;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String gender;
    private String address;
    private String suburb;
    private String state;
    private String postCode;
    private String phoneNumber;

    public PatientData() {
    }

    public PatientData(Patient p) {
        this.pid = p.getPid();
        this.firstName = p.getFirstName();
        this.lastName = p.getLastName();
        this.dateOfBirth = p.getDateOfBirth().toString();
        this.gender = p.getGender().name();
        this.address = p.getAddress();
        this.suburb = p.getSuburb();
        this.state = p.getState();
        this.postCode = p.getPostCode();
        this.phoneNumber = p.getPhoneNumber();
    }

    public String getPid() {
        return pid;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public String getSuburb() {
        return suburb;
    }

    public String getState() {
        return state;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
