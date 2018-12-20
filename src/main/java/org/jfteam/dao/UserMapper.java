package org.jfteam.dao;

import org.apache.ibatis.annotations.Param;
import org.jfteam.vo.UserVO;

public interface UserMapper {

    UserVO findOne(@Param("id") Integer id);

    void insert(UserVO userVO);
}
