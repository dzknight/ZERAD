package Admin;

public class Note {
	String title;
	String memo;
	
	Note(String title,String memo){
		this.title=title;
		this.memo=memo;
	}
	
	public void ptr() {		//Ãâ·Â
		System.out.println(title+": "+memo);
	}
}
