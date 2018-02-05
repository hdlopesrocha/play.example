package controllers;

import play.mvc.*;

import views.html.*;

public class HomeController extends Controller {


    public Result index() {
        return ok(index.render("Hello"));
    }

    public Result setName() {
        String name = request().body().asFormUrlEncoded().get("name")[0];
        session("name",name);
        System.out.println(name);
        return redirect("/");
    }
}
