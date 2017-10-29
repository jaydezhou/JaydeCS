package com.jayde.test.lombok;

import java.util.Date;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import ensemble.samples.language.fxml.User;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
public class TestLombok {
  private Integer id;
  private String userName;
  private String password;
  private String email;
  private Integer age;
  private Date signupTime;
  public static void main(String[] args) {
    TestLombok user=new TestLombok();
    user.setId(1001);
    user.setUserName("pollyduan");
    user.setPassword("123456");
    user.setEmail("pollyduan@pollyduan.com");
    user.setAge(30);
    user.setSignupTime(new Date());
    System.out.println(user);
    System.out.println(user.getUserName());
    System.out.println(user.hashCode());
  }
}
