package hap.org.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hand.hap.core.IRequest;
import com.hand.hap.core.exception.BaseException;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.system.dto.ResponseData;

import hap.org.dto.Companys;
import hap.org.service.ICompanysService;


public class CompanysControllers  extends BaseController{
	 @Autowired
	    private ICompanysService icompanysService;
	    
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
	    @RequestMapping(value = "/org/companys/query")
	    @ResponseBody
	    public ResponseData getTasks(Companys companys, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
	            @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pagesize, HttpServletRequest request) {
	        IRequest requestContext = createRequestContext(request);
	        return new ResponseData(icompanysService.selectByCompanys(requestContext, companys, page, pagesize));
	    }
	    
	   
	    @RequestMapping(value = "/org/companys/submit", method = RequestMethod.POST)
	    @ResponseBody
	    public ResponseData submitCompanys(@RequestBody List<Companys> companyss, BindingResult result, HttpServletRequest request)
	            throws BaseException {
	        getValidator().validate(companyss, result);
	        if (result.hasErrors()) {
	            ResponseData rd = new ResponseData(false);
	            rd.setMessage(getErrorMessage(result, request));
	            return rd;
	        }
	        IRequest requestContext = createRequestContext(request);
	        return new ResponseData(icompanysService.batchUpdate(requestContext, companyss));
	    }
}
