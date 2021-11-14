import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Calculator extends JFrame
{
	private JTextField textfield;
	private double num1, num2, result;
	boolean state = false;
	String func = "";
	String nInput = ""; 
	
	public Calculator()
	{
		setLayout(null);
		
		textfield=new JTextField(); //텍스트필드 생성
		textfield.setEnabled(false); // 텍스트필드에 입력불가
		textfield.setBounds(10,10,270,70); //텍스트필드 위치
		textfield.setFont(new Font("Arial", Font.BOLD, 50));// 텍스트필드 폰트
		
		JPanel panel = new JPanel(); //패널 생성
		panel.setLayout(new GridLayout(4,4,5,5));// 가로,세로 4칸씩 좌우,상하 간격은 5씩
		panel.setBounds(8,90,270,235);// 패널 위치
		
		String CalcButton[]= {"1","2","3","+","4","5","6","-","7","8","9","*","C","0","=","/"}; //버튼에 넣을 배열
		JButton button[]=new JButton[CalcButton.length]; //버튼 배열 
		
		for(int i=0;i<CalcButton.length;i++)
		{
			button[i]=new JButton(CalcButton[i]);  //버튼 끼워넣기
			panel.add(button[i]); //패널에 버튼추가
			button[i].addActionListener(new CalcActionlistener());
		}
		
		add(textfield);
		add(panel);
		
		setSize(300,400); 		
		setLocation(700,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("계산기");
		setVisible(true);
	}
	
	class CalcActionlistener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String op = e.getActionCommand();
			
			if (op.equals("+")) {
		        num1 = num2;  
		        func = "+";
		        nInput = ""; // 마지막에 누른 연산자 저장
			}
		     else if (op.equals("-")) 
		     {
		        num1 = num2;
		        func = "-";
		        nInput = "";
		     }
		     else if (op.equals("*")) 
		    {
		        num1 = num2;
		        func = "*";
		        nInput = "";
		    }
		     else if (op.equals("/")) 
		    {
		        num1 = num2;
		        func = "/";
		        nInput = "";

		    } 
		     else if (op.equals("C")) 
		    {  
		        nInput = "";
		        num2 = 0;
		        num1 = 0;
		        textfield.setText("0");
		    }
		     else if (op.equals("=")) 
		    {
		        if (func.equals("+")) 
		        {
		            result = num1 + num2;
		            textfield.setText(String.valueOf(result)); //결과값을 문자열로 반환하여 결과창에 출력
		            state = true; // 결과 값이 나온 후 다음 입력이 들어왔을 때 화면에 표시된 결과 값을 지운다.
		        }
		         else if (func.equals("-")) 
		        {
		            result = num1 - num2;
		            textfield.setText(String.valueOf(result));
		            state = true;
		        }
		         else if (func.equals("*")) 
		        {
		            result = num1 * num2;
		            textfield.setText(String.valueOf(result));
		            state = true;

		        } 
		         else if (func.equals("/")) 
		        {
		            result = num1 / num2;
		            textfield.setText(String.valueOf(result));
		            state = true;
		        }
		    }
		     else 
		     {
		        if (state) 
		        {
		        	textfield.setText("0");
		            state = false;
		            num1 = 0;
		            num2 = 0;
		            nInput = "";
		        }

		        nInput += e.getActionCommand();
		        textfield.setText(nInput);
		        num2 = Double.parseDouble(nInput); //문자열에서 double형 변

		    }
		}
	}
	
	public static void main(String[] args) 
	{
		new Calculator();
	}

}