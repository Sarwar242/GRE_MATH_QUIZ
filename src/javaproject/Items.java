package javaproject;

	public class Items {
		public String getQues() {
			return ques;
		}


		public void setQues(String ques) {
			this.ques = ques;
		}


		public String getAns1() {
			return ans1;
		}


		public void setAns1(String ans1) {
			this.ans1 = ans1;
		}


		public String getAns2() {
			return ans2;
		}


		public void setAns2(String ans2) {
			this.ans2 = ans2;
		}


		public String getAns3() {
			return ans3;
		}


		public void setAns3(String ans3) {
			this.ans3 = ans3;
		}


		public String getAns4() {
			return ans4;
		}


		public void setAns4(String ans4) {
			this.ans4 = ans4;
		}


		public String getRan() {
			return ran;
		}


		public void setRan(String ran) {
			this.ran = ran;
		}


		private int id;
	    private String ques;
	    private String ans1;
	    private String ans2;
	    private String ans3;
	    private String ans4;
	    private String ran;
	    
	    public Items(int id, String ques, String ans1, String ans2,String ans3,String ans4,String ran)
	    {
	        this.setId(id);
	        this.setQues(ques);
	      this.setAns1(ans1);
	      this.setAns2(ans2);
	      this.setAns3(ans3);
	      this.setAns4(ans4);
	      this.setRan(ran);

	    }
	    
	 
		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}

	}
