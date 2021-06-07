package kr.or.ddit.member.mapper;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.ddit.member.vo.MemberVO;

@Repository
public class MemberMapper {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public int insert(Map<String, Object> map) {
		return this.sqlSessionTemplate.insert("member.insert",map);
	};
	
	public List<MemberVO> readAll(Map<String, Object> map){
		List<MemberVO> list = this.sqlSessionTemplate.selectList("member.select_list", map);
		return list;
	};
	
	public int update(Map<String,Object> map) {
		return this.sqlSessionTemplate.update("member.update",map);
	};
	
	public int delete(String id) {
		return this.sqlSessionTemplate.delete("member.delete",id);
	};
	
	public MemberVO read(String id) {
		MemberVO MemberVo = this.sqlSessionTemplate.selectOne("member.select_detail",id);
		return MemberVo;
	};
	
	public List<Map<String,Object>> selectListEtc(String id){
		return this.sqlSessionTemplate.selectList("member.select_list_etc",id);
		
	}
}
