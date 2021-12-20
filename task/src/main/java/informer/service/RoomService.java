/**
 * 
 */
package informer.service;

import java.util.List;
import java.util.Optional;

import informer.model.RoomModel;
import informer.validator.unique.FieldValueExists;

/**
 * @author firsov
 *
 */
public interface RoomService extends FieldValueExists {

	List<RoomModel> allRoom(String string);

	void save(RoomModel model);

	void update(RoomModel model);

	Optional<RoomModel> byId(int id);

	boolean delete(Integer id);

}
