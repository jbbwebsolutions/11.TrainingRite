package com.trainingrite.employee;

public class TaxRule {
	private String code;
	private String description;
	private float start;
	private float end;
	private float taxRate;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getStart() {
		return start;
	}
	public void setStart(float start) {
		this.start = start;
	}
	public float getEnd() {
		return end;
	}
	public void setEnd(float end) {
		this.end = end;
	}
	public float getTaxRate() {
		return taxRate;
	}
	public void setTaxRate(float taxRate) {
		this.taxRate = taxRate;
	}
	@Override
	public String toString() {
		return "TaxRule [code=" + code + ", description=" + description + ", start=" + start + ", end=" + end
				+ ", taxRate=" + taxRate + "]";
	}
	
}
