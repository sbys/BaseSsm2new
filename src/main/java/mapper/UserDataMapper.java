package mapper;

import viewmodel.UserData;

public interface UserDataMapper {
    int insert(UserData record);
    UserData select(String name);
    int update(UserData userData);
}
