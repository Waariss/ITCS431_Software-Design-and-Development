package com.example.demo.Repositories;
import com.example.demo.Models.SciencePlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SciencePlanRepository extends JpaRepository<SciencePlan, Integer> {
}

