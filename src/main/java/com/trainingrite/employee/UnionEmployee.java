package com.trainingrite.employee;

public class UnionEmployee extends AbstractEmployee 
   implements IOvertime {	

	public UnionEmployee(float salary) {
		super(salary);
	}	

	public UnionEmployee(String status, float salary, float hoursWorked) {
		super(status, salary, hoursWorked);	
	}


	@Override
	public float getOvertimeHours() {
		float hoursWorked = super.getHoursWorked();
		float otHours = 0;
		if (hoursWorked > 40){
			otHours = hoursWorked - 40;
		}
		return otHours;
	}

	@Override
	public float getOvertimeHourlyWage() {
		// TODO Auto-generated method stub
		return  1.5f * this.getHourlyWage();
	}

	@Override
	public float getOvertimePay() {
		// TODO Auto-generated method stub
		return getOvertimeHourlyWage() * getOvertimeHours();
	}

	@Override
	public float getWeeklySalary() {		
		return (super.getWeeklySalary() + getOvertimePay()) * this.getTaxRate();
	}	

}
