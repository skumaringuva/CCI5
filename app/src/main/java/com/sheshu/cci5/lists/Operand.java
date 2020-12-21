package com.sheshu.cci5.lists;

public class Operand{
        int number;
        char operand;
        Operand(int aNumber){
            number = aNumber;
        }
        Operand(char aOperand){
            operand = aOperand;
        }

    @Override
    public String toString() {
        return "["+operand+" "+number+"]";
    }
}