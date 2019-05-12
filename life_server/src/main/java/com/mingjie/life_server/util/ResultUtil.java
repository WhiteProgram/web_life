package com.mingjie.life_server.util;


public class ResultUtil {

    public static BaseResult success(Object data) {
        return commonResult(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMsg(), data);
    }

    public static BaseResult success() {
        return commonResult(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMsg(),null);
    }

    public static BaseResult error(Integer code, String errorMsg) {
        return commonResult(code, errorMsg, null);
    }

    public static BaseResult error(String errorMsg) {
        return commonResult(ResultEnum.REQUEST_ERROR.getCode(), errorMsg, null);
    }

    public static BaseResult successPageList(Object content, Integer totalPages) {
        PageList pageList = new PageList();
        pageList.setContent(content);
        pageList.setTotalPages(totalPages);
        return commonResult(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMsg(), pageList);
    }

    private static BaseResult commonResult(Integer code, String msg, Object data) {
        BaseResult<Object> result = new BaseResult<>();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }


}

