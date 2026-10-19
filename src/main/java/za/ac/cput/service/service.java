package za.ac.cput.service;

import java.util.List;

public interface service <T, ID>{
    T create(T t);
    T read(ID id);
    T update(T t);
    void delete(ID id);
    List<T> getAll();
   }
