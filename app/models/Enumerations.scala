package models

import play.api.libs.json.Reads

object Enumerations {


  object MESSAGE extends Enumeration {
    type MESSAGE = Value
    val SUCCESS, FAILURE = Value
    //implicit val _Read: Reads[MESSAGE] = Reads.enumNameReads(MESSAGE)
  }

}
