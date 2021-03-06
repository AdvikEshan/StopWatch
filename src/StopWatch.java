import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StopWatch extends JPanel
{
	private static final long serialVersionUID = 1L;
	private Timer myTimer1;
	public static final int ONE_SEC = 1000; 
	public static final int TENTH_SEC = 100;

	private Font myClockFont;

	private JButton startBtn, stopBtn, resetBtn;
	private JLabel timeLbl;
	private JPanel topPanel, bottomPanel;

	private int clockTick;  	
	private double clockTime;  
	private String clockTimeString;


	public StopWatch()
	{
		clockTick = 0; 
		clockTime = ((double)clockTick)/10.0;

		clockTimeString = new Double(clockTime).toString();
		myClockFont = new Font("Serif", Font.PLAIN, 50);

		timeLbl = new JLabel();
		timeLbl.setFont(myClockFont);
		timeLbl.setText(clockTimeString);

		startBtn = new JButton("Start");
		stopBtn = new JButton("Stop");
		resetBtn = new JButton("Reset");


		myTimer1 = new Timer(TENTH_SEC, new ActionListener() {
		public void actionPerformed(ActionEvent evt) {
			clockTick++;
			clockTime = ((double)clockTick)/10.0;
			clockTimeString = new Double(clockTime).toString();
			timeLbl.setText(clockTimeString);
		    }
		});


		startBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				myTimer1.start();
			}
		});

		stopBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				myTimer1.stop();
			}
		});

		resetBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				clockTick = 0;
				clockTime = ((double)clockTick)/10.0;
				clockTimeString = new Double(clockTime).toString();
				timeLbl.setText(clockTimeString);
			}
		});

	}
	public void launchStopWatch()
	{
		topPanel = new JPanel();
		topPanel.setBackground(Color.orange);
		bottomPanel = new JPanel();
		bottomPanel.setBackground(Color.green);
		topPanel.add(timeLbl);
		bottomPanel.add(startBtn);
		bottomPanel.add(stopBtn);
		bottomPanel.add(resetBtn);

		this.setLayout(new BorderLayout());

		add(topPanel, BorderLayout.CENTER);
		add(bottomPanel, BorderLayout.SOUTH);

		setSize(300,200);
		setBackground(Color.orange);

	}

	public static void main(String[] args)
	{
		MyTestFrame myTestFrame1 = new MyTestFrame();
	}


}

class MyTestFrame extends JFrame
{
	StopWatch StopWatch1;

	public MyTestFrame()
	{
		super("My Stop Watch");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container myPane = getContentPane();

		StopWatch1 = new StopWatch();
		StopWatch1.launchStopWatch();
		myPane.add(StopWatch1);
		pack();
		setVisible(true);
	}
}