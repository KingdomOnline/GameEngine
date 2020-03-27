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

  public User (String username, String password){

    try {
      if(!User.userExists(username)) return;
    } catch (IOException e) {
      e.printStackTrace();
    }

    this.username = username;
    this.password = password;

  }

  public Boolean setPassword(String newPassword) throws IOException{
    Properties prop = new Properties();
    InputStream input = getClass().getClassLoader().getResourceAsStream("user.properties");

    if (input != null) {
      prop.load(input);
    } else {
      throw new FileNotFoundException("property file 'user.properties' not found in the classpath");
    }
    if(prop.getProperty(this.username) == newPassword) { return false; }
    
    prop.replace(this.username, newPassword);
    password = newPassword;
    prop.store(new FileOutputStream("/src/com/kingsroyale/resources/properties.config"), null);
    input.close();
    return true;
  }

  public Boolean setUsername(String newUsername) throws IOException{
    Properties prop = new Properties();
    InputStream input = getClass().getClassLoader().getResourceAsStream("user.properties");

    if (input != null) {
      prop.load(input);
    } else {
      throw new FileNotFoundException("property file 'user.properties' not found in the classpath");
    }
    if(prop.getProperty(newUsername) != null || this.username.equals(newUsername)) return false;
    prop.remove(this.username);
    prop.setProperty(newUsername, this.password);
    username = newUsername;
    prop.store(new FileOutputStream("/src/com/kingsroyale/resources/properties.config"), null);
    input.close();
    return true;
  }

  public static Boolean userExists(String username) throws IOException {
    Properties prop = new Properties();
    InputStream input = User.class.getClassLoader().getResourceAsStream("user.properties");

    if (input != null) {
      prop.load(input);
    } else {
      throw new FileNotFoundException("property file 'user.properties' not found in the classpath");
    }
    if(prop.getProperty(username) == null){         return false;
    }
    return true;
  }

  public static User createUser(String username, String password) throws IOException{
    Properties prop = new Properties();
    InputStream input = User.class.getClassLoader().getResourceAsStream("user.properties");

    if (input != null) {
      prop.load(input);
    } else {
      throw new FileNotFoundException("property file 'user.properties' not found in the classpath");
    }
    if(User.userExists(username)) return null;

    prop.setProperty(username, password);

    prop.store(new FileOutputStream("/src/com/kingsroyale/resources/properties.config"), null);
    input.close();
    return new User(username, password);
  }

}
