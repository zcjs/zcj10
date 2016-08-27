package hap.org.service.impl;

import java.util.List;

import com.hand.hap.core.IRequest;
import com.hand.hap.system.service.impl.BaseServiceImpl;

import hfs.ass.dto.Fruit;
import hfs.ass.service.IFruitService;

public class LinesServiceImpl extends BaseServiceImpl<Fruit> implements IFruitService{

	@Override
	public List<Fruit> selectByFruit(IRequest requestContext, Fruit fruit, int page, int pagesize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Fruit> update(IRequest requestContext, List<Fruit> fruitList) {
		// TODO Auto-generated method stub
		return null;
	}

}
