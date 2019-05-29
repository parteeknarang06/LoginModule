package com.test;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FiltersMap {

	public static void main(String[] args) {
		String recordFilters ="[{" + 
				"	\"type\": \"string\"," + 
				"	\"value\": \"C\"," + 
				"	\"field\": \"fileType\"" + 
				"}, {" + 
				"	\"type\": \"numeric\"," + 
				"	\"comparison\": \"lt\"," + 
				"	\"value\": 23," + 
				"	\"field\": \"size\"" + 
				"}, {" + 
				"	\"type\": \"numeric\"," + 
				"	\"comparison\": \"gt\"," + 
				"	\"value\": 25," + 
				"	\"field\": \"size\"" + 
				"}, {" + 
				"	\"type\": \"string\"," + 
				"	\"value\": \"Y\"," + 
				"	\"field\": \"homogeneousType\"" + 
				"}, {" + 
				"	\"type\": \"string\"," + 
				"	\"value\": \"NM\"," + 
				"	\"field\": \"isHomogeneous\"" + 
				"}, {" + 
				"	\"type\": \"string\"," + 
				"	\"value\": \"NN\"," + 
				"	\"field\": \"dirOwner\"" + 
				"}, {" + 
				"	\"type\": \"string\"," + 
				"	\"value\": \"GFF\"," + 
				"	\"field\": \"unixpermission\"" + 
				"}, {" + 
				"	\"type\": \"string\"," + 
				"	\"value\": \"3\"," + 
				"	\"field\": \"fileCount\"" + 
				"}, {" + 
				"	\"type\": \"string\"," + 
				"	\"value\": \"32\"," + 
				"	\"field\": \"subDirCount\"" + 
				"}, {" + 
				"	\"type\": \"date\"," + 
				"	\"comparison\": \"lt\"," + 
				"	\"value\": \"05/10/2019\"," + 
				"	\"field\": \"modificationTime\"" + 
				"}, {" + 
				"	\"type\": \"date\"," + 
				"	\"comparison\": \"gt\"," + 
				"	\"value\": \"05/18/2019\"," + 
				"	\"field\": \"modificationTime\"" + 
				"}]";
		setFilterStruct(recordFilters);
		//setFilterStruct("sas()sas");
	}
	
	public static void setFilterStruct(String recordFilters) {
	    Pattern pattern = Pattern.compile("^\\{(.*)\\}");
	    Matcher matcher = pattern.matcher(recordFilters);
	    while (matcher.find()) {
	    	System.out.println("find:");
	      String str = matcher.group();
	      
	    }
	    
	  }

}
