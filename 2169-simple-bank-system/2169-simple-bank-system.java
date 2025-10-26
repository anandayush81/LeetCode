class Bank {
    long bal[];

    public Bank(long[] balance) {
    //    bal=new long[balance.length];
       bal=balance;
        
    }
    private boolean isValidAcc(int x){
        int n=bal.length;
        if(x>=1 && x<=n) return true; return false;
    }
    public boolean transfer(int account1, int account2, long money) {
        if(isValidAcc(account1) && isValidAcc(account2) && bal[account1-1]>=money ){
            bal[account1-1]-=money;
            bal[account2-1]+=money;
            return true;
        }
        return false;

        
    }
    
    public boolean deposit(int account, long money) {
        if(isValidAcc(account)){
            bal[account-1]+=money;
            return true;
        }
        return false;
        
    }
    
    public boolean withdraw(int account, long money) {
        if(isValidAcc(account) && bal[account-1]>=money){
            bal[account-1]-=money;
            return true;
        }
        return false;
        
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */