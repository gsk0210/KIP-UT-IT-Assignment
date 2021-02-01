package com.knoldus.validator

class EmailValidator {



  def emailIsVaid(email:String):Boolean=email.matches("^[a-zA-Z0-9_.-]+@[a-zA-Z0-9.-]+$")

}


