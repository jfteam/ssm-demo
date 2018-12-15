package org.jfteam.framework.web;

/**
 * @description: Http状态提供者接口
 * @author: fengwenping
 * @date: 2018-12-15 18:27
 */
public interface HttpStatusProvider {

    /**
     * 返回http code,如500,403,401,200等....
     *
     * @return
     */
    int getHttpCode();
}
