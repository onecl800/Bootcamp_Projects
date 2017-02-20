
public class Driver implements Person {
	
	//variables
	private String name;
	private String license;

	
	//getters and setters
	public String getName() {
		return name;
	}

	public String getLicense() {
		return license;
	}

	
	//constructor
	public Driver(String n, String l) {
		name = n;
		license = l;
	}

}
