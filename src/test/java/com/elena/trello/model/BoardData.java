package com.elena.trello.model;

public class BoardData {
  private  String boardName;
  String team;



  public BoardData(String boardName) {
    this.boardName = boardName;
  }

  public String getBoardName() {
    return boardName;
  }

}
