import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.RenderingHints.Key;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;


class Calculator extends JFrame  {
	
	JButton[] numberButtons= new JButton[10];
	JTextField result;
	int currentNum;
	int nextnumber;
	Function function;
	
	public enum Function{ADD, SUBTRACT, DIVIDE, MULTIPLY
	}
	 public Calculator(){
		   createCalculator();
		   System.out.println("g");
	   }
	   
	
	public void add(Component comp, int gridx, int gridy, int gridheight, int gridwidth, Insets inset){
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx=gridx;
		gbc.gridy=gridy;
		gbc.gridheight=gridheight;
		gbc.gridwidth=gridwidth;
		gbc.insets=inset;
		add(comp, gbc);
	}
	
	public JButton createButton(int x, int y, String name){
		JButton btn = new JButton(name);
		 btn.setPreferredSize(new Dimension(x, y));
		 return btn;
	}
	
  
   public void createCalculator(){
	   setLayout(new GridBagLayout());
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       addTextField();
       addNumberButtons();
       addFunctions();	
       pack();
       setVisible(true);
       
   }
   
   public void addTextField(){
	   result = new JTextField();
	   result.setEditable(false);
	   result.setBackground(Color.WHITE);
	   result.setPreferredSize(new Dimension(400, 100));
	   add(result, 0, 0, 1, 4, new Insets(0,0,0,0));
	   
	    
   }
   public void addNumberButtons(){
	   for(int i =1; i<10; i++){
		   numberButtons[i]=createButton(100,50, new Integer(i).toString());
		   
	   }
	   numberButtons[0]=createButton(316, 50, "0");
	 
	   add(numberButtons[1], 0,1, 1,1, new Insets(4,4,4,4));
	   add(numberButtons[2], 1,1, 1,1, new Insets(4,4,4,4));
	   add(numberButtons[3], 2,1, 1,1, new Insets(4,4,4,4));
	   add(numberButtons[4], 0,2, 1,1, new Insets(4,4,4,4));
	   add(numberButtons[5], 1,2, 1,1, new Insets(4,4,4,4));
	   add(numberButtons[6], 2,2, 1,1, new Insets(4,4,4,4));
	   add(numberButtons[7], 0,3, 1,1, new Insets(4,4,4,4));
	   add(numberButtons[8], 1,3, 1,1, new Insets(4,4,4,4));
	   add(numberButtons[9], 2,3, 1,1, new Insets(4,4,4,4));
	   add(numberButtons[0], 0,4, 1,3, new Insets(4,4,4,4));
	   
	   numberButtonAction[] actions = new numberButtonAction[10];
	   for(int i=0; i<10; i++){
		   actions[i]=new numberButtonAction(new Integer(i).toString());
		   numberButtons[i].addActionListener(actions[i]);
	   }
   }
   public void addFunctions(){
	   	JButton plus = createButton(100, 50, "+");
	   	add(plus, 3, 1, 1,1, new Insets(4,4,4,4));
	   	plus.addActionListener(new functionButtonAction(Function.ADD));
	   	
	 	JButton minus = createButton(100, 50, "-");
	   	add(minus, 3, 2, 1,1, new Insets(4,4,4,4));
	   	minus.addActionListener(new functionButtonAction(Function.SUBTRACT));

	 	JButton multiply = createButton(100, 50, "*");
	   	add(multiply, 3, 3, 1,1, new Insets(4,4,4,4));
	   	multiply.addActionListener(new functionButtonAction(Function.MULTIPLY));

	   	
	 	JButton divide = createButton(100, 50, "/");
	   	add(divide, 3, 4, 1,1, new Insets(4,4,4,4));
	   	divide.addActionListener(new functionButtonAction(Function.DIVIDE));

	   	
	   	JButton clear = createButton(200, 50, "CLR");
	   	add(clear, 0, 5, 1, 2, new Insets(4,4,4,4));
	   	JButton enter = createButton(200, 50, "=");
	   	add(enter, 2, 5, 1, 2, new Insets(4,4,4,4));
	   	
   }
   	
   private class numberButtonAction implements ActionListener{
	   
	   String number;
	   
	   public numberButtonAction(String number){
		  this.number = number;
	   }

	   @Override
		public void actionPerformed(ActionEvent arg0) {
		  result.setText(result.getText()+number);
	}
	   
   }
   private class clearButtonAction implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		result.setText("");
		
	}
	   
   }
   
   private class functionButtonAction implements ActionListener{
	   Function buttonFunc;
	
	public functionButtonAction(Function func){
		buttonFunc=func;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		currentNum = Integer.parseInt(result.getText());
		result.setText("");
		function=buttonFunc;
		
	}
	   
   }
   
   
   
		   
	private class enterButtonAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			nextnumber= Integer.parseInt(result.getText());
			switch(function){
			    case ADD:
			    	result.setText(new Integer(currentNum+nextnumber).toString());
			    	break;
			    case SUBTRACT:
			    	result.setText(new Integer(currentNum-nextnumber).toString());
			    	break;
			    case MULTIPLY:
			    	result.setText(new Integer(currentNum*nextnumber).toString());
			    	break;	
			    case DIVIDE:
			    	if(nextnumber==0){
			    		result.setText("Divide by zero error");
			    		break;
			    	}
			    	else{
			    		result.setText(new Integer(currentNum/nextnumber).toString());
			    		break;	
			    	}
			}
			
		}
		
	}
    




}