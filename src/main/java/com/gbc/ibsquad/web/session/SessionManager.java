package com.gbc.ibsquad.web.session;

import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * managing sessions
 */
@Component
public class SessionManager {
    public static final String SESSION_COOKIE_NAME = "mysessionId";

    private Map<String, Object> sessionStore = new ConcurrentHashMap<>();

    /**
     * Generate Session
     */
    public void createSession(Object value, HttpServletResponse response){
        //generate session id and save it
        String sessionId = UUID.randomUUID().toString();
        sessionStore.put(sessionId, value);

        //generate cookie
        Cookie mySessionCookie = new Cookie(SESSION_COOKIE_NAME, sessionId);
        response.addCookie(mySessionCookie);
    }

    /**
     * Look for session
     */
    public Object getSession(HttpServletRequest request){
        Cookie sessionCookie = findCookie(request, SESSION_COOKIE_NAME);
        if(sessionCookie==null){
            return null;
        }
        return sessionStore.get(sessionCookie.getValue());
    }

    public Cookie findCookie(HttpServletRequest request, String cookieName){
        if(request.getCookies()==null){
            return null;
        }
        return Arrays.stream(request.getCookies())
                .filter(cookie -> cookie.getName().equals(cookieName))
                .findAny()
                .orElse(null);
    }
    /**
     * Session end
     */
    public void expire(HttpServletRequest request){
        Cookie sessionCookie = findCookie(request, SESSION_COOKIE_NAME);
        if(sessionCookie!=null){
            sessionStore.remove(sessionCookie.getValue());
        }
    }
}
