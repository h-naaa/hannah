/*import javax.swing.*;
import java.awt.*;

public class PaintComponent_Exam extends JFrame{
	
	PaintComponent_Exam(){
			setTitle("paintConponent Example");
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			OurPanel op = new OurPanel(); //�г�������
			add(op, BorderLayout.CENTER); //�г��������ӿ�����
			setSize(300,300);
			setVisible(true);
	
	}
class OurPanelextends JPanel{

	public void paintComponent(Graphics g){
		//�гο��������׸�
		super.paintComponent(g); //JPanel��paintComponent()��ȣ��
		g.setColor(Color.YELLOW); //���������
		g.fillRect(30, 30, 50, 50); //(30,30)��ġ��50*50ũ����ä�����簢���׸�
		g.setColor(Color.GREEN); //�ʷϻ�����
		g.fillOval(70, 70, 50, 50); //(70,70) ��ġ��50*50 ũ����ä�������׸�
	}
}

public static void main(String[] args){
	new PaintComponent_Exam();
}
} */