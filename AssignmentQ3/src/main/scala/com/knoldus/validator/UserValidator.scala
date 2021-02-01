package com.knoldus.validator

import com.knoldus.db.{CompanyReadDto, UserReadDto}
import com.knoldus.models.User

class UserValidator(userReadDto: UserReadDto,companyReadDto: CompanyReadDto,emailValidator: EmailValidator) {


    def userIsValid(user:User):Boolean={
      if(emailExist(user.emailId)){
        if(companyExist(user)){
          return true
        }
        else
          {
            return false
          }
      }
      else{
        return false
      }
    }

    def companyExist(user:User):Boolean={
      val companyExist=companyReadDto.getCompanyByName(user.companyName)
      if(companyExist.nonEmpty){
        return true
      }
      else{
        return false
      }
    }

    def emailExist(email:String):Boolean={
      if(emailValidator.emailIsVaid(email)){
        return true
      }
      else{
        return false
      }
    }
  }




