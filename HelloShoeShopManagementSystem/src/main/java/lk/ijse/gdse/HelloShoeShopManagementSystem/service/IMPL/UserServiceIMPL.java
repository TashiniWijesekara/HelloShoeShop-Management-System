package lk.ijse.gdse.HelloShoeShopManagementSystem.service.IMPL;

import lk.ijse.gdse.HelloShoeShopManagementSystem.repository.UserServiceDAO;
import lk.ijse.gdse.HelloShoeShopManagementSystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceIMPL implements UserService {
    final private UserServiceDAO userServiceDAO;
    @Override
    public UserDetailsService userDetailsService() {
        return username ->
                userServiceDAO.findByEmail(username).
                        orElseThrow(()->new UsernameNotFoundException("User Not Found"));
    }
}
