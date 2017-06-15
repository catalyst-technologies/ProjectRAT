/*
 * 
 */

package org.pysz.agata.keylogger;

import javax.swing.JFrame;

import de.ksquared.system.keyboard.GlobalKeyListener;
import de.ksquared.system.keyboard.KeyAdapter;
import de.ksquared.system.keyboard.KeyEvent;

public class SimpleKeyLogger {

    /**
     * panel which logs information about pressed keys
     */
    LoggerPanel loggerPanel;

    public static void main(String[] args) {

	// Schedule a job for the event dispatch thread:
	// creating and showing this application's GUI.
	javax.swing.SwingUtilities.invokeLater(new Runnable() {
	    public void run() {
		init();
	    }

	});
    }

    /**
     * init application: create window and register the key listeners
     */
    private static void init() {
	SimpleKeyLogger simpleKeyLogger = new SimpleKeyLogger();
	simpleKeyLogger.createAndShowGUI();
	simpleKeyLogger.initializeKeyListeners();
    }

    /**
     * Create the GUI and show it.
     */
    private void createAndShowGUI() {
	// Create and set up the window.
	JFrame frame = new JFrame("Key Logger");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	// Add contents to the window.
	loggerPanel = new LoggerPanel();
	frame.add(loggerPanel);

	// Display the window.
	frame.pack();
	frame.setVisible(true);

	loggerPanel.appendTextToPanel("--start logging--");

    }

    /**
     * initialize listeners which will listen for key events
     */
    private void initializeKeyListeners() {
	new GlobalKeyListener().addKeyListener(new KeyAdapter() {
	    @Override
	    public void keyPressed(KeyEvent event) {
                
		loggerPanel.appendTextToPanel(event.toString());
	    }

	    @Override
	    public void keyReleased(KeyEvent event) {
		loggerPanel.appendTextToPanel(event.toString());
		if (event.getVirtualKeyCode() == KeyEvent.VK_ADD && event.isCtrlPressed())
		    loggerPanel.appendTextToPanel("CTRL+ADD was just released (CTRL is still pressed)");
	    }
	});

    }

}