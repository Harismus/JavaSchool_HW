package com.company.terminal;

public class TerminalServer {
    private int countOfMoneyOnAccount = 0;

    public int getCountOfMoneyOnAccount () {
        return countOfMoneyOnAccount;
    }

    public int deposit ( int value ) {
        countOfMoneyOnAccount += value;
        return countOfMoneyOnAccount;
    }

    public int withdraw ( int value ) throws NotEnoughMoneyException {
        if (countOfMoneyOnAccount < value) {
            throw new NotEnoughMoneyException ("Недостаточно денег.");
        }
        countOfMoneyOnAccount -= value;
        return countOfMoneyOnAccount;
    }

}
