package main;

import javax.swing.*;
import java.net.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
 

public class AppClient {
 
    public static void main(String[] args) {
    	
    	// creates instance of JFrame
    	JFrame frame1 = new JFrame();
    	// creates instance of JButton
    	JButton button1 = new JButton("Click to get time information from time.nist.gov ");
    	// x axis, y axis, width, height
    	button1.setBounds(30, 150 ,380, 80);
    	// adds button1 in Frame1
    	frame1.add(button1);
    	// adds button2 in Frame1
    	// 400 width and 500 height of frame1
    	frame1.setSize(440, 500) ;
    	// uses no layout managers
    	frame1.setLayout(null);
    	// makes the frame visible
    	frame1.setVisible(true);
    	
    	
    	button1.addActionListener(new ActionListener() {
    		@Override
    		public void actionPerformed(ActionEvent e) {
    	        String hostname = "time.nist.gov";
    	        int port = 13;
    	 
    	        try (Socket socket = new Socket(hostname, port)) {
    	 
    	            InputStream input = socket.getInputStream();
    	            InputStreamReader reader = new InputStreamReader(input);
    	 
    	            int character;
    	            StringBuilder data = new StringBuilder();
    	 
    	            while ((character = reader.read()) != -1) {
    	                data.append((char) character);
    	            }
    	            JOptionPane.showMessageDialog(frame1, "Data from server: " + data);
    	 
    	        } catch (UnknownHostException ex) {
    	 
    	        	JOptionPane.showMessageDialog(frame1, "Server not found: " + ex.getMessage());
    	 
    	        } catch (IOException ex) {
    	 
    	        	JOptionPane.showMessageDialog(frame1, "I/O error: " + ex.getMessage());
    	        }
    		}
    	});

    }
}