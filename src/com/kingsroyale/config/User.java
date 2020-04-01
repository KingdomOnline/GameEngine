package com.kingsroyale.config;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

class User {

  String username;
  String password;
  Properties prop;

  private User (String username, String password){

    this.username = username;
    this.password = password;

  }

  public boolean setPassword(String newPassword){
    Properties prop = new Properties();
    InputStream input = getClass().getClassLoader().getResourceAsStream("user.properties");

    try {
      prop.load(input);

      if(prop.getProperty(this.username) == newPassword) { return false; }

      prop.replace(this.username, newPassword);
      password = newPassword;
      prop.store(new FileOutputStream("/src/com/kingsroyale/resources/properties.config"), null);
      input.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

    return true;
  }

  public boolean setUsername(String newUsername) {
    Properties prop = new Properties();
    InputStream input = getClass().getClassLoader().getResourceAsStream("user.properties");

    try {
      prop.load(input);

      if(prop.getProperty(newUsername) != null || this.username.equals(newUsername)) return false;
      prop.remove(this.username);
      prop.setProperty(newUsername, this.password);
      username = newUsername;
      prop.store(new FileOutputStream("/src/com/kingsroyale/resources/properties.config"), null);
      input.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

    return true;
  }

  public static boolean userExists(String username) {
    Properties prop = new Properties();
    InputStream input = User.class.getClassLoader().getResourceAsStream("user.properties");

    try {
      prop.load(input);
    } catch (IOException e) {
      e.printStackTrace();
    }

    return prop.getProperty(username) != null;
  }

  public static boolean passwordIsCorrect(String username, String password){
    Properties prop = new Properties();
    InputStream input = User.class.getClassLoader().getResourceAsStream("user.properties");

    try {
      prop.load(input);
    } catch (IOException e) {
      e.printStackTrace();
    }

    return prop.getProperty(username).equals(password);
  }

  public static User createUser(String username, String password) {
    Properties prop = new Properties();
    InputStream input = User.class.getClassLoader().getResourceAsStream("user.properties");

    try {
      prop.load(input);

      if(User.userExists(username)) return null;

      prop.setProperty(username, password);

      prop.store(new FileOutputStream("/src/com/kingsroyale/resources/properties.config"), null);
      input.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

    return new User(username, password);
  }

  public static User getUser(String username, String password){

    if(!User.userExists(username)) return null;
    if(!User.passwordIsCorrect(username, password)) return null;

    return new User(username, password);

  }

}
