package Exceptions;

public class InvalidArgument extends RuntimeException{
    public InvalidArgument() {
        super("Неправильный аргумент!");
    }
}
