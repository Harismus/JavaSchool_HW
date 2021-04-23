package com.company;


public class TerminalImpl implements ITerminal {
    private final TerminalServer server = new TerminalServer();
    private final PinValidator pinValidator = new PinValidator();

    @Override
    public boolean inputPinCode(int pinCode) throws IncorrectPinExceprion, AccountIsLockedException {
        pinValidator.inputPinCode( pinCode );
        return pinValidator.isAuthorized();
    }

    @Override
    public boolean isAuthorized(){
        return  pinValidator.isAuthorized();
    }

    @Override
    public int checkAccount() throws IsNotAuthorizedExeption, AccountIsLockedException {
        IsAuthorizedAndNotLocked();
        return server.getCountOfMoneyOnAccount();
    }

    @Override
    public int withdraw(int valueToWithdraw) throws IsNotAuthorizedExeption,
            NotEnoughMoneyException, AccountIsLockedException, IsNotValidValueException {
        IsAuthorizedAndNotLocked();

        if (!isValidDeposit( valueToWithdraw ))
            throw new IsNotValidValueException( "Неправильное количество денег для депозита. Введите сумму кратную 100." );

        return server.withdraw( valueToWithdraw );
    }

    @Override
    public int deposit(int valueToDeposit) throws IsNotAuthorizedExeption, AccountIsLockedException, IsNotValidValueException {
        IsAuthorizedAndNotLocked();
        if (!isValidDeposit( valueToDeposit ))
            throw new IsNotValidValueException( "Неправильное количество денег для депозита. Введите сумму кратную 100." );
        return server.deposit( valueToDeposit );
    }

    @Override
    public boolean isValidDeposit(int valueToDeposit) throws AccountIsLockedException, IsNotAuthorizedExeption {
        IsAuthorizedAndNotLocked();
        return valueToDeposit % 100 == 0;
    }

    @Override
    public boolean isValidWithdraw(int valueToWithdraw) throws AccountIsLockedException, IsNotAuthorizedExeption {
        IsAuthorizedAndNotLocked();
        return (valueToWithdraw % 100 == 0) && (server.getCountOfMoneyOnAccount() >= valueToWithdraw);
    }

    @Override
    public void exitFromAccount() {
        pinValidator.exitFromAccount();
    }

    private void IsAuthorizedAndNotLocked() throws AccountIsLockedException, IsNotAuthorizedExeption {
        if (pinValidator.isAccountLocked())
            throw new AccountIsLockedException( "Аккаунт заблокирован.", pinValidator.checkTimeout() );
        if (!pinValidator.isAuthorized())
            throw new IsNotAuthorizedExeption( "Отсутствует авторизация." );
    }
}
