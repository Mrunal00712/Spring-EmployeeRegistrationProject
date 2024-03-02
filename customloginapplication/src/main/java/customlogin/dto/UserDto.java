package customlogin.dto;

public class UserDto {

	
	private String fullname;
	private String dateofbirth;
	private String gender;
	private String address;
	private String city;
	private String state;
	private String username;
	private String password;
	
	
	
	
	public UserDto() {
		super();
	}




	public UserDto(String fullname, String dateofbirth, String gender, String address, String city, String state,
			String username, String password) {
		
		this.fullname = fullname;
		this.dateofbirth = dateofbirth;
		this.gender = gender;
		this.address = address;
		this.city = city;
		this.state = state;
		this.username = username;
		this.password = password;
	}




	public String getFullname() {
		return fullname;
	}




	public void setFullname(String fullname) {
		this.fullname = fullname;
	}




	public String getDateofbirth() {
		return dateofbirth;
	}




	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}




	public String getGender() {
		return gender;
	}




	public void setGender(String gender) {
		this.gender = gender;
	}




	public String getAddress() {
		return address;
	}




	public void setAddress(String address) {
		this.address = address;
	}




	public String getCity() {
		return city;
	}




	public void setCity(String city) {
		this.city = city;
	}




	public String getState() {
		return state;
	}




	public void setState(String state) {
		this.state = state;
	}




	public String getUsername() {
		return username;
	}




	public void setUsername(String username) {
		this.username = username;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
	
	
}
