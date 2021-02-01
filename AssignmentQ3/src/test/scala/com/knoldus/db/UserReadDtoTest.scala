package com.knoldus.db

import org.scalatest.flatspec.AsyncFlatSpec

class UserReadDtoTest extends AsyncFlatSpec {

  val userReadDto=new UserReadDto

  "User John" should "be present in database" in{
    val userDetails=userReadDto.getUserByName("John")
    assert(userDetails.nonEmpty)
  }

  "User Marie" should "be present in database" in{
    val userDetails=userReadDto.getUserByName("Marie")
    assert(userDetails.nonEmpty)
  }

  "User Steve" should "be present in database" in{
    val userDetails=userReadDto.getUserByName("Steve")
    assert(userDetails.nonEmpty)
  }
  "User George" should "not be present in database" in{
    val userDetails=userReadDto.getUserByName("George")
    assert(userDetails.isEmpty)
  }

}
