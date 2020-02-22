package com.guoyz.mybatis;

import org.apache.ibatis.session.SqlSession;

public class ActorDaoImpl implements ActorDao {
    
    private SqlSession sqlSession;
    
    public ActorDaoImpl(SqlSession sqlSession){
        this.sqlSession = sqlSession;
    }
    @Override
    public Actor queryActorById(Integer id) {
        return sqlSession.selectOne("myMapper.selectActor",id);
    }
}
