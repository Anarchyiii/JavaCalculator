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
		
		textfield=new JTextField(); //�ؽ�Ʈ�ʵ� ����
		textfield.setEnabled(false); // �ؽ�Ʈ�ʵ忡 �ԷºҰ�
		textfield.setBounds(10,10,270,70); //�ؽ�Ʈ�ʵ� ��ġ
		textfield.setFont(new Font("Arial", Font.BOLD, 50));// �ؽ�Ʈ�ʵ� ��Ʈ
		
		JPanel panel = new JPanel(); //�г� ����
		panel.setLayout(new GridLayout(4,4,5,5));// ����,���� 4ĭ�� �¿�,���� ������ 5��
		panel.setBounds(8,90,270,235);// �г� ��ġ
		
		String CalcButton[]= {"1","2","3","+","4","5","6","-","7","8","9","*","C","0","=","/"}; //��ư�� ���� �迭
		JButton button[]=new JButton[CalcButton.length]; //��ư �迭 
		
		for(int i=0;i<CalcButton.length;i++)
		{
			button[i]=new JButton(CalcButton[i]);  //��ư �����ֱ�
			panel.add(button[i]); //�гο� ��ư�߰�
			button[i].addActionListener(new CalcActionlistener());
		}
		
		add(textfield);
		add(panel);
		
		setSize(300,400); 		
		setLocation(700,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("����");
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
		        nInput = ""; // �������� ���� ������ ����
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
		            textfield.setText(String.valueOf(result)); //������� ���ڿ��� ��ȯ�Ͽ� ���â�� ���
		            state = true; // ��� ���� ���� �� ���� �Է��� ������ �� ȭ�鿡 ǥ�õ� ��� ���� �����.
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
		        num2 = Double.parseDouble(nInput); //���ڿ����� double�� ��

		    }
		}
	}
	
	public static void main(String[] args) 
	{
		new Calculator();
	}

}