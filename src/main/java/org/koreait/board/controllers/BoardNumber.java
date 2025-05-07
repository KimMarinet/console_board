package org.koreait.board.controllers;

import org.apache.ibatis.session.SqlSession;
import org.koreait.board.mappers.BoardMapper;
import org.koreait.global.configs.DBConn;
import org.koreait.board.entities.BoardData;
import org.koreait.global.router.Controller;

import java.util.List;
import java.util.Scanner;

import static org.koreait.member.MemberSession.isAdmin;
import static org.koreait.member.MemberSession.isLogin;

public class BoardNumber extends Controller{
    @Override
    public void common() {
        System.out.println("*************** 게시판 *******************");
    }

    @Override
    public void show() {
        Scanner sc = new Scanner(System.in);
        SqlSession session = DBConn.getInstance().getSession();
        try {

            BoardMapper mapper = session.getMapper(BoardMapper.class);
            List<BoardData> list1 = mapper.getList();  // DB에서 불러오기
            int a=0;
            for (BoardData b : list1) {
                System.out.printf("[%d] %s / %s\n", b.getSeq(), b.getSubject(), b.getPoster());
                a++;
            }
            int choice = Integer.parseInt(sc.nextLine());
            if (choice<=a){
                BoardData c= list1.get(choice-1);
                System.out.printf("제목:%s\n작성자: %s\n내용:%s\n", c.getSubject(), c.getPoster(),c.getContent());
            }
            else {
                System.out.println("존재하지 않는 글입니다.");
            }


            session.commit(); // 필요한 경우
        } finally {
            session.close(); // 항상 닫기
        }

    }
}

