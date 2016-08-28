package hap.org.service;

import java.util.List;

import com.hand.hap.core.IRequest;
import com.hand.hap.core.ProxySelf;
import com.hand.hap.core.annotation.StdWho;
import com.hand.hap.system.service.IBaseService;

import hap.org.dto.Companys;
import hap.org.dto.Headers;

public interface IHeadersService extends IBaseService<Headers>, ProxySelf<IHeadersService>{
	//查询
	 List<Headers> selectByHeaders(IRequest requestContext, Headers headers, int page, int pagesize);
	    
	    List<Headers> batchUpdate(IRequest requestContext, @StdWho List<Headers> headerslist);
	    
	    List<Headers> update(IRequest requestContext, List<Headers> headerslist);
	    
	    
	    //插入
	    void insertHeaders(IRequest requestContext, Headers headers);
	    
	    
	    //查询companyID
	    int selectby(IRequest requestContext, Companys company);
}
