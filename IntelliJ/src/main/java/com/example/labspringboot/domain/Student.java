package com.example.labspringboot.domain;

import javax.persistence.*;

@Entity
@Table(name = "Student")
@NamedStoredProcedureQuery(name = "Student.getAllStudents", procedureName = "SelectStudent")

@NamedStoredProcedureQuery(name = "Student.getStudentById",procedureName = "SelectStudentById", parameters = {@StoredProcedureParameter(mode = ParameterMode.IN, name = "@Id", type = Integer.class)})

@NamedStoredProcedureQuery(name = "Student.deleteStudentSP",procedureName = "DeleteStudent", parameters = {@StoredProcedureParameter(mode = ParameterMode.IN, name = "Id", type = Integer.class)})

@NamedStoredProcedureQuery(name = "Student.insertStudentSP",procedureName = "InsertStudent", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Name", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Email", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Id_Major", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Password", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Id_Nationality", type = Integer.class)
})

@NamedStoredProcedureQuery(name = "Student.updateStudentSP",procedureName = "UpdateStudent", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Id", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Name", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Email", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Id_Major", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Password", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Id_Nationality", type = Integer.class)
})
public class Student {

    /* Debe tener el mismo nombre de id en la BD */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String name;
    private String email;
    private String password;

    //Hay que decir como estan asociadas Major y Nationality en la BD
    @ManyToOne
    @JoinColumn(name = "Id_Major")
    private Major major;

    @ManyToOne
    @JoinColumn(name = "Id_Nationality")
    private Nationality nationality;

    public Student(){

    }

    public Student(int id, String name, String email, String password, Major major, Nationality nationality) {
        this.setId(id);
        this.setName(name);
        this.setEmail(email);
        this.setPassword(password);
        this.setMajor(major);
        this.setNationality(nationality);
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

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public Nationality getNationality() {
        return nationality;
    }

    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }
}
