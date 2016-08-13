package net.sunmingchun.www.base.po;

import java.util.List;

/**
 * Created by smc on 2016/1/12.
 */
public class BasePagePO<T> {

    private int draw;

    private int recordsTotal;   //总条数

    private int recordsFiltered;   //

    private int currentPage;  //当前是第几页

    private int totalPage;  // 总共多少页

    private int pageSize = 10;  //每页显示条数

    private List<T> data;

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public int getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(int recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public int getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(int recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        if(recordsTotal % pageSize == 0){
            return recordsTotal/pageSize;
        }else{
            return recordsTotal/pageSize+1;
        }
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
