package com.example.demo.Service;

import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService,UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //user girişi için user gerçekten var olan login formunu mu kullanıyor, girilen password
    // doğru mu, user’ın sistemdeki rolü veya yetkileri nedir gibi bilgilerin kontrol edildiği method
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = getUserByUsername(username);
        if (null == user) {
            throw new UsernameNotFoundException("User with username: " + username + " not found.");
        } else {
            return user;
        }
    }
    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
