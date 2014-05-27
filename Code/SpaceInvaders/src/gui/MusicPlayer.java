package gui;

import java.io.File;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class MusicPlayer {

	private String[] soundPaths = new String[] {"Assets/Musix/SK_-_Boss.mid",
			"Assets/Musix/bombexplosion.wav",
			"Assets/Musix/explosion.wav"};
	
	private Sequencer musicSequencer;
	private Clip bulletClip;
	private Clip explosionClip;
	
	private static MusicPlayer instance;	
	
	private MusicPlayer() {
		instance = this;
		playMusic();
		initExplosionClip();
		initBulletClip();
	}
	
	private void initExplosionClip() {
		try {
			explosionClip = AudioSystem.getClip();
			explosionClip.open(AudioSystem.getAudioInputStream(new File(soundPaths[2])));
		} catch (Exception e) {
		}
	}

	public static MusicPlayer getInstance() {
		if (instance == null)
			instance = new MusicPlayer();
		return instance;
	}
		
	private void initBulletClip() {
		try {
			bulletClip = AudioSystem.getClip();
			bulletClip.open(AudioSystem.getAudioInputStream(new File(soundPaths[1])));
		} catch (Exception e) {
		}
	}
	
	private void playMusic() {
		play(soundPaths[0], Integer.MAX_VALUE);
	}
	
	public void playExplosionSound() {
		explosionClip.setMicrosecondPosition(0);
		explosionClip.start();
	}
	
	public void playBulletSound() {
		bulletClip.setMicrosecondPosition(0);
		bulletClip.start();
	}
	
	private void play(String musicPath, int loopCount) {
		musicSequencer = null;
		try {
			Sequence sequence = MidiSystem.getSequence(new File(musicPath));
			musicSequencer = MidiSystem.getSequencer();
			musicSequencer.open();
			musicSequencer.setSequence(sequence);
			musicSequencer.setLoopCount(loopCount);
			musicSequencer.start();
		} catch (Exception e) {
		}
	}

}
