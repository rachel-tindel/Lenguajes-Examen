package com.example.labspringboot.domain;
import javax.persistence.*;

@Entity
@Table(name = "Major")
@NamedStoredProcedureQuery(name = "Major.getAllMajors", procedureName = "SelectMajor")

@NamedStoredProcedureQuery(name = "Major.getMajorById",procedureName = "SelectMajorById", parameters = {@StoredProcedureParameter(mode = ParameterMode.IN, name = "@Id", type = Integer.class)})

@NamedStoredProcedureQuery(name = "Major.deleteMajorSP",procedureName = "DeleteMajor", parameters = {@StoredProcedureParameter(mode = ParameterMode.IN, name = "Id", type = Integer.class)})

@NamedStoredProcedureQuery(name = "Major.insertMajorSP",procedureName = "InsertMajor", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Code", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Name", type = String.class)
})

@NamedStoredProcedureQuery(name = "Major.updateMajorSP",procedureName = "UpdateMajor", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Id", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Code", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Name", type = String.class)
})
public class Major {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String code;
    private String name;

    public Major(){

    }

    public Major(int id, String code, String name) {
        this.setId(id);
        this.setCode(code);
        this.setName(name);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
