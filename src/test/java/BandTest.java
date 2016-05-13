import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;
import static org.assertj.core.api.Assertions.assertThat;


public class BandTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void Band_instantiatesCorrectly_true() {
    Band myBand = new Band("Proxy", "Brief description of band");
    assertEquals(true, myBand instanceof Band);
  }

  @Test
  public void getName_bandInstantiatesWithName_String() {
    Band myBand = new Band("Proxy", "Brief description of band");
    assertEquals("Proxy", myBand.getName());
  }

  @Test
  public void all_emptyAtFirst_0() {
    assertEquals(0, Band.all().size());
  }

  @Test
  public void equals_returnsTrueIfNamesAretheSame_true() {
    Band firstBand = new Band("Proxy", "Brief description of band");
    Band secondBand = new Band("Proxy", "Brief description of band");
    assertTrue(firstBand.equals(secondBand));
  }

  @Test
  public void save_savesObjectIntoDatabase_true() {
    Band myBand = new Band("Proxy", "Brief description of band");
    myBand.save();
    assertTrue(Band.all().get(0).equals(myBand));
  }

  @Test
  public void save_assignsIdToObject_int() {
    Band myBand = new Band("Proxy", "Brief description of band");
    myBand.save();
    Band savedBand = Band.all().get(0);
    assertEquals(myBand.getId(), savedBand.getId());
  }

  @Test
  public void find_findsBandInDatabase_true() {
    Band myBand = new Band("Proxy", "Brief description of band");
    myBand.save();
    Band savedBand = Band.find(myBand.getId());
    assertTrue(myBand.equals(savedBand));
  }

  @Test
  public void find_findsBandInDatabaseAndDescription_true() {
    Band myBand = new Band("Proxy", "Brief description of band");
    myBand.save();
    Band savedBand = Band.find(myBand.getId());
    assertThat(myBand.getDescription()).contains("Brief");
  }

  // @Test
  // public void find_findsAllBandsInDatabaseAndCompares_true() {
  //   Band firstBand = new Band("Tacos", "meat and cheese", "cook", 5);
  //   firstBand.save();
  //   Band secondBand = new Band("Burgers", "burger meat and bun", "cook", 5);
  //   secondBand.save();
  //   Band thirdBand = new Band("Salad", "lettuce and dressing", "cook", 5);
  //   thirdBand.save();
  //   List<Band> allBands = Band.all();
  //
  //   List<Band> found  = Band.searchIngredients("%" + "meat" + "%");
  //
  //   assertEquals(2, found.size());
  //   // assertTrue(myBand.equals(savedBand));
  // }

  // // @Test
  // // public void find_findsAllBandsInDatabaseAndCompares_true() {
  // //   Band firstBand = new Band("Tacos", "meat and cheese", "cook", 5);
  // //   firstBand.save();
  // //   Band secondBand = new Band("Burgers", "burger meat and bun", "cook", 5);
  // //   secondBand.save();
  // //
  // //   Band findIngredient = firstBand.searchIngredients();
  // //   assertThat(findIngredient.contains("meat");
  // // }
  //
  @Test
  public void update_updatesBandName_true() {
    Band myBand = new Band("Proxy", "Brief description of band");
    myBand.save();
    myBand.update("Odesza", "A new description for this new artist");
    assertEquals("Odesza", Band.find(myBand.getId()).getName());
  }

  @Test
  public void delete_deletesBand_true() {
    Band myBand = new Band("Proxy", "Brief description of band");
    myBand.save();
    int myBandId = myBand.getId();
    myBand.delete();
    assertEquals(null, Band.find(myBandId));
  }

  @Test
  public void addVenue_addsVenueToBand() {
    Venue myVenue = new Venue("CBGB", "123 First St");
    myVenue.save();
    Band myBand = new Band("Proxy", "Brief description of band");
    myBand.save();
    myBand.addVenue(myVenue);
    Venue savedVenue = myBand.getVenues().get(0);
    assertTrue(myVenue.equals(savedVenue));
  }

  @Test
  public void getVenues_returnsAllVenues_List() {
    Venue myVenue = new Venue("CBGB", "123 First St");
    myVenue.save();
    Band myBand = new Band("Proxy", "Brief description of band");
    myBand.save();
    myBand.addVenue(myVenue);
    List savedVenues = myBand.getVenues();
    assertEquals(1, savedVenues.size());
  }

  @Test
  public void delete_deletesAllBandsAndVenuesAssociations() {
    Venue myVenue = new Venue("CBGB", "123 First St");
    myVenue.save();
    Band myBand = new Band("Proxy", "Brief description of band");
    myBand.save();
    myBand.addVenue(myVenue);
    myBand.delete();
    assertEquals(0, myVenue.getBands().size());
  }

}
