package com.webPage.am.security;


import com.webPage.am.entity.User;
import com.webPage.am.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;
  @Autowired
  private PasswordEncoder passwordEncoder;

  @Override
  public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
    User byEmail= userRepository.findByEmail(s);
    "$2a$10$rDllynIskf24ZsXUqXBkzeC12aCCV3mq1wFjvoVM6SbakCXRAc3ZK".equals(passwordEncoder.encode(byEmail.getPassword()));
    if(byEmail == null){
      throw new UsernameNotFoundException(("ddd"));
    }
    return new SpringUser(byEmail);
  }
}
