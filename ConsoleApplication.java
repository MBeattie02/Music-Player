
package part01;

import java.util.ArrayList;

import java.util.List;
import java.util.Random;
import java.util.Scanner;


/**
 * this class allows the user to input data to get different outputs and gain access to other classes in the package through the eclipse console
 * @author matthewbeattie
 *
 */


public class ConsoleApplication {
	static Scanner input = new Scanner(System.in);
	private static ArrayList<AudioTrack> list = new ArrayList<AudioTrack>();
	public static void main(String[] args) {
		
		Jukebox myJukebox = new Jukebox(new AudioPlayer());
		
		String items[] = { "Dislay all Tracks", "Display tracks By Artist", "Add New track","play a Track","Create a Playlist","Shuffle Play","Display the Top 10","Quit" };
		Menu myMenu = new Menu("QUB Music Management", items);

		boolean quit = false;
		int choice = myMenu.getUserChoice();//requests and processes the users choice 
		while (choice != items.length) {
			processChoice(choice, myJukebox);
			choice = myMenu.getUserChoice();
		}
		System.out.println("Goodbye!");
	}
	
	/**
	 * Switch case that takes the users input and will call the methods that the user requires for their selection
	 * @param choice - takes the users choice through a scanner input
	 * @param myJukebox - allows access to the jukebox class 
	 */
	//display the menu option for the user to select from 
	public static void processChoice(int choice, Jukebox myJukebox) {
		AudioTrack[] myTracks = getTracks(myJukebox);

		switch (choice) {
		case 1:
			System.out.println("List of all tracks in order are :\n");
			System.out.println(myJukebox.getTrackList());//call method
			break;
		case 2:
			Select(myTracks , myJukebox);
			break;
		case 3:
			AudioTrack newTrack = createNewTrack();
			myJukebox.addTrack(newTrack);//call method
			System.out.println("Added new track: \n " + newTrack.toString());
			break;
		case 4:			
			play(myTracks , myJukebox);
			break;
		case 5:
			System.out.println("Create playlist: ");
			CreatePlaylist(myTracks,myJukebox);//call method
			
			break;
		case 6:
			System.out.println("Shuffle the playlist: ");
			randomize(myJukebox);//call method
			break;
		case 7:
			System.out.println("Display top played songs: ");
			System.out.println(myJukebox.displayTop()); //call method

			
			break;
		}
	}
	/**
	 * Allows the user to input the details of a new track that they want to add to the AudiOTrack array list 
	 * @return - the details of the track that was added 0by the user 
	 */
	private static AudioTrack createNewTrack() {
		boolean ok = false;
		do {
			try {
				System.out.print("Enter title: ");
				String title = input.nextLine();//takes the users input on the next line 
				System.out.print("Enter artist: ");
				String artist = input.nextLine();
				System.out.print("Enter duration: ");
				int duration = Integer.parseInt(input.nextLine());
				EnumDemo();
				System.out.print("Enter style: ");
				int genre = Integer.parseInt(input.nextLine());
				System.out.print("Enter encoding ");
				String encoding = input.nextLine();
			
				AudioTrack trk = new AudioTrack(title, artist, encoding, Genre.values()[genre], duration);
				return trk;
			}
			catch (Exception ex) {//returns an exception if the data entered by the user is not of the correct format
				System.out.println("Data entered is not valid try again!!");
				
			}
		}while (!ok);
			
		return null;
		
			
			
	}
	
	
	/**
	 * get the details of each track
	 * @param myJukebox - allows the getTracks method to be called in the Jukebox class
	 * @return - return the details of the track stored in the AudioTrack array
	 */
	private static AudioTrack[] getTracks(Jukebox myJukebox) {
		return myJukebox.getTracks();	
	}

	
	
	
	/**
	 * plays the song that the user selects 
	 * @param myTracks - allows access to myTracks array List
	 * @param myJukebox - allows methods in Jukebox class to be accessed 
	 * @return - the title of the track that was played
	 */
	private static void play(AudioTrack[] myTracks ,Jukebox myJukebox){
	
		//print out all the songs that are available for selection
		for(int index=0; index<myTracks.length;index++) {
			AudioTrack current = myTracks[index];
			System.out.println(current.getTrackCode() +": " + current.getTitle());
		
		}
		
		//get user to pick a song
		System.out.println("Pick the number of song the song you want to play: ");
		int chosenSongNumber = Integer.parseInt(input.nextLine());
		
		//need to minus one the number because the array is indexed from zero
		AudioTrack chosenTrack = myTracks[chosenSongNumber - 1];
		
		System.out.println("Playing track: " + chosenTrack.getTitle());
		System.out.println("Successfully played song? " + myJukebox.playTrack(chosenTrack));//output true or false depending if the song could be played 
	
	
	}


	
	/**
	 * Alloys the user to select the artist and display the available songs for that artist 
	 * @param myTracks - access array List my tracks
	 * @param myJukebox - allows access to the methods in Jukebox
	 * @return - the titles for the artist that was selected 
	 */
	private static void Select(AudioTrack[] myTracks ,Jukebox myJukebox) {
		for(int index=0; index<myTracks.length;index++) {
			AudioTrack current = myTracks[index];
			System.out.println(current.getTrackCode() +": " + current.getArtist());
		}
		
		//get user to pick a song
		System.out.println("Pick the Artist whose songs you would like to see: ");
		int chosenSongNumber = Integer.parseInt(input.nextLine());
		
		//need to minus one the number because the array is indexed from zero
		AudioTrack chosenTrack = myTracks[chosenSongNumber - 1];
		
		System.out.println("Songs for that Artist: \n" + chosenTrack.getTitle());
		
	}
	
	
	/**
	 * allows the user to select the songs that they want to add to the playlist
	 * @param myTracks - access to the arrayList myTracks
	 * @param myJukebox - access to methods within my Jukebox
	 */
	
	//allow user to select the songs that they want to add to the playlist
	private static void CreatePlaylist(AudioTrack[] myTracks, Jukebox myJukebox) {
		
			System.out.println(myJukebox.getTrackList());
			System.out.println("Pick the Songs you want to add to the playlist seperated by a comma: ");
			String value = input.nextLine(); 
			String[] valueSplit = value.trim().split(",");//takes away any white space between inputs 
			
			for(String songNumber : valueSplit) {
				AudioTrack chosenTrack = myTracks[Integer.parseInt(songNumber) - 1];
				list.add(chosenTrack);
				
			}
			
			
			System.out.println(list);
			
		
		
			
	}
	
	
	
	/**
	 * allows the playlist the user created to be played in a random order 
	 * @param myJukebox - access to methods within my Jukebox
	 * @return - playlist played in a random order 
	 */
	//Display and play the playlist in a random order 
	private static void randomize(Jukebox myJukebox) {
		myJukebox.shuffle(list);
		
		System.out.println(" The random playlist consists of: ");
		System.out.println(myJukebox.shuffle(list));
    } 
	
	/**
	 * Take a list and return it in a shuffled order 
	 * @param <T>
	 * @param list - take the list AudioTrack
	 */
	public static<T> void random(List<T> list)
    {
        Random random = new Random();
 
        // start from end of the list
        for (int i = list.size() - 1; i >= 1; i--)
        {
            // get a random index j such that 0 <= j <= i
            int j = random.nextInt(i + 1);
 
            // swap element at i'th position in the list with element at
            // randomly generated index j
            T obj = list.get(i);
            list.set(i, list.get(j));
            list.set(j, obj);
        }
    }
 
	/**
	 * display the values that the genre can take in the main console so the user can select which one they want
	 * @return - values of the genre through the enumeration 
	 */
	private static void EnumDemo() {
		for(Genre g : Genre.values()) {
		System.out.println(g);
			
		}

	}
	

}
