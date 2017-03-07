package fr.detienne.library.chrono.test;

import fr.detienne.library.chrono.Chrono;
import fr.detienne.library.chrono.ChronoFactory;
import junit.framework.TestCase;

public class ChronoJunit extends TestCase {

		public void test1(){
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
