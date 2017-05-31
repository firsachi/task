package kievreclama.task.configurations;

import java.util.ArrayList;
import java.util.List;

public enum Colors {
	Black,
	Cyan,
	Magenta,
	Yellow;
	public static final List<Colors> getListColors(){
		List<Colors> colors = new ArrayList<>();
		colors.add(Black);
		colors.add(Cyan);
		colors.add(Magenta);
		colors.add(Yellow);
		return colors;
	}
}
