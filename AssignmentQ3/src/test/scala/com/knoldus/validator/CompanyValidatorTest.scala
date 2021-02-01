package com.knoldus.validator

import com.knoldus.db.CompanyReadDto
import com.knoldus.models.Company
import org.scalatest.flatspec.AsyncFlatSpec
import org.mockito.Mockito.{mock, when}

class CompanyValidatorTest extends AsyncFlatSpec {

  val mockedCompanyReadDto:CompanyReadDto=mock(classOf[CompanyReadDto])
  val mockedEmailValidator:EmailValidator=mock(classOf[EmailValidator])
  val companyValidator=new CompanyValidator(mockedCompanyReadDto,mockedEmailValidator)

  "Company Tesla" should " be validate" in{
    val company=Company("Tesla","contactus@tesla.com","California")
    when(mockedCompanyReadDto.getCompanyByName(company.name)) thenReturn None
    when(mockedEmailValidator.emailIsVaid(company.emailId)) thenReturn true
    assert(companyValidator.companyIsValid(company))

  }

  "Company Amazon" should "not validate due to wrong email address" in{
    val company=Company("Amazon","amaz123india.","Seattle")
    when(mockedCompanyReadDto.getCompanyByName(company.name)) thenReturn None
    when(mockedEmailValidator.emailIsVaid(company.emailId)) thenReturn false
    assert(!companyValidator.companyIsValid(company))
  }

  "Company Knoldus" should "not validate if it already exists" in{
    val company=Company("Knoldus","knoldus@gmail.com","Noida")
    when(mockedCompanyReadDto.getCompanyByName(company.name)) thenReturn Some(Company("Knoldus","knoldus@gmail.com","Noida"))
    assert(!companyValidator.companyIsValid(company))
  }
}