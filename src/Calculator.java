import javax.swing.JFrame;

public class Calculator extends JFrame {
	
	public Calculator(){
		createCalculator();
	}
	
	
	public void createCalculator(){
		setTitle("Calculator");
		setSize(500,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

}
