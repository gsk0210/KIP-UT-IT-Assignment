package com.knoldus
import scala.util.matching.Regex

class CheckPassword(password:String) {
  def canBePassword: Boolean=password.matches("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-])(?=\\S+$).{8,}$")






}