package com.knoldus

import org.scalatest.FlatSpec

class PasswordValidator extends FlatSpec{

  "the password" should "be valid "in{
    val checkPassword=new CheckPassword("Abcdef@123")
    assert(checkPassword.canBePassword)
  }

  it should "have atleast one Uppercase alphabet" in{
    val checkPassword=new CheckPassword("abcdef@123")
    assert(!checkPassword.canBePassword)
  }

  it should "have atleast one Lowercase alphabet" in{
    val checkPassword=new CheckPassword("ABCDEF@123")
    assert(!checkPassword.canBePassword)
  }

  it should "have atleast one number" in{
    val checkPassword=new CheckPassword("Abcdef@")
    assert(!checkPassword.canBePassword)
  }

  it should "have atleast one symbol" in{
    val checkPassword=new CheckPassword("Abcdef1234")
    assert(!checkPassword.canBePassword)
  }

  it should "have no spaces" in{
    val checkPassword=new CheckPassword("Abc def@123")
    assert(!checkPassword.canBePassword)
  }

}
