import java.util.List;
import org.sql2o.*;
import java.util.ArrayList;

public class Band {
  private int id;
  private String name;
  private String description;

  public Band(String name, String description) {
    this.name = name;
    this.description = description;
  }

  public String getName() {
    return name;
  }

  public String getDescription(){
    return description;
  }

  public int getId() {
    return id;
  }

  public static List<Band> all() {
    String sql = "SELECT * FROM bands";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Band.class);
    }
  }

  // public static List<Band> allRated() {
  //   String sql = "SELECT * FROM bands WHERE rating > 0 ORDER BY rating DESC;";
  //   try(Connection con = DB.sql2o.open()){
  //     return con.createQuery(sql).executeAndFetch(Band.class);
  //   }
  // }
  //
  // public static List<Band> searchIngredients(String search) {
  //   String sql = "SELECT * FROM bands WHERE description LIKE :search";
  //   try(Connection con = DB.sql2o.open()) {
  //     return con.createQuery(sql)
  //       .addParameter("search", search)
  //       .executeAndFetch(Band.class);
  //   }
  // }

  @Override
  public boolean equals(Object otherBand){
    if (!(otherBand instanceof Band)) {
      return false;
    } else {
      Band newBand = (Band) otherBand;
      return this.getName().equals(newBand.getName()) &&
             this.getId() == newBand.getId();
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO bands(name, description) VALUES (:name, :description)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("name", this.name)
        .addParameter("description", this.description)
        .executeUpdate()
        .getKey();
    }
  }

  public static Band find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM bands where id=:id";
      Band band = con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Band.class);
      return band;
    }
  }

  public void update(String newName, String newDescription) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE bands SET name = :name, description = :description WHERE id = :id";
      con.createQuery(sql)
        .addParameter("title", newName)
        .addParameter("description", newDescription)
        .addParameter("id", this.id)
        .executeUpdate();
    }
  }


  public void addVenue(Venue venue) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO bands_venues (band_id, venue_id) VALUES (:band_id, :venue_id)";
      con.createQuery(sql)
        .addParameter("venue_id", venue.getId())
        .addParameter("band_id", this.getId())
        .executeUpdate();
    }
  }


  public List<Venue> getVenues(){
    try(Connection con = DB.sql2o.open()) {
      String joinQuery = "SELECT venue_id FROM bands_venues WHERE band_id = :band_id";
      List<Integer> venueIds = con.createQuery(joinQuery)
        .addParameter("band_id", this.getId())
        .executeAndFetch(Integer.class);


      List<Venue> venues = new ArrayList<Venue>();

      for (Integer venueId : venueIds) {
        String venueQuery = "Select * FROM venues WHERE id = :venueId";
        Venue venue = con.createQuery(venueQuery)
          .addParameter("venueId", venueId)
          .executeAndFetchFirst(Venue.class);
        venues.add(venue);
      }

      return venues;
    }
  }

  public void delete(){
    try(Connection con = DB.sql2o.open()) {
      String deleteQuery = "DELETE FROM bands WHERE id = :id;";
        con.createQuery(deleteQuery)
          .addParameter("id", this.getId())
          .executeUpdate();

      String joinDeleteQuery = "DELETE FROM bands_venues WHERE band_id = :bandId";
        con.createQuery(joinDeleteQuery)
          .addParameter("bandId", this.getId())
          .executeUpdate();
    }
  }

}
