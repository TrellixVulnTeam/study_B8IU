package kr.or.ddit.member.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MemberController {
	@Autowired
	MemberService service;

	@RequestMapping(value = "/member/create", method = RequestMethod.GET)
	public ModelAndView create(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/create");
		return mav;
	}

	@RequestMapping(value = "/member/create", method = RequestMethod.POST)
	public ModelAndView createPost(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		service.insertMember(map);
		log.info("memberId :" + map.get("memberId"));
		if (map.get("memberId") == null) {
			mav.setViewName("redirect:/member/create");
		} else {
			mav.setViewName("redirect:/member/detail?memberId=" + map.get("memberId"));

		}
		return mav;
	}

	@RequestMapping(value = "/member/detail", method = RequestMethod.GET)
	public ModelAndView detail(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		String memberId = (String) map.get("memberId");
		MemberVO memberVo = service.getMember(memberId);
		mav.addObject("memberVo", memberVo);
		mav.setViewName("member/detail");
		return mav;

	}

	@RequestMapping(value = "/member/list", method = RequestMethod.GET)
	public ModelAndView list(@RequestParam Map<String, Object> map, ModelAndView mav) {
		List<MemberVO> memberVo = this.service.getMemberList(map);
		mav.addObject("memberListVo", memberVo);
		mav.setViewName("member/list");
		return mav;
	}

	@RequestMapping(value = "/member/update", method = RequestMethod.POST)
	public ModelAndView updatePost(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		int result = this.service.updateMember(map);
		if (result > 0) { // 업데이트가 잘 되었다면..
			String memberId = map.get("memberId").toString();
			mav.setViewName("redirect:/member/detail?memberId=" + memberId + "&updateGu=success");
		} else { // 업데이트 대상이 없거나 업데이트 실패 시
			String memberId = map.get("memberId").toString();
			mav.setViewName("redirect:/member/detail?memberId=" + memberId + "&updateGu=fail");
		}

		return mav;
	}

	@RequestMapping(value = "/member/delete", method = RequestMethod.POST)
	public ModelAndView deletePost(@RequestParam Map<String, Object> map, ModelAndView mav) {
		int result = service.deleteMember((String) map.get("memberId"));
		if (result > 0) {
			mav.setViewName("redirect:/list");
		} else {
			String memberId = map.get("memberId").toString();
			mav.setViewName("redirect:/member/detail?memberId=" + memberId);
		}
		return mav;
	}

	@RequestMapping(value = "/member/login", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/loginForm");
		return mav;
	}

	@RequestMapping(value = "/member/login", method = RequestMethod.POST)
	public ModelAndView loginPost(@RequestParam Map<String, Object> map, HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		MemberVO memberVO = service.getMember(map.get("memberid").toString());

		if (memberVO != null && memberVO.getMemberid() != null && memberVO.getPassword().equals(map.get("password").toString())) {
			req.getSession().setAttribute("memberVO", memberVO);
		}

		mav.setViewName("member/loginForm");

		return mav;
	}
}
