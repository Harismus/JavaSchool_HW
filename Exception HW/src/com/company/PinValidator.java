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

    public boolean isAccountIsLocked() {
        return isLockedAccount;
    }

    public boolean isAuthorized() {
        return isAuthorized;
    }

    public long getDateOfBlocking() {
        return dateOfBlocking;
    }

    public void inputPinCode(int code) throws IncorrectPinExceprion, AccountIsLockedException {
        if (code == pinCode) {
            isAuthorized = true;
            incorrectPinCount = 0;
        } else {
            if (++incorrectPinCount >= 3) {
                dateOfBlocking = System.currentTimeMillis();
                throw new AccountIsLockedException( "Аккаунт заблокирован на 10 секунд. ", timeToUnlock() );
            }
            throw new IncorrectPinExceprion( "Неверный пин." );
        }
    }

    public long timeToUnlock() {
        long isTimeout = (dateOfBlocking + lockTimeInSeconds * 1000 - System.currentTimeMillis()) / 1000;
        return isTimeout >= 0 ? isTimeout : 0;
    }
}
