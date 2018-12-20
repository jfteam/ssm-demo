package org.jfteam.framework.context;

import java.io.Serializable;

/**
 * @description: 描述
 * @author: fengwenping
 * @date: 2018/12/20 11:25
 */
public interface IUserContext extends Serializable {

    Long getUserId();

    String getUserName();

    String getEmail();

    String getPhone();
}
