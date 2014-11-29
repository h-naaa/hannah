/*import javax.swing.*;
import java.awt.*;

public class PaintComponent_Exam extends JFrame{
	
	PaintComponent_Exam(){
			setTitle("paintConponent Example");
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			OurPanel op = new OurPanel(); //패널을생성
			add(op, BorderLayout.CENTER); //패널을프레임에붙임
			setSize(300,300);
			setVisible(true);
	
	}
class OurPanelextends JPanel{

	public void paintComponent(Graphics g){
		//패널에도형을그림
		super.paintComponent(g); //JPanel의paintComponent()를호출
		g.setColor(Color.YELLOW); //노랑색설정
		g.fillRect(30, 30, 50, 50); //(30,30)위치에50*50크기의채워진사각형그림
		g.setColor(Color.GREEN); //초록생설정
		g.fillOval(70, 70, 50, 50); //(70,70) 위치에50*50 크기의채워진원그림
	}
}

public static void main(String[] args){
	new PaintComponent_Exam();
}
} */