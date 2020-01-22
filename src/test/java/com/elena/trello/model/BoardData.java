package com.elena.trello.model;

public class BoardData {
  private  String boardName;
  String team;


  public BoardData setBoardName(String boardName) {
    this.boardName = boardName;
    return  this;
  }


  public String getBoardName() {
    return boardName;
  }

  @Override
  public String toString() {
    return "BoardData " +
            "boardName='" + boardName + '\'' +
            '}';
  }
}
