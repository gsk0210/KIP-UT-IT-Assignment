package com.knoldus.validator

import org.scalatest.flatspec.AsyncFlatSpec


class EmailValidationTest extends AsyncFlatSpec{

  val mail=new EmailValidator

  "the email" should "be valid" in{

    val isEmail=mail.emailIsVaid("abc12@gmail.com")
    assert(isEmail)
  }

   "not email" should "not be valid" in{

    val isEmail=mail.emailIsVaid("abc12@gmailcom")
    assert(!isEmail)
  }

     "not email1" should "not be valid" in{

    val isEmail=mail.emailIsVaid("abc12gmail.com")
    assert(!isEmail)
  }

}
