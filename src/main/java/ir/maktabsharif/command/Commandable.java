package ir.maktabsharif.command;

public interface Commandable <A,Q,S>{

    A DtoRequestToDao(Q q);

    S DaoToDtoResponse(A a);

}
