package com.elena.trello.tests;

import com.elena.trello.model.BoardData;
import com.elena.trello.model.TeamData;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

  @DataProvider
  public Iterator<Object[]> validTeams(){
    List<Object[]> list = new ArrayList<>();
    list.add(new Object[]{"name DP","decsription DP"});
    list.add(new Object[]{"DPn",""});
    return list.iterator();
  }

  @DataProvider
  public Iterator<Object[]> validTeamsCSV() throws IOException {
    List<Object[]> list = new ArrayList<>();
    BufferedReader  reader= new BufferedReader(
            new FileReader(new File("src/test/resources/teamsPositiveCSV.csv")));
    String line = reader.readLine();
    while (line!=null){
      String[] split = line.split(",");
      list.add(new Object[] {
              new TeamData()
                      .withTeamName(split[0])
                      .withTeamDescr(split[1])});

      line = reader.readLine();
    }
    return list.iterator();
  }
  @DataProvider
  public Iterator<Object[]> validBoards() throws IOException {
    List<Object[]> list = new ArrayList<>();
    BufferedReader reader = new BufferedReader(
            new FileReader(new File("src/test/resources/boardsData.csv")));

    String line = reader.readLine();
    while (line != null) {
      String[] split = line.split(",");
      list.add(new Object[]{new BoardData().setBoardName(split[0])});
      line = reader.readLine();
    }
    return list.iterator();
  }
}
