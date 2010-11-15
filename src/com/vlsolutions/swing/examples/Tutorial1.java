package com.vlsolutions.swing.examples;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class Tutorial1 extends JFrame {
	MyTextEditor editorPanel = new MyTextEditor();
	MyTree treePanel = new MyTree();
	MyGridOfButtons buttonGrid = new MyGridOfButtons();
	MyJTable tablePanel = new MyJTable();

	public Tutorial1() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().add(editorPanel, BorderLayout.CENTER);
		getContentPane().add(treePanel, BorderLayout.WEST);
		getContentPane().add(buttonGrid, BorderLayout.NORTH);
		getContentPane().add(tablePanel, BorderLayout.EAST);
	}

	public static void main(String[] args) {
		final Tutorial1 frame = new Tutorial1();
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		frame.validate();
		SwingUtilities.invokeLater(new Runnable() {
			// in the event dispatch thread
			public void run() {
				frame.setVisible(true);
			}
		});
	}
}

class MyJTable extends JPanel {
	JTable table = new JTable();

	public MyJTable() {
		setLayout(new BorderLayout());
		table.setModel(new DefaultTableModel(5, 5));
		JScrollPane jsp = new JScrollPane(table);
		jsp.setPreferredSize(new Dimension(200, 200));
		add(jsp, BorderLayout.CENTER);
	}
}

class MyGridOfButtons extends JPanel {
	public MyGridOfButtons() {
		setLayout(new FlowLayout(FlowLayout.TRAILING, 3, 3));
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				add(new JButton("btn" + (i * 3 + j)));
			}
		}
		setPreferredSize(new Dimension(200, 300));
	}
}

class MyTree extends JPanel {
	JTree tree = new JTree();

	public MyTree() {
		setLayout(new BorderLayout());
		JScrollPane jsp = new JScrollPane(tree);
		jsp.setPreferredSize(new Dimension(200, 200));
		add(jsp, BorderLayout.CENTER);
	}
}

class MyTextEditor extends JPanel {
	JTextArea textArea = new JTextArea("A Text Area");

	public MyTextEditor() {
		setLayout(new BorderLayout());
		JScrollPane jsp = new JScrollPane(textArea);
		jsp.setPreferredSize(new Dimension(300, 400));
		add(jsp, BorderLayout.CENTER);
	}
}
