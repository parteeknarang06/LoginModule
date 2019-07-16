package com.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regextest {

	public static void main(String[] args) {
		Pattern pattern=Pattern.compile("^(.*)\\(");
		String input="[\n" + 
				"	{\n" + 
				"		\"Version\": \"2012-10-17\",\n" + 
				"		\"Statement\": {\n" + 
				"			\"Effect\": \"Allow\",\n" + 
				"			\"Action\": \"sts:AssumeRole\",\n" + 
				"			\"Resource\": \"arn:aws:iam::311220264402:role/Arvil_CrossAccount_PS\",\"arn:aws:iam::ddd:311220264402:role/Arvil_CrossAccount_PS\"\n" + 
				"		}\n" + 
				"	},\n" + 
				"	\n" + 
				"	{\n" + 
				"		\"Version\": \"2012-10-17\",\n" + 
				"		\"Statement\": [{\n" + 
				"			\"Sid\": \"VisualEditor0\",\n" + 
				"			\"Effect\": \"Allow\",\n" + 
				"			\"Action\": \"sts:AssumeRole\",\n" + 
				"			\"Resource\": \"arn:aws:iam::311220264402:role/Abhi_assumerole\",\"arn:aws:iam::311220264402:dddrole/Abhi_assumerole\"\n" + 
				"		}]\n" + 
				"	},\n" + 
				"	\n" + 
				"	{\n" + 
				"		\"Version\": \"2012-10-17\",\n" + 
				"		\"Statement\": [{\n" + 
				"			\"Sid\": \"VisualEditor0\",\n" + 
				"			\"Effect\": \"Allow\",\n" + 
				"			\"Resource\": \"arn:aws:iam3::311220264402:role/Abhi_assumerole\",\"arn:aws:iam3::311220264402:dddrole/Abhi_assumerole\",\n" + 
				"			\"Action\": \"sts:AssumeRole\"\n" + 
				"		}]\n" + 
				"	}\n" + 
				"]";
		Matcher mat= pattern.matcher("The role with name harinder-dev-role-EMR_EC2_DefaultRole2 cannot be found. (Service: AmazonIdentityManagement; Status Code: 404; Error Code: NoSuchEntity; Request ID: d5c056d0-a3de-11e9-8fbf-6d2072fb443f)");
		if(mat.find()) {
			System.out.println(mat.group(1));
		}
	}

}
