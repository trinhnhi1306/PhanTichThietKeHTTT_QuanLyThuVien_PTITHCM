/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.database;

/**
 *
 * @author tonth
 */
public class Staff {
    private String username,password,fullName, gender,dateOfBirth,registeredDate;
    private int address_id;
    private String phoneNumber, email;
    private int roleId, status;

    public Staff() {
    }

    // thêm mới.
    public Staff(String username, String password, String fullName, String gender, String dateOfBirth, String registeredDate, int address_id, String phoneNumber, String email, int roleId, int status) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.registeredDate = registeredDate;
        this.address_id = address_id;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.roleId = roleId;
        this.status = status;
    }

    // dùng trong update.
    public Staff(String username, String fullName, String gender, String dateOfBirth,int address_id, String phoneNumber, String email , int roleId) {
        this.username = username;
        this.fullName = fullName;
        this.gender = gender;
        this.address_id = address_id;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.roleId = roleId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(String registeredDate) {
        this.registeredDate = registeredDate;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
}
