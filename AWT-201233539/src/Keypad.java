import java.awt.*;
import java.awt.event.*;


public class Keypad extends Frame implements ActionListener{
	
	TextField display = new TextField();
	
	public Keypad(){
		
		add(display, BorderLayout.NORTH); //or add(display, "North"); 
		add(buildKeypanel(), BorderLayout.CENTER);
		
		setSize(300,400);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		
	}
	
	private Panel buildKeypanel(){
		Panel panel = new Panel();
		
		panel.setLayout(new GridLayout(4,3));
		panel.add(new KeyButton("1"));
		panel.add(new KeyButton("2"));
		panel.add(new KeyButton("3"));
		panel.add(new KeyButton("4"));
		panel.add(new KeyButton("5"));
		panel.add(new KeyButton("6"));
		panel.add(new KeyButton("7"));
		panel.add(new KeyButton("8"));
		panel.add(new KeyButton("9"));
		panel.add(new KeyButton("*"));
		panel.add(new KeyButton("0"));
		panel.add(new KeyButton("#"));
	
		
		
		//Button btn1= new Button("1");
		//btn1.addActionListener(new MyActionListener());
		//panel.add(btn1);
		
		return panel;
	}
	
	class KeyButton extends Button {
		
		public KeyButton(String label){
			super(label);
			addActionListener(Keypad.this);
		}
			
	}

		
	
	
	public static void main(String[] args) {
		new Keypad();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() instanceof Button){
			Button btn = (Button) e.getSource();
			display.setText(display.getText() + btn.getLabel());
	}
	
}
}