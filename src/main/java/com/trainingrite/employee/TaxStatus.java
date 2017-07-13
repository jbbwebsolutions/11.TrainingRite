package com.trainingrite.employee;

public enum TaxStatus {	
	
	Single("S"),
	MarriedFilingJointly("MFJ"),
	QualifiedWidow("QW"),
	MarriedFilingSeparately("MFS"),
	HeadHousehold("HH");
	
	private String status;

	TaxStatus(String status) {
        this.status = status;
    }

    public String status() {
        return status;
    }
	
}
