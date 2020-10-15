package informer.old.transformer;

import org.springframework.stereotype.Component;

@Component
public interface BaseTransformer<E, M> {

	E modelToEntity(M model);
	M entityToModel(E entity);
}
