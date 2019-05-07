package br.edu.utfpr.model;


import javax.persistence.*;

@Entity
@Table(name = "employee_contact")
public class EmployeeContact {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String address;

    private String email;


    public EmployeeContact() {
    }

    public EmployeeContact(String address, String email) {
        this.address = address;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
