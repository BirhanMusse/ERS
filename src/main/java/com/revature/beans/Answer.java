package com.revature.beans;

public class Answer {
	public Answer() {
		super();
	}
	public Answer(String Answer) {
		super();
		this.Answer=Answer;
	}
	private String Answer;
	public String getAnswer() {
		return Answer;
	}
	public void setAnswer(String answer) {
		Answer = answer;
	}
	@Override
	public String toString() {
		return "Answer [Answer=" + Answer + "]";
	}
	
}
