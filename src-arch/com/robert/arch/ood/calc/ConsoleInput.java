package com.robert.arch.ood.calc;

import java.io.IOException;

public class ConsoleInput implements Input {

	public char input() {
		while (true) {
			try {
				char c = (char) System.in.read();

				if (!Util.isNumber(c) && !Util.isOperator(c) && !Util.isControl(c))
					continue;

				return c;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
