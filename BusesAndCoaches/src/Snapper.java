
public class Snapper {
	
	//variables
	private int uniqueId;
	private int balance;
	
	
	//getters and setters
	public int getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(int uniqueId) {
		this.uniqueId = uniqueId;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}	
	
	
	//constructor
	public Snapper(int id) {
		uniqueId = id;
		balance = 5;
	}
	
	public Snapper() {
		uniqueId = 0;
		balance = 5;
	}
	 
	
	

	public Boolean spendMoney(Snapper snapper) {
		
		//if snapper balance is less than $2, do not allow passenger to board
		if(snapper.getBalance() < 2) {
			System.out.println("Your snapper balance is less than $2, you cannot board the bus");
			return false;
		
		//if balance is over $2, allow passenger to board and subtract $2 from their snapper balance 
		} else if (snapper.getBalance() > 2) {
			snapper.setBalance(balance-2);
			//System.out.println("New passenger balance: $" + snapper.getBalance());
			return true;
		}
		
		return true;
	}



}

	//boolean spendMoney: if snapper has funds then spend $m and return true, else do not change the value on the card and
	//return false
	 
	//once spendMoney method is complete, amend coach and passenger classes to require all passengers to have a snapper. Then
	//only allow them to enter the coach if they have $2 to spend and then charge them $2. This method will need to be called
	//on each passenger entering the coach

