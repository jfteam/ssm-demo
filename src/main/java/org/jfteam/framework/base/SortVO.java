package org.jfteam.framework.base;

import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.Locale;

/**
 * @description: 描述
 * @author: fengwenping
 * @date: 2018/12/11 13:45
 */
public class SortVO {

    public enum Direction {

        ASC, DESC;

        public boolean isAscending() {
            return this.equals(ASC);
        }

        public boolean isDescending() {
            return this.equals(DESC);
        }

        public static SortVO.Direction fromString(String value) {
            try {
                return SortVO.Direction.valueOf(value.toUpperCase(Locale.US));
            } catch (Exception e) {
                throw new IllegalArgumentException(String.format("Invalid value '%s' for orders given! Has to be either 'desc' or 'asc' (case insensitive).", value), e);
            }
        }

        public static SortVO.Direction fromStringOrNull(String value) {
            try {
                return fromString(value);
            } catch (IllegalArgumentException e) {
                return null;
            }
        }
    }

    public enum NullHandling {
        NATIVE, NULLS_FIRST, NULLS_LAST;
    }

    public static class OrderVO implements Serializable {

        private static final boolean DEFAULT_IGNORE_CASE = false;
        public static final Direction DEFAULT_DIRECTION = Direction.ASC;

        private final Direction direction;
        private final String property;
        private final boolean ignoreCase;
        private final NullHandling nullHandling;

        public OrderVO(Direction direction, String property) {
            this(direction, property, DEFAULT_IGNORE_CASE, null);
        }

        public OrderVO(Direction direction, String property, NullHandling nullHandlingHint) {
            this(direction, property, DEFAULT_IGNORE_CASE, nullHandlingHint);
        }

        public OrderVO(String property) {
            this(DEFAULT_DIRECTION, property);
        }

        private OrderVO(Direction direction, String property, boolean ignoreCase, SortVO.NullHandling nullHandling) {

            if (!StringUtils.hasText(property)) {
                throw new IllegalArgumentException("Property must not null or empty!");
            }

            this.direction = direction == null ? DEFAULT_DIRECTION : direction;
            this.property = property;
            this.ignoreCase = ignoreCase;
            this.nullHandling = nullHandling == null ? SortVO.NullHandling.NATIVE : nullHandling;
        }
    }
}
