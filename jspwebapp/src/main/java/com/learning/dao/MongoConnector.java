package com.learning.dao;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class MongoConnector {
	
	private MongoConnector(){}
	
	private static class MongoConnectorHolder {
		public static final MongoConnector INSTANCE = new MongoConnector();
	}
	public static MongoConnector getInstance() {
		return MongoConnectorHolder.INSTANCE;
	}
	
	public DBCollection getCollection(String database, String collection){
		DB db = null;
		try {
			MongoClient client = new MongoClient();
	        db = client.getDB(database);
		}catch(UnknownHostException e) {
			e.printStackTrace();
		}
        return  db.getCollection(collection);
	}

}
