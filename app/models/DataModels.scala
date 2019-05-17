package models

import play.api.libs.json.Json
//import reactivemongo.bson.{BSONDocument, BSONDocumentReader, BSONDocumentWriter}
import reactivemongo.bson.{BSONBoolean, BSONDateTime, BSONDocument, BSONDocumentReader, BSONDocumentWriter, BSONDouble, BSONInteger, BSONObjectID, BSONTimestamp}


object DataModels {
  //member registration
  case class Register(
                     firstName: String,
                     lastName:String,
                     phoneNumber: String,
                     email: String,
                     password: String,
                     country: String,
                     dateOfBirth:Long
                     )

  object Register{
    implicit val _formats = Json.format[Register]

    implicit object reader extends BSONDocumentReader[Register] {
      def read(x: BSONDocument): Register = Register(
        x.getAs[String]("_firstName").getOrElse(""),
        x.getAs[String]("_lastName").getOrElse(""),
        x.getAs[String]("_phoneNumber").getOrElse(""),
        x.getAs[String]("_email").getOrElse(""),
        x.getAs[String]("_password").getOrElse(""),
        x.getAs[String]("_country").getOrElse(""),
        x.getAs[Long]("_dateOfBirth").getOrElse(0),
      )
    }


    implicit object writer extends BSONDocumentWriter[Register] {
      def write(x:Register ):BSONDocument = BSONDocument(
        "_firstName" -> x.firstName,
        "_lastName" -> x.firstName,
        "_phoneNumber" -> x.phoneNumber,
        "_email" -> x.email,
        "_password" -> x.password,
        "_country" -> x.country,
        "_dateOfBirth" -> x.dateOfBirth
      )
    }
  }

}


/*


  implicit object autosaveWriter extends BSONDocumentWriter[AutoSave] {
    def write(autosave: AutoSave): BSONDocument = BSONDocument(
//      "_id" -> BSONObjectID.generate(),
      "_accountNo" -> autosave.accountNo,
      "_dayOfMonth" -> autosave.dayOfMonth,
      "_currency" -> autosave.currency.toString,
      "_amount" -> BSONDouble(autosave.amount.toDouble),
      "_dayOfWeek" -> autosave.dayOfWeek,
      "_status" -> autosave.status.toString,
      "_frequency" -> autosave.frequency.toString,
      "_tombStone" -> false,
      "_timeStamp" -> BSONDateTime(autosave.timeStamp),
      "_lastUpdated" -> BSONDateTime(autosave.lastUpdated),
      "_usage" -> autosave.usage.getOrElse(Usage.UNSET).toString,
      "_isApproved" -> BSONBoolean(autosave.isApproved.getOrElse(false)),
      "_tId" -> autosave.tId.getOrElse("XX")
    )



    implicit object autoSaveReader extends BSONDocumentReader[AutoSave] {
    def read(x: BSONDocument): AutoSave = AutoSave(
      x.getAs[String]("_accountNo").getOrElse("none"),
      x.getAs[BSONDouble]("_amount").getOrElse(BSONDouble(0.0)).value,
      Currency.withName(x.getAs[String]("_currency").getOrElse("UGX")),
      AutoSaveStatus.withName(x.getAs[String]("_status").getOrElse("UNSET")),
      AutoSaveFrequency.withName(x.getAs[String]("_frequency").getOrElse("UNSET")),
      Some(x.getAs[String]("_dayOfWeek").getOrElse(" none")),
      Some(x.getAs[BSONInteger]("_dayOfMonth").getOrElse(BSONInteger(0)).value),
      x.getAs[BSONDateTime]("_timeStamp").getOrElse(BSONDateTime.apply(0)).value,
      x.getAs[BSONDateTime]("_lastUpdated").getOrElse(BSONDateTime.apply(0)).value,
      Some(Usage.withName(x.getAs[String]("_usage").getOrElse("UNSET"))),
      Some(x.getAs[BSONBoolean]("_isApproved").getOrElse(BSONBoolean(false)).value),
      Some(x.getAs[String]("_tId").getOrElse("None"))
    )
  }*/