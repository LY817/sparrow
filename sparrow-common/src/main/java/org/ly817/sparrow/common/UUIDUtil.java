package org.ly817.sparrow.common;

import java.util.UUID;

/**
 * @author LY
 * @date 2019/08/21 14:47
 * <p>
 * Description:
 */
public class UUIDUtil {
    public static String getUUID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
