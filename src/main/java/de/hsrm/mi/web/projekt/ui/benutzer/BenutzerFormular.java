package de.hsrm.mi.web.projekt.ui.benutzer;

import java.time.LocalDate;

public class BenutzerFormular {

    private String name = "";
    private String mail = "";
    private String password = "";
    private LocalDate birthday;

    public String getName() {
        return name;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

}
