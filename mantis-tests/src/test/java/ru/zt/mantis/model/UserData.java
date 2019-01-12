package ru.zt.mantis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name = "mantis_user_table")
@Entity
public class UserData {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserData userData = (UserData) o;

        if (id != userData.id) return false;
        if (username != null ? !username.equals(userData.username) : userData.username != null) return false;
        if (email != null ? !email.equals(userData.email) : userData.email != null) return false;
        return email != null ? email.equals(userData.email) : userData.email == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
    @Id
    @Column(name="id")
    private int id = Integer.MAX_VALUE;

    @Column(name="username")
    private String username;

    @Column(name="email")
    private String email;

    public int getId() { return id;    }

    public String getEmail() {
        return email;
    }


}
