package com.sheshu.cci5.lists;

import android.graphics.Path;

import java.util.Collections;
import java.util.Stack;

public class ListToNumber {
    public static void test(){

        CalcNode a = new CalcNode('5');
        a.next = new CalcNode('7');
        a.next.next = new CalcNode('6');

        CalcNode o = new CalcNode('+');

        CalcNode b = new CalcNode('4');
        b.next = new CalcNode('5');
        b.next.next = new CalcNode('7');

        a.next.next.next = o;
        o.next = b;

        printCalcList(a);

        System.out.println("List to number value: "+listTONumber(a));

    }

    private static void printCalcList(CalcNode root){
        System.out.println("Printing calc list---");
        while(root!=null){
            System.out.print(root.value);
            root = root.next;
        }
        System.out.println("End Printing calc list---");

    }

    private static int listTONumber(CalcNode list){

        Stack<Operand> stack = new Stack<>();
        int cur = Integer.MAX_VALUE;

        while(list!=null){
            if(list.value >='0' && list.value<='9'){
                if(cur == Integer.MAX_VALUE)
                    cur = 0;

               cur = makeNumber(cur,list.value-'0',true);
               //System.out.println("CurrentNumber: "+cur+" digit: "+list.value);
            }
            else {
                if(cur!=Integer.MAX_VALUE){
                    stack.add(new Operand(cur));
                    cur = Integer.MAX_VALUE;
                }
                stack.add(new Operand(list.value));
            }
            list = list.next;

            // Before going out of loop check for any residue..
            if(list ==null && cur!=Integer.MAX_VALUE){
                    stack.add(new Operand(cur));
            }
        }
        System.out.println("Opstack: "+  stack.toString());
        return calculate(stack);
    }

    private static int calculate(Stack<Operand> operands){
        int result = 0;

        while(!operands.empty()){
            Operand op = operands.pop();
            // If we got a number out of turn then add it to the result..
            // Else pop next item expecting an operation and next value as another number
            // and go for evaluation..
            // add it back to result and continue..
            // its expected to have operands inbetwen numbers..
            // If not the previous method could have cought the value as single digit..
            if(op.operand == '\u0000'){
                result+= op.number;
            }
            else{
                if(!operands.empty()) {
                    System.out.println("Operand: "+op.toString());
                    if(!operands.empty()) {
                        Operand nextValue = operands.pop();
                        System.out.println("Operand2: "+nextValue.toString());
                        result = performOperation(op.operand,result, nextValue.number);
                    }
                }
            }
            System.out.println("Current result: "+result);
        }

        return result;
    }

    private static int performOperation(char operand, int result, int nextValue) {

        if(operand == '+'){
            return result+nextValue;
        }
        return 0;
    }

    private static int makeNumber(int prevSum, int digit, boolean reverseOrder){
        if(reverseOrder){
           return prevSum*10+digit;
        }
        else
        {
            int prev2= prevSum;
            int curSum = digit;
            while(prev2 >0){
                prev2 = prev2/10;
                curSum*=10;
            }
            return prevSum+curSum;
        }
    }

}
