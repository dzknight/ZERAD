package coffee;


		public class StringBuilderEx {
		    public static void main(String[] args) {
		        // StringBuilder 객체 생성
		        StringBuilder stringBuilder = new StringBuilder();
						
		        // append()를 통해 문자열 연결
		        stringBuilder.append("안녕하세요 ").append("홍길동입니다.");
		        // toString()을 통해 문자열 변수에 할당
		        String str = stringBuilder.toString();
		        
		        System.out.println(stringBuilder);
		        System.out.println(str);
		    }
		}
		