package ir.maktabsharif.service.base;

import ir.maktabsharif.command.Commandable;
import ir.maktabsharif.dao.BaseModel;
import ir.maktabsharif.exception.BuisenesException;
import ir.maktabsharif.exception.RepositoryException;
import ir.maktabsharif.exception.ValidationExceptio;
import ir.maktabsharif.repository.base.BaseRepository;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseServiceImpl <T extends BaseModel<ID>
        ,Q,S,ID extends Number
        ,R extends BaseRepository<T,ID>
        ,C extends Commandable<T,Q,S>>
        implements BaseService<Q,S,ID>
{

    R repository ;
    C command;

    public BaseServiceImpl(R repository,C command){
        this.repository =repository;
        this.command = command;
    }

    protected abstract void validation(Q q);

    @Override
    public S save(Q q) {
        try {
            validation(q);
            T model = command.DtoRequestToDao(q);
            S s = command.DaoToDtoResponse(repository.create(model));
            return s;
        }catch (ValidationExceptio | RepositoryException e){
            throw new BuisenesException("service is failed => "+e.getMessage());
        }
    }

    @Override
    public S update(Q q) {
        try {
            validation(q);
            T model = command.DtoRequestToDao(q);
            S s = command.DaoToDtoResponse(repository.update(model));
            return s;
        }catch (ValidationExceptio | RepositoryException e){
            throw new BuisenesException("service is failed => "+e.getMessage());
        }
    }

    @Override
    public ID delete(ID id) {
        try {
            return repository.delete(id);
        }catch (RepositoryException e){
            throw new BuisenesException("service is failed => "+e.getMessage());
        }
    }

    @Override
    public S findById(ID id) {
        try {
            return command.DaoToDtoResponse(repository.read(id));

        }catch (RepositoryException e){
            throw new BuisenesException("service is failed => "+e.getMessage());
        }
    }

    @Override
    public List<S> findAll() {
        try {
            List<T> models = repository.findAll();
            List<S> commandModels = new ArrayList<>();
            for (T t:models){
                commandModels.add(command.DaoToDtoResponse(t));
            }
            return commandModels;
        }catch (RepositoryException e){
            throw new BuisenesException("service is failed => "+e.getMessage());
        }
    }
}
