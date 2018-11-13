package com.codefactory.internship.lesson8.dto;

public class UserDataDto {
    private long id;
    private String firstName;
    private String lastName;
    private boolean hasDebts;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isHasDebts() {
        return hasDebts;
    }

    public void setHasDebts(boolean hasDebts) {
        this.hasDebts = hasDebts;
    }

    @Override
    public String toString() {
        return "UserDataDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", hasDebts=" + hasDebts +
                '}';
    }
}
