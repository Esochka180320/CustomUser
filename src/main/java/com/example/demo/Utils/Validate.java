package com.example.demo.Utils;

public class Validate {
  public static boolean validateName(String fullName){
    return fullName.length() > 2 && fullName.length() < 50;
  }

  public static boolean validateEmail(String email){
    return email.length() > 2 && email.length() < 100 && email.contains("@") && email.split("@").length == 2;
  }

  public static boolean validatePhone(String phone){
    if (phone.isEmpty() || (phone.length() > 6 && phone.length() < 14 && phone.startsWith("+") && phone.matches("[0-9]+"))) {
      return true;
    }
    else return false;
  }
}
