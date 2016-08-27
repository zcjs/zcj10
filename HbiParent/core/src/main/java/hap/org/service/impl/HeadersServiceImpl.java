package hap.org.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.service.impl.BaseServiceImpl;

import hap.org.dto.Headers;
import hap.org.mapper.HeadersMapper;
import hap.org.service.IHeadersService;
@Service
public class HeadersServiceImpl extends BaseServiceImpl<Headers> implements IHeadersService{

	 @Autowired
	    private HeadersMapper headersMapper;

		@Override
		public List<Headers> selectByHeaders(IRequest requestContext, Headers headers, int page, int pagesize) {
			// TODO Auto-generated method stub
			PageHelper.startPage(page, pagesize);
			return headersMapper.selectByHeaders(headers);
		}
		


//插入
	
		@Override
		public List<Headers> insertHeaders(IRequest requestContext, List<Headers> headerslist) {
			// TODO Auto-generated method stub
			for (Headers headers : headerslist) {
				headersMapper.insertHeaders(headers);
				System.out.println(headers);
	        }
			
	        return headerslist;
		}



		@Override
		public List<Headers> update(IRequest requestContext, List<Headers> headerslist) {
			// TODO Auto-generated method stub
			return null;
		}



		







}
