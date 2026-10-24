package za.ac.cput.service.IService;

import java.util.List;

public interface service <T, ID>{
    T create(T t);
    T read(ID id);
    T update(T t);
    void delete(ID id);
    List<T> getAll();
   }
