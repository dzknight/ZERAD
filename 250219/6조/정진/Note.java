package Admin;

public class Note {
	String title;
	String memo;
	
	Note(String title,String memo){
		this.title=title;
		this.memo=memo;
	}
	
	public void ptr() {		//���
		System.out.println(title+": "+memo);
	}
}
