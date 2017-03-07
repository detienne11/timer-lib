package fr.detienne.library.chrono;

import java.util.HashMap;
import java.util.Map;

public final class ChronoFactory {
	
	private final static Map<String, Chrono> map = new HashMap<String, Chrono>();
	
	private final static String CHRONO_IMPL = "fr.detienne.library.chrono.impl.ChronoImpl";
	
	private ChronoFactory(){
		
		// recherche de l'implementation
//		Properties properties = new Properties();
//		
//		FileReader file = null;
//		try {
//			file = new FileReader("fr.detienne.library.chrono.chrono.properties");
//			properties.load(file);
//			CHRONO_IMPL = properties.getProperty("chrono.impl"); 
//		} catch (FileNotFoundException e) {
//			throw new ChronoException(e);
//		} catch (IOException e) {
//			throw new ChronoException(e);
//		} finally {
//			if (file != null){
//				try {
//					file.close();
//				} catch (IOException e) {
//					throw new ChronoException(e);
//				}	
//			}
//		}
		
	}
	
	public synchronized final static Chrono getChrono(String identifier){
		
		//---> traitement
		Chrono chrono = null;
				
		if( ChronoFactory.map.containsKey(identifier) ){
			chrono = ChronoFactory.map.get(identifier);
		}else{
			try {
				chrono = (Chrono) Class.forName(ChronoFactory.CHRONO_IMPL).newInstance();
			} catch (InstantiationException e) {
				throw new ChronoException(e);
			} catch (IllegalAccessException e) {
				throw new ChronoException(e);
			} catch (ClassNotFoundException e) {
				throw new ChronoException(e);
			}
				
			ChronoFactory.map.put(identifier,chrono);
		}
		return chrono;		
	}
	
	public synchronized final static <T> Chrono getChrono(Class<T> clazz){
		
		if (clazz == null){
			throw new ChronoException("Invalid class identifier for ChronoFactory");
		}
		return ChronoFactory.getChrono(clazz.getName());
	}
	
}