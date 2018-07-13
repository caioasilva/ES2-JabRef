package org.jabref.logic.importer.fileformat;

import org.jabref.logic.importer.OutputPrinter;

public class OutputPrinterToNull implements OutputPrinter {

	@Override
	public void setStatus(String s) {
	}

	@Override
	public void showMessage(Object message, String title, int msgType) {
	}

	@Override
	public void showMessage(String string) {
	}

	@Override
	public void showMessage(String message, String title, int msgType) {
		// TODO Auto-generated method stub
		
	}
	
}
