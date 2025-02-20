package Admin;

public class Member {
	String id;
	String name;
	String addr;
	boolean adult;
	String[] hobby=new String[5];
	Note[] note=new Note[10];
	
	Member(String id, String name, String addr, boolean adult) {	//생성자
		this.id=id;
		this.name=name;
		this.addr=addr;
		this.adult=adult;
	}
	
	public void mPrt(){						//정보출력
		System.out.println("id:	"+id);
		System.out.print("name:	"+name);
		if(adult) {
			System.out.println();
		}else {
			System.out.println("  (미성년자)");
		}
		System.out.println("addr:	"+addr);
		System.out.print("hobby:	");
		for(int i=0;i<hobby.length;i++) {
			if(hobby[i]!=null) {
				System.out.print(i+":"+hobby[i]+"  ");
			}
		}
		System.out.println();
		System.out.println("note: ");
		for(int i=0;i<note.length;i++) {
			if(note[i]!=null) {
				System.out.print("	"+i+": ");
				note[i].ptr();
			}
		}
		System.out.println();
	}
	
	
	public void addHobby(String hobby) {	//취미추가
		for(int i=0;i<this.hobby.length;i++) {
			if(this.hobby[i]==null) {
				this.hobby[i]=hobby;
				System.out.println("등록성공!");
				return;
			}
		}
		System.out.println("이미 5개를 등록하셨습니다.");
	}

	
	public void addNote(String title,String memo) {	//노트추가
		Note note=new Note(title,memo);
		
		for(int i=0;i<this.note.length;i++) {
			if(this.note[i]==null) {
				this.note[i]=note;
				System.out.println("등록성공!");
				return;
			}
		}
		System.out.println("이미 10개를 등록하셨습니다.");
	}
		
	
}
