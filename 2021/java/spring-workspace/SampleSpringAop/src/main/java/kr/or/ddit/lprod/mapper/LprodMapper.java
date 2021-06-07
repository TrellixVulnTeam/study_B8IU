package kr.or.ddit.lprod.mapper;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.ddit.lprod.vo.LprodVO;

@Repository
public class LprodMapper {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public int insert(Map<String, Object> map) {
		//namespace가 lprod 이고 id가 insert인 xml을 찾음
		return this.sqlSessionTemplate.insert("lprod.insert",map);
	};
	
	public List<LprodVO> readAll(Map<String, Object> map){
		List<LprodVO> list = this.sqlSessionTemplate.selectList("lprod.select_list", map);
		return list;
	};
	
	public int update(Map<String,Object> map) {
		return this.sqlSessionTemplate.update("lprod.update",map);
	};
	
	public int delete(String id) {
		return this.sqlSessionTemplate.delete("lprod.delete",id);
	};
	
	public LprodVO read(String id) {
		LprodVO lprodVo = this.sqlSessionTemplate.selectOne("lprod.select_detail",id);
		return lprodVo;
	};
}
