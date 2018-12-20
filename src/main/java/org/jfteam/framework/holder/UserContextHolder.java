package org.jfteam.framework.holder;

import org.jfteam.framework.context.IUserContext;
import org.springframework.util.StringUtils;

/**
 * @description: 描述
 * @author: fengwenping
 * @date: 2018/12/20 11:24
 */
public final class UserContextHolder {

    public static final ThreadLocal<IUserContext> USER_CONTEXT_THREAD_LOCAL = new ThreadLocal<>();

    public static IUserContext get() {
        return USER_CONTEXT_THREAD_LOCAL.get();
    }

    public static void put(IUserContext userContext) {
        USER_CONTEXT_THREAD_LOCAL.set(userContext);
    }

    public static void remove() {
        USER_CONTEXT_THREAD_LOCAL.remove();
    }

    public static IUserContext build(final String token) {
        Long userId = 0L;
        if (StringUtils.hasText(token)) {
            userId = Long.valueOf(token);
        }
        IUserContext userContext = new IUserContext() {
            @Override
            public Long getUserId() {
                return 0L;
            }

            @Override
            public String getUserName() {
                return null;
            }

            @Override
            public String getEmail() {
                return null;
            }

            @Override
            public String getPhone() {
                return null;
            }
        };
        return userContext;
    }
}
