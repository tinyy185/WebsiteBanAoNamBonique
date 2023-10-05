package com.example.demo.repository;

import com.example.demo.entity.SoAo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoAoRepository extends JpaRepository<SoAo,Integer> {
}
