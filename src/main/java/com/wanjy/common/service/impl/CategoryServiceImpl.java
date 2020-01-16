package com.wanjy.common.service.impl;

import com.wanjy.common.entity.Category;
import com.wanjy.common.mapper.CategoryMapper;
import com.wanjy.common.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 类别表 服务实现类
 * </p>
 *
 * @author wanjy
 * @since 2020-01-12
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

}
