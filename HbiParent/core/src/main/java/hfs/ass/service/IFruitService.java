package hfs.ass.service;


import com.hand.hap.system.service.IBaseService;

import hfs.ass.dto.Fruit;

import com.hand.hap.core.ProxySelf;
import com.hand.hap.core.annotation.StdWho;

import java.util.List;

import com.hand.hap.core.IRequest;


/**
 * Created by hailor on 16/6/2.
 */
public interface IFruitService extends IBaseService<Fruit>, ProxySelf<IFruitService> {

    List<Fruit> selectByFruit(IRequest requestContext, Fruit fruit, int page, int pagesize);
    
    List<Fruit> batchUpdate(IRequest requestContext, @StdWho List<Fruit> fruits);
    
    List<Fruit> update(IRequest requestContext, List<Fruit> fruitList);
}
