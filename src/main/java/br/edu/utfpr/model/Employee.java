package br.edu.utfpr.model;


import br.edu.utfpr.util.BCrypt;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String cpf;

    @OneToOne
    private EmployeeContact employeeContact;

    @OneToOne
    private User user;

    public Employee() {
    }

    public Employee(String name, String cpf, EmployeeContact employeeContact, User user) {
        this.name = name;
        this.cpf = cpf;
        this.employeeContact = employeeContact;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        String passwordHash = BCrypt.hashpw(cpf, BCrypt.gensalt(12));
        this.cpf = passwordHash;
    }

    public EmployeeContact getEmployeeContact() {
        return employeeContact;
    }

    public void setEmployeeContact(EmployeeContact employeeContact) {
        this.employeeContact = employeeContact;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
