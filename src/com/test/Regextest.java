package com.test;

import java.util.regex.Pattern;

public class Regextest {

	public static void main(String[] args) {
		Pattern pattern=Pattern.compile("");
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
		

	}

}
