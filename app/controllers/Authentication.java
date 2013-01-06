package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import fi.foyt.foursquare.api.FoursquareApi;
import fi.foyt.foursquare.api.FoursquareApiException;
import foursquare.Foursquare;

public class Authentication extends Controller {

    public static Result start() {
        return redirect( Foursquare.client().getAuthenticationUrl() );
    }

    public static Result callback( String code ) throws FoursquareApiException {
        FoursquareApi client = Foursquare.client();

        client.authenticateCode( code );

        response().setCookie( "oauthtoken", client.getOAuthToken() );

        return redirect( "/home" );
    }
}
