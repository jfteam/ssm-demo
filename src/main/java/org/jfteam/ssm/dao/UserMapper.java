package org.jfteam.ssm.dao;

import org.apache.ibatis.annotations.Param;
import org.jfteam.ssm.vo.UserVO;

public interface UserMapper {

    UserVO findOne(@Param("id") Integer id);

    void insert(UserVO userVO);
}
