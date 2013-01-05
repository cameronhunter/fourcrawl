package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.With;
import views.html.index;
import actions.Authentication;
import actions.HomeIfAuthenticated;

public class Application extends Controller {

    @With( { HomeIfAuthenticated.class } )
    public static Result index() {
        return ok( index.render( "" ) );
    }

    @With( { Authentication.class } )
    public static Result home() {
        return ok( "Logged in" );
    }

}
