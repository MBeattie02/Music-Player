package part01;

/**
 * this class plays the song selected within the jukebox by the user
 * will return if the song selected is able to be played
 * @author matthewbeattie
 *
 */

public class AudioPlayer implements IPlayer {
	
	private AudioTrack currentTrack;
	
	
	public AudioPlayer() {
		
	}
	
	/**
	 * checks if the song selected to be played can actually be played 
	 * @return - return true if the track is able to be played 
	 */
	public boolean play(AudioTrack trk) {
		trk.increasePlayCount();//increases the trackCount by one if the song can be played
		
		return true;
		
	}


	
	




}
