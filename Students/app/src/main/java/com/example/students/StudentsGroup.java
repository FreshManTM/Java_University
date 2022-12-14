package com.example.students;

import java.util.ArrayList;
import java.util.Arrays;

public class StudentsGroup {
    private int id;
    private String  number;
    private String facultyName;
    private int educationLevel;
    private boolean contractExistsFlg;
    private boolean privilegeExistsFlg;

    public StudentsGroup(String number, String facultyName, int educationLevel, boolean contractExistsFlg, boolean privilageExistsFlg){
        this.number = number;
        this.facultyName = facultyName;
        this.educationLevel = educationLevel;
        this.contractExistsFlg = contractExistsFlg;
        this.privilegeExistsFlg = privilageExistsFlg;
    }
    public StudentsGroup(int id, String number, String facultyName, int educationLevel, boolean contractExistsFlg, boolean privilageExistsFlg){
    }

    public String getNumber(){
        return number;
    }

    public String getFacultyName(){
        return facultyName;
    }

    public int getEducationLevel(){
        return educationLevel;
    }
    public  boolean isContractExistsFlg(){
        return contractExistsFlg;
    }
    public boolean isPrivilegeExistsFlg(){
        return privilegeExistsFlg;
    }
    public int getId(){
        return id;
    }

    private static ArrayList<StudentsGroup> groups = new ArrayList<StudentsGroup>(
            Arrays.asList(
                    new StudentsGroup("301", "Комп'ютерних наук",0,true,false),
                    new StudentsGroup("302", "Комп'ютерних наук",0,true,false),
                    new StudentsGroup("308", "Комп'ютерних наук",0,true,true),
                    new StudentsGroup("309", "Комп'ютерних наук",1,false,false),
                    new StudentsGroup("501m", "Комп'ютерних наук",1,false,true)
            )
    );

    public static StudentsGroup getGroup(String groupNumber){
        for (StudentsGroup g: groups){
            if(g.getNumber().equals(groupNumber)){
                return g;
            }
        }
        return null;
    }
    public static ArrayList<StudentsGroup> getGroups(){
        return groups;
    }
    @Override
    public String toString(){
        return number;
    }

    public static void addGroup(StudentsGroup group){groups.add(group);}
}
