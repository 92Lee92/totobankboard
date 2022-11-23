package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.Board;
import repository.BoardRepository;

@Service
public class BoardService {
	
	@Autowired
	BoardRepository boardRepository;
	
	public void wirteBoard(Board board) throws Exception {
		boardRepository.save(board);
	}
}
