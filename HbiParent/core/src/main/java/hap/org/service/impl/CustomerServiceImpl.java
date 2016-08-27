package hap.org.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hand.hap.core.IRequest;
import com.hand.hap.system.dto.DTOStatus;
import com.hand.hap.system.service.impl.BaseServiceImpl;

import hap.org.dto.Customer;
import hap.org.mapper.CustomerMapper;
import hap.org.service.ICustomerService;
@Service
public class CustomerServiceImpl extends BaseServiceImpl<Customer> implements ICustomerService{

	@Autowired
    private CustomerMapper customerMapper;

	/*@Override
	public List<Customer> selectByCustomer(IRequest requestContext, Companys companys, int page, int pagesize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, pagesize);
		return customerMapper.selectByCustomer(companys);
	}*/
	
	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
    public List<Customer> batchUpdate(IRequest requestContext, List<Customer> customers ) {
        // TODO Auto-generated method stub
        for (Customer customer : customers) {
            if (customer.get__status() != null) {
                switch (customer.get__status()) {
                case DTOStatus.ADD:
                	/*Date date = new Date();
                	long datetime = date.getTime();
                	Timestamp timestamp = new Timestamp(datetime);
                	fruit.setMyDate(timestamp);*/
                	customerMapper.insertCustomer(customer);
                    break;
                case DTOStatus.UPDATE:
                	customerMapper.updateCustomer(customer);
                    break;
                case DTOStatus.DELETE:
                	customerMapper.deleteCustomer(customer);
                    break;
                default:
                    break;
                }
            }
        }
        return customers;
    }
	@Override
	public List<Customer> update(IRequest requestContext, List<Customer> customerlist) {
		// TODO Auto-generated method stub
		for (Customer customer : customerlist) {
			customerMapper.updateCustomer(customer);
        }
        return customerlist;
	}

	@Override
	public List<Customer> selectByCustomer(IRequest requestContext, Customer customer, int page, int pagesize) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
