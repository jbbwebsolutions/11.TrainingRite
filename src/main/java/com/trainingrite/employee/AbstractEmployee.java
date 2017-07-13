package com.trainingrite.employee;

public abstract class AbstractEmployee  {

	protected ITaxRate taxes = new MarginalTaxRates();
	private float salary;
	private float hoursWorked;
	private String status;
	private final static float MONTH_CAL = 12;
	private final static float WEEKLY_CAL = 52f;
	
	
	public AbstractEmployee() {}
	
	public AbstractEmployee(float salary ) {		
		this.salary = salary;
	}
	
	public AbstractEmployee(String status, float salary ) {	
		this.status = status;
		this.salary = salary;
	}
	
	public AbstractEmployee(String status, float salary, float hoursWorked ) {		
		this.status = status;
		this.salary = salary;
		this.hoursWorked = hoursWorked;
	}
	
	public float getHourlyWage() {		
		return this.salary/WEEKLY_CAL/40;
	}
	
	public float getWeeklySalary() {		
		return this.salary/WEEKLY_CAL;
	}

	public float getMonthlySalary() {	
		return this.salary/MONTH_CAL;
	}
	
	public float getYearlySalary() {
		// TODO Auto-generated method stub
		return this.salary;
	}
	
	public float getHoursWorked(){
		return this.hoursWorked;
	}
	
	public float getTaxRate(){
		try {
			return taxes.getTaxRate(status, salary);
		} catch (InvalidCodeException e) {						
		}
		return 0;
	}

	@Override
	public String toString() {
		return "AbstractEmployee [taxes=" + taxes + ", salary=" + salary + ", hoursWorked=" + hoursWorked + "]";
	}
}
