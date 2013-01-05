package controllers;

import play.Configuration;
import play.mvc.Controller;
import play.mvc.Result;
import fi.foyt.foursquare.api.FoursquareApi;
import fi.foyt.foursquare.api.FoursquareApiException;

public class Authentication extends Controller {

    private static Configuration CONFIG = play.Configuration.root();
    private static FoursquareApi CLIENT = new FoursquareApi( CONFIG.getString( "foursquare.clientid" ), CONFIG.getString( "foursquare.secret" ), "http://localhost:9000/authentication/callback" );

    public static Result start() {
        return redirect( CLIENT.getAuthenticationUrl() );
    }

    public static Result callback() throws FoursquareApiException {
        String code = request().queryString().get( "code" )[0];
        CLIENT.authenticateCode( code );
        return ok( code );
    }
}
