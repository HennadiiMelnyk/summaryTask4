package ua.nure.melnyk.summaryTask4.model;

import java.util.Objects;

/**
 * User model
 */
public class User {

    private int id;
    private String surname;
    private String email;
    private String password;
    private boolean isBlock;
    private Role role;

    public User() {
    }

    public User(int id, String surname, String email, String password, boolean isBlock, Role role) {
        this.id = id;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.isBlock = isBlock;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getIsBlock() {
        return isBlock;
    }

    public void setBlock(boolean block) {
        isBlock = block;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(surname, user.surname) &&
                Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, surname, email);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", getIsBlock=" + isBlock +
                ", role=" + role +
                '}';
    }
}
