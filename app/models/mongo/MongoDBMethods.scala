package models.mongo

import models.DataModels.Register
import reactivemongo.api.collections.bson.BSONCollection

import scala.concurrent.Future

object MongoDBMethods {

  def registerUser(collection: Future[BSONCollection],value: Register) =  {

  }
}
