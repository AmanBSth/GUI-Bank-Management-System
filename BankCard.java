/**
 * This is the parent class of DebitCard and CreditCard. The class has a display method to display the client detials if client name is entered.
 * If the client name has not been set, the method will print a message to enter the client's name.
 *
 * @author 22067829 Aman Babu Shrestha
 * @version 2023-01-20
 */

public class BankCard 
{
        //declaring variables with private access modifier
        private int cardID;
        private String clientName;
        private String issuerBank;
        private String bankAccount;
        private int balanceAmount;
        
        //creating getter method for each variables
        public int getcardID()
        {
            return this.cardID;
        }
        
        public String getClientName() 
        {
            return this.clientName;
        }
        
        public int getBalanceAmount()
        {
            return this.balanceAmount;
        }
        
        public String getBankAccount()
        {
            return this.bankAccount;
        }
        
        public String getIssuerBank()
        {
            return this.issuerBank;
        }

        //creating setter method for clientName
        public void setClientName(String clientName) 
        {
            this.clientName = clientName;
        }

        //creating setter method for balanceAmout
        public void setBalanceAmount(int balanceAmount)
        {
            this.balanceAmount=balanceAmount;
        }

        //creating constructor of BankCard
        public BankCard(int balanceAmount, int cardID, String bankAccount, String issuerBank) 
        {
            this.cardID = cardID;
            this.balanceAmount = balanceAmount;
            this.bankAccount = bankAccount;
            this.issuerBank = issuerBank;
            this.clientName=" ";
        }
        
        /* method prints a message to enter client name if the name is not set.
        Else prints the detail of client*/
        public void display()
        {
            if(this.clientName.equals(" ")){
                System.out.println("Please enter your name");
            }
            else{
                System.out.println("the cardId is"+ " " +this.cardID);
                System.out.println("the clientName is" +" " + this.clientName);
                System.out.println("the issuer bank is" + " " +this.issuerBank);
                System.out.println("the bank account is" +" " + this.bankAccount);
                System.out.println("the balance amount is" + " " +this.balanceAmount);
            }
        }
}