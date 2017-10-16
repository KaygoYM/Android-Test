package com.example.login;


	public class Letter {
	      private String letter_name;
	      private int image_id;
          private String password;
          
	      public Letter(String letter_name, int image_id){
	            this.letter_name = letter_name;
	            this.image_id = image_id;
	           }

	      public String getLetterName(){
	            return letter_name;
	      }

	      public int getImageId(){
	            return image_id;
	      }
	
	      public String getPassword(){return password;}
	      public void setPassword(String p){this.password=p;}
	}


