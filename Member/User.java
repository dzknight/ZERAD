package Member;

public class User {

	public String id=null;
	public String name=null;
	public String addr=null;
	public String adult=null;
	//y일시 미성년자 노출
	//n이면 표시 안함

	public String hobby[]= new String[5];
//	public String hobby[]= {"자바","자바","자바","자바","자바"};
	public String memo[]= new String[10];
	
	
	public User(String id,String name,String addr,String adult){
		this.id=id;
		this.name=name;
		this.addr=addr;
		this.adult=adult;
		
		
	}
}

