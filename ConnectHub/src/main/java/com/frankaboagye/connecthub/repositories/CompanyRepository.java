package com.frankaboagye.connecthub.repositories;

import com.frankaboagye.connecthub.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    Optional<Company> findByEmailAndPassword(String email, String password);
}
