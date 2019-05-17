package models.mongo

import models.DataModels.Register
import models.Enumerations.MESSAGE.MESSAGE

import scala.concurrent.Future

trait AccountDAO {

  def register(value:Register): Future[(Register, MESSAGE)]



}
