package logic;

import java.util.Set;

public interface Properties {
	
	public String getProperty(String key);
	
	public void setProperty(String key, String value);
	
	public void removeProperty(String key);
	
	public int size();
	
	public Set<String> keys();

}
