package org.koreait.board.mappers;

import org.koreait.board.entities.BoardData;
import org.koreait.global.paging.SearchForm;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface BoardMapper {
    int register(BoardData item);
    int update(BoardData item);
    int delete(long seq);
    List<BoardData> getList();
    Optional<BoardData> get(long seq);
}
