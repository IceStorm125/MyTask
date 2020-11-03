package com.Andrey.TestTask.repository;

import com.Andrey.TestTask.model.Client;
import com.Andrey.TestTask.model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitRepository extends JpaRepository<Visit,Long> {
    int countAllByClient(Client client);
}
