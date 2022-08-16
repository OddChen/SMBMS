package com.chen.pojo;

import java.util.Date;

/**
 * @author chenxingyu
 */
public class User {
    private Long id;
    private String address;
    private Date birthday;
    private Long createdBy;
    private Date createDate;
    private Integer gender;
    private Long modifyBy;
    private Date modifyDate;
    private String phone;
    private String userCode;
    private String userName;
    private String userPassword;
    private Integer userRole;

    private Integer age;
    private String userRoleName;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return  address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Long getCreatedBy() {
        return createdBy;
    }
    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreateDate() {
        return createDate;
    }
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getGender() {
        return gender;
    }
    public void setGender(Integer gender){
        this.gender = gender;
    }

    public Long getModifyBy() {
        return modifyBy;
    }
    public void setModifyBy(Long modifyBy) {
        this.modifyBy = modifyBy;
    }

    public Date getModifyDate() {
        return modifyDate;
    }
    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Integer getUserRole() {
        return userRole;
    }

    public void setUserRole(Integer userRole) {
        this.userRole = userRole;
    }

    public Integer getAge() {
        Date nowDate = new Date();
        Integer age = nowDate.getYear() - birthday.getYear();
        return age;
    }


    public String getUserRoleName() {
        return userRoleName;
    }

    public void setUserRoleName(String userRoleName) {
        this.userRoleName = userRoleName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", birthday=" + birthday +
                ", createdBy=" + createdBy +
                ", createDate=" + createDate +
                ", gender=" + gender +
                ", modifyBy=" + modifyBy +
                ", modifyDate=" + modifyDate +
                ", phone='" + phone + '\'' +
                ", userCode='" + userCode + '\'' +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userRole=" + userRole +
                ", age=" + age +
                ", userRoleName='" + userRoleName + '\'' +
                '}';
    }
}
