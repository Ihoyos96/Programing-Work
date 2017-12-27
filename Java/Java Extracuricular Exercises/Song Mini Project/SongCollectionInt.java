package songs;

import java.io.*;
public interface SongCollectionInt
{
  /**
    * return the number of elements in the collection
    */
  public int size();

  /**
    * add data from the file f
    *
    * first, the method creates a new scanner to read from f
    * encase the creation in try-catch so that if FileNotFoundException
    * occurs, then the method prints an error message and returns
    * immediately.
    *
    * second, the method reads the next line and converts it to an integer
    * this int is the number of additional slots
    *
    * third, the method creates a new array of Song data whose dimension
    * is the current size + the additional number of elements. This can
    * be achieved by Arrays.copyOf( THE_CURRENT_ARRAY, NEW_ARRAY_LENGHT )
    * after that, the methods reads data from the file in pairs of lines
    * and stores the data in the new slot.
    */
  public void addFromFile( File f );

  /**
    * write data to the file f; must handle FileNotFoundException
    */
  public void writeToFile( File f );

  /**
    * add a new song whose title is t and artist is a
    */
  public void addOneSong( String t, String a );

  /**
    * add a new song whose title is t and artist is a
    */
  public void delete( int pos );

  /**
    * print the list of all songs whose title contains key
    */
  public void searchByTitle( String key );

  /**
    * print the list of all songs whose artist contains key
    */
  public void searchByArtist( String key );

  /**
    * print the list with range index
    */
  public void show( int start, int end );

}
