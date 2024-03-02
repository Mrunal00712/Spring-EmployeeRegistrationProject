package customlogin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import customlogin.dto.UserDto;
import customlogin.model.User;
import customlogin.repositories.UserRepository;


@Service
public class UserServiceImpl  implements UserService{
	
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	private UserRepository userRepository;
	
	//private final UserRepository userRepository;
    //private final PasswordEncoder passwordEncoder;
	
	

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
		//this.passwordEncoder = passwordEncoder;
	}

	@Override
	public User findByUsername(String username) {
		
		return userRepository.findByUsername(username);
	}

	@Override
	public User save(UserDto userDto) {
		User user = new User(userDto.getFullname(), userDto.getDateofbirth(), userDto.getGender(), userDto.getAddress(), userDto.getCity(), userDto.getState(), userDto.getUsername(),passwordEncoder.encode(userDto.getPassword()));
		return userRepository.save(user);
	}
	
	@Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

}
