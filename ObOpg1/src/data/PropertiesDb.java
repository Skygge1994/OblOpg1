package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PropertiesDb {
	private Map<String, String> properties = new HashMap<>();
	private File file = new File("properties.obj");
	private boolean test = false;
	
	
	public PropertiesDb() {
		try {
			rollback();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public PropertiesDb(boolean test) {
		this.test = test;
	}

	public String get(String key) {
		return properties.get(key);
	}

	public void put(String key, String value) {
		properties.put(key, value);
		if (!test) {
			try {
				commit();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void remove(String key) {
		properties.remove(key);
		if (!test) {
			try {
				commit();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public int size() {
		return properties.size();
	}

	public Set<String> keys() {
		return properties.keySet();
	}

	private void commit() throws IOException {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
			out.writeObject(this.properties);
		}
	}

	@SuppressWarnings("unchecked")
	private void rollback() throws FileNotFoundException, IOException, ClassNotFoundException {
		if (file.exists()) {
			try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
				this.properties = (Map<String, String>) in.readObject();
			}
		}
	}

}
