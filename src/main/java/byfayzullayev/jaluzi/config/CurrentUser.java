package byfayzullayev.jaluzi.config;

import byfayzullayev.jaluzi.entity.user.UserEntity;
import byfayzullayev.jaluzi.service.user.ApplicationUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class CurrentUser {
    private final ApplicationUserDetailService applicationUserDetailService;

    @Autowired
    public CurrentUser(ApplicationUserDetailService applicationUserDetailService) {
        this.applicationUserDetailService = applicationUserDetailService;
    }

    public UserEntity getCurrentUser() {
        Authentication authentication = SecurityContextHolder
                .getContext()
                .getAuthentication();
        if (authentication != null) {
            String username = (String) authentication.getPrincipal();
            UserDetails userDetails = applicationUserDetailService.loadUserByUsername(username);
            return (UserEntity) userDetails;
        }
        return null;
    }

}
