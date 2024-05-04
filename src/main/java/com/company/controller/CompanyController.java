package com.company.controller;

import com.company.model.CompanyModel;
import com.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    //getAllCompany
    @GetMapping("/getAll")
    public ResponseEntity<?>getAllCompany(){
        List<CompanyModel> allCompany=companyService.getAllCompany();
        if(!allCompany.isEmpty()){
            return ResponseEntity.ok(allCompany);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not fetched all company info");
        }
    }

    // getByCompanyId
    @GetMapping("/getById/{id}")
    public ResponseEntity<?>getByCompanyId(@PathVariable("id") String companyId){
        CompanyModel company=companyService.getByCompanyId(companyId);
        if(company!=null){
            return ResponseEntity.ok(company);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not fetched company info based on given id");
        }
    }

    // createCompany
    @PostMapping("/post")
    public ResponseEntity<?>createCompany(@RequestBody CompanyModel companyModel){
        CompanyModel company=companyService.createCompany(companyModel);
        if(company!=null){
            return ResponseEntity.ok("created successfully");
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not created");
        }
    }

    // updateCompany
    @PutMapping("/modify/{id}")
    public ResponseEntity<?>updateCompany(@PathVariable("id") String companyId,@RequestBody CompanyModel companyModel){
        CompanyModel company=companyService.updateCompany(companyId,companyModel);
        if(company!=null){
            return ResponseEntity.ok(company);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not updated");
        }
    }

    // deleteCompanyById
    @DeleteMapping("del/{id}")
    public ResponseEntity<?>deleteByCompanyId(@PathVariable("id") String companyId){
        try{
            companyService.deleteCompanyById(companyId);
            return ResponseEntity.ok("deleted successfully");
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not deleted based on given id");
        }
    }



}
