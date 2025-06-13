package com.compiler;

import java.util.List;

public class FunctionInfo {
	public String m_name;
	public InstrBlock m_body;
	public List<String> varNames;
	
	public FunctionInfo(String name, List<String> varNames) {
		this(name, null, varNames);
	}
    
    public FunctionInfo(String name, InstrBlock body, List<String> varNames) {
        m_name = name;
        m_body = body;
        this.varNames = varNames;
    }
    
    public void setEntry(InstrBlock entry) {
        m_body = entry;
    }
}
