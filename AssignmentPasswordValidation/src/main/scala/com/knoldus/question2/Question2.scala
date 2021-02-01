package com.knoldus.question2

class Question2 {

    def checkPallindrome(number:Int):Boolean={
      var numberString=number.toString
      var reverseNumber=numberString.reverse
      if(numberString.equals(reverseNumber)) return true
      else return false
    }
    def factorial(number:Int):Int={
      var result:Int=1
      var temp=number
      while(temp>0){
        result=result*temp
        temp=temp-1
      }
      return result
    }

}
