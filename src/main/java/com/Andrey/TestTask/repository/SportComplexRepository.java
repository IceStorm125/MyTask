package com.Andrey.TestTask.repository;

import com.Andrey.TestTask.model.SportComplex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SportComplexRepository extends JpaRepository<SportComplex,Long> {
}
