package com.example.labspringboot.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import com.example.labspringboot.domain.Major;
import com.example.labspringboot.repository.MajorRepository;

@Service
@Transactional
public class MajorService {
    @Autowired //Es como instaciar el context en MVC
    private MajorRepository repository;
    //From the stored procedure
    public List<Major> getAllMajors() {
        return repository.getAllMajors();
    }
    //From the stored procedure
    public Major getMajorById(int id) {
        return repository.getMajorById(id);
    }
    //From the stored procedure
    public void insertMajorSP(Major major) {
        repository.insertMajorSP(major.getCode(),
                major.getName(), major.getNumberofterms());
    }
    //From the stored procedure
    public void updateMajorSP(Major major) {
        repository.updateMajorSP(major.getId(),major.getCode(),
                major.getName(), major.getNumberofterms());
    }
    //From the stored procedure
    public void deleteMajorSP(int id) {
        repository.deleteMajorSP(id);
    }


}
