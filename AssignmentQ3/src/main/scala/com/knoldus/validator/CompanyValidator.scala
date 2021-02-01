package com.knoldus.validator

import com.knoldus.models.Company
import com.knoldus.db.CompanyReadDto


class CompanyValidator(companyReadDto: CompanyReadDto,emailValidator: EmailValidator) {

  def companyIsValid(company: Company):Boolean={
    val res=companyReadDto.getCompanyByName(company.name)
    if(res.isEmpty) {
      if (emailExist(company.emailId)) {
        return true
      }
      else {
        return false
      }
    }
    else{
      return false
    }
  }


  def emailExist(email:String):Boolean={
    if(emailValidator.emailIsVaid
    (email)){
      return true
    }
    else{
      return false
    }
  }
  }

