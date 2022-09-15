package com.gd.lms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gd.lms.vo.Board;

@Mapper
public interface BoardMapper {
	public List<Board> selectBoradList(int lectureNo);
}
