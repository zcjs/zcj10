package hap.org.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.service.impl.BaseServiceImpl;

import hap.org.dto.Companys;
import hap.org.dto.Headers;
import hap.org.mapper.CompanysMapper;
import hap.org.mapper.HeadersMapper;
import hap.org.service.IHeadersService;



@Service
public class HeadersServiceImpl extends BaseServiceImpl<Headers> implements IHeadersService{

	 @Autowired
	    private HeadersMapper headersMapper;
	 @Autowired
	 private CompanysMapper companysMapper;

		@Override
		public List<Headers> selectByHeaders(IRequest requestContext, Headers headers, int page, int pagesize) {
			// TODO Auto-generated method stub
			PageHelper.startPage(page, pagesize);
			return headersMapper.selectByHeaders(headers);
		}
		


//插入
	@Override
		public void insertHeaders(IRequest requestContext, Headers headers) {
			// TODO Auto-generated method stub
				headersMapper.insertHeaders(headers);
		}



	@Override
	public List<Headers> update(IRequest requestContext, List<Headers> headerslist) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public int selectby(IRequest requestContext, Companys companys) {
		// TODO Auto-generated method stub
		return headersMapper.selectby(companys);

	}}
