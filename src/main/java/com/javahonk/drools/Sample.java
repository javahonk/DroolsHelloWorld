package com.javahonk.drools;

public class Sample {

	private String printMessage;
	private Integer price;

	public String getPrintMessage() {
		return printMessage;
	}

	public void setPrintMessage(String printMessage) {
		this.printMessage = printMessage;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public void showMessage() {
		System.out.println(printMessage);
	}

}
