package net.netne.andycomputer.jrpg.Battle.Properties;

import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import javax.swing.Action;
import javax.swing.AbstractAction;

/**
 *  This class will create and dispatch a WINDOW_CLOSING event to the active
 *  frame.  As a result a request to close the frame will be made and any
 *  WindowListener that handles the windowClosing event will be executed.
 *  Since clicking on the "Close" button of the frame or selecting the "Close"
 *  option from the system menu also invoke the WindowListener, this will
 *  provide a commen exit point for the application.
 */
public class Exit
{
	private Frame frame;
	public Exit(Frame f)
	{
		frame = f;
	}
}