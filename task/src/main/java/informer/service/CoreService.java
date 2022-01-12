/**
 * 
 */
package informer.service;

import java.util.List;

import informer.validator.unique.FieldValueExists;

/**
 * @author firsov
 *
 */
public interface CoreService<M> extends FieldValueExists {

	List<M> all(String namedQery);

	void save(M model);

	void update(M model);

	M byId(int id);

	boolean delete(int id);

}
