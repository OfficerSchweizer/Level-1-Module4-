
/*
 *    Copyright (c) The League of Amazing Programmers 2013-2018
 *    Level 1
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import javazoom.jl.player.advanced.AdvancedPlayer;

/* 1. Download the JavaZoom jar from here: http://bit.ly/javazoom
 * 2. Right click your project and add it as an External JAR (Under Java Build Path > Libraries).*/

public class Jukebox implements Runnable, ActionListener {

	JFrame frame = new JFrame();
	JButton song1 = new JButton();
	JButton song2 = new JButton();
	JButton stop = new JButton();
	JPanel panel = new JPanel();

	public void run() {

		song1.addActionListener(this);
		song1.setText("Star Spangled Banner");
		song2.addActionListener(this);
		song2.setText("Zeze");
		stop.addActionListener(this);
		stop.setText("pause");
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		
		panel.add(song2);
		panel.add(song1);
		panel.add(stop);
		frame.add(panel);
		frame.setVisible(true);
		frame.pack();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == song1) {
			Song music = new Song("http://www.mostfreebies.com/Music/StarSpangledBanner.mp3");
			music.play();
			if (e.getSource() == stop) {
				music.stop();
			}
		}
		if (e.getSource() == song2) {
			Song music2 = new Song(
					"https://www.naijaexclusive.net/wp-content/uploads/2018/10/Kodak_Black_-_Zeze_Ft_Travis_Scott_Offset__NaijaExclusive.net.mp3");
			music2.play();
			if (e.getSource() == stop) {
				music2.stop();
			}
		}

	}

	/* Use this method to add album covers to your Panel. */
	private JLabel loadImage(String fileName) {
		URL imageURL = getClass().getResource(fileName);
		Icon icon = new ImageIcon(imageURL);
		return new JLabel(icon);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Jukebox());

		Jukebox songPlayer = new Jukebox();
		songPlayer.run();
	}

}

class Song {

	private int duration;
	private String songAddress;
	private AdvancedPlayer mp3Player;
	private InputStream songStream;

	/**
	 * Songs can be constructed from files on your computer or Internet addresses.
	 * 
	 * Examples: <code> 
	 * 		new Song("everywhere.mp3"); 	//from default package 
	 * 		new Song("/Users/joonspoon/music/Vampire Weekend - Modern Vampires of the City/03 Step.mp3"); 
	 * 		new	Song("http://freedownloads.last.fm/download/569264057/Get%2BGot.mp3"); 
	 * </code>
	 */
	public Song(String songAddress) {
		this.songAddress = songAddress;
	}

	public void play() {
		loadFile();
		if (songStream != null) {
			loadPlayer();
			startSong();
		} else
			System.err.println("Unable to load file: " + songAddress);
	}

	public void setDuration(int seconds) {
		this.duration = seconds * 100;
	}

	public void stop() {
		if (mp3Player != null)
			mp3Player.close();
	}

	private void startSong() {
		Thread t = new Thread() {
			public void run() {
				try {
					if (duration > 0)
						mp3Player.play(duration);
					else
						mp3Player.play();
				} catch (Exception e) {
				}
			}
		};
		t.start();
	}

	private void loadPlayer() {
		try {
			this.mp3Player = new AdvancedPlayer(songStream);
		} catch (Exception e) {
		}
	}

	private void loadFile() {
		if (songAddress.contains("http"))
			this.songStream = loadStreamFromInternet();
		else
			this.songStream = loadStreamFromComputer();
	}

	private InputStream loadStreamFromInternet() {
		try {
			return new URL(songAddress).openStream();
		} catch (Exception e) {
			return null;
		}
	}

	private InputStream loadStreamFromComputer() {
		try {
			return new FileInputStream(songAddress);
		} catch (FileNotFoundException e) {
			return this.getClass().getResourceAsStream(songAddress);
		}
	}

}
