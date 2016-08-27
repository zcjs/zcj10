/*
 * #{copyright}#
 */

package hfs.ass.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.system.dto.ResponseData;

import hfs.ass.dto.Fruit;
import hfs.ass.service.IFruitService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hand.hap.core.IRequest;
import com.hand.hap.core.exception.BaseException;
import com.hand.hap.mail.dto.MessageTemplate;

/**
 * 水果控制器.
 * 
 * @author taotao.xu@hand-china.com
 */
@Controller
public class FruitController extends BaseController {

    @Autowired
    private IFruitService fruitService;
    
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
    @RequestMapping(value = "/ass/fruit/query")
    @ResponseBody
    public ResponseData getTasks(Fruit fruit, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
            @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pagesize, HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        return new ResponseData(fruitService.selectByFruit(requestContext, fruit, page, pagesize));
    }
    
    /**
     * 保存水果.
     * 
     * @param fruits
     *            fruits
     * @param result
     *            BindingResult
     * @param request
     *            HttpServletRequest
     * @return ResponseData ResponseData
     * @throws BaseException
     *             BaseException
     */
    @RequestMapping(value = "/ass/fruit/submit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData submitFruit(@RequestBody List<Fruit> fruits, BindingResult result, HttpServletRequest request)
            throws BaseException {
        getValidator().validate(fruits, result);
        if (result.hasErrors()) {
            ResponseData rd = new ResponseData(false);
            rd.setMessage(getErrorMessage(result, request));
            return rd;
        }
        IRequest requestContext = createRequestContext(request);
        return new ResponseData(fruitService.batchUpdate(requestContext, fruits));
    }
    //编辑的update
  /*  @ResponseBody
    @RequestMapping(value="/ass/fruit/update")
    public ResponseData updateMessageTemplate(HttpServletRequest request, @RequestBody Fruit obj, BindingResult result) throws BaseException {
        //没意义的值
        obj.setObjectVersionNumber(0L);
        
        getValidator().validate(obj, result);
        if (result.hasErrors()) {
            ResponseData responseData = new ResponseData(false);
            responseData.setMessage(getErrorMessage(result, request));
            return responseData;
        }
        IRequest requestContext = createRequestContext(request);
        fruitService.updateByPrimaryKey(requestContext, obj);
        return new ResponseData();
        
    }*/
    @ResponseBody
    @RequestMapping(value = "/ass/fruit/update", method = RequestMethod.POST)
    public ResponseData updateFruit(HttpServletRequest request, @RequestBody List<Fruit> fruitList){    	
    	IRequest requestContext = createRequestContext(request);
    	return new ResponseData(fruitService.update(requestContext, fruitList));
    }
}
