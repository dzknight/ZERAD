package Admin;

import java.util.Scanner;

public class Manager {
	Scanner in=new Scanner(System.in);
	Member[] m=new Member[5];
	
	Manager() {
		System.out.println("ȸ������ ���α׷�");
		int sel=-1;
		
		while(true) {
			System.out.println("\n1.���    2.��ü����   3.����    4.����   5.�˻�");
			sel=in.nextInt();
			in.nextLine();
			
			if(sel==1) {
				add();
			}else if(sel==2) {
				view();
			}else if(sel==3) {
				delete();
			}else if(sel==4) {
				update();
			}else if(sel==5) {
				search();
			}else {
				break;
			}
		}
	}
	
	
	public void add() {									//�߰�
		System.out.println("���̵� �Է��ϼ���: ");
		String id=in.nextLine();
		
		if(check(id)>-1) {
			System.out.println("���̵� �ߺ�, ó������ ���ư��ϴ�.");
			return;
		}
		System.out.println("�̸��� �Է��ϼ���: ");
		String name=in.nextLine();
		
		System.out.println("�ּҸ� �Է��ϼ���: ");
		String addr=in.nextLine();
		
		System.out.println("���� ���θ� �Է��ϼ���: 1.����, 2.�̼�����");
		int input=in.nextInt();
		boolean adult=true;
		if(input==2) {
			adult=false;
		}
		Member temp=new Member(id,name,addr,adult);
		
		for(int i=0;i<m.length;i++) {
			if(m[i]==null) {
				m[i]=temp;
				System.out.println("��ϵǾ����ϴ�.");
				return;
			}
		}
		System.out.println("ȸ���� 5����� �Է��Ҽ� �ֽ��ϴ�.");
		
	}
	
	
	public void view() {								//��ü����
		for(int i=0;i<m.length;i++) {
			if(m[i]!=null) {
				m[i].mPrt();
			}
		}
	}
	
	
	public void delete() {								//����
		System.out.println("������ ���̵� �Է��ϼ���: ");
		String id=in.nextLine();
		int index=check(id);
		
		if(index==-1) {
			System.out.println("���� ���̵� �Դϴ�.");
			return;
		}
		m[index]=null;
		
		System.out.println("�����Ǿ����ϴ�");
		
	}
	
	
	public void update() {									//����
		int sel=-1;
		
		System.out.println("������ ���̵� �Է��ϼ���: ");
		String id=in.nextLine();
		int index=check(id);
		
		if(index==-1) {
			System.out.println("���� ���̵� �Դϴ�.");
			return;
		}
		
		while(sel<6) {
			System.out.println("\n1.ȸ����������  2.��̵��  3.��̻���  4.�޸��ۼ�  5.�޸����  6.���ư���");
			sel=in.nextInt();
			in.nextLine();
			if(sel==1) {
				System.out.println("������ �̸��� �Է��ϼ���: ");
				m[index].name=in.nextLine();
				
				System.out.println("������ �ּҸ� �Է��ϼ���: ");
				m[index].addr=in.nextLine();
				
				System.out.println("�����Ϸ�");
				
			}else if(sel==2) {
				System.out.println("����� ��̸�  �Է��ϼ���: ");
				m[index].addHobby(in.nextLine());
				
			}else if(sel==3) {
				System.out.println("������ ����� ��ȣ��  �Է��ϼ���: ");
				int index2=in.nextInt();
				in.nextLine();
				if(index2<5 && index2>=0)
					m[index].hobby[index2]=null;

			}else if(sel==4) {
				System.out.println("����� �޸��� ������  �Է��ϼ���: ");
				String title=in.nextLine();
				System.out.println("����� �޸��� ������  �Է��ϼ���: ");
				String memo=in.nextLine();
				
				m[index].addNote(title,memo);
				
			}else if(sel==5) {
				System.out.println("������ �޸��� ��ȣ��  �Է��ϼ���: ");
				int index2=in.nextInt();
				in.nextLine();
				if(index2<10 && index2>=0)
					m[index].note[index2]=null;

				
			}
		}
	}
	
	
	public void search() {									//�˻�
		System.out.println("�˻��� ���̵� �Է��ϼ���: ");
		String id=in.nextLine();
		
		for(int i=0;i<m.length;i++) {
			if(m[i]!=null) {
				if(m[i].id.indexOf(id)>-1) {
					m[i].mPrt();
				}
			}
		}
	}
	
	
	public int check(String id) {							//��ġ�ϴ� id �ε��� ��ȯ
		for(int i=0;i<m.length;i++) {
			if(m[i]!=null) {
				if(m[i].id.equals(id)) {
					return i;
				}
			}
		}
		return -1;
	}
	
}
