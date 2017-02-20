package accounts;

import java.util.ArrayList;

import management.Customer;
import management.Payee;

public class DepartmentAccount {
	
	//variables
    private ArrayList<Customer> customers;
    private ArrayList<Payee> payees;
    private int deptBalance = 0;
    
    
    //constructor
    public DepartmentAccount (int db) {
    	customers = new ArrayList<Customer>();
    	payees = new ArrayList<Payee>();
    	deptBalance = db;
    }
    
    
    //getters and setters
	public ArrayList<Customer> getCustomers() {
		return customers;
	}
	
	public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
	}

	public ArrayList<Payee> getPayees() {
		return payees;
	}

	public void setPayees(ArrayList<Payee> payees) {
		this.payees = payees;
	}
    
	
	//add student to customer list
	public void addCustomer(Customer c) {
		customers.add(c);
	}

		
	//add lecturer to payee list
	public void addPayee(Payee p) {
		payees.add(p);
	}
	
	
	//calculate dept account balance
	public int calcDeptBalance() {
		return deptBalance;
	}
	
}
 

//objectives of the accounts system:
//	1. pay people that are owed money
//	2. collect money from customers (students)
//	3. report to cost centres on their profit and loss

//customers are students, payees are lecturers
//when lecturers and students are added to a course, the management system must update DepartmentAccounts by
//adding the payee or customer to the appropriate array list. A student attending two courses will appear twice
//on the list
 
//compute the loss or profit of the department by adding fees for every customer on the list of customers and costs
//for every payee on the list of payees. 
 
//for each course in each department, add costs of course, cost of lecturers and fees of students. 
 
//will need method to add students and lecturers to array list of customers and payees