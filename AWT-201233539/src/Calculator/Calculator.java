package Calculator;

import javax.swing.*;

import java.awt.BorderLayout;
 import java.awt.Color;
 import java.awt.GridLayout;
 import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener, KeyListener{

 final int MAX_INPUT_LENGTH = 20; 
  //각 모드별로 index를 부여
 final int INPUT_MODE = 0;
  final int RESULT_MODE = 1;
  final int ERROR_MODE = 2;
  int displayMode;
  
  boolean clearOnNextDigit;  
 
  double lastNumber;   
 String lastOperator;  
  private JLabel output;    
 private JButton buttons[];   
  private JPanel masterPanel, btnPanel, ctrPanel; 
 
 
  public Calculator(){
   
   setBackground(Color.gray);  
  
   masterPanel = new JPanel();
   
   output = new JLabel("0", JLabel.RIGHT); 
   output.setBackground(Color.WHITE);
   output.setOpaque(true);
   
   buttons = new JButton[23];
   
   btnPanel = new JPanel();
   
   
   for (int i=0 ; i<=9 ; i++){
    buttons[i] = new JButton(String.valueOf(i));   
   }
   
 
   buttons[10] = new JButton("±");
   buttons[11] = new JButton(".");
   buttons[12] = new JButton("=");
   buttons[13] = new JButton("/");
   buttons[14] = new JButton("*");
   buttons[15] = new JButton("-");
   buttons[16] = new JButton("+");
   buttons[17] = new JButton("√");
   buttons[18] = new JButton("1/x");
   buttons[19] = new JButton("%");
   
  
   buttons[20] = new JButton("←");
   buttons[21] = new JButton("CE");
   buttons[22] = new JButton("C");
   
  
  for(int i=0 ; i<buttons.length ; i++){
    if(i<10){
     buttons[i].setForeground(Color.black); 
   }else if(i>=10 && i<21){
     buttons[i].setForeground(Color.blue);
   }else{
     buttons[i].setForeground(Color.red); 
    }
   }
   
   
  btnPanel.setLayout(new GridLayout(4,5,2,2));
   
   for(int i=7; i<=9 ; i++){
    btnPanel.add(buttons[i]);
   }
   
   btnPanel.add(buttons[13]);
   btnPanel.add(buttons[17]); 
   
   for(int i=4; i<=6 ; i++){
    btnPanel.add(buttons[i]);
   }
   
   btnPanel.add(buttons[14]); 
   btnPanel.add(buttons[18]); 
   
   for(int i=1; i<=3 ; i++){
    btnPanel.add(buttons[i]);
   }
   
   btnPanel.add(buttons[15]);
  btnPanel.add(buttons[19]); 
   
   btnPanel.add(buttons[0]); 
   btnPanel.add(buttons[10]);
  btnPanel.add(buttons[11]); 
   btnPanel.add(buttons[16]); 
   btnPanel.add(buttons[12]); 
   
   
  ctrPanel = new JPanel();
   ctrPanel.setLayout(new GridLayout(1,2,2,2));
   
   
   ctrPanel.add(buttons[20]);
   ctrPanel.add(buttons[21]);
   ctrPanel.add(buttons[22]);
   
   
   
  masterPanel.setLayout(new BorderLayout());
   masterPanel.add(ctrPanel, BorderLayout.NORTH);
   masterPanel.add(btnPanel, BorderLayout.SOUTH);
   
   
   getContentPane().add(output, BorderLayout.NORTH);
   getContentPane().add(masterPanel,BorderLayout.SOUTH);
   requestFocus();
   
   
   for(int i=0 ; i<buttons.length ; i++){
    buttons[i].addActionListener(this);
    buttons[i].addKeyListener(this);
   }
     
   clearAll(); 
   
   addWindowListener(new WindowAdapter() {
     public void windowClosing(WindowEvent e){
      System.exit(0);
     }
    }
   );  
  }
  
  
 @Override
  public void actionPerformed(ActionEvent e){
   
   double result = 0;
   
   for(int i=0 ; i<buttons.length ; i++){
    if(e.getSource()==buttons[i]){
     if(i<10){
      addToDisplay(i);
      break;
     }else{
      switch(i){
       case 10: 
       processSingChange();
        break;
       case 11:
        addPoint();
        break;
       case 12: 
        processEquals();
        break;
       case 13: 
        processOperator("/");
        break;
       case 14:
        processOperator("*");
        break;
       case 15: 
       processOperator("-");
        break;
       case 16: 
        processOperator("+");
        break;
       case 17:
        if (displayMode != ERROR_MODE)
        {
           try
         {
          if (getDisplayString().indexOf("-") == 0)
              displayError("Invalid input for function!");

         result = Math.sqrt(getNumberInDisplay());
          displayResult(result);
         }

        catch(Exception ex)
         {
          displayError("Invalid input for function!");
          displayMode = ERROR_MODE;
         }
        }
        break;
       case 18: 
        if (displayMode != ERROR_MODE){
         try
         {
          if (getNumberInDisplay() == 0)
           displayError("영으로 나눌 수 없습니다.");
   
          result = 1 / getNumberInDisplay();
          displayResult(result);
         }
         
         catch(Exception ex) {
          displayError("영으로 나눌 수 없습니다.");
          displayMode = ERROR_MODE;
         }
        }
        break;
       case 19:
        if (displayMode != ERROR_MODE){
         try {
          result = getNumberInDisplay() / 100;
          displayResult(result);
         }
   
         catch(Exception ex) {
          displayError("Invalid input for function!");
          displayMode = ERROR_MODE;
         }
        }
        break;
       case 20: // ←
        backspace();
        break;
       case 21: //CE
        setDisplayString("0");
        clearOnNextDigit = true;
        displayMode = INPUT_MODE;
        break;
       case 22: //C
        clearAll();
        break;       
      }
     } 
    }
   }
  }
  
  
  
 public void keyPressed(KeyEvent e){

  int keycode = e.getKeyChar();
 
  switch(keycode){
    case KeyEvent.VK_0:
     addToDisplay(0);
     break;
    case KeyEvent.VK_1:
     addToDisplay(1);
     break;
    case KeyEvent.VK_2:
     addToDisplay(2);
     break;
    case KeyEvent.VK_3:
     addToDisplay(3);
     break;
    case KeyEvent.VK_4:
     addToDisplay(4);
     break;
    case KeyEvent.VK_5:
     addToDisplay(5);
     break;
    case KeyEvent.VK_6:
     addToDisplay(6);
     break;
    case KeyEvent.VK_7:
     addToDisplay(7);
     break;
    case KeyEvent.VK_8:
     addToDisplay(8);
     break;
    case KeyEvent.VK_9:
     addToDisplay(9);
     break;
    case 46: // .
     addPoint();    
     break;
    case 10: // =
     processEquals();
     break;
    case 47: // /
     processOperator("/");
     break;
    case 42: // *
     processOperator("*");
     break;
    case 43: // +
     processOperator("+");
     break;
    case 45: // -
    processOperator("-");
     break;
    case 8: //backspace
     backspace();
     break;
    case 27: //ESC
     clearAll();
     break;    
   }
  }

 private void clearAll() {
   setDisplayString("0");
   lastOperator = "0";
   lastNumber = 0;
   displayMode = INPUT_MODE;
   clearOnNextDigit = true;
  }
  
  private void backspace(){
   if (displayMode != ERROR_MODE){
    setDisplayString(getDisplayString().substring(0,
        getDisplayString().length() - 1));
    
    if (getDisplayString().length() < 1)
     setDisplayString("0");
   }
  }

 private void processOperator(String string) {
   if (displayMode != ERROR_MODE){
    double numberInDisplay = getNumberInDisplay();

   if (!lastOperator.equals("0")){
     try {
      double result = processLastOperator();
      displayResult(result);
      lastNumber = result;
     }catch(Exception e){}
    
    }else{
     lastNumber = numberInDisplay;
    }
    
    clearOnNextDigit = true;
    lastOperator = string;
   }
  }


  private double processLastOperator() throws Exception{
   double result = 0;
   double numberInDisplay = getNumberInDisplay();

  if (lastOperator.equals("/")){
    if (numberInDisplay == 0)
     throw (new Exception());

   result = lastNumber / numberInDisplay;
   }
    
   if (lastOperator.equals("*")){
    result = lastNumber * numberInDisplay;
   }
   if (lastOperator.equals("-")){
    result = lastNumber - numberInDisplay;
   }
   if (lastOperator.equals("+")){
    result = lastNumber + numberInDisplay;
   }
   
   return result;
  }

 private void processEquals() {
   double result = 0;

  if (displayMode != ERROR_MODE){
    try{
     result = processLastOperator();
     displayResult(result);
    }catch (Exception e){
     displayError("영으로 나눌 수 없습니다.");
    }
    lastOperator = "0";
   }
  }

 private void addPoint() {
   displayMode = INPUT_MODE;

  if (clearOnNextDigit)
    setDisplayString("");

  String inputString = getDisplayString();
  
  
   if (inputString.indexOf(".") < 0)
    setDisplayString(new String(inputString + "."));
  }

 private void processSingChange() {
   if (displayMode == INPUT_MODE){
    String input = getDisplayString();
    if (input.length() > 0 && !input.equals("0")){
     if (input.indexOf("-") == 0)
      setDisplayString(input.substring(1));
     else
      setDisplayString("-" + input);
    }
   }else if (displayMode == RESULT_MODE){
    double numberInDisplay = getNumberInDisplay();
   
    if (numberInDisplay != 0)
     displayResult(-numberInDisplay);
   }
  }

 private void displayResult(double result) {
   setDisplayString(Double.toString(result));
   lastNumber = result;
   displayMode = RESULT_MODE;
   clearOnNextDigit = true;
  }

 private void displayError(String error) {
   setDisplayString(error);
   lastNumber = 0;
   displayMode = ERROR_MODE;
   clearOnNextDigit = true;
  }

 private double getNumberInDisplay() {
   String input = output.getText();
   return Double.parseDouble(input);
  }

 private void addToDisplay(int i) {
   if (clearOnNextDigit)
    setDisplayString("");
   
   String inputString = getDisplayString();
   
   if(inputString.indexOf("0") == 0){
    inputString = inputString.substring(1);
   }
   if(( !inputString.equals("0") || i>0 ) && inputString.length() < MAX_INPUT_LENGTH){
    setDisplayString(inputString + i);
   }
   
   displayMode = INPUT_MODE;
   clearOnNextDigit = false;
  }


  private void setDisplayString(String string) {
   output.setText(string);
  }


  private String getDisplayString() {
   return output.getText();
  }
  

 public static void main(String args[]){
   Calculator cal = new Calculator();
   cal.setTitle("Calculator");
   cal.setSize(300,300);
   cal.pack();
   cal.setVisible(true);
   cal.setResizable(false);  
  }

 @Override
  public void keyReleased(KeyEvent arg0) {}

 @Override
  public void keyTyped(KeyEvent arg0) {}
 }




