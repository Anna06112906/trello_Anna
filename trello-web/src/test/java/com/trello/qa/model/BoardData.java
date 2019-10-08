package com.trello.qa.model;

public class BoardData {
    private String boardName;
    private String s;



    public BoardData withBoardName(String boardName) {
        this.boardName = boardName;
        return this;
    }

    public BoardData withS(String s) {
        this.s = s;
        return this;
    }

    public String getBoardName() {
        return boardName;
    }

    @Override
    public String toString() {
        return "BoardData{" +
                "boardName='" + boardName + '\'' +
                '}';
    }

    public String getS() {
        return s;
    }
}
