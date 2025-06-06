package com.compiler.ast;

import java.io.OutputStreamWriter;

public class ASTPlusMinusExprNode extends ASTExprNode {
    ASTExprNode m_operand0;
    ASTExprNode m_operand1;
    com.compiler.TokenIntf.Type m_operator;

    public ASTPlusMinusExprNode(ASTExprNode operand0, ASTExprNode operand1, com.compiler.TokenIntf.Type operator) {
        m_operand0 = operand0;
        m_operand1 = operand1;
        m_operator = operator;
    }

    public int eval() {
       int operand0 = m_operand0.eval();
       int operand1 = m_operand1.eval();
       if (m_operator == com.compiler.TokenIntf.Type.PLUS) {
          return operand0 + operand1;
       } else {
        return operand0 - operand1;
       }
    }

    public com.compiler.InstrIntf codegen(com.compiler.CompileEnvIntf compileEnv) {
        com.compiler.InstrIntf operand0 = m_operand0.codegen(compileEnv);
        com.compiler.InstrIntf operand1 = m_operand1.codegen(compileEnv);
        com.compiler.InstrIntf plusMinusInstr = new com.compiler.instr.InstrPlusMinus(m_operator, operand0, operand1);
        compileEnv.addInstr(plusMinusInstr);
        return plusMinusInstr;
    }
 
    public void print(OutputStreamWriter outStream, String indent) throws Exception {
        outStream.write(indent);
        outStream.write("PlusMinusExpr ");
        outStream.write(m_operator.toString());
        outStream.write("\n");
        m_operand0.print(outStream, indent + "  ");
        m_operand1.print(outStream, indent + "  ");
    }
}
