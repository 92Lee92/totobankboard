package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.Board;

public interface BoardRepository extends JpaRepository<Board, Integer>{

}
