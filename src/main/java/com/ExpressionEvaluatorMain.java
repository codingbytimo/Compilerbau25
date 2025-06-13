package com;

public class ExpressionEvaluatorMain {

    public static void main(String[] args) throws Exception {
        com.compiler.Lexer lexer = new com.compiler.Lexer();
        com.compiler.ExpressionEvaluator evaluator = new com.compiler.ExpressionEvaluator(lexer);
        int result = evaluator.eval("(4+2)*3");
        System.out.println(result);
    }

}
