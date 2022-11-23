package controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import entity.Board;
import service.BoardService;

@RestController
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@PostMapping("/writeboard")
	public ResponseEntity<String> writeboard(@RequestParam("writer") String writer,
			@RequestParam("password") String password, 
			@RequestParam("subject") String subject,
			@RequestParam("content") String content,
			@RequestParam(name="file", required=false) MultipartFile file)	{
		
		ResponseEntity<String> res = null;
		try {
			if(!file.isEmpty()) {
				String path = "C;/react/upload";
				File dFile = new File(path+file.getOriginalFilename());
				file.transferTo(dFile);
				boardService.writeBoard(
						new Board(null, writer,password,subject,content,file.getOriginalFilename());
			}
			res = new ResponseEntity<String>("r게저성", HttpStatus.OK);
			}catch(Exception e) {
				e.printStackTrace();
				res = new RespOonseEnity<String>("게저실", HttpStatus.BAD_REQUEST);
		}
			return res;
		
	}
		
}
