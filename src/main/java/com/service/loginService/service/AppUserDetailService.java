package com.service.loginService.service;

import com.service.loginService.model.AppUserDetail;
import com.service.loginService.model.User;
import com.service.loginService.model.UserRole;
import com.service.loginService.repository.UserLogInDetailsRepository;
import com.service.loginService.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AppUserDetailService implements UserDetailsService {

    @Autowired
    private UserLogInDetailsRepository userLogInDetailsRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userLogInDetailsRepository.findByUsername(username);
        return user.map(u -> {
            List<UserRole> userRoleList = userRoleRepository.findAllById(u.getId());
            Set<String> roles = userRoleList.stream().map(UserRole::getRole).collect(Collectors.toSet());
            return new AppUserDetail(u.getUsername(), u.getPassword(), roles, u.isActive());
        }).orElseThrow(() -> new UsernameNotFoundException("user is not found in database" + username));
    }
}
