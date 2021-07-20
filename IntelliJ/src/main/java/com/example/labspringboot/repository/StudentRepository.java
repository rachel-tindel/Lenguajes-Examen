package com.example.labspringboot.repository;
import com.example.labspringboot.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
/*Aqui van las SP's
* metodos customizados
* los que ya existen por defecto */

        @Query(value = "SelectStudent", nativeQuery = true)
        List<Student> getAllStudents();
        @Query(value = "{ call SelectStudentById(:Id)}", nativeQuery = true)
        Student getStudentById(@Param("Id") Integer id);
        @Procedure(name = "Student.insertStudentSP")
        void insertStudentSP(@Param("Name") String name,
                             @Param("Email") String email,
                             @Param("Id_Major") int idMajor,
                             @Param("Password") String password,
                             @Param("Id_Nationality") int idNationality );

        @Procedure(name = "Student.updateStudentSP")
        void updateStudentSP(@Param("Id") Integer studentId,
                             @Param("Name") String name,
                             @Param("Email") String email,
                             @Param("Id_Major") int idMajor,
                             @Param("Password") String password,
                             @Param("Id_Nationality") int idNationality);
        @Procedure(name = "Student.deleteStudentSP")
        void deleteStudentSP(@Param("Id") int id);


}
