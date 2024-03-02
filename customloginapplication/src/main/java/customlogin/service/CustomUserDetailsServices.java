package customlogin.service;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import customlogin.model.User;
import customlogin.repositories.UserRepository;
import customlogin.service.CustomUserDetails;


@Service
public class CustomUserDetailsServices implements UserDetailsService{

	private UserRepository userRepository;
	
	@Autowired
    public CustomUserDetailsServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("Username or Password Not Found");
		}
		return  new CustomUserDetails(
				user.getFullname(),
				user.getDateofbirth(), 
				user.getGender(), 
				user.getAddress(), 
				user.getCity(), 
				user.getState(), 
				user.getUsername(), 
				user.getPassword(), 
				authorities());
				
	}
	
	public Collection<? extends GrantedAuthority> authorities () {
		return Arrays.asList(new SimpleGrantedAuthority("USER"));
	}

}
