
package bean;

import java.io.Serializable;

public class AccountBean implements Serializable{
    
    private int accountNo;
    private String name;
    private int amount;
    
    public AccountBean(){
        this.amount=0;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    public void deposit(double Amount){
        this.amount+=Amount;
    }
    public boolean withdraw(double Amount){
        if(Amount > this.amount){
            return false;
        }
        this.amount-=Amount;
        return true;
    }
    public int getBalance(){
        return this.amount;
    }
    
}
