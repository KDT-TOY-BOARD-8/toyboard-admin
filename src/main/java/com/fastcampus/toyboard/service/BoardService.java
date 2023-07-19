package com.fastcampus.toyboard.service;

import com.fastcampus.toyboard.dto.BoardUserDto;
import com.fastcampus.toyboard.repository.BoardUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {

    @Autowired
    private final BoardUserRepository boardUserRepository;

    public List<BoardUserDto> getBoardListWithUser(){
        return boardUserRepository.findAll();
    }

    public void updateHide(Long id, BoardUserDto boardUserDto){
        BoardUserDto board = new BoardUserDto();
        board.setId(boardUserDto.getId());

        if(boardUserDto.getHide() == false){
            board.setHide(true);
        }else{
            board.setHide(false);
        }

        boardUserRepository.updateHideById(board);
    }
}
