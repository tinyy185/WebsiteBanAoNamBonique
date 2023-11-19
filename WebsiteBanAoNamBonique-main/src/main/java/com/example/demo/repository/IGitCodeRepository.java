package com.example.demo.repository;

import com.example.demo.model.GitCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGitCodeRepository extends JpaRepository<GitCode,Integer> {

    GitCode findGitCodeById(Integer id);
    GitCode findGitCodeByTenGitCode(String tenGitCode);

}
