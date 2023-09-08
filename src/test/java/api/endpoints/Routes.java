package api.endpoints;

public class Routes {
	
	    //Post : https://petstore.swagger.io/v2/user
		//Get: https://petstore.swagger.io/v2/user/{username}
		//Get: https://petstore.swagger.io/v2/user/{username}
		//PUT: https://petstore.swagger.io/v2/user/{username}
		//DELETE: https://petstore.swagger.io/v2/user/{username}
	
	//User module url
	
	public static String base_Url = "https://petstore.swagger.io/v2";
	public static String post_url = base_Url+"/user";
	public static String get_url = base_Url+"/user/{username}";
	public static String put_url = base_Url+"/user/{username}";
	public static String delete_url = base_Url+"/user/{username}";
	

}
