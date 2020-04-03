package com.qa.utility;

import java.util.Random;

public class GenerateRandomString {
  
  public String getRandomString(int stringLength) {
      String allAlphabets = "abcdefghijklmnopqrstuvwxyz";
      StringBuilder newString = new StringBuilder();
      Random rnd = new Random();
      while (newString.length() < stringLength) { 
          int index = (int) (rnd.nextFloat() * allAlphabets.length());
          newString.append(allAlphabets.charAt(index));
      }
      String randomString = newString.toString();
      
     //System.out.println(randomString);
      return randomString;

  }
}
