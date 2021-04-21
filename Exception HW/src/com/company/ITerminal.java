package com.company;

public interface ITerminal {
    boolean inputPinCode(int code) throws IncorrectPinExceprion, AccountIsLockedException;

    /**
     *
     * @return Account balance.
     * @throws AccountIsLockedException
     * @throws IsNotAuthorizedExeption
     */
    int checkAccount () throws AccountIsLockedException, IsNotAuthorizedExeption;

    /**
     *
     * @return
     */
    public boolean isAuthorized();


    /**
     *
     * @param valueToWithdraw - Count of money user wants to withdraw.
     * @return Account balance after withdrawing.
     * @throws AccountIsLockedException
     * @throws IsNotAuthorizedExeption
     * @throws NotEnoughMoneyException
     */
    int withdraw(int valueToWithdraw) throws AccountIsLockedException, IsNotAuthorizedExeption, NotEnoughMoneyException, IsNotValidValueException;

    /**
     *
     * @param valueToDeposit - Count of money user wants to deposit.
     * @return Account balance after depositing.
     * @throws AccountIsLockedException
     * @throws IsNotAuthorizedExeption
     */
    int deposit(int valueToDeposit) throws AccountIsLockedException, IsNotAuthorizedExeption, IsNotValidValueException;

    boolean isValidDeposit(int valueToDeposit) throws AccountIsLockedException, IsNotAuthorizedExeption;

    boolean isValidWithdraw(int valueToWithdraw) throws AccountIsLockedException, IsNotAuthorizedExeption;

    void exitFromAccount();

}
