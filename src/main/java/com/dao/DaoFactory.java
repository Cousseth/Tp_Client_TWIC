package com.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import com.beans.Ville;


public class DaoFactory {
	private static final String URL = "http://localhost:8181/ville";

    public DaoFactory() {
    	super();
    }
    
    public List<Ville> getlistVille(){
    	String stringVilles = null;
    	DefaultHttpClient httpClient = new DefaultHttpClient();
    	try {
    		HttpGet httpGet = new HttpGet(URL);
    		HttpResponse execute = httpClient.execute(httpGet);
    		HttpEntity httpEntity = execute.getEntity();
    		stringVilles = EntityUtils.toString(httpEntity);
    		
    	} catch(IOException  e) {
    		e.printStackTrace();
    	} finally {
    		httpClient.close();
    	}
    	
    	List<Ville> listeVille = new ArrayList<>();
		JSONArray jsonArray = new JSONArray(stringVilles); 

		for(int i = 0;i<jsonArray.length();i++) {
			Ville ville = new Ville((JSONObject)jsonArray.get(i));
			listeVille.add(ville);
		}
    	
    	return listeVille;
    }
    
    
    public void modifVille(Ville ville){
    	DefaultHttpClient httpClient = new DefaultHttpClient();
    	try {
    		HttpPut httpPut = new HttpPut(URL);
    		StringEntity entity = new StringEntity(ville.toJSON().toString());
    		httpPut.setEntity(entity);
    		httpClient.execute(httpPut);
    		
    	} catch(IOException  e) {
    		e.printStackTrace();
    	} finally {
    		httpClient.close();
    	}
    	
    }
    
    public String ajoutVille(Ville ville){
    	DefaultHttpClient httpClient = new DefaultHttpClient();
    	String ret = null;
    	try {
    		HttpPost httpPost = new HttpPost(URL);
    		StringEntity entity = new StringEntity(ville.toJSON().toString());
    		httpPost.setEntity(entity);
    		CloseableHttpResponse response = httpClient.execute(httpPost);
    		ret = EntityUtils.toString(response.getEntity());
    		
    	} catch(IOException  e) {
    		return e.getMessage();
    	} finally {
    		httpClient.close();
    	}
    	
    	return ret;
    }
    
    public Ville getVilleByNomCommune(String nom){
    	List<Ville> listeVille = this.getlistVille();
    	for(Ville ville : listeVille) {
    		if(ville.getNom_commune().equals(nom)) {
    			return ville;
    		}
    	}
    	return null;
    }
    
}
