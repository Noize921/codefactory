package com.codefactory.internship.lesson8.remote;

import java.util.Random;

public class RemoteService {
    private Random random = new Random();

    public boolean hasUserDebts(long userId) {
        if (userId < 0) throw new IllegalArgumentException("User id cannot be negative");

        return random.nextBoolean();
    }
}
