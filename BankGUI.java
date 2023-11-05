import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class BankGUI implements ActionListener {
    // Personal Information panel components
    private JFrame frame;
    private JLabel cardIdLabel, clientNameLabel, issuerBankLabel, bankAccountLabel, balanceAmountLabel;
    private JTextField cardIdField, clientNameField, issuerBankField, bankAccountField, balanceAmountField;

    // Debit Card panel components
    private JLabel pinNumberLabel, withdrawalAmountLabel, withdrawalDateLabel, expirationDateLabel;
    private JTextField pinNumberField, withdrawalAmountField;
    private JButton addDebitBtn, withdrawBtn, addCreditBtn, setCreditBtn, personalClearBtn, debitClearBtn, creditClearBtn, debitDisplayBtn, creditDisplayBtn, cancelCreditBtn;

    // Credit Card panel components
    private JLabel cvcNumberLabel, creditLimitLabel, interestRateLabel, gracePeriodLabel;
    private JTextField cvcNumberField, creditLimitField, interestRateField, gracePeriodField;
    private JPanel debitCardPanel,creditCardPanel;

    // combobox componenets
    private JComboBox withdrawDayComboBox,withdrawMonthComboBox,withdrawYearComboBox,expDayComboBox,expMonthComboBox,expYearComboBox;
    //Creating arraylist of BankCard type
    ArrayList<BankCard> bankCards = new ArrayList<BankCard>();

    public BankGUI() {

        JFrame frame = new JFrame("Card Information");
        JTabbedPane tabbedPane = new JTabbedPane();

        // creating, setting position and size for personal info panel
        JPanel personalInfoPanel = new JPanel();
        personalInfoPanel.setLayout(null);

        cardIdLabel = new JLabel("Card ID:");
        cardIdLabel.setBounds(90, 50, 150, 50);
        personalInfoPanel.add(cardIdLabel);

        cardIdField = new JTextField();
        cardIdField.setBounds(340, 50, 250, 50);
        personalInfoPanel.add(cardIdField);

        clientNameLabel = new JLabel("Client Name:");
        clientNameLabel.setBounds(90, 200, 150, 50);
        personalInfoPanel.add(clientNameLabel);

        clientNameField = new JTextField();
        clientNameField.setBounds(340, 200, 250, 50);
        personalInfoPanel.add(clientNameField);

        issuerBankLabel = new JLabel("Issuer Bank:");
        issuerBankLabel.setBounds(90, 350, 150, 50);
        personalInfoPanel.add(issuerBankLabel);

        issuerBankField = new JTextField();
        issuerBankField.setBounds(340, 350, 250, 50);
        personalInfoPanel.add(issuerBankField);

        bankAccountLabel = new JLabel("Bank Account:");
        bankAccountLabel.setBounds(90, 500, 250, 50);
        personalInfoPanel.add(bankAccountLabel);

        bankAccountField = new JTextField();
        bankAccountField.setBounds(340, 500, 250, 50);
        personalInfoPanel.add(bankAccountField);

        balanceAmountLabel = new JLabel("Balance Amount:");
        balanceAmountLabel.setBounds(90, 650, 200, 50);
        personalInfoPanel.add(balanceAmountLabel);

        balanceAmountField = new JTextField();
        balanceAmountField.setBounds(340, 650, 250, 50);
        personalInfoPanel.add(balanceAmountField);

        personalClearBtn = new JButton("Clear");
        personalClearBtn.setBounds(650, 50, 210, 50);
        personalInfoPanel.add(personalClearBtn);

        tabbedPane.addTab("Personal Information", personalInfoPanel);

        //creating components for Debit Card panel
        JPanel debitCardPanel = new JPanel();
        debitCardPanel.setLayout(null);

        pinNumberLabel = new JLabel("PIN Number:");
        pinNumberLabel.setBounds(90, 50, 150, 50);
        debitCardPanel.add(pinNumberLabel);

        pinNumberField = new JTextField();
        pinNumberField.setBounds(340, 50, 250, 50);
        debitCardPanel.add(pinNumberField);

        withdrawalAmountLabel = new JLabel("Withdrawal Amount:");
        withdrawalAmountLabel.setBounds(90, 200, 210, 50);
        debitCardPanel.add(withdrawalAmountLabel);

        withdrawalAmountField = new JTextField();
        withdrawalAmountField.setBounds(340, 200, 250, 50);
        debitCardPanel.add(withdrawalAmountField);

        withdrawalDateLabel = new JLabel("Withdrawal Date:");
        withdrawalDateLabel.setBounds(90, 350, 190, 50);
        debitCardPanel.add(withdrawalDateLabel);

        // Creating a combo box to select a year from 1980 to 2000 as options
        withdrawYearComboBox = new JComboBox();
        JComboBox<Integer> withdrawYearComboBox = new JComboBox<>();
        for (int i = 1980; i < 2001; i++) {
            withdrawYearComboBox.addItem(i);
        }
        withdrawYearComboBox.setBounds(340, 350, 100, 50);
        withdrawYearComboBox.setFont(new Font("Arial", Font.BOLD, 20));
        withdrawYearComboBox.setBorder(new LineBorder(Color.BLACK, 2));
        debitCardPanel.add(withdrawYearComboBox);

        // Creating a combo box to select a day from 1 to 30 as options
        withdrawDayComboBox = new JComboBox();
        JComboBox<Integer> withdrawDayComboBox = new JComboBox<>();
        for (int i = 1; i < 31; i++) {
            withdrawDayComboBox.addItem(i);
        }
        withdrawDayComboBox.setBounds(450, 350, 50, 50);
        withdrawDayComboBox.setFont(new Font("Arial", Font.BOLD, 20));
        withdrawDayComboBox.setBorder(new LineBorder(Color.BLACK, 2));
        debitCardPanel.add(withdrawDayComboBox);

        // Creating a combo box to select a month from 1 to 12 as options
        withdrawMonthComboBox = new JComboBox();
        JComboBox<Integer> withdrawMonthComboBox = new JComboBox<>();
        for (int i = 1; i < 13; i++) {
            withdrawMonthComboBox.addItem(i);
        }
        withdrawMonthComboBox.setBounds(510, 350, 50, 50);
        withdrawMonthComboBox.setFont(new Font("Arial", Font.BOLD, 20));
        withdrawMonthComboBox.setBorder(new LineBorder(Color.BLACK, 2));
        debitCardPanel.add(withdrawMonthComboBox);

        withdrawBtn = new JButton("Withdraw Amount");
        withdrawBtn.setBounds(330, 500, 210, 50);
        debitCardPanel.add(withdrawBtn);

        addDebitBtn = new JButton("Add");
        addDebitBtn.setBounds(90, 500, 210, 50);
        debitCardPanel.add(addDebitBtn);


        debitClearBtn = new JButton("Clear");
        debitClearBtn.setBounds(650, 50, 210, 50);
        debitCardPanel.add(debitClearBtn);

        debitDisplayBtn = new JButton("Display");
        debitDisplayBtn.setBounds(650, 140, 210, 50);
        debitCardPanel.add(debitDisplayBtn);
        tabbedPane.addTab("Debit Card", debitCardPanel);

        // Creating Credit Card panel
        JPanel creditCardPanel = new JPanel();
        creditCardPanel.setLayout(null);

        expirationDateLabel = new JLabel("Withdrawal Date:");
        expirationDateLabel.setBounds(90, 500, 190, 50);
        creditCardPanel.add(expirationDateLabel);

        // Creating a combo box to select a day from 1 to 30 as options
        expDayComboBox = new JComboBox();
        JComboBox<Integer> expDayComboBox = new JComboBox<>();
        for (int i=1; i <= 31; i++) {
            expDayComboBox.addItem(i);
        }
        expDayComboBox.setBounds(450, 500, 50, 50);
        expDayComboBox.setFont(new Font("Arial", Font.BOLD, 20));
        expDayComboBox.setBorder(new LineBorder(Color.BLACK, 2));
        creditCardPanel.add(expDayComboBox);

        // Creating a combo box to select a year from 1 to 12 as options
        expMonthComboBox = new JComboBox();
        JComboBox<Integer> expMonthComboBox = new JComboBox<>();
        for (int i = 1; i < 13; i++) {
            expMonthComboBox.addItem(i);
        }
        expMonthComboBox.setBounds(510, 500, 50, 50);
        expMonthComboBox.setFont(new Font("Arial", Font.BOLD, 20));
        expMonthComboBox.setBorder(new LineBorder(Color.BLACK, 2));
        creditCardPanel.add(expMonthComboBox);

        // Creating a combo box to select a year from 1990 to 2001 as options
        expYearComboBox = new JComboBox();
        JComboBox<Integer> expYearComboBox = new JComboBox<>();
        for (int i = 1980; i < 2001; i++) {
            expYearComboBox.addItem(i);
        }
        expYearComboBox.setBounds(340, 500, 100, 50);
        expYearComboBox.setFont(new Font("Arial", Font.BOLD, 20));
        expYearComboBox.setBorder(new LineBorder(Color.BLACK, 2));
        creditCardPanel.add(expYearComboBox);

        cvcNumberLabel = new JLabel("CVC Number:");
        cvcNumberLabel.setBounds(90, 50, 150, 50);
        creditCardPanel.add(cvcNumberLabel);

        cvcNumberField = new JTextField();
        cvcNumberField.setBounds(340, 50, 250, 50);
        creditCardPanel.add(cvcNumberField);

        creditLimitLabel = new JLabel("Credit Limit:");
        creditLimitLabel.setBounds(90, 200, 150, 50);
        creditCardPanel.add(creditLimitLabel);

        creditLimitField = new JTextField();
        creditLimitField.setBounds(340, 200, 250, 50);
        creditCardPanel.add(creditLimitField);

        interestRateLabel = new JLabel("Interest Rate:");
        interestRateLabel.setBounds(90, 350, 150, 50);
        creditCardPanel.add(interestRateLabel);

        interestRateField = new JTextField();
        interestRateField.setBounds(340, 350, 250, 50);
        creditCardPanel.add(interestRateField);

        gracePeriodLabel = new JLabel("Grace Period:");
        gracePeriodLabel.setBounds(90, 610, 150, 50);
        creditCardPanel.add(gracePeriodLabel);

        gracePeriodField = new JTextField();
        gracePeriodField.setBounds(340, 610, 250, 50);
        creditCardPanel.add(gracePeriodField);
        tabbedPane.addTab("Credit Card", creditCardPanel);

        addCreditBtn = new JButton("Add");
        addCreditBtn.setBounds(90, 750, 210, 50);
        creditCardPanel.add(addCreditBtn);

        setCreditBtn = new JButton(" Set Credit Limit");
        setCreditBtn.setBounds(340, 750, 250, 50);
        creditCardPanel.add(setCreditBtn);

        cancelCreditBtn = new JButton(" Cancel Credit");
        cancelCreditBtn.setBounds(630, 750, 210, 50);
        creditCardPanel.add(cancelCreditBtn);

        creditClearBtn = new JButton("Clear");
        creditClearBtn.setBounds(650, 50, 210, 50);
        creditCardPanel.add(creditClearBtn);

        creditDisplayBtn = new JButton("Display");
        creditDisplayBtn.setBounds(650, 140, 210, 50);
        creditCardPanel.add(creditDisplayBtn);

        //setting the position and height, font size and family for tabn
        tabbedPane.setBounds(0, 0, 960, 1000);
        // Increase the font size of the tabs
        Font tabFont = new Font("Arial", Font.BOLD, 20);
        tabbedPane.setFont(tabFont);
        personalInfoPanel.setBackground(new Color(200, 221, 242));
        creditCardPanel.setBackground(new Color(200, 221, 242));
        debitCardPanel.setBackground(new Color(200, 221, 242));

        // creating an array to give changes for every buttons
        JButton[] buttons = {addCreditBtn, addDebitBtn, withdrawBtn, setCreditBtn, cancelCreditBtn, creditDisplayBtn, debitDisplayBtn, personalClearBtn, debitClearBtn, creditClearBtn};
        for (JButton button : buttons) {
            button.setBorder(new LineBorder(Color.BLACK, 2));
            button.setBackground(new Color(255, 246, 214));
            button.setFont(new Font("Arial", Font.BOLD, 20));
            // hover effect to change the color for every buttons
            button.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent evt) {
                    button.setBackground(new Color(244, 232, 178));
                }

                public void mouseExited(MouseEvent evt) {
                    button.setBackground(new Color(255, 246, 214));
                }
            });
        }

        // creating an array to give changes for every buttons
        JLabel[] texts = {cardIdLabel,pinNumberLabel, clientNameLabel, issuerBankLabel, bankAccountLabel, balanceAmountLabel, withdrawalAmountLabel, withdrawalDateLabel, expirationDateLabel, cvcNumberLabel, creditLimitLabel, interestRateLabel, gracePeriodLabel};
        for (JLabel j : texts) {
            j.setFont(new Font("Arial", Font.BOLD, 20));
        }

        // creating an array to give changes for every buttons
        JTextField[] fields = {cardIdField, clientNameField, issuerBankField, cvcNumberField, creditLimitField, interestRateField, gracePeriodField, bankAccountField, pinNumberField, withdrawalAmountField, balanceAmountField};
        for (JTextField f : fields) {
            f.setBorder(new LineBorder(Color.BLACK, 2));
            f.setFont(new Font("Arial", Font.BOLD, 20));
        }

        frame.add(tabbedPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(960, 1000);
        frame.setTitle("BankCard");
        frame.setLayout(null);
        frame.setVisible(true);

        // Adding action listeners to the buttons
        addDebitBtn.addActionListener(this);
        addCreditBtn.addActionListener(this);
        personalClearBtn.addActionListener(this);
        debitClearBtn.addActionListener(this);
        creditClearBtn.addActionListener(this);
        debitDisplayBtn.addActionListener(this);
        creditDisplayBtn.addActionListener(this);
        withdrawBtn.addActionListener(this);
        setCreditBtn.addActionListener(this);
        cancelCreditBtn.addActionListener(this);

        // displays the user entered value in the text field
        debitDisplayBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String clientName = clientNameField.getText();
                int cardId = Integer.parseInt(cardIdField.getText());
                String dateOfWithdraw = withdrawDayComboBox.getSelectedItem() + "/" + withdrawMonthComboBox.getSelectedItem() + "/" + withdrawYearComboBox.getSelectedItem();
                for (BankCard bankCard : bankCards) {
                    if (bankCard instanceof DebitCard) {
                        DebitCard debitCard = (DebitCard) bankCard;
                        if (cardId == bankCard.getcardID()) {
                            debitCard.display();
                            JOptionPane.showMessageDialog(debitCardPanel,
                                    "client names is       : " + " " + clientName + "\n" +
                                            "card Id                      : " + " " + cardId + "\n" +
                                            "balance amount is   :" + " " + debitCard.getBalanceAmount() + "\n" +
                                            "withdrawal Date is  :" + " " + dateOfWithdraw
                            );
                        }
                    }
                }
            }
        });

        //displays the user entered values in the text field
        creditDisplayBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String clientName = clientNameField.getText();
                int cvc= Integer.parseInt(cvcNumberField.getText());
                int cardId = Integer.parseInt(cardIdField.getText());
                int creditLimit=Integer.parseInt(creditLimitField.getText());
                int gracePeriod= Integer.parseInt(gracePeriodField.getText());
                String expirationDate = expDayComboBox.getSelectedItem() + "/" + expYearComboBox.getSelectedItem() + " /" + expMonthComboBox.getSelectedItem();
                for (BankCard bankCard : bankCards) {
                    if (bankCard.getcardID() == cardId && bankCard instanceof CreditCard) {
                        CreditCard creditCard = (CreditCard) bankCard;
                        creditCard.display();
                        JOptionPane.showMessageDialog(creditCardPanel,
                                "Client names is   : " + " " + clientName + "\n" +
                                        "Card Id  names is : " + " " + cardId + "\n" +
                                        "Cvc amount is     :" + " " + creditCard.getCvcNumber()+ "\n" +
                                        "Grace period is   :" + " " + creditCard.getGracePeriod() + "\n" +
                                        "Credit Limit is   : " + " " + creditCard.getCreditLimit() + "\n" +
                                        "Expiration Date is:" + " " + expirationDate
                        );
                        break;
                    }
                }
            }
        });


        /*checks if arraylist is empty or not.If not, then proceeds to withdraw amount from balance amount. If the condition does not meet, it cannot
        perform the operation.Downcasting is used to call the withdraw method*/
        withdrawBtn.addActionListener((new ActionListener() {
            int cardId;
            int pinNumber;

            int withdrawalAmount;
            String dateOfWithdraw;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (bankCards.isEmpty()) {
                    JOptionPane.showMessageDialog(debitCardPanel, "Please add a debit card");
                } else {
                    dateOfWithdraw = withdrawDayComboBox.getSelectedItem() + "/" + withdrawMonthComboBox.getSelectedItem() + " /" + withdrawYearComboBox.getSelectedItem();
                    cardId = Integer.parseInt(cardIdField.getText());
                    pinNumber = Integer.parseInt(pinNumberField.getText());
                    withdrawalAmount = Integer.parseInt(withdrawalAmountField.getText());
                    boolean cardMatch = false;
                    for (BankCard bankCard : bankCards) {
                        if (bankCard instanceof DebitCard) {
                            DebitCard debitCard = (DebitCard) bankCard;
                            if (cardId == bankCard.getcardID()) {
                                cardMatch=true;
                                // create confirmation dialog
                                int confirm = JOptionPane.showConfirmDialog(frame,
                                        "Card ID: " + cardId + "\n" +
                                                "Withdrawal amount: " + withdrawalAmount + "\n" +
                                                "Pin Number: " + pinNumber + "\n" +
                                                "Withdrawal Date: " + dateOfWithdraw + "\n" +
                                                "Do you want sure want to withdraw the amount?",
                                        "Confirmation",
                                        JOptionPane.YES_NO_OPTION);
                                if (confirm == JOptionPane.YES_OPTION) {
                                    // proceed with withdrawal
                                    debitCard.withdraw(withdrawalAmount, dateOfWithdraw, pinNumber);
                                    if (!debitCard.getHasWithdrawn()) {
                                        JOptionPane.showMessageDialog(debitCardPanel, "Sorry Couldn't withdraw the amount");
                                        break;

                                    } else {
                                        JOptionPane.showMessageDialog(debitCardPanel, "Withdrawn Successfully");
                                    }

                                }
                                else {
                                    // cancel withdrawal
                                    JOptionPane.showMessageDialog(frame,
                                            "Withdrawal cancelled");
                                }
                                break;
                            }
                            }

                        }
                        if (!cardMatch) {
                            JOptionPane.showMessageDialog(debitCardPanel, "Sorry! Card ID doesn't match");
                    }
                }
            }
        }));
        /*checks if the arraylist is empty or not.If not, it sets the credit limit. If the condition does not meet
        , it doesn't set the limit. setCreditLimit is called by from CreditCard by downcasting.*/
        setCreditBtn.addActionListener((new ActionListener() {
            int cardId;
            int gracePeriod;
            int creditLimit;
            int cvcNumber;
            double interestRate;

            public void actionPerformed(ActionEvent e) {
                if (bankCards.isEmpty()) {
                    JOptionPane.showMessageDialog(creditCardPanel, "Please add a credit card first");
                } else {
                    cvcNumber = Integer.parseInt(cvcNumberField.getText());
                    gracePeriod = Integer.parseInt(gracePeriodField.getText());
                    cardId = Integer.parseInt(cardIdField.getText());
                    creditLimit = Integer.parseInt(creditLimitField.getText());
                    interestRate = Integer.parseInt(interestRateField.getText());
                    String expirationDate = expYearComboBox.getSelectedItem() + "/" + expDayComboBox.getSelectedItem() + "/" + expMonthComboBox.getSelectedItem();
                    for (BankCard bankCard : bankCards) {
                        if (bankCard instanceof CreditCard) {
                            CreditCard creditCard = (CreditCard) bankCard;

                            if (cardId == bankCard.getcardID()) {
                                int confirm = JOptionPane.showConfirmDialog(frame,
                                        "CVC Number      : " + cvcNumber + "\n" +
                                                "expiration Date  : " + expirationDate + "\n" +
                                                "Interest Rate    : " + interestRate + "\n" +
                                                "Credit Limit     : " + creditLimit + "\n" +
                                                "Grace Period     : " + gracePeriod + "\n" +
                                                "Do you want sure want to set the credit limit?",
                                        "Confirmation",
                                        JOptionPane.YES_NO_OPTION);
                                if (confirm == JOptionPane.YES_OPTION) {
                                    creditCard.setCreditLimit(creditLimit, gracePeriod);
                                    if (!creditCard.getIsGranted()) {
                                        JOptionPane.showMessageDialog(creditCardPanel, "Sorry! Couldnt set the credit Limit");
                                    } else {
                                        JOptionPane.showMessageDialog(creditCardPanel, "Credit limit set successfully");
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(frame,
                                            "Process cancelled");
                                }
                                break;
                            }
                        }
                    }
                }
            }
        }));
    }

    @Override
    public void actionPerformed(ActionEvent a) {
        //declaring the values
        int cardId;
        String clientName;
        String issuerBanks;
        String bankAccount;
        int balanceAmount;
        int pinNumber;
        int cvcNumber;
        double interestRate;
        Boolean cardExists = false;
        String dateOfWithdraw;
        /* first checks if all the field are filled or not. If filled and credit card matches with existing card Id, then adds the debit card object in the arraylist.
        If card with  same cardID is entered, it throws a message. If non-numeric value is passed in text field, then displays an error message by using exception handling.*/
        if (a.getSource() == addDebitBtn) {
            if (clientNameField.getText().isEmpty() || issuerBankField.getText().isEmpty() || bankAccountField.getText().isEmpty() || cardIdField.getText().isEmpty() || balanceAmountField.getText().isEmpty() || pinNumberField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(debitCardPanel, "Please fill all the input field","Error",JOptionPane.WARNING_MESSAGE);
            }
            else {
                try {
                    clientName = clientNameField.getText();
                    issuerBanks = issuerBankField.getText();
                    bankAccount = bankAccountField.getText();
                    cardId = Integer.parseInt(cardIdField.getText());
                    balanceAmount = Integer.parseInt(balanceAmountField.getText());
                    pinNumber = Integer.parseInt(pinNumberField.getText());

                    for (BankCard card : bankCards) {
                        if (card instanceof DebitCard && card.getcardID() == cardId) {
                            JOptionPane.showMessageDialog(debitCardPanel, "A DebitCard with this card ID already exists.", "Error",JOptionPane.WARNING_MESSAGE);
                            cardExists = true;
                        }
                    }

                    if (!cardExists) {
                        DebitCard debitCard = new DebitCard(balanceAmount, cardId, bankAccount, issuerBanks, clientName, pinNumber);
                        bankCards.add(debitCard);
                        // displays success message if the DebitCard was successfully added
                        JOptionPane.showMessageDialog(debitCardPanel, "Debit Card added successfully!");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(debitCardPanel, "Please enter a valid number");
                }
            }
        }
        /* first checks if all the field are filled or not. If filled and credit card matches with existing card Id, then adds the credit card object in the arraylist.
        If card with  same cardID is entered, it throws a message. If non-numeric value is passed in text field, then displays an error message by using exception handling.*/
        else if (a.getSource() == addCreditBtn) {
            if (clientNameField.getText().isEmpty() || issuerBankField.getText().isEmpty() || bankAccountField.getText().isEmpty() || cardIdField.getText().isEmpty() || balanceAmountField.getText().isEmpty() || cvcNumberField.getText().isEmpty() || gracePeriodField.getText().isEmpty() || interestRateField.getText().isEmpty() ||
                    creditLimitField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(debitCardPanel, "Please fill all the input field","Error",JOptionPane.WARNING_MESSAGE);
            } else {
                try {
                    clientName = clientNameField.getText();
                    issuerBanks = issuerBankField.getText();
                    bankAccount = bankAccountField.getText();
                    cardId = Integer.parseInt(cardIdField.getText());
                    balanceAmount = Integer.parseInt(balanceAmountField.getText());
                    cvcNumber = Integer.parseInt(cvcNumberField.getText());
                    interestRate = Double.parseDouble(interestRateField.getText());
                    dateOfWithdraw = withdrawDayComboBox.getSelectedItem() + "/" + withdrawMonthComboBox.getSelectedItem() + " /" + withdrawYearComboBox.getSelectedItem();
                    for(BankCard card:bankCards){
                        if(card instanceof CreditCard){
                            if(card.getcardID()==cardId){
                                JOptionPane.showMessageDialog(creditCardPanel, "A CreditCard with this card ID already exists.","Error",JOptionPane.WARNING_MESSAGE);
                                cardExists = true;
                            }
                        }
                    }
                    if(!cardExists){
                        bankCards.add(new CreditCard(cardId, issuerBanks, balanceAmount, bankAccount, clientName, cvcNumber, interestRate, dateOfWithdraw));
                        JOptionPane.showMessageDialog(creditCardPanel, "Credit Card added successfully!");
                    }
                }
                catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(creditCardPanel, "Please enter a valid number");
                }
            }
        }
        else if (a.getSource() == cancelCreditBtn) {
            if (bankCards.isEmpty()) {
                JOptionPane.showMessageDialog(creditCardPanel, "Please add a credit card first");
            } else {
                cardId = Integer.parseInt(cardIdField.getText());
                for (BankCard bankCard : bankCards) {
                    if (bankCard instanceof CreditCard) {
                        CreditCard creditCard = (CreditCard) bankCard;
                        if (cardId == bankCard.getcardID()) {
                            int confirm = JOptionPane.showConfirmDialog(frame,
                                    "Are you sure you want to cancel your Credit Card","Confirmation",JOptionPane.YES_NO_OPTION);

                            if (confirm == JOptionPane.YES_OPTION) {
                                creditCard.cancelCreditCard();

                                JOptionPane.showMessageDialog(creditCardPanel, "Credit Card has been cancelled");
                                break;
                            }
                            else{
                                JOptionPane.showMessageDialog(creditCardPanel, " Credit Card not cancelled");
                            }
                        }
                        else{
                            JOptionPane.showMessageDialog(creditCardPanel,"Sorry! couldn't cancel your credit card");
                        }
                    }
                }
            }
            // sets the text filled to empty if it contains any character.
            if (a.getSource() == debitClearBtn) {
                pinNumberField.setText("");
                withdrawalAmountField.setText("");
            }

            if (a.getSource() == personalClearBtn) {
                cardIdField.setText(null);
                clientNameField.setText(null);
                issuerBankField.setText(null);
                bankAccountField.setText(null);
                balanceAmountField.setText(null);
            }
            if (a.getSource() == creditClearBtn) {
                cvcNumberField.setText("");
                gracePeriodField.setText("");
                creditLimitField.setText("");
                interestRateField.setText("");
            }
        }
    }

    public static void main(String[] args) {
        new BankGUI();
    }
}