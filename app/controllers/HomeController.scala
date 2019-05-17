package controllers


import javax.inject._
import play.api.libs.json.{JsError, JsSuccess, Json}
import play.api.mvc._
import models.DataModels._

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global


/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }



  //register memebrs
  def register() = Action.async(parse.json){implicit request =>
    Json.fromJson[Register](request.body) match {
      case JsSuccess(value, _) => {
        println("JsSucess")
        Future(Ok("Done..."))

      }

      case JsError(e) => {
        println("JsError")
        Future(Ok("Failed"))
      }
    }



  }

}
