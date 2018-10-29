package logic;

import java.util.Set;

import data.PropertiesDb;

public class PropertiesImpl implements Properties {

	private PropertiesDb db = new PropertiesDb();
	
	@Override
	public String getProperty(String key) {
		return db.get(key);
	}

	@Override
	public void setProperty(String key, String value) {
		db.put(key, value);
		
	}

	@Override
	public void removeProperty(String key) {
		db.remove(key);
		
	}

	@Override
	public int size() {
		return db.size();
	}

	@Override
	public Set<String> keys() {
		return db.keys();
	}
}
