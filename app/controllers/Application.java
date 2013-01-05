package controllers;

import play.Configuration;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;
import fi.foyt.foursquare.api.FoursquareApi;

public class Application extends Controller {

    public static Result index() {
        Configuration configuration = play.Configuration.root();

        String clientid = configuration.getString( "foursquare.clientid" );
        String secret = configuration.getString( "foursquare.secret" );

        FoursquareApi client = new FoursquareApi( clientid, secret, "http://localhost:9000/callback" );

        return ok( index.render( "Your new application is ready." ) );
    }

}
