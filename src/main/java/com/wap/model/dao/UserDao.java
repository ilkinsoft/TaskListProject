package com.wap.model.dao;

import com.wap.SessionSingleton;
import com.wap.model.dto.UserDto;
import com.wap.model.entity.Userr;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.lang.reflect.InvocationTargetException;

public class UserDao extends BaseDao<Userr, UserDto> {

    public UserDao() {
        super.typeTDto = UserDto.class;
        super.typeTEntity = Userr.class;

    }

    public UserDto getByEmail(String email) {
        Session session = SessionSingleton.getSession();

        UserDto dto = null;
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


        Query query= session.
                createQuery("from Userr where email=:email");
        query.setParameter("email", email);

        Userr userr = (Userr) query.uniqueResult();

        UserDto tDtoResult = (UserDto) dto.toDto(userr);

        session.close();
        return tDtoResult;
    }




}
