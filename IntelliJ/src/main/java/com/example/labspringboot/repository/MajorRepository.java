package com.example.labspringboot.repository;

import com.example.labspringboot.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import com.example.labspringboot.domain.Major;

import java.util.List;

public interface MajorRepository extends JpaRepository<Major, Integer> {

    @Query(value = "SelectMajor", nativeQuery = true)
    List<Major> getAllMajors();
    @Query(value = "{ call SelectMajorById(:Id)}", nativeQuery = true)
    Major getMajorById(@Param("Id") Integer id);
    @Procedure(name = "Major.insertMajorSP")
    void insertMajorSP(@Param("Code") String code,
                         @Param("Name") String name,
                       @Param("Numberofterms") String numberofterms);

    @Procedure(name = "Major.updateMajorSP")
    void updateMajorSP(@Param("Id") Integer majorId,
                         @Param("Code") String code,
                         @Param("Name") String name,
                       @Param("Numberofterms") String numberofterms);
    @Procedure(name = "Major.deleteMajorSP")
    void deleteMajorSP(@Param("Id") int id);


}
