import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;



public class CarFrame extends Frame implements WindowListener {
	
	

   public CarFrame() {
	   
	   //this.addWindowListener(new MyWindowListener());   //1번방법
	   //this.addWindowListener(new MyWindowListener2());  //2번방법
	   //addWindowListener(this);   //3번방법
	   addWindowListener(new  WindowAdapter(){
		   public void windowClosing(WindowEvent e){
			   System.exit(0);
		   }
	   });    //4번방법    //바로 그자리에서 확인, 코드의 사이즈가 간결한 경우
	   
	   this.setSize(400, 600);  //this는 생략가능함
	   this.setVisible(true);
	   
  
	    
   }
   
   class MyWindowListener implements WindowListener{

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.exit(0);
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	   
   }
   
   class MyWindowListener2 extends WindowAdapter{
	   
	   public void windowClosing(WindowEvent e){
		   System.exit(0);
	   }
   }

@Override
public void windowActivated(WindowEvent arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void windowClosed(WindowEvent arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void windowClosing(WindowEvent arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void windowDeactivated(WindowEvent arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void windowDeiconified(WindowEvent arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void windowIconified(WindowEvent arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void windowOpened(WindowEvent arg0) {
	// TODO Auto-generated method stub
	
}
   
   
}