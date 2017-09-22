package com.aug22.avinashchintareddy.thedoctors.model;

/**
 * Created by avinashchintareddy on 9/17/17.
 */

public class DoctorListM {
    private String Name;
    private String Experience;
    private String Rating;
    String doctorPhoto;
    String address;
    String id;



    public DoctorListM(String name, String experience, String rating, String doctorPhoto, String address,String id) {
        Name = name;
        Experience = experience;
        Rating = rating;
        this.doctorPhoto = doctorPhoto;
        this.address = address;
        this.id= id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getExperience() {
        return Experience;
    }

    public void setExperience(String experience) {
        Experience = experience;
    }

    public String getRating() {
        return Rating;
    }

    public void setRating(String rating) {
        Rating = rating;
    }

    public String getDoctorPhoto() {
        return doctorPhoto;
    }

    public void setDoctorPhoto(String doctorPhoto) {
        this.doctorPhoto = doctorPhoto;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
