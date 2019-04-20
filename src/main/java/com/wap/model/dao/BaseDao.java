package com.wap.model.dao;

import com.wap.SessionSingleton;
import com.wap.model.dto.BaseDto;
import com.wap.model.entity.BaseEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.lang.reflect.InvocationTargetException;

public abstract class BaseDao<TEntity extends BaseEntity, TDto extends BaseDto> {

    protected Class<TEntity> typeTEntity;
    protected Class<TDto> typeTDto;

    //TEntity objectTEntity;


    public void save(TDto tDto) {
        Session session = SessionSingleton.getSession();
        Transaction transaction = session.beginTransaction();

        TEntity tEntity = (TEntity) tDto.toEntity();

        try {

            session.save(tEntity);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }

        session.close();
    }


    public void delete(TDto tDto) {
        Session session = SessionSingleton.getSession();
        Transaction transaction = session.beginTransaction();

        TEntity tEntity = (TEntity) tDto.toEntity();
        try {


            session.delete(tEntity);


            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }

        session.close();
    }


    public void update(TDto tDto) {
        Session session = SessionSingleton.getSession();
        Transaction transaction = session.beginTransaction();
        try {

            session.update(tDto);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }

        session.close();

    }


    public TDto getById(int id) {
        Session session = SessionSingleton.getSession();

        TDto dto = null;
        try {
            dto = typeTDto.getConstructor().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        TEntity tEntity = session.get(typeTEntity, id);
        TDto tDtoResult = (TDto) dto.toDto(tEntity);


        session.close();

        return tDtoResult;


    }


}
