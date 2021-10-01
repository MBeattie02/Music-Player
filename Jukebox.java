package part01;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;
import java.util.Random;
import java.util.Scanner;





/**
 * this class constructs all the methods that are needed to connect all of the classes together 
 * @author matthewbeattie
 *
 */

public class Jukebox implements IJukebox {
	
	public Jukebox(AudioPlayer player) {
		createAudioTracks();
		this.player = player;
	}
	
	private AudioPlayer player; 
	
	static final int MAX = 10;
	private static ArrayList<AudioTrack> allTracks = new ArrayList<AudioTrack>();//create new arrayList
	static int count;
		
	/**
	 * add audio tracks to the audioTrack array for testing 
	 */
	
	private static void createAudioTracks() {
		AudioTrack trk1 = new AudioTrack("Last christmas", "wham", "mp3", Genre.ROCK, 3);
		AudioTrack trk2 = new AudioTrack("Do they know its christmas ","Band aid ","mp3", Genre.CLASSICAL, 2 );
		AudioTrack trk3 = new AudioTrack("Driving home for christmas", "Chris Rea", "mp3", Genre.DANCE, 4);
		
		allTracks.add(trk1);
		allTracks.add(trk2);
		allTracks.add(trk3);
		
	}
	
	
	
	
	
	




	




	/**
	 * get the track code and title for each track and display
	 * @return - the details of the track
	 */
	// list the details of all tracks after each other (DisplayAlltracks 1 )
	public String getTrackList() {
		ArrayList<AudioTrack> copyOfTracks = new ArrayList<>(allTracks);
		quickSort(copyOfTracks);
		String getTitleList = "";
		for(AudioTrack track : copyOfTracks) {
			getTitleList +=  "TrackCode : " + track.getTrackCode() +", Track Title: " + track.getTitle() + " Track Artist: " + track.getArtist() + "\n";
			
		}
		return getTitleList;
	}

	
	


	/**
	 * select a specific track and play it 
	 */
	
	public boolean playTrack(AudioTrack trk) {
		 return player.play(trk);//play the track through the AudioPlayer class
	}
	
	/**
	 * take the only playlist created and play it in a shuffle order 
	 * @return - playlist in a shuffled order 
	 */
	
	public String shuffle(ArrayList <AudioTrack> list) {
		ConsoleApplication.random(list);
		String trackPlaylist = "";
		for(AudioTrack track : list) {
			trackPlaylist += "title: " + track.getTitle() + ", artist: " + track.getArtist() + "\n";
			
			playTrack(track);
		}

		 return trackPlaylist;
	}
	
	 
	
	
	
	
	/**
	 * add a new track from the users input to the array audio tracks 
	 */
	
	public void addTrack(AudioTrack trk) {
		allTracks.add(trk);
	}
	
	
	/**
	 * display list of all artist and allowing for them to be selected and their song details displayed
	 * @return - the tracks to be displayed
	 */
	
	public AudioTrack[] getTracks() {
		AudioTrack[] trackList = allTracks.toArray(new AudioTrack[allTracks.size()]);
		return trackList;
	}
		
	/**
	 * This sorts the values that are in the ArrayList AudioTrack	
	 * @param copyOfTracks - takes a copy of Arraylist so original Arraylist does not change order 
	 * @return - returns the sorted array
	 */
	protected ArrayList<AudioTrack> quickSort(ArrayList<AudioTrack> copyOfTracks)
	{
	    if (copyOfTracks.size() <= 1) 
	        return copyOfTracks; // Already sorted  

	    ArrayList<AudioTrack> sorted = new ArrayList<AudioTrack>();
	    ArrayList<AudioTrack> lesser = new ArrayList<AudioTrack>();
	    ArrayList<AudioTrack> greater = new ArrayList<AudioTrack>();
	    AudioTrack pivot = copyOfTracks.get(copyOfTracks.size()-1); // Use last Vehicle as pivot
	    for (int i = 0; i < copyOfTracks.size()-1; i++)
	    {
	        //int order = list.get(i).compareTo(pivot);
	        if (copyOfTracks.get(i).compareTo(pivot) < 0)
	            lesser.add(copyOfTracks.get(i));    
	        else
	            greater.add(copyOfTracks.get(i));   
	    }

	    lesser = quickSort(lesser);
	    greater = quickSort(greater);

	    lesser.add(pivot);
	    lesser.addAll(greater);
	    sorted = lesser;

	    return sorted;
	}
	
	


	/**
	 * Display the songs that with the number of plays they have 
	 * @return - the number of plays that each song has 
	 */
	public String displayTop() {
		
		ArrayList<AudioTrack> copyOfTracks = new ArrayList<>(allTracks);
		quickSort(copyOfTracks);
		String playCountList = "";
		for(AudioTrack track : copyOfTracks) {
			playCountList += "title: " + track.getTitle() + ", artist: " + track.getArtist() + " plays: " + track.getPlayCount() + "\n";
			
		}
		return playCountList;
	}




	

}
