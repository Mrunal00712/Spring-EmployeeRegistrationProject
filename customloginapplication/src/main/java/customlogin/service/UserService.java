package customlogin.service;

import java.util.List;

import customlogin.dto.UserDto;
import customlogin.model.User;

public interface UserService {
	
	User findByUsername(String username);
	User save(UserDto userDto);
	
	
	List<User> findAll();

}
