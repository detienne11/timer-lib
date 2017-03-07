package fr.detienne.library.chrono.test;

import fr.detienne.library.chrono.Chrono;
import fr.detienne.library.chrono.ChronoFactory;

public class ChronoTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Chrono chrono = ChronoFactory.getChrono(ChronoTest.class);				
		try {
			chrono.start();
			Thread.sleep(1000);
			chrono.stop();
		} catch (InterruptedException e) {
			// interrupted
		} finally {
			System.out.println(chrono.getLap());
		}
	}

}
