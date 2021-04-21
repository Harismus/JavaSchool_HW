package com.company;

public class PinValidator {

    private int pinCode = 1234;
    private boolean isAuthorized = false;
    private int incorrectPinCount = 0;
    private long dateOfBlocking;
    private int lockTimeInSeconds = 10;
    private boolean isLockedAccount = false;

    public int getLockTimeInSeconds() {
        return lockTimeInSeconds;
    }

    public boolean isAccountLocked() {
        return isLockedAccount;
    }

    public boolean isAuthorized() {

        return isAuthorized;
    }

    public long getDateOfBlocking() {
        return dateOfBlocking;
    }

    public void exitFromAccount() {
        isAuthorized = false;
        incorrectPinCount = 0;
    }

    public void inputPinCode(int code) throws IncorrectPinExceprion, AccountIsLockedException {
        System.out.println( "code = " + code );

        if (isLockedAccount) {
            triedToCheckTimeout();
        }

        if (!isLockedAccount && code == pinCode) {
            isAuthorized = true;
            incorrectPinCount = 0;
            isLockedAccount = false;
        }  else {
            if (++incorrectPinCount >= 3) {
                isLockedAccount = true;
                dateOfBlocking = System.currentTimeMillis();
                triedToCheckTimeout();
            }

            throw new IncorrectPinExceprion( "Неверный пин." );
        }
    }

    public long checkTimeout() {
        long isTimeout = (dateOfBlocking + lockTimeInSeconds * 1000 - System.currentTimeMillis()) / 1000;
        return isTimeout >= 0 ? isTimeout : 0;
    }


    private void triedToCheckTimeout() throws AccountIsLockedException
    {
        long sec = checkTimeout();
        if (sec > 0) {
            throw new AccountIsLockedException( "Аккаунт заблокирован. ", sec );
        }
        else {
            incorrectPinCount = 0;
            isLockedAccount = false;
        }
    }
}
