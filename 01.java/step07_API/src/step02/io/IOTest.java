/* 학습 내용
 * 1. 실습 로직
 * 	키보드로 입력한 데이터를 미존재하는 파일과 콘솔창에 출력
 * 	- 미존재 파일 : 파일 생성 및 데이터 출력
 * 	- 존재 파일 : 갱신
 * 		- 새롭게 모든 내용 작성
 * 		- 기존 내용 유지하면서 내용 추가(append)
 * 
 * 존재 파일로부터 미존재하는 파일과 콘솔창에 출력 경우의 수
 * 	1. 정상 실행(데이터를 보유한 파일이 존재)
 * 	2. 데이터를 read하려는 파일이 없음
 * 		- FileNotFoudException 발생
 * 
 * 2. java.io package에서 API 제공
 * 	- 어쩌구InputStrem / 어쩌구OutputStream : 1byte 기반으로 입출력 API
 * 	- 저쩌구Reader / 저쩌구Writer : 2byte 기반으로 입출력 API
 * 	- 기능 수행 가능한 객체 생성해서 필요 메소드만 호출하면 ㅇㅋ
 * 		1. 키보드 : System.in
 * 		2. 콘솔 : System.out
 * 		3. file로부터 데이터 read기능의 class : FileInputStream / FileReader
 * 		4. file에 데이터 write기능의 class : FileOutputStream / FileWriter
 * 
 * 3. 참고
 * 	- 모든 언어의 io(데이터 입출력 / input output)는 sys. 자원을 사용
 * 		- 입출력 가능한 하드웨어 자원 기능을 사용한다
 * 			: 로직 종료시에 자원 반환(해제) 필수*****************************************
 */

package step02.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class IOTest {

	// 키보드에 입력되는 데이터 출력
	/*
	 * 키보드 : System.in 콘솔 : System.out 한글 데이터 입출력 - 콜솔에 출력시 콘솔지정 - System.out / 출력
	 * println() buffer 기능 활용 BufferedReader - enter 기준으로 문자열 구분해서 한 문자열로 read 가능한
	 * 메소드 지원
	 * 
	 * System.in - 1바이트 / BufferedReader - 2바이트 - 1바이트와 2바이트 호환 API 필요 :
	 * InputStreamReader(1바이트 -> 2바이트)
	 * 
	 * BufferedReader(Reader in){} InputStreamReader(InputStream in){}
	 * 
	 * 로직 2차 개선 - 실시간 입출력 실시간 입력(read/ write 반복) - String 즉 문자열 단위로 read시 존재여부 null로
	 * 검증 ctrl + z로 종료
	 */
	public static void m() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String data = in.readLine();

		while (data != null) { // ctrl z로 종료
			System.out.println(data);
			data = in.readLine();
		}
	}

	/*
	 * FileWriter API = playdata.txt 파일 생성
	 */
	// 키보드로부터 read한 데이터 파일에 출력
	public static void m2() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new FileWriter("playdata.txt"));
		String data = in.readLine();

		while (data != null) {
			out.write(data);
			data = in.readLine();
			out.flush(); // 버퍼에 있는 메모리 밖으로 빼는것//버퍼메모리보다 입력된 데이터가 작으면 버퍼가 메모리를 가지고 있음
		}
		in.close(); // 입력 시스템 자원 해제
		out.close(); // 출력 시스템 자원 해제
	}

	// m2 메소드 코드 -> 실무형 안정적인 코드로 개선
	/*
	 * 
	 */
	public static void m3() throws IOException {
		BufferedReader in = null;
		BufferedWriter out = null;
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new BufferedWriter(new FileWriter("playdata.txt", true)); // true 존재하는 파일에 추가 //true없으면 기존 data 없어지고
																			// 새로 내용 작성
			String data = in.readLine();

			while (data != null) {
				out.write(data);
//				out.write(data + "\n");
				out.newLine(); // new line 적용하는 메소드
				data = in.readLine();
				out.flush();
			}

		} finally {
			if (in != null) {
				in.close();
				in = null;
			}
			if (out != null) {
				out.close();
				out = null;
			}
		}
	}

	// playdata.txt read해서 encore.txt에 출력
	public static void m4() throws IOException {
		BufferedReader in = null;
		BufferedWriter out = null;
		try {
			in = new BufferedReader(new FileReader("playdata.txt"));
			out = new BufferedWriter(new FileWriter("encore.txt", true));
			String data = in.readLine();

			while (data != null) {
				out.write(data);
				System.out.println(data);
				out.newLine(); // new line 적용하는 메소드
				data = in.readLine();
				out.flush();
			}

		} finally {
			if (in != null) {
				in.close();
				in = null;
			}
			if (out != null) {
				out.close();
				out = null;
			}
		}
	}

	/*
	 * my.properties 생성 및 데이터 저장 - key=value
	 * 
	 * my.properties내에 있는 특정 key에 해당하는 value값만 출력 -
	 * 
	 * 개발 시 고려 사항 my.properties 파일을 활용 API properties 클래스
	 * 
	 */
	public static void m5() {
		Properties stuInfo = new Properties(); // 학생 정보 properties
		// my.properties Properties 객체에 로딩(저장)
		try {
			//step07_API 바로 하위에 존재할 경우만 정상 실행
			stuInfo.load(new FileReader("my.properties"));
			//key로 value를 획득하는 메소드(중요**************************************)
			System.out.println(stuInfo.getProperty("stu1"));
			
			//step07_API\src\my2.properties 경로로 정살 개발해보기
			stuInfo.load(new FileReader("src/my2.properties"));
			System.out.println(stuInfo.getProperty("stu2"));
			// . : 현재 경로
			// ./ : 현재 경로 하위에 src파일 의미
			stuInfo.load(new FileReader("./src/my2.properties"));
			System.out.println(stuInfo.getProperty("stu3"));
			
			//절대 경로
			stuInfo.load(new FileReader("C:\\20220103_lab\\01.java\\step07_API\\src\\my2.properties"));
			System.out.println(stuInfo.getProperty("stu4"));

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		m5();
		
		/*
		try {
//			m();
//			m2();
//			m3();
			m4();
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
	}

}
