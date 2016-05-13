import org.sql2o.*;
import org.junit.*;
import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.assertj.core.api.Assertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.*;
import static org.junit.Assert.*;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Band Tacker");
  }
//
//   @Test
//   public void venueIsCreatedTest() {
//     goTo("http://localhost:4567/");
//     click("a", withText("Venues"));
//     fill("#name").with("Mexican");
//     submit(".btn");
//     assertThat(pageSource()).contains("Mexican");
//   }
//
//   @Test
//   public void bandIsCreatedTest() {
//     goTo("http://localhost:4567/");
//     click("a", withText("Bands"));
//     fill("#title").with("Tacos");
//     fill("#ingredients").with("Meat");
//     fill("#instructions").with("Cook");
//     fill("#rating").with("5");
//     submit("#addBand");
//     assertThat(pageSource()).contains("Tacos");
//   }
//
//   @Test
//   public void venueShowPageDisplaysName() {
//     Venue testVenue = new Venue("Mexican");
//     testVenue.save();
//     String url = String.format("http://localhost:4567/venues/%d", testVenue.getId());
//     goTo(url);
//     assertThat(pageSource()).contains("Mexican");
//   }
//
//   @Test
//   public void bandShowPageDisplaysTitle() {
//     Band testBand = new Band("Tacos", "meat", "cook", 5);
//     testBand.save();
//     String url = String.format("http://localhost:4567/bands/%d", testBand.getId());
//     goTo(url);
//     assertThat(pageSource()).contains("Tacos");
//   }
//   //
//   @Test
//   public void bandIsAddedToVenue() {
//     Venue testVenue = new Venue("Mexican");
//     testVenue.save();
//     Band testBand = new Band("Tacos", "meat", "cook", 5);
//     testBand.save();
//     String url = String.format("http://localhost:4567/venues/%d", testVenue.getId());
//     goTo(url);
//     fillSelect("#band_id").withText("Tacos");
//     submit("#selectBand");
//     assertThat(pageSource()).contains("<li>");
//     assertThat(pageSource()).contains("Tacos");
//   }
//
//   @Test
//   public void venueIsAddedToBand() {
//     Venue testVenue = new Venue("Mexican");
//     testVenue.save();
//     Band testBand = new Band("Tacos", "meat", "cook", 5);
//     testBand.save();
//     String url = String.format("http://localhost:4567/bands/%d", testBand.getId());
//     goTo(url);
//     fillSelect("#venue_id").withText("Mexican");
//     submit("#addVenue");
//     assertThat(pageSource()).contains("<li>");
//     assertThat(pageSource()).contains("Mexican");
//   }
//   @Test
//   public void bandIsUpdated() {
//     Band testBand = new Band("Tacos", "meat", "cook", 5);
//     testBand.save();
//     String url = String.format("http://localhost:4567/bands/%d", testBand.getId());
//     goTo(url);
//     click("a", withText("Edit this band"));
//     fill("#title").with("Burgers");
//     fill("#ingredients").with("Beef");
//     fill("#instructions").with("Grill");
//     fill("#rating").with("5");
//     submit(".btn");
//     goTo(url);
//     assertThat(pageSource()).contains("Burgers");
//   }
//
//   @Test
//   public void bandIsDeleted() {
//     Band testBand = new Band("Tacos", "meat", "cook", 5);
//     testBand.save();
//     String url = String.format("http://localhost:4567/bands/%d", testBand.getId());
//     goTo(url);
//     submit("#delete");
//     goTo(url);
//     assertThat(pageSource()).contains("$band.getTitle()");
//   }
//
}
