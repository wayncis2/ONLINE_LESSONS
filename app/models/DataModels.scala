package models

import play.api.libs.json.Json

object DataModels {
  //member registration
  case class Register(
                     firstname: String,
                     lastname:String,
                     phoneNumber: String,
                     email: String,
                     password: String,
                     country: String,
                     dateOfBirth:Long
                     )

  object Register{
    implicit val _formats = Json.format[Register]
  }

}
