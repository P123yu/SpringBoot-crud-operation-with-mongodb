package com.company.repository;

import com.company.model.CompanyModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CompanyRepository extends MongoRepository<CompanyModel,String> {

}
