package informer.validator.unique;

public interface FieldValueExists {

	boolean fieldValueExists(Object value, String fieldName) throws UnsupportedOperationException;
	
}
