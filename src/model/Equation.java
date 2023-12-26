package model;

import utils.EqautionProcessing;

public class Equation {
	/* Feilds */
	private String initEpression; //example: 7+7 *9 +0 
	private String expression; // After conversion
	private boolean isInfix; //if true: infix, else: postfix
	private double value;

	public Equation(String initexpression, boolean isInfix) {
		setInitEpression(initexpression);
		setInfix(isInfix);
		/*
		* if its infix Convert to postfix and then evaluate it.
		* if its postfix Convert to a prefix and then evaluate it.
		*/
		if(isInfix == true) {
			setExpression(EqautionProcessing.infixToPostfix(initexpression));
			setValue(EqautionProcessing.evaluatePostfix(getExpression()));
		}else if(isInfix == false){
			setExpression(EqautionProcessing.postfixToPrefix(initexpression));
			setValue(EqautionProcessing.evaluatePrefix(getExpression()));
		}
	}

	@Override
	public String toString() {
		String exp="";
		if(isInfix) {
			exp = "Infix:  \n";
		}else {
			exp = "Postfix: \n";
		}
		return exp+ getInitEpression() + "==>" + getExpression() + "==>" + getValue()+"\n";
	}

	/* Getters & Setters */
	public String getExpression() {
		return expression;
	}
	public void setExpression(String expression) {
		this.expression = expression;
	}
	public boolean isInfix() {
		return isInfix;
	}
	public void setInfix(boolean isInfix) {
		this.isInfix = isInfix;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}

	public String getInitEpression() {
		return initEpression;
	}

	public void setInitEpression(String initEpression) {
		this.initEpression = initEpression;
	}
}