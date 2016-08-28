package hap.org.controllers;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hand.hap.core.IRequest;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.system.dto.ResponseData;

import hap.org.dto.Companys;
import hap.org.dto.Headers;
import hap.org.service.IHeadersService;
@Controller
public class HeadersControllers extends BaseController{
	    @Autowired
	    private IHeadersService iheadersService;
	    
	    /**
	     * 任务分配查询.
	     * 
	     * @param fruit
	     *            分配对象
	     * @param page
	     *            起始页
	     * @param pagesize
	     *            分页大小
	     * @param request
	     *            HttpServletRequest
	     * @return ResponseData
	     */
	    //查询
	    @RequestMapping(value = "/org/Headers/query",method = RequestMethod.POST)
	    @ResponseBody
	    public ResponseData getTasks(Headers headers, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
	            @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pagesize, HttpServletRequest request) 
	    {
	        IRequest requestContext = createRequestContext(request);
	        return new ResponseData(iheadersService.selectByHeaders(requestContext, headers, page, pagesize));
	    }
	    //插入
	    @ResponseBody
	    @RequestMapping(value = "/org/headers/submit",method = RequestMethod.POST)
	    public void insertHeaders(HttpServletRequest request, @RequestBody List<Headers> headerslist)
	    {    	
	    	IRequest requestContext = createRequestContext(request);
	    	String ss = headerslist.get(0).getCompanyName();
	    	Companys com = new Companys();
	    	com.setCompanyName(ss);
	    	long s = iheadersService.selectby(requestContext, com);
	    	
	    	Headers headers =  headerslist.get(0);
	    	headers.setCompanyId(s);
	    	 iheadersService.insertHeaders(requestContext, headers);
	    }
	   
	    
}
