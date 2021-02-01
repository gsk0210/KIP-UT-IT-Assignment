package com.knoldus.question2
import org.scalatest.FlatSpec

class Question2Test extends FlatSpec {

  val question2=new Question2

  "10501" should "be validate" in{
    val isPallindrome=question2.checkPallindrome(10501)
  assert(isPallindrome)
  }

  "12635" should "not validate " in{
    val isPallindrome=question2.checkPallindrome(12635)
    assert(!isPallindrome)
  }

  "Factorial of 3" should "be 6" in{
    val factorial=question2.factorial(3)
    assert(factorial==6)
  }

}
