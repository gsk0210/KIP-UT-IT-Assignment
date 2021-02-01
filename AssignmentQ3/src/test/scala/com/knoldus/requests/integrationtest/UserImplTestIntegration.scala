package com.knoldus.requests.integrationtest

import com.knoldus.db.{CompanyReadDto, UserReadDto}
import com.knoldus.models.{Company, User}
import com.knoldus.request.UserImpl
import com.knoldus.validator.{EmailValidator, UserValidator}
import org.scalatest.funsuite.AsyncFunSuite

class UserImplTestIntegration extends AsyncFunSuite {

  val userValidator=new UserValidator(userReadDto = new UserReadDto,companyReadDto = new CompanyReadDto,emailValidator = new EmailValidator)
  val userImpl=new UserImpl(userValidator)

  val user1:User=User("Robert","Andrews",31,2400000.0,"Project Manager","Philips","robert.andrews@philips.com")
  test("Correct User Name and email Id"){
    val isCreated=userImpl.createUser(user1)
    assert(isCreated==Some(user1.firstName))
  }

  val user2:User=User("Steve","Jones",28,1500000.0,"IT Executive","Apple","steve.jones@philips.com")
  test("user already exist"){
    val isCreated=userImpl.createUser(user2)
    assert(isCreated==None)
  }

  val user3:User=User("Steven","Jonas",29,1900000.0,"IT Executive","Philips","stevejonesphilips.com")
  test("Email is incorrect"){
    val isCreated=userImpl.createUser(user3)
    assert(isCreated==None)
  }



  /*val company2:Company=Company("Philips","philips123@gmail.com","California")
  test("Company Name already exist"){
    val isCreated=companyImpl.createCompany(company2)
    assert(isCreated==None)
  }

  val company3:Company=Company("Flipkart","contactflipkartcom","Bengaleru")
  test("Company has invalid email"){
    val isCreated=companyImpl.createCompany(company3)
    assert(isCreated==None)
  } {*/

}
