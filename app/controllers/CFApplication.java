package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class CFApplication extends Controller {

    public Result index() {
        return ok(index.render("Your new application is ready."));
    }

}
