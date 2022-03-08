package com.example.dating.repository;

import com.example.dating.domain.Idel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdelRepository extends JpaRepository<Idel, Integer> {
}
