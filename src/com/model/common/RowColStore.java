package com.model.common;

import java.util.HashMap;
import java.util.Map.Entry;

public class RowColStore {
	private HashMap<String,HashMap<String,String>> storage=null;
	
	public RowColStore() {
		storage=new HashMap<String,HashMap<String,String>>();
	}
	
	public void putRowCol(String row,String col,String value) {
		HashMap<String,String> colStore=null;
		String colValue=null;
		
		value=	value!=null ? value.trim() 	: Vars.BLANK;
		row=	row!=null 	? row.trim() 	: Vars.BLANK;
		col=	col!=null 	? col.trim() 	: Vars.BLANK;
		colStore=storage.get(row);
		colValue=colStore!=null && colStore.get(col)!=null ? colStore.get(col) : Vars.BLANK ;
		if(!colValue.isEmpty()) {
			colStore.replace(col, value);
		} else if(colStore!=null && colValue.isEmpty() ) {
			colStore.put(col, value);
		} else {	
			colStore=new HashMap<String,String>();
			colStore.put(col, value);
			storage.put(row, colStore);
		}
	}
	
	public String getRowCol(String row,String col) {
		HashMap<String,String> colStore=null;
		
		colStore=storage.get(row);
		return colStore!=null && colStore.get(col)!=null ? colStore.get(col) : Vars.BLANK; 
	}
	
	public HashMap<String,HashMap<String,String>> getStorage() {
		return storage;
	}
	
	public void dropAllRows() {
		for(Entry<String, HashMap<String, String>> entry:storage.entrySet()) {
			entry.getValue().clear();
		}
		storage.clear();
	}
	
	public void merge(RowColStore sourceRCS) {
		HashMap<String,String> sourceCol=null;
		
		for(Entry<String, HashMap<String, String>> entry:sourceRCS.getStorage().entrySet()) {
			sourceCol=storage.get(entry.getKey());
			if(sourceCol!=null) {
				sourceCol.putAll(entry.getValue());
			} else {
				storage.put(entry.getKey(), entry.getValue());
			}
		}
	}
}
