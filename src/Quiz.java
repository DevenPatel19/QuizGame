import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

/* Assignment Parameters
The program should include five multiple-choice questions with four options.
The four options should be labeled A, B, C, and D.
The program should prompt the user to enter their answer by typing the corresponding letter (A, B, C, or D).
After the user has entered their answer for each question, the program should compare it to the correct answer 
and keep track of the number of correct responses.
The program should compute and display the final score as a percentage of the total number of questions.
Use if and switch case statements to handle user input and compare it to the correct answers.
Include comments to explain the purpose of each section of code and enhance code readability.
*/

// Class definition - implement Quiz method into Main Class
public class Quiz implements ActionListener{

	// Arrays to store questions, options and correct answers
	String[] questions = {
	"Declare a constant value in Java",
	"Which of the following is the correct way to declare a method in Java?",
	"What is an exmaple of an invalid variable name in Java?",
	"Which of the following data types in Java is NOT used to store integer values?",
	"Object initialization method in Java?"		
	};
	
	String[][] options = {
			{"final","const","static","immutable"},
			{"void myMethod {}","int myMethod(){}","void myMethod() {}","int myMethod"},
			{"myVariable","_myVariable"," 3myVariable","$variable"},
			{"int","long","byte","float"},
			{"initializer","creator","constructor","starter"}
	};
	
	char[] answers = {
		'A',
		'B',
		'C',
		'D',
		'C'
	};
	
	// Variables for tracking the user's guess and the keep results
	char guess;
	char answer;
	int index;
	int correct_guesses = 0;
	int total_questions = questions.length;
	int result;
	
	//GUI components using JFrame 
	JFrame frame = new JFrame();
	JTextField textfield = new JTextField();
	JTextArea textarea = new JTextArea();
	JButton buttonA = new JButton();
	JButton buttonB = new JButton();
	JButton buttonC = new JButton();
	JButton buttonD = new JButton();
	JLabel answer_labelA = new JLabel();
	JLabel answer_labelB = new JLabel();
	JLabel answer_labelC = new JLabel();
	JLabel answer_labelD = new JLabel();
	JTextField number_correct = new JTextField();
	JTextField grade = new JTextField();
	JButton buttonNext = new JButton();
	
	//Quiz Constructor
	public Quiz() {
		// Frame setup
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 800);
		frame.setLocation(800, 400);
		frame.getContentPane().setBackground(new Color(100,100,100));
		frame.setLayout(null);
		frame.setResizable(false);
		buttonNext.setEnabled(false);	// Disables Next button
		
//Question Number Label
		textfield.setBounds(0,0,650,50);
		textfield.setBackground(new Color(50,50,50));
		textfield.setForeground(new Color(25,255,0));
		textfield.setFont(new Font("New Times Roman",Font.BOLD,40));
		textfield.setBorder(BorderFactory.createBevelBorder(1));
		textfield.setHorizontalAlignment(JTextField.CENTER);
		textfield.setEditable(false);
		textfield.setText("Question!");
		
//Questions
		textarea.setBounds(0,50,650,50);
		textarea.setLineWrap(true);
		textarea.setWrapStyleWord(true);;
		textarea.setBackground(new Color(50,50,50));
		textarea.setForeground(new Color(25,255,0));
		textarea.setFont(new Font("New Times Roman",Font.BOLD,20));
		textarea.setBorder(BorderFactory.createBevelBorder(1));
		textarea.setEditable(false);
		textarea.setText("TEST2!");

//Button Objects
		//Button A
		buttonA.setBounds(0,100,100,100);
		buttonA.setFont(new Font("New Times Roman",Font.BOLD,35));
		buttonA.setFocusable(false); //prevents highlighting
		buttonA.addActionListener(this);
		buttonA.setText("A");
		
		//Button B
		buttonB.setBounds(0,200,100,100);
		buttonB.setFont(new Font("New Times Roman",Font.BOLD,35));
		buttonB.setFocusable(false); //prevents highlighting
		buttonB.addActionListener(this);
		buttonB.setText("B");

		//Button C
		buttonC.setBounds(0,300,100,100);
		buttonC.setFont(new Font("New Times Roman",Font.BOLD,35));
		buttonC.setFocusable(false); //prevents highlighting
		buttonC.addActionListener(this);
		buttonC.setText("C");
		
		//Button D
		buttonD.setBounds(0,400,100,100);
		buttonD.setFont(new Font("New Times Roman",Font.BOLD,35));
		buttonD.setFocusable(false); //prevents highlighting
		buttonD.addActionListener(this);
		buttonD.setText("D");
		
//Label objects
		//Label for answer A
		answer_labelA.setBounds(125,100,500,100);
		answer_labelA.setBackground(new Color(0,50,50));
		answer_labelA.setForeground(new Color(25,255,0));
		answer_labelA.setFont(new Font("New Times Roman",Font.ITALIC,35));
		answer_labelA.setText("Test label option A");
		
		//Label for answer 
		answer_labelB.setBounds(125,200,500,100);
		answer_labelB.setBackground(new Color(0,50,50));
		answer_labelB.setForeground(new Color(25,255,0));
		answer_labelB.setFont(new Font("New Times Roman",Font.ITALIC,35));
		answer_labelB.setText("Test label option B");
		
		//Label for answer 
		answer_labelC.setBounds(125,300,500,100);
		answer_labelC.setBackground(new Color(0,50,50));
		answer_labelC.setForeground(new Color(25,255,0));
		answer_labelC.setFont(new Font("New Times Roman",Font.ITALIC,35));
		answer_labelC.setText("Test label option C");
		
		//Label for answer 
		answer_labelD.setBounds(125,400,500,100);
		answer_labelD.setBackground(new Color(0,50,50));
		answer_labelD.setForeground(new Color(25,255,0));
		answer_labelD.setFont(new Font("New Times Roman",Font.ITALIC,35));
		answer_labelD.setText("Test label option D");
		
		// Field to display number of answers correct
		number_correct.setBounds(675,20,200,100);
		number_correct.setBackground(new Color(25,25,25));
		number_correct.setForeground(new Color(25,255,0));
		number_correct.setFont(new Font("InkFree",Font.BOLD,75));
		number_correct.setBorder(BorderFactory.createBevelBorder(1));
		number_correct.setHorizontalAlignment(JTextField.CENTER);
		number_correct.setEditable(false);
		
		
		// Field to display grade expressed as a percentage
		grade.setBounds(675,125,200,100);
		grade.setBackground(new Color(25,25,25));
		grade.setForeground(new Color(25,255,0));
		grade.setFont(new Font("InkFree",Font.BOLD,75));
		grade.setBorder(BorderFactory.createBevelBorder(1));
		grade.setHorizontalAlignment(JTextField.CENTER);
		grade.setEditable(false);
		
		
		// Next Question Button
		buttonNext.setBounds(325,625,400,100);
		buttonNext.setFont(new Font("New Times Roman",Font.BOLD,35));
		buttonNext.setFocusable(false); //prevents highlighting
		buttonNext.addActionListener(this);
		buttonNext.setText("Next");
		
//This section adds the objects to the JFrame
		frame.add(number_correct);
		frame.add(grade);
		frame.add(answer_labelA);
		frame.add(answer_labelB);
		frame.add(answer_labelC);
		frame.add(answer_labelD);
		frame.add(buttonA);
		frame.add(buttonB);
		frame.add(buttonC);
		frame.add(buttonD);
		frame.add(textarea);
		frame.add(textfield);
		frame.add(buttonNext);
		frame.setVisible(true);
		
		nextQuestion();	// Calls method for next Question
	}
	
	public void nextQuestion() {
		if(index>=total_questions) {
			results(); // if all questions are answered results are displayed
		}
		else {
			//Resets colors of questions back to normal 
			answer_labelA.setForeground(new Color(25, 255, 0));
		    answer_labelB.setForeground(new Color(25, 255, 0));
		    answer_labelC.setForeground(new Color(25, 255, 0));
		    answer_labelD.setForeground(new Color(25, 255, 0));

		    // Sets new text for question,numbers and options
			textfield.setText("Question: "+(index+1));
			textarea.setText(questions[index]);
			answer_labelA.setText(options[index][0]);
			answer_labelB.setText(options[index][1]);
			answer_labelC.setText(options[index][2]);
			answer_labelD.setText(options[index][3]);
			
			
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	    buttonA.setEnabled(false);
	    buttonB.setEnabled(false);
	    buttonC.setEnabled(false);
	    buttonD.setEnabled(false);
	    buttonNext.setEnabled(true);

	    char answer = ' '; // Initializes the answer variable

	    // Switch-case statement to handle button clicks
	    switch (e.getActionCommand()) {
	        case "A":
	            answer = 'A';
	            break;
	        case "B":
	            answer = 'B';
	            break;
	        case "C":
	            answer = 'C';
	            break;
	        case "D":
	            answer = 'D';
	            break;
	        case "Next":
	            // Resets answer to empty
	            answer = ' ';
	            
	            // Enables buttons for next question
	            buttonA.setEnabled(true);
	            buttonB.setEnabled(true);
	            buttonC.setEnabled(true);
	            buttonD.setEnabled(true);
	            buttonNext.setEnabled(false);
	            
	            // Moves to the next question
	            index++;

	            nextQuestion();
	            break; // exits switch statement
	        default:
	            break; // exits switch statement
	    }

	    if (answer != ' ') { // Checks if a button other than "Next" was clicked
	        if (answer == answers[index]) {
	            correct_guesses++;
	        }
	        displayAnswer(); // Displays correct answer
	    }
	}
	
	// Method for displaying correct answer
	public void displayAnswer() {
	    buttonA.setEnabled(false);
	    buttonB.setEnabled(false);
	    buttonC.setEnabled(false);
	    buttonD.setEnabled(false);
	    
	    //Highlights correct answer
	    if (answers[index] != 'A')
	        answer_labelA.setForeground(new Color(255, 0, 0));
	    
	    if (answers[index] != 'B')
	        answer_labelB.setForeground(new Color(255, 0, 0));
	    
	    if (answers[index] != 'C')
	        answer_labelC.setForeground(new Color(255, 0, 0));
	    
	    if (answers[index] != 'D')
	        answer_labelD.setForeground(new Color(255, 0, 0));
	       
	}
	
 	  // Method to display the quiz results
	public void results() {
		
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		buttonNext.setEnabled(false);
		
		// Calculates the result percentage
		result = (int)((correct_guesses/(double)total_questions)*100);
		
		// Displays the results
		textfield.setText("RESULTS!!");
		textarea.setText("");
		answer_labelA.setText("");
		answer_labelB.setText("");
		answer_labelC.setText("");
		answer_labelD.setText("");
		
		number_correct.setText("("+correct_guesses+"/"+total_questions+")");
		grade.setText(result+"%");
		
		// Adds number_correct and grade pieces to the JFrame
		frame.add(number_correct);
		frame.add(grade);
	}
	
}
