package org.koreait.board.controllers;

import org.koreait.global.router.Controller;
import org.koreait.global.router.Router;
import org.koreait.main.controllers.MainController;
import org.koreait.member.MemberSession;

import java.util.List;

public class BoardController extends Controller {
    public BoardController() {
        setMenus(List.of("1","2","3","4","5"));
    }
    @Override
    public void show() {
        // 로그인 상태가 아니라면 메인 페이지로 이동
        if (!MemberSession.isLogin()) {
            System.out.println("로그인이 필요합니다.");
            Router.change(MainController.class);
            return;
        }
        StringBuffer sb = new StringBuffer(3500);
        sb.append("1. 게시글 작성\n")
                .append("2. 게시글 목록\n")
                .append("3. 게시글 수정\n")
                .append("4. 게시글 삭제\n")
                .append("5. 돌아가기");
        System.out.println(sb);
    }

    @Override
    public void process(String command) {
        int menu = Integer.parseInt(command);

        switch (menu){
            case 1:
                Router.change(BoardWriteController.class); //게시글 작성 화면으로 이동
                break;
            case 2:
                Router.change(BoardListController.class); //게시글 작성 화면으로 이동
                break;
            case 3:
                Router.change(MyBoardListController.class);
                break;
            case 4:
                Router.change(BoardDeleteController.class);
                break;
            case 5:
                Router.change(MainController.class);
        }
    }
}
