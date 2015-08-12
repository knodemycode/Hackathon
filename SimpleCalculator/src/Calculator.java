import javax.swing.*;
public class Calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JTextField x = new JTextField();
		JTextField y = new JTextField();
		int a, b, answer = 0;
		double ans = 0;
		Object[] operations = {"+", "-", "x", "/"};
		int[] inputs;
		Object[] fields = {
			"First number", x,
			"Second number", y
		};
		int n = JOptionPane.showOptionDialog(null,
				"Pick Operation,",
				null,
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null, operations,
				operations[0]);
		int r = JOptionPane.showConfirmDialog(null, fields, "header", JOptionPane.OK_CANCEL_OPTION);
		if(r == JOptionPane.OK_OPTION){
			try {
				if(n == 0){
					answer = add(Integer.parseInt(x.getText()),Integer.parseInt(y.getText()));
				}
				else if(n == 1){
					answer = subtract(Integer.parseInt(x.getText()),Integer.parseInt(y.getText()));
				}
				else if(n == 2){
					answer = multiply(Integer.parseInt(x.getText()),Integer.parseInt(y.getText()));
				}
				else if(n == 3){
					ans = divide(Integer.parseInt(x.getText()),Integer.parseInt(y.getText()));
				}
			} catch(NumberFormatException e) {
				System.out.println("Input integers only please!");
			}
		}
		if(n == 3){
			System.out.println(ans);
		}
		else{
			System.out.println(answer);
		}
		
	}
	private static double divide(double a, double b){
		return a/b;
	}
	private static int multiply(int a, int b){
		return a*b;
	}
	private static int add(int a, int b){
		return a+b;
	}
	private static int subtract(int a, int b){
		return a-b;
	}
}
