package models.mongo

import javax.inject.Inject
import models.DataModels.Register
import models.Enumerations.MESSAGE._
import play.modules.reactivemongo.{MongoController, ReactiveMongoApi, ReactiveMongoComponents}
import reactivemongo.api.collections.bson.BSONCollection

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class AccountMongoDAO @Inject()(val mongo: ReactiveMongoApi)() extends AccountDAO {

  def table_user_registration: Future[BSONCollection] = mongo.database.map(_.collection[BSONCollection]("register"))

  //register user on website
  def register(value:Register): Future[(Register, MESSAGE)] =  {
      table_user_registration.map(_.insert[Register](value)).map{_ => (value,SUCCESS)}
  }recoverWith {
    case e: Exception => Future((null, FAILURE))
  }




}
