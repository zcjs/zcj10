package hfs.ass.service.impl;

import com.github.pagehelper.PageHelper;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.dto.DTOStatus;
import com.hand.hap.system.service.impl.BaseServiceImpl;

import hfs.ass.dto.Fruit;

import hfs.ass.mapper.FruitMapper;

import hfs.ass.service.IFruitService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author taotao.xu@hand-china.com
 */
@Service
public class FruitServiceImpl extends BaseServiceImpl<Fruit> implements IFruitService {

    @Autowired
    private FruitMapper fruitMapper;

	@Override
	public List<Fruit> selectByFruit(IRequest requestContext, Fruit fruit, int page, int pagesize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, pagesize);
		return fruitMapper.selectByFruit(fruit);
	}
	
	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
    public List<Fruit> batchUpdate(IRequest requestContext, List<Fruit> fruits ) {
        // TODO Auto-generated method stub
        for (Fruit fruit : fruits) {
            if (fruit.get__status() != null) {
                switch (fruit.get__status()) {
                case DTOStatus.ADD:
                	/*Date date = new Date();
                	long datetime = date.getTime();
                	Timestamp timestamp = new Timestamp(datetime);
                	fruit.setMyDate(timestamp);*/
                	fruitMapper.insertFruit(fruit);
                    break;
                case DTOStatus.UPDATE:
                	fruitMapper.updateFruit(fruit);
                    break;
                case DTOStatus.DELETE:
                	fruitMapper.deleteFruit(fruit);
                    break;
                default:
                    break;
                }
            }
        }
        return fruits;
    }
	@Override
	public List<Fruit> update(IRequest requestContext, List<Fruit> fruitList) {
		// TODO Auto-generated method stub
		for (Fruit fruit : fruitList) {
			fruitMapper.updateFruit(fruit);
        }
        return fruitList;
	}
}
