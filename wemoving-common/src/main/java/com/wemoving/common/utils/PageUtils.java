package com.wemoving.common.utils;

import com.github.pagehelper.PageHelper;
import com.wemoving.common.core.page.PageDomain;
import com.wemoving.common.core.page.TableSupport;
import com.wemoving.common.utils.sql.SqlUtil;

/**
 * @author liuyuhui
 * @date 2022/01/14
 * @qq 1515418211
 */
public class PageUtils extends PageHelper {

    /**
     * 设置请求分页数据
     */
    public static void startPage() {
        PageDomain pageDomain = TableSupport.buildPageRequest();
        Integer pageNum = pageDomain.getPageNum();
        Integer pageSize = pageDomain.getPageSize();
        if (StringUtils.isNotNull(pageNum) && StringUtils.isNotNull(pageSize)) {
            String orderBy = SqlUtil.escapeOrderBySql(pageDomain.getOrderBy());
            Boolean reasonable = pageDomain.getReasonable();
            PageHelper.startPage(pageNum, pageSize, orderBy).setReasonable(reasonable);
        }
    }

}
