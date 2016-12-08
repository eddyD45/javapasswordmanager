import java.util.ArrayList;
import java.util.List;


public class Folder {
	private String folderName;
	private List<Website> siteList;
	
	public Folder(String folderName){
		this.folderName = folderName;
		siteList = new ArrayList<Website>();
	}
	
	public String getFolderName(){
		return folderName;
	}
	
	public void setFolderName(String foldername){
		this.folderName = foldername;
	}
	
	public List<Website> getSiteList(){
		return siteList;
	}
	
	public void addSite(Website website){
		
		this.siteList.add(website);
	}
	
	public void deleteSite(Website website){
		this.siteList.remove(website);
	}
}
