package es.upm.miw.pd.singleton.factory;

import java.util.HashMap;
import java.util.Map;

public class FactoryReferences {
	
	private static FactoryReferences myFactoryReferences  = null;
	
    private Map<String, Integer> references;
    private int reference;
    
    private static FactoryReferences getFactoryReferences(){
    	if(FactoryReferences.myFactoryReferences == null){
    		FactoryReferences.myFactoryReferences = new FactoryReferences();
    	}
    	return FactoryReferences.myFactoryReferences;
    }

    private FactoryReferences() {
        this.references = new HashMap<>();
        this.reference = 0;
    }

    public int getReference(String key) {
        Integer result = this.references.get(key);
        if (result == null) {
            this.references.put(key, this.reference);
            result = this.reference;
            reference++;
        }
        return result;
    }

    public void removeReference(String key) {
        this.references.remove(key);
    }

}
