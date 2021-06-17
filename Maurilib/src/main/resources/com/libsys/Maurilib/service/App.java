package com.libsys.Maurilib.service;

public class App {

    public static boolean valideEmail( String email ) {
        if ( email == null || email.trim().length() == 0 || email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" )) {
            return false;
        }
        return true;
    }

    public static boolean valideText( String text ) {
        if ( text == null || text.trim().length() == 0 ) {
            return false;
        }
        return true;
    }
}
