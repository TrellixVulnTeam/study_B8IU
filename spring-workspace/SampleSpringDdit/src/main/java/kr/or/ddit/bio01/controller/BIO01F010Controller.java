package kr.or.ddit.bio01.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BIO01F010Controller {
	@RequestMapping(path = "/bio01/BIO01F010", method = RequestMethod.GET)
	public ModelAndView create() {
		return new ModelAndView("/bio01/BIO01F010");
	}

	@RequestMapping(path = "/bio01/BIO01F010", method = RequestMethod.POST)
	public ModelAndView create(@RequestParam Map<String, Object> map) {
		ModelAndView modelAndView = new ModelAndView();

		return null;
	}
}
