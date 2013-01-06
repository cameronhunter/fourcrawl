package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.With;
import actions.Authentication;
import actions.HomeIfAuthenticated;
import fi.foyt.foursquare.api.FoursquareApi;
import fi.foyt.foursquare.api.FoursquareApiException;
import fi.foyt.foursquare.api.entities.CompleteUser;
import foursquare.Foursquare;

public class Application extends Controller {

    @With( { HomeIfAuthenticated.class } )
    public static Result index() {
        return ok( views.html.index.render() );
    }

    @With( { Authentication.class } )
    public static Result home() throws FoursquareApiException {

        FoursquareApi client = Foursquare.authenticatedClient( request() );

        CompleteUser user = client.user( "self" ).getResult();

        return ok( views.html.home.render( user ) );
    }

}
