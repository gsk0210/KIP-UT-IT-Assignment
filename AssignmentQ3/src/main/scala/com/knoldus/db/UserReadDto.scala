package com.knoldus.db

import com.knoldus.models.User

import scala.collection.immutable.HashMap

class UserReadDto {

  val john: User = User("John","Mathews",25,1200000.0,"Manager","Philips","john.mathews@philips.com")
  val marie: User = User("Marie","Rogers",27,1800000.0,"Developer","Philips","marie.rogers@philips.com")
  val steve: User = User("Steve","Jones",28,1500000.0,"IT Executive","Philips","steve.jones@philips.com")

  val users: HashMap[String,User]=HashMap("John"->john,"Marie"->marie,"Steve"->steve)

  def getUserByName(name:String):Option[User]=users.get(name)

}
