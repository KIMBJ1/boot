/* �н� ����
 * 1. �ǽ� ����
 * 	Ű����� �Է��� �����͸� �������ϴ� ���ϰ� �ܼ�â�� ���
 * 	- ������ ���� : ���� ���� �� ������ ���
 * 	- ���� ���� : ����
 * 		- ���Ӱ� ��� ���� �ۼ�
 * 		- ���� ���� �����ϸ鼭 ���� �߰�(append)
 * 
 * ���� ���Ϸκ��� �������ϴ� ���ϰ� �ܼ�â�� ��� ����� ��
 * 	1. ���� ����(�����͸� ������ ������ ����)
 * 	2. �����͸� read�Ϸ��� ������ ����
 * 		- FileNotFoudException �߻�
 * 
 * 2. java.io package���� API ����
 * 	- ��¼��InputStrem / ��¼��OutputStream : 1byte ������� ����� API
 * 	- ��¼��Reader / ��¼��Writer : 2byte ������� ����� API
 * 	- ��� ���� ������ ��ü �����ؼ� �ʿ� �޼ҵ常 ȣ���ϸ� ����
 * 		1. Ű���� : System.in
 * 		2. �ܼ� : System.out
 * 		3. file�κ��� ������ read����� class : FileInputStream / FileReader
 * 		4. file�� ������ write����� class : FileOutputStream / FileWriter
 * 
 * 3. ����
 * 	- ��� ����� io(������ ����� / input output)�� sys. �ڿ��� ���
 * 		- ����� ������ �ϵ���� �ڿ� ����� ����Ѵ�
 * 			: ���� ����ÿ� �ڿ� ��ȯ(����) �ʼ�*****************************************
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

	// Ű���忡 �ԷµǴ� ������ ���
	/*
	 * Ű���� : System.in �ܼ� : System.out �ѱ� ������ ����� - �ݼֿ� ��½� �ܼ����� - System.out / ���
	 * println() buffer ��� Ȱ�� BufferedReader - enter �������� ���ڿ� �����ؼ� �� ���ڿ��� read ������
	 * �޼ҵ� ����
	 * 
	 * System.in - 1����Ʈ / BufferedReader - 2����Ʈ - 1����Ʈ�� 2����Ʈ ȣȯ API �ʿ� :
	 * InputStreamReader(1����Ʈ -> 2����Ʈ)
	 * 
	 * BufferedReader(Reader in){} InputStreamReader(InputStream in){}
	 * 
	 * ���� 2�� ���� - �ǽð� ����� �ǽð� �Է�(read/ write �ݺ�) - String �� ���ڿ� ������ read�� ���翩�� null��
	 * ���� ctrl + z�� ����
	 */
	public static void m() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String data = in.readLine();

		while (data != null) { // ctrl z�� ����
			System.out.println(data);
			data = in.readLine();
		}
	}

	/*
	 * FileWriter API = playdata.txt ���� ����
	 */
	// Ű����κ��� read�� ������ ���Ͽ� ���
	public static void m2() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new FileWriter("playdata.txt"));
		String data = in.readLine();

		while (data != null) {
			out.write(data);
			data = in.readLine();
			out.flush(); // ���ۿ� �ִ� �޸� ������ ���°�//���۸޸𸮺��� �Էµ� �����Ͱ� ������ ���۰� �޸𸮸� ������ ����
		}
		in.close(); // �Է� �ý��� �ڿ� ����
		out.close(); // ��� �ý��� �ڿ� ����
	}

	// m2 �޼ҵ� �ڵ� -> �ǹ��� �������� �ڵ�� ����
	/*
	 * 
	 */
	public static void m3() throws IOException {
		BufferedReader in = null;
		BufferedWriter out = null;
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new BufferedWriter(new FileWriter("playdata.txt", true)); // true �����ϴ� ���Ͽ� �߰� //true������ ���� data ��������
																			// ���� ���� �ۼ�
			String data = in.readLine();

			while (data != null) {
				out.write(data);
//				out.write(data + "\n");
				out.newLine(); // new line �����ϴ� �޼ҵ�
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

	// playdata.txt read�ؼ� encore.txt�� ���
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
				out.newLine(); // new line �����ϴ� �޼ҵ�
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
	 * my.properties ���� �� ������ ���� - key=value
	 * 
	 * my.properties���� �ִ� Ư�� key�� �ش��ϴ� value���� ��� -
	 * 
	 * ���� �� ��� ���� my.properties ������ Ȱ�� API properties Ŭ����
	 * 
	 */
	public static void m5() {
		Properties stuInfo = new Properties(); // �л� ���� properties
		// my.properties Properties ��ü�� �ε�(����)
		try {
			//step07_API �ٷ� ������ ������ ��츸 ���� ����
			stuInfo.load(new FileReader("my.properties"));
			//key�� value�� ȹ���ϴ� �޼ҵ�(�߿�**************************************)
			System.out.println(stuInfo.getProperty("stu1"));
			
			//step07_API\src\my2.properties ��η� ���� �����غ���
			stuInfo.load(new FileReader("src/my2.properties"));
			System.out.println(stuInfo.getProperty("stu2"));
			// . : ���� ���
			// ./ : ���� ��� ������ src���� �ǹ�
			stuInfo.load(new FileReader("./src/my2.properties"));
			System.out.println(stuInfo.getProperty("stu3"));
			
			//���� ���
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
