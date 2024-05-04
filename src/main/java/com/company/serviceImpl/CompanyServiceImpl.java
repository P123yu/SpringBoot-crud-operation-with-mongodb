package com.company.serviceImpl;

import com.company.model.CompanyModel;
import com.company.repository.CompanyRepository;
import com.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;


@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public List<CompanyModel> getAllCompany() {
        List<CompanyModel>allCompany=companyRepository.findAll();
        return allCompany;
    }

    @Override
    public CompanyModel getByCompanyId(String companyId) {
        CompanyModel company=companyRepository.findById(companyId).orElse(null);
        return company;
    }

    @Override
    public CompanyModel createCompany(CompanyModel companyModel) {
        CompanyModel company=companyRepository.save(companyModel);
        return company;
    }

    @Override
    public CompanyModel updateCompany(String companyId, CompanyModel companyModel) {
        boolean result=companyRepository.existsById(companyId);
        if(result){
            companyModel.setCompanyId(companyId);
            CompanyModel company=companyRepository.save(companyModel);
            return company;
        }
        else{
            return null;
        }
    }

    @Override
    public void deleteCompanyById(String companyId) {
        boolean result=companyRepository.existsById(companyId);
        if(result){
            companyRepository.deleteById(companyId);
        }
        else{
            throw new NoSuchElementException();
        }

    }
}
