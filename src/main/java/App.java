import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.List;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    // For rootTest in AppTest
    get("/", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    // get("/venues", (request, response) -> {
    //   HashMap<String, Object> model = new HashMap<String, Object>();
    //   model.put("venues", Venue.all());
    //   model.put("template", "templates/venues.vtl");
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());
    //
    // get("/bands", (request, response) -> {
    //   HashMap<String, Object> model = new HashMap<String, Object>();
    //   System.out.println(request.queryParams("searchIngredients"));
    //   if (request.queryParams("searchIngredients") != null) {
    //     String query = request.queryParams("searchIngredients");
    //     List<Band> foundBands  = Band.searchIngredients("%" + query + "%");
    //     model.put("foundBands", foundBands);
    //     System.out.println("hello");
    //   }
    //   List<Band> bands = Band.all();
    //   model.put("bandRatings", Band.allRated());
    //   model.put("bands", bands);
    //   model.put("template", "templates/bands.vtl");
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());
    //
    // post("/bands", (request, response) -> {
    //   HashMap<String, Object> model = new HashMap<String, Object>();
    //   String title = request.queryParams("title");
    //   String ingredients = request.queryParams("ingredients");
    //   String instructions = request.queryParams("instructions");
    //   int rating = Integer.parseInt(request.queryParams("star"));
    //   System.out.println(rating);
    //   Band newBand = new Band(title, ingredients, instructions, rating);
    //   newBand.save();
    //   response.redirect("/bands");
    //   return null;
    // });
    //
    //
    // post("/venues", (request, response) -> {
    //   HashMap<String, Object> model = new HashMap<String, Object>();
    //   String name = request.queryParams("name");
    //   Venue newVenue = new Venue(name);
    //   newVenue.save();
    //   response.redirect("/venues");
    //   return null;
    // });
    //
    // get("/bands/:id", (request,response) -> {
    //   HashMap<String, Object> model = new HashMap<String, Object>();
    //   Band band = Band.find(Integer.parseInt(request.params("id")));
    //   model.put("band", band);
    //   model.put("allVenues", Venue.all());
    //   model.put("template", "templates/band.vtl");
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());
    //
    // get("/venues/:id", (request,response) ->{
    //   HashMap<String, Object> model = new HashMap<String, Object>();
    //   Venue venue = Venue.find(Integer.parseInt(request.params("id")));
    //   model.put("venue", venue);
    //   model.put("allBands", Band.all());
    //   model.put("template", "templates/venue.vtl");
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());
    //
    // post("/add_bands", (request, response) -> {
    //   int bandId = Integer.parseInt(request.queryParams("band_id"));
    //   int venueId = Integer.parseInt(request.queryParams("venue_id"));
    //   Venue venue = Venue.find(venueId);
    //   Band band = Band.find(bandId);
    //   venue.addBand(band);
    //   response.redirect("/venues/" + venueId);
    //   return null;
    // });
    //
    // post("/add_venues", (request, response) -> {
    //   int bandId = Integer.parseInt(request.queryParams("band_id"));
    //   int venueId = Integer.parseInt(request.queryParams("venue_id"));
    //   Venue venue = Venue.find(venueId);
    //   Band band = Band.find(bandId);
    //   band.addVenue(venue);
    //   response.redirect("/bands/" + bandId);
    //   return null;
    // });
    // post("/bands/:id/edit", (request, response) -> {
    //   HashMap<String, Object> model = new HashMap<String, Object>();
    //   Band band = Band.find(Integer.parseInt(request.params("id")));
    //   String title = request.queryParams("title");
    //   String ingredients = request.queryParams("ingredients");
    //   String instructions = request.queryParams("instructions");
    //   int rating = Integer.parseInt(request.queryParams("rating"));
    //   band.update(title, ingredients, instructions, rating);
    //   String url = String.format("/bands/%d", band.getId());
    //   response.redirect(url);
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());
    //
    // post("/bands/:id/delete", (request,response) -> {
    //   int bandId = Integer.parseInt(request.params("id"));
    //   Band band = Band.find(bandId);
    //   band.delete();
    //   response.redirect("/bands");
    //   return null;
    // });
    //
    // // post("/bands/:id/delete", (request, response) -> {
    // //   HashMap<String, Object> model = new HashMap<String, Object>();
    // //   Band band = Band.find(Integer.parseInt(request.params("id")));
    // //   band.delete();
    // //
    // //   response.redirect("/bands");
    // //   return new ModelAndView(model, layout);
    // // }, new VelocityTemplateEngine());
    //
    //
    // post("/venues/:id/edit", (request, response) -> {
    //   HashMap<String, Object> model = new HashMap<String, Object>();
    //   Venue venue = Venue.find(Integer.parseInt(request.params("id")));
    //   String venueName = request.queryParams("venueName");
    //   // Venue venue = Venue.find(venue.getVenueId());
    //   venue.update(venueName);
    //   String url = String.format("/venues/%d", venue.getId());
    //   response.redirect(url);
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());
    //
    // post("/venues/:id/delete", (request, response) -> {
    //   HashMap<String, Object> model = new HashMap<String, Object>();
    //   Venue venue = Venue.find(Integer.parseInt(request.params("id")));
    //   venue.delete();
    //
    //   response.redirect("/venues");
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());
    //
    //
    // get("/bands/:id/edit", (request,response) -> {
    //   HashMap<String, Object> model = new HashMap<String, Object>();
    //   Band band = Band.find(Integer.parseInt(request.params("id")));
    //   model.put("band", band);
    //   model.put("template", "templates/band-edit.vtl");
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());
    //
    // post("/bands/:id", (request,response) -> {
    //   int bandId = Integer.parseInt(request.params("id"));
    //   Band band = Band.find(bandId);
    //   String newTitle = request.queryParams("title");
    //   String newIngredients = request.queryParams("ingredients");
    //   String newInstructions = request.queryParams("instructions");
    //   int newRating = Integer.parseInt(request.queryParams("rating"));
    //   band.update(newTitle, newIngredients, newInstructions, newRating);
    //   response.redirect("/bands/" + bandId);
    //   return null;
    // });

  }
}
