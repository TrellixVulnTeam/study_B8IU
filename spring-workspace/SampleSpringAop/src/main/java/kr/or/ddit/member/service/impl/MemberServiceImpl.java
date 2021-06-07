package kr.or.ddit.member.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.member.mapper.MemberMapper;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	MemberMapper mapper;

	@Override
	public int insertMember(Map<String, Object> map) {
		return mapper.insert(map);
	}

	@Override
	public List<MemberVO> getMemberList(Map<String, Object> map) {
		List<MemberVO> MemberVo = mapper.readAll(map);
		return MemberVo;
	}

	@Override
	public int deleteMember(String id) {
		return mapper.delete(id);
	}

	@Override
	public MemberVO getMember(String id) {
		MemberVO MemberVo = mapper.read(id);
		return MemberVo;
	}

	@Override
	public int updateMember(Map<String, Object> map) {
		return mapper.update(map);
	}

}
