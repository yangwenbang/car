package com.car.service;

import com.car.entity.Commodity;
import com.car.form.CommodityForm;


/**
 * 
 *
 * @author lzp
 * @email sunlightcs@gmail.com
 * @date 2019-05-16 21:33:04
 */
public interface CommodityService {

    Commodity insertCommodity(CommodityForm commodity);
}

