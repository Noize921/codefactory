package com.codefactory.internship.lesson7.dao.impl;

import com.codefactory.internship.lesson7.dao.UserDaoIntf;
import com.codefactory.internship.lesson7.domain.User;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CSVUserDaoImpl implements UserDaoIntf {
    private static final String FILE_NAME = "users.csv";
    private String userFileName;
    private List<User> users = new ArrayList<>();

    public CSVUserDaoImpl() {}
    public CSVUserDaoImpl(String fileName) {
        this.userFileName = fileName;
    }

    @Override
    public void save(User user) {
        users.add(user);
        saveToFile();
    }

    private void saveToFile() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < this.users.size(); i++) {
            User currentUser = users.get(i);

            stringBuilder.append(currentUser.getId());
            stringBuilder.append(",");
            stringBuilder.append(currentUser.getFirstName());
            stringBuilder.append(",");
            stringBuilder.append(currentUser.getLastName());

            if (i < this.users.size() - 1) stringBuilder.append("\n");
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter((this.userFileName == null) ? FILE_NAME : this.userFileName))) {
            bufferedWriter.write(stringBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        String[] userData;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader((this.userFileName == null) ? FILE_NAME : this.userFileName))) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                // [userId, userFirstName, userLastName]
                String[] splittedLine = line.split(",");


                users.add(new User(Long.parseLong(splittedLine[0]), splittedLine[1], splittedLine[2]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return users;
    }
}
