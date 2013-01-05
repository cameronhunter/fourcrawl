package foursquare;

import play.Configuration;
import fi.foyt.foursquare.api.FoursquareApi;


public final class Foursquare {

    private static Configuration CONFIG = play.Configuration.root();
    private static final String CLIENT_ID = CONFIG.getString( "foursquare.clientid" );
    private static final String SECRET = CONFIG.getString( "foursquare.secret" );
    private static final String CALLBACK_URL = "http://localhost:9000/authentication/callback";

    public static FoursquareApi client() {
        return new FoursquareApi( CLIENT_ID, SECRET, CALLBACK_URL );
    }

    private Foursquare() {}

}
