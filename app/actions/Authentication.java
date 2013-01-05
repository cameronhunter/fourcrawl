package actions;

import static org.apache.commons.lang3.StringUtils.isNotBlank;
import play.mvc.Action;
import play.mvc.Http.Context;
import play.mvc.Http.Cookie;
import play.mvc.Result;

public class Authentication extends Action.Simple {

    @Override
    public Result call( Context context ) throws Throwable {
        Cookie cookie = context.request().cookies().get( "oauthtoken" );
        if ( cookie != null && isNotBlank( cookie.value() ) ) {
            return delegate.call( context );
        }
        return redirect( "/" );
    }

}
