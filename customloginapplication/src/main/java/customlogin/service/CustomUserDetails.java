package customlogin.service;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails {
	
	
	private String fullname;
	private String dateofbirth;
	private String gender;
	private String address;
	private String city;
	private String state;
	private String username;
	private String password;
	private Collection<? extends GrantedAuthority> authorities;
	
	
	
	
	
	public CustomUserDetails(String fullname, String dateofbirth, String gender, String address, String city,
			String state, String username, String password, Collection<? extends GrantedAuthority> authorities) {
		
		this.fullname = fullname;
		this.dateofbirth = dateofbirth;
		this.gender = gender;
		this.address = address;
		this.city = city;
		this.state = state;
		this.username = username;
		this.password = password;
		this.authorities = authorities;
	}
	
	public String getFullname() {
		return fullname;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return authorities;
	}

	@Override
	public String getPassword() {
		
		return password;
	}

	@Override
	public String getUsername() {
		
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
