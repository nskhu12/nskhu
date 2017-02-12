package org.nskhu.security;

import org.nskhu.model.User;
import org.nskhu.model.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class SecurityProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        User u = repo.findByName((String) authentication.getPrincipal());
        if (u == null) throw new BadCredentialsException("Bad username");
        else if (!u.getPassword().equals(authentication.getCredentials()))
            throw new BadCredentialsException("Bad password");
        session.setAttribute("LOGGED_USERNAME", authentication.getPrincipal());
        return new UsernamePasswordAuthenticationToken(authentication.getPrincipal(), authentication.getCredentials(), authentication.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

    @Autowired
    private HttpSession session;

    @Autowired
    private UserRepository repo;
}
