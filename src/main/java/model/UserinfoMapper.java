package model;

public interface UserinfoMapper {
    int deleteByPrimaryKey(Integer uid);
    int insert(Userinfo record);
    int insertSelective(Userinfo record);
    Userinfo selectByPrimaryKey(Integer uid);
    int updateByPrimaryKeySelective(Userinfo record);
    int updateByPrimaryKey(Userinfo record);
}