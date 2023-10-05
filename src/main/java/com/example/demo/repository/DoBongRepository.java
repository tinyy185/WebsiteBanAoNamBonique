package com.example.demo.repository;

import com.example.demo.entity.DoiBong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoBongRepository extends JpaRepository<DoiBong,Integer> {
}
