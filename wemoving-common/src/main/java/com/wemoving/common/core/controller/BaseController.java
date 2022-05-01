package com.wemoving.common.core.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wemoving.common.constant.HttpStatus;
import com.wemoving.common.core.domain.Result;
import com.wemoving.common.core.page.PageDomain;
import com.wemoving.common.core.page.PageResult;
import com.wemoving.common.core.page.TableSupport;
import com.wemoving.common.utils.DateUtils;
import com.wemoving.common.utils.PageUtils;
import com.wemoving.common.utils.StringUtils;
import com.wemoving.common.utils.sql.SqlUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.beans.PropertyEditorSupport;
import java.util.Date;
import java.util.List;

/**
 * web层通用数据处理
 *
 * @author wemoving
 */
public class BaseController {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 将前台传递过来的日期格式的字符串，自动转化为Date类型
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // Date 类型转换
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                setValue(DateUtils.parseDate(text));
            }
        });
    }

    /**
     * 设置请求分页数据
     */
    protected void startPage() {
        PageUtils.startPage();
    }

    /**
     * 设置请求排序数据
     */
    protected void startOrderBy() {
        PageDomain pageDomain = TableSupport.buildPageRequest();
        if (StringUtils.isNotEmpty(pageDomain.getOrderBy())) {
            String orderBy = SqlUtil.escapeOrderBySql(pageDomain.getOrderBy());
            PageHelper.orderBy(orderBy);
        }
    }

    /**
     * 响应请求分页数据
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    protected PageResult buildPageResult(List<?> list) {
        PageResult rspData = new PageResult();
        rspData.setCode(HttpStatus.SUCCESS);
        rspData.setMsg("查询成功");
        rspData.setRows(list);
        rspData.setSuccess(Boolean.TRUE);
        rspData.setTotal((int) new PageInfo(list).getTotal());
        return rspData;
    }

    /**
     * 返回成功
     */
    public Result success() {
        return Result.success();
    }

    /**
     * 返回失败消息
     */
    public Result error() {
        return Result.error();
    }

    /**
     * 返回成功消息
     */
    public Result success(String message) {
        return Result.success(message);
    }

    /**
     * 返回失败消息
     */
    public Result error(String message) {
        return Result.error(message);
    }

    /**
     * 响应返回结果
     *
     * @param rows 影响行数
     * @return 操作结果
     */
    protected Result toResult(int rows) {
        return rows > 0 ? Result.success() : Result.error();
    }

    /**
     * 响应返回结果
     *
     * @param result 结果
     * @return 操作结果
     */
    protected Result toResult(boolean result) {
        return result ? success() : error();
    }

    /**
     * 页面跳转
     */
    public String redirect(String url) {
        return StringUtils.format("redirect:{}", url);
    }

}
