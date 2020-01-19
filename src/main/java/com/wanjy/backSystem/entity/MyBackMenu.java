package com.wanjy.backSystem.entity;

import com.wanjy.common.entity.BackMenu;
import lombok.Data;

/**
 * @author 12068
 * @date 2020/1/19  12:55
 */
@Data
public class MyBackMenu extends BackMenu {
    /**
     * 菜单子节点
     */
    private Object child=null;
}
