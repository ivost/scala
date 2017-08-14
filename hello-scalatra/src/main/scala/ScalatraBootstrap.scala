import com.example.app._
import org.scalatra._
import javax.servlet.ServletContext

class ScalatraBootstrap extends LifeCycle {
    //with CasClientInit {

  implicit val swagger = new MySwagger

  override def init(context: ServletContext) {
    //configureClient()
    context.mount(new MyController, "/posts/*", "posts")
    context mount (new ResourcesApp, "/api-docs/*")
  }

  // doesn't fire?
  override def destroy(context: ServletContext) {
    //closeClient()
  }
}
