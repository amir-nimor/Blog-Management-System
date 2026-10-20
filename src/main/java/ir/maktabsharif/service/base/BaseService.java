package ir.maktabsharif.service.base;

import java.util.List;

public interface BaseService<Q, S, ID extends Number> {


    S save(Q q);

    S update(Q q);

    ID delete(ID id);

    S findById(ID id);

    List<S> findAll();
}
