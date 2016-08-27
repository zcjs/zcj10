package hap.org.service;

import java.util.List;

import com.hand.hap.core.IRequest;
import com.hand.hap.core.ProxySelf;
import com.hand.hap.core.annotation.StdWho;
import com.hand.hap.system.service.IBaseService;

import hap.org.dto.Customer;

public interface ICustomerService extends IBaseService<Customer>, ProxySelf<ICustomerService>{
	 List<Customer> selectByCustomer(IRequest requestContext, Customer customer, int page, int pagesize);
	    
	    List<Customer> batchUpdate(IRequest requestContext, @StdWho List<Customer> customerlist);
	    
	    List<Customer> update(IRequest requestContext, List<Customer> customerlist);
}
