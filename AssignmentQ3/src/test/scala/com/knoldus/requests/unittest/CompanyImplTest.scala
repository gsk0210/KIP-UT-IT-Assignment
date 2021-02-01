package com.knoldus.requests.unittest

import com.knoldus.models.Company
import com.knoldus.request.CompanyImpl
import com.knoldus.validator.CompanyValidator
import org.mockito.Mockito.{mock, when}
import org.scalatest.flatspec.AsyncFlatSpec

class CompanyImplTest extends AsyncFlatSpec {

  val mockCompanyValidator:CompanyValidator=mock(classOf[CompanyValidator])
  val companyImpl=new CompanyImpl(mockCompanyValidator)

  "Company Google" should "be created" in{
    val company=Company("Google","googleinc@alphabet.com","California")
    when(mockCompanyValidator.companyIsValid(company)) thenReturn true
    val isCreated=companyImpl.createCompany(company)
    assert(isCreated==Some(company.name))
  }

  "Company Knoldus" should "not be validate" in{
    val company=Company("Knoldus","knoldus@gmail.com","Noida")
    when(mockCompanyValidator.companyIsValid(company)) thenReturn false
    val isCreated=companyImpl.createCompany(company)
    assert(isCreated==None)
  }
  "Company Facebook" should "not be validate" in{
    val company=Company("Facebook","facebookcom","California")
    when(mockCompanyValidator.companyIsValid(company)) thenReturn false
    val isCreated=companyImpl.createCompany(company)
    assert(isCreated==None)
  }
 }
