package com.camilia.listfilms;

import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ListFilms {
	
	private ArrayList<Film> films = new ArrayList<Film>();
	//database json file
    private String file_path = "bdd.txt";

	public ListFilms()  {
		load_films_list();
		
		
	}
	public void load_films_list()
	{
		try {
			String string_json = new String(Files.readAllBytes(Paths.get(file_path)));       
			Gson g = new Gson();

	        Type type = new TypeToken<ArrayList<Film>>(){}.getType();

	        films = g.fromJson(string_json, type);

	        System.out.println(string_json);

	        System.out.println(films.get(0));	
			}
		catch(Exception IOException) {
		  //   handle errors
		}
		
		
	}
	public void save_films_list ( ) {
		try {
			File file = new File(file_path);
		    FileWriter myWriter = new FileWriter(file_path);
		    
		    
			String json = new Gson().toJson(films);
			System.out.println(json);
	        myWriter.write(json);
	        myWriter.close();
		}
		catch(Exception IOException) {
			  //   handle errors
			}



        
	}
	public ArrayList<Film> getList (){
		return films ;
	}
	
	  public Film getFilmById (int id) {
	    	for (Film f : films)
	    	{
	    		if (f.getId() == id)
	    		{
	    			return f;
	    		}
	    		
	    	}
	    	return null;
	    }

}
