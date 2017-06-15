/*
 * 
 */

package org.pysz.agata.keylogger;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class LoggerPanel extends JPanel {

  
    private static final long serialVersionUID = 1L;

    /**
     * area which will hold the list of logged key events
     */
    private JTextArea textArea;

    /**
     * construct the panel
     */
    public LoggerPanel() {
	super(new GridBagLayout());

	textArea = new JTextArea(5, 20);
	textArea.setEditable(false);
	JScrollPane scrollPane = new JScrollPane(textArea);

	// Add Components to this panel.
	GridBagConstraints c = new GridBagConstraints();
	c.gridwidth = GridBagConstraints.REMAINDER;

	c.fill = GridBagConstraints.HORIZONTAL;

	c.fill = GridBagConstraints.BOTH;
	c.weightx = 1.0;
	c.weighty = 1.0;
	add(scrollPane, c);

    }

    /**
     * add given text to the panel and scroll to the bottom
     * @param text string which will be added to the panel
     */
    public void appendTextToPanel(String text) {

	final String newline = "\n";
	textArea.append(text + newline);
	textArea.setCaretPosition(textArea.getDocument().getLength());
    }
}