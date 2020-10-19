package com.camilia.listfilms;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.ArrayList;


@Path("/films")

public class FilmResource {
    private ListFilms films = new ListFilms() ;
    
   
    
  

  @GET 
  @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Film> getFilms() {
    	
    // return all movies

    	return films.getList();
    }
  
  @Path("/viewedFilms")
  @GET 
  @Produces(MediaType.APPLICATION_JSON)
  public ArrayList<Film> getViewedFilms() {
  	
	  ArrayList<Film> viewedFilms = new ArrayList<Film>();
	  ArrayList<Film> moovies = films.getList();
	  for (Film f : moovies)
	  	{
	  		if (f.isViewed())
	  		{
	  			viewedFilms.add(f);
	  		}
	  		
	  	}
  	
  	return viewedFilms;
  }
  
  
  @Path("/favouriteFilms")
  @GET 
  @Produces(MediaType.APPLICATION_JSON)
  public ArrayList<Film> getFavouriteFilms() {
  	
	  ArrayList<Film> favouriteFilms = new ArrayList<Film>();
	  ArrayList<Film> moovies = films.getList();
	  for (Film f : moovies)
	  	{
	  		if (f.isFav())
	  		{
	  			favouriteFilms.add(f);
	  		}
	  		
	  	}
  	
  	return favouriteFilms;
  }
  
  

@Path("/addViewed/{filmId}")
@POST
     

public void addViewedFilm(@PathParam("filmId") int filmId) {
		System.out.println(filmId);
		Film film = films.getFilmById(filmId);
		System.out.println(film);
		film.setViewed(true);
		System.out.println(film);

		films.save_films_list();
		

      } 

@Path("/addFavourite/{filmId}")
@POST
	public void addFavoriteFilm(@PathParam("filmId") int filmId) {
			Film film = films.getFilmById(filmId);
			System.out.println(film);
			film.setFav(true);
			films.save_films_list();


	} 


@Path("/removeViewed/{filmId}")
@POST

  public void removeViewedFilm(@PathParam("filmId") int filmId) {
	Film film = this.films.getFilmById(filmId);
	if (film.isViewed())
	{
		film.setViewed(false);
		film.setFav(false);
		films.save_films_list();
	
		
	}

  } 

@Path("/removeFavourite/{filmId}")
@POST
public void removeFavoriteFilm(@PathParam("filmId") int filmId) {
	Film film = this.films.getFilmById(filmId);
	if (film.isViewed() && film.isFav())
	{
		film.setFav(false);
		films.save_films_list();
	}


} 
    

    
    

  
    
}
