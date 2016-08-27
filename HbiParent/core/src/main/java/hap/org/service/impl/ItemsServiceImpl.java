package hap.org.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.service.impl.BaseServiceImpl;

import hap.org.dto.Items;
import hap.org.mapper.ItemsMapper;
import hap.org.service.IItemsService;
@Service
public class ItemsServiceImpl extends BaseServiceImpl<Items> implements IItemsService{


	 @Autowired
	    private ItemsMapper itemsMapper;
	   @Override
		public List<Items> selectByItems(IRequest requestContext, Items items, int page, int pagesize) {
			// TODO Auto-generated method stub
			PageHelper.startPage(page, pagesize);
			return itemsMapper.selectByItems(items);
		}

		@Override
		public List<Items> update(IRequest requestContext, List<Items> Itemslist) {
			// TODO Auto-generated method stub
			return null;
		}

		

		
		
}
