package users.pojo;

public class GeneratePayload {
	
	
	
	public Users GeneratePayloadForUser(String name)
	{
		Users user = new Users();
		user.setName(name);
		
		user.setJob("SDET");
		
		return user;
		
	}

}
