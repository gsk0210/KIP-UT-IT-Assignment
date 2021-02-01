package com.knoldus.requests.integrationtest

import com.knoldus.db.CompanyReadDto
import com.knoldus.validator.{CompanyValidator, EmailValidator}
import com.knoldus.models.Company
import com.knoldus.request.CompanyImpl
import org.scalatest.funsuite.AsyncFunSuite

class CompanyImplTestIntegration extends AsyncFunSuite {

  val companyValidator=new CompanyValidator(companyReadDto = new CompanyReadDto,emailValidator = new EmailValidator)
  val companyImpl=new CompanyImpl(companyValidator)

  val company1:Company=Company("Walmart","contactus@walmart.com","Arkansas")
  test("Correct Company Name and email Id"){
    val isCreated=companyImpl.createCompany(company1)
    assert(isCreated==Some(company1.name))
  }

  val company2:Company=Company("Philips","philips123@gmail.com","California")
  test("Company Name already exist"){
    val isCreated=companyImpl.createCompany(company2)
    assert(isCreated==None)
  }

  val company3:Company=Company("Flipkart","contactflipkartcom","Bengaleru")
  test("Company has invalid email"){
    val isCreated=companyImpl.createCompany(company3)
    assert(isCreated==None)
  }


}
