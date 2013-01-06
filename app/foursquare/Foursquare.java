package foursquare;

import play.Configuration;
import play.mvc.Http.Request;

public final class Foursquare {

    private static Configuration CONFIG = play.Configuration.root();
    private static final String CLIENT_ID = CONFIG.getString( "foursquare.clientid" );
    private static final String SECRET = CONFIG.getString( "foursquare.secret" );
    private static final String CALLBACK_URL = "http://localhost:9000/authentication/callback";

    public static FoursquareApi client() {
        return new FoursquareApi( CLIENT_ID, SECRET, CALLBACK_URL );
    }

    public static FoursquareApi authenticatedClient( Request request ) {
        FoursquareApi client = client();
        client.setoAuthToken( request.cookies().get( "oauthtoken" ).value() );
        return client;
    }

    private Foursquare() {}
}
