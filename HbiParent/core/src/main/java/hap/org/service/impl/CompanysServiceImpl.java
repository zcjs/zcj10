package hap.org.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.dto.DTOStatus;
import com.hand.hap.system.service.impl.BaseServiceImpl;

import hap.org.dto.Companys;
import hap.org.mapper.CompanysMapper;
import hap.org.service.ICompanysService;

@Service
public class CompanysServiceImpl extends BaseServiceImpl<Companys> implements ICompanysService{
	 @Autowired
	    private CompanysMapper companysMapper;

		@Override
		public List<Companys> selectByCompanys(IRequest requestContext, Companys companys, int page, int pagesize) {
			// TODO Auto-generated method stub
			PageHelper.startPage(page, pagesize);
			return companysMapper.selectByCompanys(companys);
		}
		
		@Override
		@Transactional(propagation = Propagation.SUPPORTS)
	    public List<Companys> batchUpdate(IRequest requestContext, List<Companys> companyss ) {
	        // TODO Auto-generated method stub
	        for (Companys companys : companyss) {
	            if (companys.get__status() != null) {
	                switch (companys.get__status()) {
	                case DTOStatus.ADD:
	                	/*Date date = new Date();
	                	long datetime = date.getTime();
	                	Timestamp timestamp = new Timestamp(datetime);
	                	fruit.setMyDate(timestamp);*/
	                	companysMapper.insertCompanys(companys);
	                    break;
	                case DTOStatus.UPDATE:
	                	companysMapper.updateCompanys(companys);
	                    break;
	                case DTOStatus.DELETE:
	                	companysMapper.deleteCompanys(companys);
	                    break;
	                default:
	                    break;
	                }
	            }
	        }
	        return companyss;
	    }
		@Override
		public List<Companys> update(IRequest requestContext, List<Companys> companyslist) {
			// TODO Auto-generated method stub
			for (Companys companys : companyslist) {
				companysMapper.updateCompanys(companys);
	        }
	        return companyslist;
		}
}
