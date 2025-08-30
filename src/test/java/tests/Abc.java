package tests;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Abc {

	public static void main(String[] args) {
		String datenew=new SimpleDateFormat("dd.mm.YYYY.hh.mm.ss").format(new Date());
		System.out.println(datenew);

	}

}
