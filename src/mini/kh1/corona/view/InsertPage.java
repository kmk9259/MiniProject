package mini.kh1.corona.view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import mini.kh1.corona.controller.InsertConstroller;
import mini.kh1.corona.controller.user.AddJoin;
import mini.kh1.corona.controller.user.AddSignup;
import mini.kh1.corona.controller.user.UserList;
import mini.kh1.corona.model.vo.User;

public class InsertPage extends JFrame implements ActionListener {

	InsertConstroller ic = new InsertConstroller();

	private JFrame frame = new JFrame();
	private Container container = getContentPane();
	private Scanner sc = new Scanner(System.in);

	// 레이블
	private JLabel userLabel = new JLabel("아이디");
	private JLabel passwordLabel = new JLabel("비밀번호");
	private JLabel nameLabel = new JLabel("이름");
	private JLabel ssnLabel = new JLabel("주민 번호");
	private JLabel emailLabel = new JLabel("이메일");
	
	

	// 필드부
	private JTextField userTextField = new JTextField();
	private JPasswordField passwordField = new JPasswordField();
	private JTextField nameField = new JTextField();
	private JTextField ssnField = new JTextField();
	private JTextField emailField = new JTextField();

	private JButton insertButton = new JButton("회원가입");
	private JButton backButton = new JButton("이전으로");
	private JButton dupliButton = new JButton("중복확인");

	private final JLabel label = new JLabel("회원가입");

	private String id = userTextField.getText();
	private String pw = passwordField.getText();
	private String name = nameField.getText();
	private String ssn = ssnField.getText();
	private String email = emailField.getText();

	UserList list = new UserList();
	AddSignup addsignup = new AddSignup();
	AddJoin join = new AddJoin();
	static List newuser = new ArrayList<User>();

	public InsertPage() {

		frame.setPreferredSize(new Dimension(900, 600));
		frame.setSize(900, 600);
		frame.setTitle("로그인 페이지");
		frame.setResizable(false);// 창 사이즈 변경 불가
		frame.setLocationRelativeTo(null);// 모니터 중간에 창 띄우기
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		container = new JPanel();
		container.setLocation(0, 0);

		container.setSize(900, 600);
		container.setLayout(null);
		container.setVisible(true);// 첫 패널만 일단 보이게 해놓음

		frame.getContentPane().add(container); // 패널로 컴포넌트를 감싸 놓음.

		// 타이틀 폰트 세팅
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("NanumGothic", Font.BOLD, 28));
		label.setBounds(262, 28, 376, 75);

		// 아이디 컨테이너
		container.add(label);
		userLabel.setBounds(274, 150, 100, 30);
		container.add(userLabel);
		userLabel.setFont(new Font("NanumGothic", Font.BOLD, 18));

		// 비밀번호 컨테이너
		passwordLabel.setBounds(274, 200, 100, 30);
		container.add(passwordLabel);
		passwordLabel.setFont(new Font("NanumGothic", Font.BOLD, 18));

		// 이름 컨테이너
		container.add(label);
		nameLabel.setBounds(274, 250, 100, 30);
		container.add(nameLabel);
		nameLabel.setFont(new Font("NanumGothic", Font.BOLD, 18));

		// 주민번호 컨테이너
		ssnLabel.setBounds(274, 300, 100, 30);
		container.add(ssnLabel);
		ssnLabel.setFont(new Font("NanumGothic", Font.BOLD, 18));

		// 이메일 컨테이너
		emailLabel.setBounds(274, 350, 100, 30);
		container.add(emailLabel);
		emailLabel.setFont(new Font("NanumGothic", Font.BOLD, 18));

		// 사용자 텍스트 필드
		userTextField.setBounds(378, 150, 150, 30);
		container.add(userTextField);

		// 비밀번호 텍스트 필드
		passwordField.setBounds(378, 201, 150, 30);
		container.add(passwordField);

		// 이름 텍스트 필드
		nameField = new JTextField();
		nameField.setBounds(378, 252, 150, 30);
		container.add(nameField);

		ssnField = new JTextField();
		ssnField.setBounds(378, 303, 150, 30);
		container.add(ssnField);

		emailField = new JTextField();
		emailField.setBounds(378, 351, 150, 30);
		container.add(emailField);

		// 회원 가입 버튼
		insertButton.setBounds(378, 421, 150, 40);
		container.add(insertButton);

		// 이전으로 버튼
		backButton.setBounds(27, 28, 150, 40);
		container.add(backButton);

		// 중복확인 버튼
		dupliButton.setBounds(558, 145, 150, 40);
		container.add(dupliButton);

		// 버튼 리슨어
		insertButton.addActionListener(this);
		dupliButton.addActionListener(this);
		backButton.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == insertButton) {
			
			String userText = userTextField.getText();
			
			id = userTextField.getText();
			pw = passwordField.getText();
			name = nameField.getText();
			ssn = ssnField.getText();
			email = emailField.getText();
			
			
			//값이 빈 곳이 있으면 가입이 되지 않게~ 
			if(id.length() == 0 || pw.length() == 0 || name.length() == 0 || ssn.length() == 0 || email.length() == 0) {
				JOptionPane.showMessageDialog(this, "정보를 모두 입력해 주세요");
				
			}else {
				JOptionPane.showMessageDialog(this, "가입 되었습니다.");
				
				addsignup.adduser(id, pw, name, ssn, email);	//회원가입
			
				newuser = addsignup.addsignup();	//$$$
				join.abc(newuser);
				new LoginPage(); // 빈 곳 없이 값이 입력 되면 로그인 할 수 있는 페이지로 이동
				frame.setVisible(false);
				
			}
			
	
		}

		if (e.getSource() == dupliButton) { // 중복이면 필드부 클리어, 아니면 성공해서 입력할 수 있다.

			String userText = userTextField.getText();
			dupliCheckID(userText);
		}
		if (e.getSource() == backButton) {
			new LoginPage(); // 클릭시, 로그인 화면 으로 돌아감
			frame.setVisible(false);
		}
	}
	
	//중복확인 메소드
		public boolean dupliCheckID(String userText) {
			boolean check=true;
			for (int i = 0; i < UserList.UserList().size(); i++) 
			{ // 전체 회원 인덱스를 돌며 확인하기 위해
				if (UserList.UserList().get(i).getId().equals(userText)) {
					//result = 1; // 참 거짓으로 표현하기 위해
					check=false;
					JOptionPane.showMessageDialog(this, "중복된 아이디 입니다.");
					break;
				}
				else
				{
					JOptionPane.showMessageDialog(this, "사용 가능한 아이디 입니다.");
					check=true;
					break;
				}
			}
			return check;
		}
	
}
