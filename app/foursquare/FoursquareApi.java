package foursquare;

import fi.foyt.foursquare.api.io.DefaultIOHandler;
import fi.foyt.foursquare.api.io.IOHandler;

public class FoursquareApi extends fi.foyt.foursquare.api.FoursquareApi {

    public FoursquareApi( String clientId, String clientSecret, String redirectUrl ) {
        super( clientId, clientSecret, redirectUrl, new DefaultIOHandler() );
    }

    public FoursquareApi( String clientId, String clientSecret, String redirectUrl, IOHandler ioHandler ) {
        super( clientId, clientSecret, redirectUrl, null, ioHandler );
    }

    public FoursquareApi( String clientId, String clientSecret, String redirectUrl, String oAuthToken, IOHandler ioHandler ) {
        super( clientId, clientSecret, redirectUrl, oAuthToken, ioHandler );
    }



}
