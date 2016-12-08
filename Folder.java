package com.max;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Folder implements Serializable {
	private String folderName;
	private List<Website> siteList;

	/** Update **/
	private Website currentSite;
	
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

	public void setCurrentSite(int index) {
	    currentSite = siteList.get(index);
    }

    public Website getSite(int index) {
	    return siteList.get(index);
    }

    public Website getCurrentSite() { return currentSite; }
	
	public void deleteSite(Website website){
		this.siteList.remove(website);
	}
}
