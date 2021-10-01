package part01;



/**
 * This class represents the AudioTracks that can be played via the jukebox
 * @author matthewbeattie
 *
 */

public class AudioTrack implements ITrack,Comparable<AudioTrack> {
	
	private int trackCode;//this is the unique track code
	private static int nextCode = 1;
	private String title;//this is the title of the track
	private String artist;//this is the name of the artist for track 
	private int duration;//this is the time length of the song 
	private Genre style;//this is the style of the song 
	private String encoding;//this is the type of encoding the song has
	private int playCount = 0;//this is the number of times a song is played 
	
	
	/**
	 * This is a constructor for the AudioTrack
	 * @param title - track TItle 
	 * @param artist - artist name 
	 * @param encoding - encoding type of the track
	 * @param style - style of track
	 * @param duration - duration of the track
	 */
	public AudioTrack(String title, String artist, String encoding, Genre style, int duration) {
		this.title = title;
		this.artist = artist;
		this.duration = duration;
		this.trackCode = nextCode;
		this.encoding = encoding;
		
		
		
		nextCode++;
		this.style = style;
	}
	/**
	 * This is a constructor for the AudioTrack
	 * @param title - track TItle 
	 * @param artist - artist name
	 * @param duration - duration of the track
	 */
	public AudioTrack(String title, String artist, int duration) {
		this.title = title;
		this.artist = artist;
		this.duration = duration;
		this.trackCode = nextCode;
		this.encoding = "mp3";
		nextCode++;
		this.style = style.OTHER;
	}	
	
	/**
	 * 
	 * @param title - track title 
	 * @param artist - track artist 
	 * @param duration - track duration
	 * @param encoding - track encoding 
	 */
	public AudioTrack(String title, String artist, int duration,String encoding) {
		this.title = title;
		this.artist = artist;
		this.duration = duration;
		this.trackCode = nextCode;
		this.encoding = "mp3";
		nextCode++;
		this.style = style.OTHER;
	}
	
	/**
	 * This gets all the details of a given track
	 * @return - the details of a given track
	 */
	public String getDetails() {
		String trk = "TrackCode: " + this.trackCode + "\n";
		trk += "title: " + this.title + "\n";
		trk += "artist: " + this.artist + "\n";
		trk += "duration: " + this.duration + "\n"; 
		trk += "style : " + this.style.toString() +"\n";
		trk += "encoding: " + this.encoding + "\n";
		trk += "Play count: " + this.playCount + "\n";
		return trk;
	}
	
	
	/**
	 * return a string representation of the object AudioTracks
	 * @return - details for a audioTrack object 
	 */
	
	@Override	
	public String toString() {
		return this.getDetails();
	}
	
	
	
	/**
	 * get the value of the variable encoding
	 * @return - this is the track encoding 
	 */
	public String getEncoding() {
		return this.encoding;
	}
	
	/**
	 * get the value of the variable Artist
	 * @return - this is the track artist 
	 */
	public String getArtist() {
		return this.artist;
	}
	/**
	 * get the value of the variable Title 
	 * @return - this is the track title  
	 */
	public String getTitle() {
		return this.title;
	}
	
	
	/**
	 * get the value of the variable Duration
	 * @return - this is the track duration 
	 */
	public int getDuration() {
		return this.duration;
	}
	
	
	/**
	 * get the value of the variable Style
	 * @return - this is the track style 
	 */
	public String getStyle() {
		return this.style.toString();
	}
	
	/**
	 * get the value of the variable playCount
	 * @return - the playCount of a track
	 */
	public Integer getPlayCount() {
		return this.playCount;
	}
	
	
	/**
	 * get the value of the the tracks unique code 
	 * @return - this is the trackCode 
	 */
	public int getTrackCode() {
		return this.trackCode;
	}
	
	
	
	
	/**
	 * increase the value of playCount when a song is played
	 * increase the value of the PlayCount by 1
	 */
	public void increasePlayCount() {
		this.playCount ++;
	}
	
	/*
	 * this will allow all details for the track to be displayed within a csv file 
	 * @return - this will return the details for a given track
	 */
	public String printStats() {
		String res = "details for :" + title + ":\n";
		res += artist + " = artist name.\n";
		res += duration + " = track duration .\n";
		res += encoding + " = track encoding.\n";
		return res;
		
	}
	
	/**
	 * compare the title of 2 different songs 
	 * @param trk - track from AudioTrack
	 * @return - the results of the 2 songs compared 
	 */
	public int compare(AudioTrack trk) {
		AudioTrack other = (AudioTrack)trk;
		return getTitle().compareTo( other.getTitle() );
	}
	
	/**
	 * compare the play counts of two songs to find the track with the highest playCount 
	 * @return - return the track that has the highest playCount first 
	 */
	
	@Override
	public int compareTo(AudioTrack at) {
		if(getPlayCount() == null || at.getPlayCount() == null) {
			return 0;
		}
		return getPlayCount().compareTo(at.getPlayCount());
	}
}