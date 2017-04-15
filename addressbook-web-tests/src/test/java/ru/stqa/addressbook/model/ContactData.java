package ru.stqa.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "addressbook")
@XStreamAlias("contact")
public class ContactData {
    @Id
    @Column(name = "id")
    @XStreamOmitField
    private int id = Integer.MAX_VALUE;

    @Column(name = "firstname")
    @Expose
    private String firstname;

    @Column(name = "lastname")
    @Expose
    private String lastname;

    @Column(name = "address")
    @Type(type = "text")
    @Expose
    private String address;

    @Column(name = "mobile")
    @Type(type = "text")
    @Expose
    private String mobilePhone;

    @Column(name = "home")
    @Type(type = "text")
    private String homePhone = "";

    @Column(name = "work")
    @Type(type = "text")
    private String workPhone = "";

    @Transient
    private String allPhones;

    @Column(name = "email")
    @Type(type = "text")
    @Expose
    private String email;

    @Transient
    private String email2;

    @Transient
    private String email3;

    @Transient
    private String allEmails;

    @Transient
    private String group;

    @Column(name = "photo")
    @Type(type = "text")
    @Expose
    private String photo;

    public ContactData withPhoto(String photo) {
        this.photo = photo;
        return this;
    }

    public ContactData withEmail(String email) {
        this.email = email;
        return this;
    }

    public ContactData withEmail2(String email2) {
        this.email2 = email2;
        return this;
    }

    public ContactData withEmail3(String email3) {
        this.email3 = email3;
        return this;
    }

    public ContactData withAllEmails(String allEmails) {
        this.allEmails = allEmails;
        return this;
    }

    public ContactData withMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    public ContactData withHomePhone(String homePhone) {

        this.homePhone = homePhone;
        return this;
    }

    public ContactData withWorkPhone(String workPhone) {
        this.workPhone = workPhone;
        return this;
    }

    public ContactData withId(int id) {
        this.id = id;
        return this;
    }

    public ContactData withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public ContactData withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public ContactData withAddress(String address) {
        this.address = address;
        return this;
    }

    public ContactData withGroup(String group) {
        this.group = group;
        return this;
    }

    public ContactData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public String getPhoto() {
        return photo;
    }

    public String getAllPhones() {
        return allPhones;
    }

    public int getId() {
        return id;
    }

    public String getAllEmails() {
        return allEmails;
    }

    public String getEmail2() {
        return email2;
    }

    public String getEmail3() {
        return email3;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getAddress() {
        return address;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public String getEmail() {
        return email;
    }

    public String getGroup() {
        return group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (id != that.id) return false;
        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (mobilePhone != null ? !mobilePhone.equals(that.mobilePhone) : that.mobilePhone != null) return false;
        if (homePhone != null ? !homePhone.equals(that.homePhone) : that.homePhone != null) return false;
        if (workPhone != null ? !workPhone.equals(that.workPhone) : that.workPhone != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        return group != null ? group.equals(that.group) : that.group == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (mobilePhone != null ? mobilePhone.hashCode() : 0);
        result = 31 * result + (homePhone != null ? homePhone.hashCode() : 0);
        result = 31 * result + (workPhone != null ? workPhone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (group != null ? group.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", address='" + address + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", homePhone='" + homePhone + '\'' +
                ", workPhone='" + workPhone + '\'' +
                ", email='" + email + '\'' +
                ", group='" + group + '\'' +
                '}';
    }

}
