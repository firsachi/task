/**
 * 
 */
package informer.service;

import java.util.List;

/**
 * @author firsov
 *
 */
public interface CoreService<M> {

	List<M> all(String namedQery);

	void save(M model);

	void update(M model);

	M byId(int id);

	boolean delete(int id);

}
