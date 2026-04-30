package edu.utsa.cs3443.iyh856_lab4.model;

public abstract class Person {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String userName;
    private String password;

    public Person(String firstName, String lastName, String email, String phoneNumber,String username, String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.userName = username;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setUserName(String username){
        this.userName = username;
    }

    public String getUserName(){
        return this.userName;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return this.password;
    }

    public String toString(){
        return String.format("%s %s, phone number: %s, email address: %s", this.firstName, this.lastName, this.phoneNumber, this.email);
    }


}
