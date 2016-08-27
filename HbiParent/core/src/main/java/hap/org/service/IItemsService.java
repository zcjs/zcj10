package hap.org.service;

import java.util.List;

import com.hand.hap.core.IRequest;
import com.hand.hap.core.ProxySelf;
import com.hand.hap.core.annotation.StdWho;
import com.hand.hap.system.service.IBaseService;

import hap.org.dto.Items;

public interface IItemsService extends IBaseService<Items>, ProxySelf<IItemsService>{
	 List<Items> selectByItems(IRequest requestContext, Items items, int page, int pagesize);
	    
	    List<Items> batchUpdate(IRequest requestContext, @StdWho List<Items> Itemslist);
	    
	    List<Items> update(IRequest requestContext, List<Items> Itemslist);
}
