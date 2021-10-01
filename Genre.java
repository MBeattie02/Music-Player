package part01;





/**
 * creates the enumeration that displays the the different possible values that the field Genre can take 
 * @author matthewbeattie
 *
 */
public enum Genre {
	
	ROCK(0),POP(1),DANCE(2),JAZZ(3),CLASSICAL(4),OTHER(5);
	
	private int GenreId;//unique id for each Genre 
	private String details[] = {"Genre is Rock ","Genre is Pop ","Genre is Dance ","Genre is Jazz","Genre is Classical","Genre is Other",};//the text that is displayed for each genre 

			
	private Genre(int id) {
		GenreId = id;
		}
	/**
	 * return a string representation of the Genre
	 * @return - return the string explanation of each Genre depending on the GenreId
	 */
	public String toString() {
		return details[GenreId];
		}	
			



}
