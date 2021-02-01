package com.knoldus.validator

import com.knoldus.db.{CompanyReadDto, UserReadDto}
import com.knoldus.models.{Company, User}
import org.mockito.Mockito.{mock, when}
import org.scalatest.flatspec.AsyncFlatSpec

class UserValidatorTest extends AsyncFlatSpec {
  val mockedUserReadDto:UserReadDto=mock(classOf[UserReadDto])
  val mockedCompanyReadDto:CompanyReadDto=mock(classOf[CompanyReadDto])
  val mockedEmailValidator:EmailValidator=mock(classOf[EmailValidator])
  val userValidator=new UserValidator(mockedUserReadDto,mockedCompanyReadDto,mockedEmailValidator)

  "User John" should " be validate" in{
    val user=User("John","Mathews",25,1200000,"Manager","Philips","john.mathews@philips.com")
    when(mockedUserReadDto.getUserByName(user.firstName)) thenReturn Some(User("John","Mathews",25,1200000,"Manager","Philips","john.mathews@philips.com"))
    when(mockedCompanyReadDto.getCompanyByName(user.companyName)) thenReturn Some(Company("Philips","philips123@gmail.com","Noida"))
    when(mockedEmailValidator.emailIsVaid(user.emailId)) thenReturn true
    assert(userValidator.userIsValid(user))
  }

  "User Steve" should " not be validate" in{
    val user=User("John","Mathews",25,1200000,"Manager","Philips","john.mathewsphilips.com")
    when(mockedUserReadDto.getUserByName(user.firstName)) thenReturn None
    when(mockedCompanyReadDto.getCompanyByName(user.companyName)) thenReturn Some(Company("Philips","philips123@gmail.com","Noida"))
    when(mockedEmailValidator.emailIsVaid(user.emailId)) thenReturn false
    assert(!userValidator.userIsValid(user))
  }

  "User Rey" should "not be validate" in{
    val user=User("Rey","Nolan",25,1200000,"Manager","Philips","rey.nolan@philips.com")
    when(mockedUserReadDto.getUserByName(user.firstName)) thenReturn None
    //when(mockedCompanyReadDto.getCompanyByName(user.companyName)) thenReturn Some(Company("Philips","philips123@gmail.com","Noida"))
    //when(mockedEmailValidator.emailIsVaid(user.emailId)) thenReturn true
    assert(!userValidator.userIsValid(user))
  }

  "User John2" should "not be validate" in{
    val user=User("John","Mathews",25,1200000,"Manager","Apple","john.mathews@apple.com")
    when(mockedUserReadDto.getUserByName(user.firstName)) thenReturn Some(User("John","Mathews",25,1200000,"Manager","Philips","john.mathewsphilips.com"))
    when(mockedCompanyReadDto.getCompanyByName(user.companyName)) thenReturn None
    when(mockedEmailValidator.emailIsVaid(user.emailId)) thenReturn true
    assert(!userValidator.userIsValid(user))
  }
}


