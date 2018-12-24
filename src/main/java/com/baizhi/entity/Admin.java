package com.baizhi.entity;

import java.util.Objects;

/**
 * 管理员类
 */
public class Admin {
    private String adminId;
    private String adminName;
    private String password;
    private String salt;
    public Admin() {
        super();
    }
    @Override
    public String toString() {
        return "Admin{" +
                "adminId='" + adminId + '\'' +
                ", adminName='" + adminName + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admin admin = (Admin) o;
        return Objects.equals(adminId, admin.adminId) &&
                Objects.equals(adminName, admin.adminName) &&
                Objects.equals(password, admin.password) &&
                Objects.equals(salt, admin.salt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adminId, adminName, password, salt);
    }

    public Admin(String adminId, String adminName, String password, String salt) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.password = password;
        this.salt = salt;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
