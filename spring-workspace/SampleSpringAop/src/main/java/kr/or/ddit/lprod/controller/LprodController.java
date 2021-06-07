package kr.or.ddit.lprod.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.lprod.service.LprodService;
import kr.or.ddit.lprod.vo.LprodVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j 
@Controller
public class LprodController {
	@Autowired
	LprodService service;
	
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public ModelAndView create(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("lprod/create");
		return mav;
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public ModelAndView createPost(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		service.insertLprod(map);
		log.info("lprodId :" +map.get("lprodId"));
		if(map.get("lprodId")==null) {
			mav.setViewName("redirect:/create");
		}else {
			mav.setViewName("redirect:/detail?lprodId="+map.get("lprodId"));
			
		}
		return mav;
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public ModelAndView detail(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		String lprodId = (String) map.get("lprodId");
		LprodVO lprodVo = service.getLprod(lprodId);
		mav.addObject("lprodVo",lprodVo);
		mav.setViewName("lprod/detail");
		return mav;
		
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list(@RequestParam Map<String,Object> map ,ModelAndView mav ){
		List<LprodVO> lprodVo =  this.service.getLprodList(map);
		mav.addObject("lprodListVo",lprodVo);
		mav.setViewName("lprod/list");
		return mav;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView updatePost(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		int result = this.service.updateLprod(map);
		if(result>0) { //업데이트가 잘 되었다면..
			String lprodId = map.get("lprodId").toString();
			mav.setViewName("redirect:/detail?lprodId=" + lprodId + "&updateGu=success");
		}else {	//업데이트 대상이 없거나 업데이트 실패 시
			String lprodId = map.get("lprodId").toString();
			mav.setViewName("redirect:/detail?lprodId=" + lprodId + "&updateGu=fail");
		}
		
		return mav;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ModelAndView deletePost(@RequestParam Map<String,Object> map, ModelAndView mav) {
		int result = service.deleteLprod((String)map.get("lprodId"));
		if(result>0) {
			mav.setViewName("redirect:/list");
		}else {
			String lprodId = map.get("lprodId").toString();
			mav.setViewName("redirect:/detail?lprodId="+lprodId);
		}
		return mav;
	}
	
	
}
