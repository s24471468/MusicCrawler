package com.musiccrawler;

import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Main {

    public static void main(String[] args) {

        try{
            ArrayList<String> listOfTeachers, listOfStudents, listOfSpecStudents;
            int count = 1;
            //Specify webpage to scrape
            Document doc = Jsoup.connect("https://en.wikipedia.org/wiki/List_of_music_students_by_teacher:_A_to_B").get();

            //Target specific element on page (see jsoup Element.select() examples)
            Elements allTeachers = doc.select("h3 > .mw-headline");
            //TODO: DETERMINE HOW TO HANDLE TEACHERS WHOSE STUDENTS LISTS DO NOT FOLLOW ".div-col > ul" (NADIA and ARNELL's students)
            Elements allStudents = doc.select(".div-col > ul");

            //store each element as plain text within respective arraylist
            listOfTeachers = new ArrayList<>(allTeachers.eachText());
            //listOfStudents = new ArrayList<>(allStudents.eachText());

            System.out.println("***LIST OF TEACHERS***");
            for(String teachers: listOfTeachers) {
                System.out.print(count + ". ");
                System.out.println(teachers);
                count++;
            }
            System.out.println("****************************");
            System.out.println();

            count = 1;
            Elements specStudents;
            for (int i = 0;i<allStudents.size();i++) {
                if (i == 58) {
                    i += 3;
                } else {
                    specStudents = allStudents.get(i).select("li > a");
                }
                System.out.println();
                count++;
            }

            /*for (Element e: allStudents) {
                Elements specStudents = e.select("li > a");
                listOfSpecStudents = new ArrayList<>(specStudents.eachText());
                for (String student: listOfSpecStudents) {
                    System.out.print(count+ ". " + student + " ");
                }
                System.out.println();
                count++;
            }*/


            /*List<String> listOfStudents;
            Elements table2 = doc.select(".div-col > ul > li > a");
            listOfStudents = table2.eachText();
            count = 1;
            System.out.println("***LIST OF STUDENTS***");
            for(String students: listOfStudents) {
                System.out.print(count + ". ");
                System.out.println(students);
                count++;
            }
            System.out.println("****************************");
            System.out.println(); */

            /*List<String> teacherTeachers;
            Elements table3 = doc.select(".mw-collapsible-content > a");
            teacherTeachers = table3.eachText();
            count = 1;
            System.out.println("***LIST OF TEACHER'S TEACHERS***");
            for(String tteach: teacherTeachers) {
                System.out.print(count + ". ");
                System.out.println(tteach);
                count++;
            }*/

        } catch(Exception e) {
            e.printStackTrace();
        }

    }
}
