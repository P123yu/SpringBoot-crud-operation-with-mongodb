package com.company.service;

import com.company.model.CompanyModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CompanyService {

    // getAllCompany
    List<CompanyModel> getAllCompany();

    // getCompanyById
    CompanyModel getByCompanyId(String companyId);

    // createCompany
    CompanyModel createCompany(CompanyModel companyModel);

    // updateCompany
    CompanyModel updateCompany(String companyId,CompanyModel companyModel);

    // deleteCompanyById
    void deleteCompanyById(String companyId);
}
