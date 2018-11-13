package com.codefactory.internship.lesson8.execptions;

import java.time.LocalDateTime;

public class UserNotFoundException extends Exception {
    private LocalDateTime occuringTime;

    public UserNotFoundException(String message) {
        super(message);
        this.occuringTime = LocalDateTime.now();
    }

    public LocalDateTime getOccuringTime() {
        return occuringTime;
    }
}
