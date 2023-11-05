/**
 *  It is a subclass of BankCard. The setCreditLimit method  sets the credit limit for the credit card and checks if the credit will be granted based on the credit limit and balance amount. 
 It also has a cancelCreditCard method which sets the instance variables,gracePeriod, creditiLimit, interestRate to 0,.The display method calls the parent class's display method and 
 prints additional credit card information if the credit is granted or else prints an error.
 
 * @author 22067829 Aman Babu Shrestha
 
 * @version 2023-01-20
 */

public class CreditCard extends BankCard 
{
   //declaring instance varialbe with private access modifier
   private int cvcNumber;
   private int creditLimit;
   private double interestRate;
   private String expirationDate;
   private int gracePeriod;
   private boolean isGranted;
   
   public int getCvcNumber() 
   {
       return this.cvcNumber;
   }
    
   public int getCreditLimit() 
   {
       return this.creditLimit;
   }
    
   public double getInterestRate() 
   {
       return this.interestRate;
   }
    
   public String getExpirationDate() 
   {
       return this.expirationDate;
   }
    
   public int getGracePeriod() 
   {
       return this.gracePeriod;
   }
    
   public boolean getIsGranted() 
   {
       return this.isGranted;
   }

   //creating constructor of CreditCard 
   CreditCard(int cardID, String issuerBank, int balanceAmount, String bankAccount, String clientName, int cvcNumber, double interestRate, String expirationDate) 
   {
       super(balanceAmount,cardID,bankAccount,issuerBank);
       super.setClientName(clientName);
       this.cvcNumber = cvcNumber;
       this.expirationDate = expirationDate;
       this.interestRate = interestRate;
       this.isGranted = false;
   }

   /* checks the condition and grants credit if the conditoin is met.
    * Otherwise displays a suitable message
    */
   public void setCreditLimit(int creditLimit, int gracePeriod) 
   {
       
       if (creditLimit <= (2.5 * getBalanceAmount())){
           this.isGranted = true;
           this.creditLimit = creditLimit;
           this.gracePeriod = gracePeriod;
           System.out.println("Your credit is granted!");
       } else {
           System.out.println("Sorry!Your credit cannot be granted");
           this.isGranted = false;
       }
   }

   //resets the variables to zero
   public void cancelCreditCard() 
   {
       this.cvcNumber=0;
       this.creditLimit=0;
       this.gracePeriod = 0;
       this.isGranted = false;
   }
   
   /*calls the display method of superclass and prints other details of credit card if credit is granted
    else displays an error*/
    @Override
   public void display() 
   {
       super.display();
       if (this.isGranted==true) {
           System.out.println("CVC number is" + " " + this.cvcNumber);
           System.out.println("Credit Limti is"+ " " + this.creditLimit);
           System.out.println("Interest rate is" + " " + this.interestRate);
           System.out.println("expiration date is" + " " + this.expirationDate);
           System.out.println("Grace period is" + " " + this.gracePeriod);
       } 
       else {       
           System.out.println("Your Credit has not been granted!");
       }
   }
}
