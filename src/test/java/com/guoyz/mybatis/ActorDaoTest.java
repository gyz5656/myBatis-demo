package com.guoyz.mybatis;

import junit.framework.TestCase;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.*;

public class ActorDaoTest {
    
    private SqlSession sqlSession;
    
    private ActorDao actorDao;

    @Before
    public void setUp() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sessionFactory.openSession();
        this.actorDao = sqlSession.getMapper(ActorDao.class);
    }

    @Test
    public void queryActorById() {
        
        Actor actor = this.actorDao.queryActorById(1);
        TestCase.assertEquals(actor.getFirstName(),"PENELOPE");
        
    }
}