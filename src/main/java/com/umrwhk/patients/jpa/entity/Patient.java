package com.umrwhk.patients.jpa.entity;

import com.umrwhk.patients.dto.PatientData;
import com.umrwhk.patients.enums.Gender;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

/**
 * Created by umrwhk(umrwhk@gmail.com)
 */
@Entity
public class Patient implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Version
    private Long version;

    @Column(length = 40)
    private String pid;
    @Column(length = 100)
    private String firstName;
    @Column(length = 100)
    private String lastName;

    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String address;
    private String suburb;
    private String state;
    @Column(length = 5)
    private String postCode;

    private String phoneNumber;

    public Patient() {
    }

    public Patient(PatientData req) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        this.pid = UUID.randomUUID().toString();
        this.firstName = req.getFirstName();
        this.lastName = req.getLastName();
        this.dateOfBirth = LocalDate.parse(req.getDateOfBirth(), formatter);
        this.gender = Gender.valueOf(req.getGender().toUpperCase());
        this.address = req.getAddress();
        this.suburb = req.getSuburb();
        this.state = req.getState();
        this.postCode = req.getPostCode();
        this.phoneNumber = req.getPhoneNumber();
    }

    public void update(PatientData req){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        this.firstName = req.getFirstName();
        this.lastName = req.getLastName();
        this.dateOfBirth = LocalDate.parse(req.getDateOfBirth(), formatter);
        this.gender = Gender.valueOf(req.getGender().toUpperCase());
        this.address = req.getAddress();
        this.suburb = req.getSuburb();
        this.state = req.getState();
        this.postCode = req.getPostCode();
        this.phoneNumber = req.getPhoneNumber();
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public Long getVersion() {
        return version;
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Gender getGender() {
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setVersion(Long version) {
        this.version = version;
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

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setGender(Gender gender) {
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
