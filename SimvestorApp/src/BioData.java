public class BioData {

	// Fields
	private static String username = "Ed Taylor"; // Dummy Username
	private static String password = "Simvestor"; // Dummy Password
	
	public BioData() {
		// Empty Constructor
	}

	public String getUsername()
	{
		return username;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public void setUsername(String username)
	{
		BioData.username = username;
	}
	
	public void setPassword(String password)
	{
		BioData.password = password;
	}
}
