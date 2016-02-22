package net.sunmingchun.www.admin.head.service;

import net.sunmingchun.www.admin.head.po.NewHeadCoordinate;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by smc on 2016/1/22.
 */
public interface IHeadService {

    public String upload(HttpServletRequest request);

    public void saveNewHeadCoordinate(NewHeadCoordinate newHeadCoordinate);

}
