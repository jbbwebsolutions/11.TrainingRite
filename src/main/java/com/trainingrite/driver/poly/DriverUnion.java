package com.trainingrite.driver.poly;

import com.trainingrite.employee.AbstractEmployee;
import com.trainingrite.employee.IOvertime;
import com.trainingrite.employee.UnionEmployee;

public class DriverUnion {

	public static void main(String[] args) {
		
		AbstractEmployee employee = new UnionEmployee("HH",120_000f,45);
		float wage = employee.getHourlyWage();
		float weeklyPay = employee.getWeeklySalary();
		float monthlySalary = employee.getMonthlySalary();
		float hourlyWage = employee.getHourlyWage();
		
		IOvertime ot = (IOvertime)employee;
		float otHours = ot.getOvertimeHours();
		float otWages = ot.getOvertimeHourlyWage();
		float otPay = ot.getOvertimePay();
		
		System.out.format("wage: %s, weeklyPay: %s "
				+ "monthly: %s hourlyWage: %s otHours: %s otHourlyWage: %s otPay: %6.2f%n \n" 
				, wage, weeklyPay, monthlySalary, hourlyWage, otHours, otWages, otPay*10000);

	}

}
