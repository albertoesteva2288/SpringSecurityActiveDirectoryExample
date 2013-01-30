/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.ldap.core.DirContextAdapter;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.ldap.userdetails.UserDetailsContextMapper;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsContextMapperImpl implements UserDetailsContextMapper, Serializable {

    @Override
    public UserDetails mapUserFromContext(DirContextOperations ctx, String username, Collection<? extends GrantedAuthority> authority) {

        List<GrantedAuthority> mappedAuthorities = new ArrayList<GrantedAuthority>();

        for (GrantedAuthority granted : authority) {

            if (granted.getAuthority().equalsIgnoreCase("MY USER GROUP")) {
                mappedAuthorities.add(new GrantedAuthority() {
                    private static final long serialVersionUID = 4356967414267942910L;

                    @Override
                    public String getAuthority() {
                        return "ROLE_USER";
                    }
                });
            } else if (granted.getAuthority().equalsIgnoreCase("MY ADMIN GROUP")) {
                mappedAuthorities.add(new GrantedAuthority() {
                    private static final long serialVersionUID = -5167156646226168080L;

                    @Override
                    public String getAuthority() {
                        return "ROLE_ADMIN";
                    }
                });
            } else {
                System.out.println(granted.getAuthority());
            }
        }
        return new User(username, "", true, true, true, true, mappedAuthorities);
    }

    @Override
    public void mapUserToContext(UserDetails arg0, DirContextAdapter arg1) {
        System.out.println(arg0.getUsername());
    }
}
