//package test;

import java.applet.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class bounce extends JApplet implements ActionListener {
	private int width, height;
	private JButton start, PacmanBtn, CircleBtn, leftBtn, rightBtn, clearBtn;
	private int xMin, xMax, yMin, yMax, check = 0, checkp=1;
	private int x, y, size, xSpeed, ySpeed;
	Timer swTimer;
	JLabel position;
	JTextField text;

	public void init() {
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		text = new JTextField("0", 10);
		c.add(text);
		
		
		start = new JButton("start");
		start.addActionListener(this);
		c.add(start);
		leftBtn = new JButton("Left");
		leftBtn.addActionListener(this);
		c.add(leftBtn);
		rightBtn = new JButton("Right");
		rightBtn.addActionListener(this);
		c.add(rightBtn);
		PacmanBtn = new JButton("Pacman");
		PacmanBtn.addActionListener(this);
		c.add(PacmanBtn);
		CircleBtn = new JButton("Circle");
		CircleBtn.addActionListener(this);
		c.add(CircleBtn);
		clearBtn = new JButton("Clear");
		clearBtn.addActionListener(this);
		c.add(clearBtn);
		
		start.setVisible(true);
		leftBtn.setVisible(false);
		rightBtn.setVisible(false);
		PacmanBtn.setVisible(false);
		CircleBtn.setVisible(false);
		clearBtn.setVisible(false);
		text.setVisible(false);
		xMin = 15;
		xMax = 487;
		yMin = 30;
		yMax = 319;
		xSpeed = 0;
		ySpeed = 0;
		x = 240;
		y = 160;
		size = 40;
		position = new JLabel("X:"+x+" Y:"+y);
		c.add(position);
		position.setVisible(false);
		swTimer = new Timer(1, this);

	}

	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.BLACK);
		g.drawRect(15, 60, 471, 285);
		if (check == 0) {
			g.setColor(Color.BLUE);
			g.fillOval(x, y, size, size);
		}
		
		else if(check == 1){
		if (checkp == 1) {
			g.setColor(Color.BLUE);
			g.fillArc(x, y, size, size, 45, 270);
		} else if (checkp == 2) {
			g.setColor(Color.BLUE);
			g.fillArc(x, y, size, size, 225, 270);
		}
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == leftBtn) {
			checkp=2;
			position.setText("X:"+x+" Y:"+y);
			xSpeed = Integer.parseInt(text.getText());
			swTimer.start();
			moveleft();
			swTimer.stop();
			repaint();
		} else if (e.getSource() == rightBtn) {
			checkp=1;
			position.setText("X:"+x+" Y:"+y);
			xSpeed = Integer.parseInt(text.getText());
			swTimer.start();
			moveright();
			swTimer.stop();
			repaint();
		} else if (e.getSource() == PacmanBtn) {
			check = 1;
			repaint();
		} else if (e.getSource() == CircleBtn) {
			check = 0;
			repaint();
		} else if (e.getSource() == clearBtn) {
			x = 240;
			y = 160;
			check = 0;
			checkp=1;
			text.setText("0");
			start.setVisible(true);
			leftBtn.setVisible(false);
			rightBtn.setVisible(false);
			PacmanBtn.setVisible(false);
			CircleBtn.setVisible(false);
			clearBtn.setVisible(false);
			text.setVisible(false);
			position.setVisible(false);
			repaint();
		}
		else if (e.getSource() == start) {
			start.setVisible(false);
			leftBtn.setVisible(true);
			rightBtn.setVisible(true);
			PacmanBtn.setVisible(true);
			CircleBtn.setVisible(true);
			clearBtn.setVisible(true);
			text.setVisible(true);
			position.setVisible(true);
			repaint();
		}
		
	}

	public void moveright() {
		x = x + xSpeed;

		if (x < xMin) {
			x = xMin;
		} else if (x + size > xMax) {
			x = xMax - size;
		}

	}

	public void moveleft() {
		x = x - xSpeed;

		if (x < xMin) {
			x = xMin;
		} else if (x + size > xMax) {
			x = xMax - size;
		}

	}
}
