package com.mingjie.life_server.QueryVo;

public class PageVo {
    private Integer page;
    private Integer size;

    public Integer getPage() {
        return page - 1;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        if(size == null){
            return 30;
        }
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
