package study;

import java.util.HashMap;

public class User {
	 private String id=null;
	 private String pass=null;
	 
	HashMap<String,String> user=new HashMap<String, String>();
	
	public User(String id,String pass) {
		this.id=id;
		this.pass=pass;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
}
