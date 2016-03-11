package bg.alexander.services;

import java.util.List;

public interface GenerictDaoInterface<E> {
	public E saveOrUpdate(E entity);
	public void delete(Long id);
	public List<E> list();
	public E getById(Long id);
}
