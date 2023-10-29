/**
 * This is the subclass of bankcard. The class has a withdraw method to deduct money from client account and prints the current amount after deduction. 
  The display method will display only the client details if client havent withdrawn any money or else prints the details of withdrawal( withdrawal amount, date of withdraw)
  if client have withdrawn the money.
  
 * @author 22067829 Aman Babu Shrestha
 
 * @version 2023-01-20
 */

public class DebitCard extends BankCard
{
    private int pinNumber;
    private int withdrawalAmount;
    private String dateOfWithdraw;
    private boolean hasWithdrawn;
    
    // creating getter method for each instance variable
    public int getPinNumber()
    {
     return this.pinNumber;
    }

    public int getWithdrawalAmount()
    {
     return this.withdrawalAmount;
    }
    
    public String getDateOfWithdraw()
    {
     return this.dateOfWithdraw;
    }
    
    public boolean getHasWithdrawn()
    {
     return this.hasWithdrawn;
    }

    // creating setter method for withdrawalAmount
    public void setWithdrawalAmount(int withdrawalAmount){
        this.withdrawalAmount=withdrawalAmount;
    }
    
    //creating constructor of BankCard
    public DebitCard(int balanceAmount, int cardID, String bankAccount, String issuerBank, String clientName, int pinNumber)
    {
        // Calling superclass constructor
        super(balanceAmount, cardID, bankAccount, issuerBank);
        // Calling setter method of super class
        setClientName(clientName);
        this.hasWithdrawn = false;
        this.pinNumber=pinNumber;
    }

    // method to deduct money from client account
    public void withdraw(int withdrawalAmount, String dateOfWithdraw, int pinNumber)
    {
        setWithdrawalAmount(withdrawalAmount);
        this.dateOfWithdraw=dateOfWithdraw;
        if (this.pinNumber== pinNumber && this.getBalanceAmount() > withdrawalAmount) {
            this.hasWithdrawn = true;
            setBalanceAmount(getBalanceAmount() - withdrawalAmount);
            System.out.println("The balance amount is" + " " + getBalanceAmount());
        }
        else{
            System.out.println("Unable to perform transaction");
        }
    }

    // Overriding display method of superclass
    @Override
    public  void display()
    {
        super.display();
        if(this.hasWithdrawn==false){
            System.out.println("You havent performed any transcation");
        }
        else{
            System.out.println("the pin number is" +" " +pinNumber);
            System.out.println("the withdrawal amount is" + " " + withdrawalAmount);
            System.out.println("the date of withdraw is" + " " + dateOfWithdraw);
        }
    }
}
