package com.knoldus.requests.unittest

import com.knoldus.models.{Company, User}
import com.knoldus.request.{CompanyImpl, UserImpl}
import com.knoldus.validator.UserValidator
import org.mockito.Mockito.{mock, when}
import org.scalatest.flatspec.AsyncFlatSpec

class UserImplTest extends AsyncFlatSpec {

  val mockUserValidator:UserValidator=mock(classOf[UserValidator])
  val userImpl=new UserImpl(mockUserValidator)

  "User Robin" should "be created" in{
    val user=User("Robin","Smith",29,1600000.0,"Software Consultant","Philips","robin.smith@philips.com")
    when(mockUserValidator.userIsValid(user)) thenReturn true
    val isCreated=userImpl.createUser(user)
    assert(isCreated==Some(user.firstName))
  }

  "User Marie" should "not be created" in{
    val user=User("Marie","Rogers",27,1800000.0,"Developer","HCL","marie.rogers@philips.com")
    when(mockUserValidator.userIsValid(user)) thenReturn false
    val isCreated=userImpl.createUser(user)
    assert(isCreated==None)
  }

  "User Kevin" should "not be created" in{
    val user=User("Kevin","Smith",31,1700000.0,"Software Consultant","Philips","robin.smithphilips.com")
    when(mockUserValidator.userIsValid(user)) thenReturn false
    val isCreated=userImpl.createUser(user)
    assert(isCreated==None)
  }

}


