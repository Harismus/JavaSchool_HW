package dao;

import model.Factorial;

public interface FactorialDao {
    Factorial createFactorial(int number, int result);
    Factorial findFactorial(int number, int result);
}
