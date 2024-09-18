package com.frankaboagye.connecthub.services;

import com.frankaboagye.connecthub.entities.Company;
import com.frankaboagye.connecthub.interfaces.CompanyServiceInterface;
import com.frankaboagye.connecthub.repositories.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyService implements CompanyServiceInterface {

    private final CompanyRepository companyRepository;

    @Override
    public void registerCompany(Company company) {
        // use aop here
        System.out.println("Registering company " + company.getName());
        companyRepository.save(company);
    }

    @Override
    public Optional<Company> loginCompany(String email, String password) {
        // ustilise aop, security e.t.c
        return companyRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public Optional<Company> updateCompanyProfile(Long id, Company companyUpdate) {

        boolean companyExists = companyRepository.existsByIdAndEmail(id, companyUpdate.getEmail());
        if(!companyExists){ return Optional.empty(); }

        return Optional.of(companyRepository.save(companyUpdate));

    }
}
