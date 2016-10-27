/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package executioner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Salman
 */
public class Executioner {

    /**
     * @param args the command line arguments
     */
    public Executioner() {
    }

    public void file(Map<String, List<String>> xx, String csv_File) throws IOException {

        FileWriter writer = new FileWriter(csv_File);
        for (String start : xx.keySet()) {
            for (String end : xx.keySet()) {

                StringBuilder sb = new StringBuilder();
                sb.append(start + "-to-" + end);
                sb.append(",");
                Map<String, String> path;
                path = new HashMap<>();
                if (start == null ? end != null : !start.equals(end)) {
                    path = recursearch(xx, start, end);
                    int count = 0;
                    if (path != null) {
                        String check = end;

                        do {
                            count++;
                            check = path.get(check);

                            sb.append(check);
                            sb.append(",");

                            //System.out.println(check); 
                        } while (check == null ? start != null : !check.equals(start));

                    }
                    sb.append(count);
                    sb.append(",");
                    sb.append("\n");

                    writer.append(sb.toString());
                    writer.flush();

                }
            }
        }
    }

    Map<String, String> recursearch(Map<String, List<String>> m, String start, String end) {
        /*   for (String name: m.keySet()){

            String key =name.toString();
            String value = m.get(name).toString();
            
        
  
            System.out.println(key + " " + value);  


} */
        Map<String, String> explored;
        explored = new HashMap<>();
        Map<String, String> track;
        track = new HashMap<>();
        // ArrayList<String> explored = new ArrayList<>();
        //ArrayList<String>  track = new ArrayList<>();
        int kkx = 0;
        int check = 1;

        Queue<String> frontier = new LinkedList();
        String parent;
        frontier.add(start);
        while (!(frontier.isEmpty())) {
            parent = frontier.remove();

            if (parent == null ? end == null : parent.equals(end)) {
                System.out.println("parent");
                return track;
            }
            /* kkx = 0;
         if(check==2){
         for(String s : explored){
         if(s==parent){
         kkx=1;
         }
     }
         }else{check++;}*/

            if (explored.get(parent) == null) {
                explored.put(parent, "yes");
                List<String> successor = m.get(parent);
                for (String success : successor) {
                    // System.out.println(success);
                    if (explored.get(success) == null) {
                        frontier.add(success);
                        if (track.get(parent) == null ? success != null : !track.get(parent).equals(success)) {
                            track.put(success, parent);
                        }
                        if (success == null ? end == null : success.equals(end)) {
                            return track;
                        }
                    }
                }
            }

        }

        return null;
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        Scanner scan = new Scanner(System.in);
        String csvFile = "dic.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = "  ";
        Map<String, List<String>> values;
        values = new HashMap<>();
        Map<String, List<String>> values3;
        values3 = new HashMap<>();
        Map<String, List<String>> values2;
        values2 = new HashMap<>();
        Map<String, List<String>> values5;
        values5 = new HashMap<>();
        Map<String, List<String>> values6;
        values6 = new HashMap<>();
        Map<String, List<String>> values7;
        values7 = new HashMap<>();
        Map<String, List<String>> values8;
        values8 = new HashMap<>();
        try {
            //for 2 leter words//for 2 leter words//for 2 leter words//for 2 leter words
            br = new BufferedReader(new FileReader(csvFile));
            int i2 = 0;

            while ((line = br.readLine()) != null) {
                if (i2 > 1) {
                    ArrayList<String> obj = new ArrayList<>();
                    // use comma as separator
                    String[] country = line.split(cvsSplitBy);
                    String y = country[0];
                    if (y.length() == 2) {

                        values2.put(y, obj);

                    }

                }

                i2++;
            }

            for (String name : values2.keySet()) {

                String key = name.toString();
                String[] ary = key.split("");
                for (char a = 'a'; a < 'z'; a++) {
                    StringBuilder sb = new StringBuilder();

                    String stringValueOf = String.valueOf(a);
                    if (ary[0] != stringValueOf) {
                        sb.append(a);
                        sb.append(ary[1]);

                        String nkey = sb.toString();
                        List<String> bb;
                        bb = values2.get(nkey);
                        if (bb != null) {
                            if (nkey == null ? key != null : !nkey.equals(key)) {
                                values2.get(key).add(nkey);

                            }
                        }
                    }

                }
                //new
                for (char a = 'a'; a < 'z'; a++) {
                    StringBuilder sb = new StringBuilder();

                    String stringValueOf = String.valueOf(a);
                    if (ary[1] != stringValueOf) {
                        sb.append(ary[0]);
                        sb.append(a);

                        String nkey = sb.toString();
                        List<String> bb;
                        bb = values2.get(nkey);
                        if (bb != null) {
                            if (nkey == null ? key != null : !nkey.equals(key)) {
                                values2.get(key).add(nkey);

                            }
                        }
                    }

                }
                //new

                //String value = values2.get(name).toString(); 
//System.out.println(value); 
            }
            Executioner myapaas = new Executioner();
              String cFile = "C:/Users/Salman/Documents/NetBeansProjects/doubleword.csv";
               myapaas.file(values2,cFile);
            //for 3leter word //for 3leter word //for 3leter word //for 3leter word
            br = new BufferedReader(new FileReader(csvFile));
            int i3 = 0;

            while ((line = br.readLine()) != null) {
                if (i3 > 1) {
                    ArrayList<String> obj = new ArrayList<>();
                    // use comma as separator
                    String[] country = line.split(cvsSplitBy);
                    String y = country[0];
                    if (y.length() == 3) {

                        values3.put(y, obj);

                    }

                }

                i3++;
            }

            for (String name : values3.keySet()) {

                String key = name.toString();
                String[] ary = key.split("");
                for (char a = 'a'; a < 'z'; a++) {
                    StringBuilder sb = new StringBuilder();

                    String stringValueOf = String.valueOf(a);
                    if (ary[0] != stringValueOf) {
                        sb.append(a);
                        sb.append(ary[1]);
                        sb.append(ary[2]);

                        String nkey = sb.toString();
                        List<String> bb;
                        bb = values3.get(nkey);
                        if (bb != null) {
                            if (nkey == null ? key != null : !nkey.equals(key)) {
                                values3.get(key).add(nkey);

                            }
                        }
                    }

                }
                //new
                for (char a = 'a'; a < 'z'; a++) {
                    StringBuilder sb = new StringBuilder();

                    String stringValueOf = String.valueOf(a);
                    if (ary[1] != stringValueOf) {
                        sb.append(ary[0]);
                        sb.append(a);
                        sb.append(ary[2]);

                        String nkey = sb.toString();
                        List<String> bb;
                        bb = values3.get(nkey);
                        if (bb != null) {
                            if (nkey == null ? key != null : !nkey.equals(key)) {
                                values3.get(key).add(nkey);

                            }
                        }
                    }

                }
                //new
                for (char a = 'a'; a < 'z'; a++) {
                    StringBuilder sb = new StringBuilder();

                    String stringValueOf = String.valueOf(a);
                    if (ary[2] != stringValueOf) {
                        sb.append(ary[0]);
                        sb.append(ary[1]);
                        sb.append(a);

                        String nkey = sb.toString();
                        List<String> bb;
                        bb = values3.get(nkey);
                        if (bb != null) {
                            if (nkey == null ? key != null : !nkey.equals(key)) {
                                values3.get(key).add(nkey);

                            }
                        }
                    }

                }

            }
             String c_File = "C:/Users/Salman/Documents/NetBeansProjects/triword.csv";
             myapaas.file(values3,c_File);
//for 4 letter words//for 4 letter words//for 4 letter words//for 4 letter words

            br = new BufferedReader(new FileReader(csvFile));
            int i = 0;

            while ((line = br.readLine()) != null) {
                if (i > 1) {
                    ArrayList<String> obj = new ArrayList<>();
                    // use comma as separator
                    String[] country = line.split(cvsSplitBy);
                    String y = country[0];
                    if (y.length() == 4) {

                        values.put(y, obj);

                    }

                }

                i++;
            }

            for (String name : values.keySet()) {

                String key = name.toString();
                String[] ary = key.split("");
                for (char a = 'a'; a < 'z'; a++) {
                    StringBuilder sb = new StringBuilder();

                    String stringValueOf = String.valueOf(a);
                    if (ary[0] != stringValueOf) {
                        sb.append(a);
                        sb.append(ary[1]);
                        sb.append(ary[2]);
                        sb.append(ary[3]);
                        String nkey = sb.toString();
                        List<String> bb;
                        bb = values.get(nkey);
                        if (bb != null) {
                            if (nkey == null ? key != null : !nkey.equals(key)) {
                                values.get(key).add(nkey);

                            }
                        }
                    }

                }
                //new
                for (char a = 'a'; a < 'z'; a++) {
                    StringBuilder sb = new StringBuilder();

                    String stringValueOf = String.valueOf(a);
                    if (ary[1] != stringValueOf) {
                        sb.append(ary[0]);
                        sb.append(a);
                        sb.append(ary[2]);
                        sb.append(ary[3]);
                        String nkey = sb.toString();
                        List<String> bb;
                        bb = values.get(nkey);
                        if (bb != null) {
                            if (nkey == null ? key != null : !nkey.equals(key)) {
                                values.get(key).add(nkey);

                            }
                        }
                    }

                }
                //new
                for (char a = 'a'; a < 'z'; a++) {
                    StringBuilder sb = new StringBuilder();

                    String stringValueOf = String.valueOf(a);
                    if (ary[2] != stringValueOf) {
                        sb.append(ary[0]);
                        sb.append(ary[1]);
                        sb.append(a);
                        sb.append(ary[3]);
                        String nkey = sb.toString();
                        List<String> bb;
                        bb = values.get(nkey);
                        if (bb != null) {
                            if (nkey == null ? key != null : !nkey.equals(key)) {
                                values.get(key).add(nkey);

                            }
                        }
                    }

                }
                //new
                for (char a = 'a'; a < 'z'; a++) {
                    StringBuilder sb = new StringBuilder();

                    String stringValueOf = String.valueOf(a);
                    if (ary[3] != stringValueOf) {
                        sb.append(ary[0]);
                        sb.append(ary[1]);
                        sb.append(ary[2]);
                        sb.append(a);
                        String nkey = sb.toString();
                        List<String> bb;
                        bb = values.get(nkey);
                        if (bb != null) {
                            if (nkey == null ? key != null : !nkey.equals(key)) {
                                values.get(key).add(nkey);
                                // System.out.println(key+" "+nkey);
                            }
                        }
                    }

                }
                //  String value = values.get(name).toString();  

            }
             String cc_File = "C:/Users/Salman/Documents/NetBeansProjects/foruletterword.csv";
              myapaas.file(values,cc_File);
            //for 5 letter word
            br = new BufferedReader(new FileReader(csvFile));
            int i5 = 0;

            while ((line = br.readLine()) != null) {
                if (i5 > 1) {
                    ArrayList<String> obj = new ArrayList<>();
                    // use comma as separator
                    String[] country = line.split(cvsSplitBy);
                    String y = country[0];
                    if (y.length() == 5) {

                        values5.put(y, obj);

                    }

                }

                i5++;
            }

            for (String name : values5.keySet()) {

                String key = name.toString();
                String[] ary = key.split("");
                for (char a = 'a'; a < 'z'; a++) {
                    StringBuilder sb = new StringBuilder();

                    String stringValueOf = String.valueOf(a);
                    if (ary[0] == null ? stringValueOf != null : !ary[0].equals(stringValueOf)) {
                        sb.append(a);
                        sb.append(ary[1]);
                        sb.append(ary[2]);
                        sb.append(ary[3]);
                        sb.append(ary[4]);
                        String nkey = sb.toString();
                        List<String> bb;
                        bb = values5.get(nkey);
                        if (bb != null) {
                            if (nkey == null ? key != null : !nkey.equals(key)) {
                                values5.get(key).add(nkey);

                            }
                        }
                    }

                }
                //new
                for (char a = 'a'; a < 'z'; a++) {
                    StringBuilder sb = new StringBuilder();

                    String stringValueOf = String.valueOf(a);
                    if (ary[1] != stringValueOf) {
                        sb.append(ary[0]);
                        sb.append(a);
                        sb.append(ary[2]);
                        sb.append(ary[3]);
                        sb.append(ary[4]);
                        String nkey = sb.toString();
                        List<String> bb;
                        bb = values5.get(nkey);
                        if (bb != null) {
                            if (nkey == null ? key != null : !nkey.equals(key)) {
                                values5.get(key).add(nkey);

                            }
                        }
                    }

                }
                //new
                for (char a = 'a'; a < 'z'; a++) {
                    StringBuilder sb = new StringBuilder();

                    String stringValueOf = String.valueOf(a);
                    if (ary[2] != stringValueOf) {
                        sb.append(ary[0]);
                        sb.append(ary[1]);
                        sb.append(a);
                        sb.append(ary[3]);
                        sb.append(ary[4]);
                        String nkey = sb.toString();
                        List<String> bb;
                        bb = values5.get(nkey);
                        if (bb != null) {
                            if (nkey == null ? key != null : !nkey.equals(key)) {
                                values5.get(key).add(nkey);

                            }
                        }
                    }

                }
                //new
                for (char a = 'a'; a < 'z'; a++) {
                    StringBuilder sb = new StringBuilder();

                    String stringValueOf = String.valueOf(a);
                    if (ary[3] != stringValueOf) {
                        sb.append(ary[0]);
                        sb.append(ary[1]);
                        sb.append(ary[2]);
                        sb.append(a);
                        sb.append(ary[4]);
                        String nkey = sb.toString();
                        List<String> bb;
                        bb = values5.get(nkey);
                        if (bb != null) {
                            if (nkey == null ? key != null : !nkey.equals(key)) {
                                values5.get(key).add(nkey);
                                // System.out.println(key+" "+nkey);
                            }
                        }
                    }

                }
                //new
                for (char a = 'a'; a < 'z'; a++) {
                    StringBuilder sb = new StringBuilder();

                    String stringValueOf = String.valueOf(a);
                    if (ary[4] != stringValueOf) {
                        sb.append(ary[0]);
                        sb.append(ary[1]);
                        sb.append(ary[2]);
                        sb.append(ary[3]);
                        //sb.append(ary[4]);
                        sb.append(a);
                        String nkey = sb.toString();
                        List<String> bb;
                        bb = values5.get(nkey);
                        if (bb != null) {
                            if (nkey == null ? key != null : !nkey.equals(key)) {
                                values5.get(key).add(nkey);
                                // System.out.println(key+" "+nkey);
                            }
                        }
                    }

                }
                // String value = values5.get(name).toString();  
                // System.out.println(value);

            }
            String cc1_File = "C:/Users/Salman/Documents/NetBeansProjects/fiveletterword.csv";
            myapaas.file(values5,cc1_File);
            //for 6 leter word
            br = new BufferedReader(new FileReader(csvFile));
            int i6 = 0;

            while ((line = br.readLine()) != null) {
                if (i6 > 1) {
                    ArrayList<String> obj = new ArrayList<>();
                    // use comma as separator
                    String[] country = line.split(cvsSplitBy);
                    String y = country[0];
                    if (y.length() == 6) {

                        values6.put(y, obj);

                    }

                }

                i6++;
            }

            for (String name : values6.keySet()) {

                String key = name.toString();
                String[] ary = key.split("");
                for (char a = 'a'; a < 'z'; a++) {
                    StringBuilder sb = new StringBuilder();

                    String stringValueOf = String.valueOf(a);
                    if (ary[0] == null ? stringValueOf != null : !ary[0].equals(stringValueOf)) {
                        sb.append(a);
                        sb.append(ary[1]);
                        sb.append(ary[2]);
                        sb.append(ary[3]);
                        sb.append(ary[4]);
                        sb.append(ary[5]);
                        String nkey = sb.toString();
                        List<String> bb;
                        bb = values6.get(nkey);
                        if (bb != null) {
                            if (nkey == null ? key != null : !nkey.equals(key)) {
                                values6.get(key).add(nkey);

                            }
                        }
                    }

                }
                //new
                for (char a = 'a'; a < 'z'; a++) {
                    StringBuilder sb = new StringBuilder();

                    String stringValueOf = String.valueOf(a);
                    if (ary[1] != stringValueOf) {
                        sb.append(ary[0]);
                        sb.append(a);
                        sb.append(ary[2]);
                        sb.append(ary[3]);
                        sb.append(ary[4]);
                        sb.append(ary[5]);
                        String nkey = sb.toString();
                        List<String> bb;
                        bb = values6.get(nkey);
                        if (bb != null) {
                            if (nkey == null ? key != null : !nkey.equals(key)) {
                                values6.get(key).add(nkey);

                            }
                        }
                    }

                }
                //new
                for (char a = 'a'; a < 'z'; a++) {
                    StringBuilder sb = new StringBuilder();

                    String stringValueOf = String.valueOf(a);
                    if (ary[2] != stringValueOf) {
                        sb.append(ary[0]);
                        sb.append(ary[1]);
                        sb.append(a);
                        sb.append(ary[3]);
                        sb.append(ary[4]);
                        sb.append(ary[5]);
                        String nkey = sb.toString();
                        List<String> bb;
                        bb = values6.get(nkey);
                        if (bb != null) {
                            if (nkey == null ? key != null : !nkey.equals(key)) {
                                values6.get(key).add(nkey);

                            }
                        }
                    }

                }
                //new
                for (char a = 'a'; a < 'z'; a++) {
                    StringBuilder sb = new StringBuilder();

                    String stringValueOf = String.valueOf(a);
                    if (ary[3] != stringValueOf) {
                        sb.append(ary[0]);
                        sb.append(ary[1]);
                        sb.append(ary[2]);
                        sb.append(a);
                        sb.append(ary[4]);
                        sb.append(ary[5]);
                        String nkey = sb.toString();
                        List<String> bb;
                        bb = values6.get(nkey);
                        if (bb != null) {
                            if (nkey == null ? key != null : !nkey.equals(key)) {
                                values6.get(key).add(nkey);
                                // System.out.println(key+" "+nkey);
                            }
                        }
                    }

                }
                //new
                for (char a = 'a'; a < 'z'; a++) {
                    StringBuilder sb = new StringBuilder();

                    String stringValueOf = String.valueOf(a);
                    if (ary[4] != stringValueOf) {
                        sb.append(ary[0]);
                        sb.append(ary[1]);
                        sb.append(ary[2]);
                        sb.append(ary[3]);
                        sb.append(a);
                        sb.append(ary[5]);
                        String nkey = sb.toString();
                        List<String> bb;
                        bb = values6.get(nkey);
                        if (bb != null) {
                            if (nkey == null ? key != null : !nkey.equals(key)) {
                                values6.get(key).add(nkey);
                                // System.out.println(key+" "+nkey);
                            }
                        }
                    }

                }
                //new
                for (char a = 'a'; a < 'z'; a++) {
                    StringBuilder sb = new StringBuilder();

                    String stringValueOf = String.valueOf(a);
                    if (ary[5] != stringValueOf) {
                        sb.append(ary[0]);
                        sb.append(ary[1]);
                        sb.append(ary[2]);
                        sb.append(ary[3]);
                        sb.append(ary[4]);
                        sb.append(a);

                        String nkey = sb.toString();
                        List<String> bb;
                        bb = values6.get(nkey);
                        if (bb != null) {
                            if (nkey == null ? key != null : !nkey.equals(key)) {
                                values6.get(key).add(nkey);
                                // System.out.println(key+" "+nkey);
                            }
                        }
                    }

                }
                // String value = values5.get(name).toString();  
                // System.out.println(value);

            }
            String  cc2_File = "C:/Users/Salman/Documents/NetBeansProjects/sixletterword.csv";
            myapaas.file(values6,cc2_File);
            //for 7 leter
            br = new BufferedReader(new FileReader(csvFile));
            int i7 = 0;

            while ((line = br.readLine()) != null) {
                if (i7 > 1) {
                    ArrayList<String> obj = new ArrayList<>();
                    // use comma as separator
                    String[] country = line.split(cvsSplitBy);
                    String y = country[0];
                    if (y.length() == 7) {

                        values7.put(y, obj);

                    }

                }

                i7++;
            }

            for (String name : values7.keySet()) {

                String key = name.toString();
                String[] ary = key.split("");
                for (char a = 'a'; a < 'z'; a++) {
                    StringBuilder sb = new StringBuilder();

                    String stringValueOf = String.valueOf(a);
                    if (ary[0] == null ? stringValueOf != null : !ary[0].equals(stringValueOf)) {
                        sb.append(a);
                        sb.append(ary[1]);
                        sb.append(ary[2]);
                        sb.append(ary[3]);
                        sb.append(ary[4]);
                        sb.append(ary[5]);
                        sb.append(ary[6]);
                        String nkey = sb.toString();
                        List<String> bb;
                        bb = values7.get(nkey);
                        if (bb != null) {
                            if (nkey == null ? key != null : !nkey.equals(key)) {
                                values7.get(key).add(nkey);

                            }
                        }
                    }

                }
                //new
                for (char a = 'a'; a < 'z'; a++) {
                    StringBuilder sb = new StringBuilder();

                    String stringValueOf = String.valueOf(a);
                    if (ary[1] != stringValueOf) {
                        sb.append(ary[0]);
                        sb.append(a);
                        sb.append(ary[2]);
                        sb.append(ary[3]);
                        sb.append(ary[4]);
                        sb.append(ary[5]);
                        sb.append(ary[6]);
                        String nkey = sb.toString();
                        List<String> bb;
                        bb = values7.get(nkey);
                        if (bb != null) {
                            if (nkey == null ? key != null : !nkey.equals(key)) {
                                values7.get(key).add(nkey);

                            }
                        }
                    }

                }
                //new
                for (char a = 'a'; a < 'z'; a++) {
                    StringBuilder sb = new StringBuilder();

                    String stringValueOf = String.valueOf(a);
                    if (ary[2] != stringValueOf) {
                        sb.append(ary[0]);
                        sb.append(ary[1]);
                        sb.append(a);
                        sb.append(ary[3]);
                        sb.append(ary[4]);
                        sb.append(ary[5]);
                        sb.append(ary[6]);
                        String nkey = sb.toString();
                        List<String> bb;
                        bb = values7.get(nkey);
                        if (bb != null) {
                            if (nkey == null ? key != null : !nkey.equals(key)) {
                                values7.get(key).add(nkey);

                            }
                        }
                    }

                }
                //new
                for (char a = 'a'; a < 'z'; a++) {
                    StringBuilder sb = new StringBuilder();

                    String stringValueOf = String.valueOf(a);
                    if (ary[3] != stringValueOf) {
                        sb.append(ary[0]);
                        sb.append(ary[1]);
                        sb.append(ary[2]);
                        sb.append(a);
                        sb.append(ary[4]);
                        sb.append(ary[5]);
                        sb.append(ary[6]);
                        String nkey = sb.toString();
                        List<String> bb;
                        bb = values7.get(nkey);
                        if (bb != null) {
                            if (nkey == null ? key != null : !nkey.equals(key)) {
                                values7.get(key).add(nkey);
                                // System.out.println(key+" "+nkey);
                            }
                        }
                    }

                }
                //new
                for (char a = 'a'; a < 'z'; a++) {
                    StringBuilder sb = new StringBuilder();

                    String stringValueOf = String.valueOf(a);
                    if (ary[4] != stringValueOf) {
                        sb.append(ary[0]);
                        sb.append(ary[1]);
                        sb.append(ary[2]);
                        sb.append(ary[3]);
                        sb.append(a);
                        sb.append(ary[5]);
                        sb.append(ary[6]);
                        String nkey = sb.toString();
                        List<String> bb;
                        bb = values7.get(nkey);
                        if (bb != null) {
                            if (nkey == null ? key != null : !nkey.equals(key)) {
                                values7.get(key).add(nkey);
                                // System.out.println(key+" "+nkey);
                            }
                        }
                    }

                }
                //new
                for (char a = 'a'; a < 'z'; a++) {
                    StringBuilder sb = new StringBuilder();

                    String stringValueOf = String.valueOf(a);
                    if (ary[5] != stringValueOf) {
                        sb.append(ary[0]);
                        sb.append(ary[1]);
                        sb.append(ary[2]);
                        sb.append(ary[3]);
                        sb.append(ary[4]);
                        sb.append(a);
                        sb.append(ary[6]);

                        String nkey = sb.toString();
                        List<String> bb;
                        bb = values7.get(nkey);
                        if (bb != null) {
                            if (nkey == null ? key != null : !nkey.equals(key)) {
                                values7.get(key).add(nkey);
                                // System.out.println(key+" "+nkey);
                            }
                        }
                    }

                }
                //new
                for (char a = 'a'; a < 'z'; a++) {
                    StringBuilder sb = new StringBuilder();

                    String stringValueOf = String.valueOf(a);
                    if (ary[6] != stringValueOf) {
                        sb.append(ary[0]);
                        sb.append(ary[1]);
                        sb.append(ary[2]);
                        sb.append(ary[3]);
                        sb.append(ary[4]);
                        sb.append(ary[5]);
                        sb.append(a);

                        String nkey = sb.toString();
                        List<String> bb;
                        bb = values7.get(nkey);
                        if (bb != null) {
                            if (nkey == null ? key != null : !nkey.equals(key)) {
                                values7.get(key).add(nkey);
                                // System.out.println(key+" "+nkey);
                            }
                        }
                    }

                }
                // String value = values5.get(name).toString();  
                // System.out.println(value);

            }
            String cc3_File = "C:/Users/Salman/Documents/NetBeansProjects/sevenletterword.csv";
            myapaas.file(values7,cc3_File);
            //for 8 letters
            br = new BufferedReader(new FileReader(csvFile));
            int i8 = 0;

            while ((line = br.readLine()) != null) {
                if (i8 > 1) {
                    ArrayList<String> obj = new ArrayList<>();
                    // use comma as separator
                    String[] country = line.split(cvsSplitBy);
                    String y = country[0];
                    if (y.length() == 8) {

                        values8.put(y, obj);

                    }

                }

                i8++;
            }

            for (String name : values8.keySet()) {

                String key = name.toString();
                String[] ary = key.split("");
                for (char a = 'a'; a < 'z'; a++) {
                    StringBuilder sb = new StringBuilder();

                    String stringValueOf = String.valueOf(a);
                    if (ary[0] == null ? stringValueOf != null : !ary[0].equals(stringValueOf)) {
                        sb.append(a);
                        sb.append(ary[1]);
                        sb.append(ary[2]);
                        sb.append(ary[3]);
                        sb.append(ary[4]);
                        sb.append(ary[5]);
                        sb.append(ary[6]);
                        sb.append(ary[7]);
                        String nkey = sb.toString();
                        List<String> bb;
                        bb = values8.get(nkey);
                        if (bb != null) {
                            if (nkey == null ? key != null : !nkey.equals(key)) {
                                values8.get(key).add(nkey);

                            }
                        }
                    }

                }
                //new
                for (char a = 'a'; a < 'z'; a++) {
                    StringBuilder sb = new StringBuilder();

                    String stringValueOf = String.valueOf(a);
                    if (ary[1] != stringValueOf) {
                        sb.append(ary[0]);
                        sb.append(a);
                        sb.append(ary[2]);
                        sb.append(ary[3]);
                        sb.append(ary[4]);
                        sb.append(ary[5]);
                        sb.append(ary[6]);
                        sb.append(ary[7]);
                        String nkey = sb.toString();
                        List<String> bb;
                        bb = values8.get(nkey);
                        if (bb != null) {
                            if (nkey == null ? key != null : !nkey.equals(key)) {
                                values8.get(key).add(nkey);

                            }
                        }
                    }

                }
                //new
                for (char a = 'a'; a < 'z'; a++) {
                    StringBuilder sb = new StringBuilder();

                    String stringValueOf = String.valueOf(a);
                    if (ary[2] != stringValueOf) {
                        sb.append(ary[0]);
                        sb.append(ary[1]);
                        sb.append(a);
                        sb.append(ary[3]);
                        sb.append(ary[4]);
                        sb.append(ary[5]);
                        sb.append(ary[6]);
                        sb.append(ary[7]);
                        String nkey = sb.toString();
                        List<String> bb;
                        bb = values8.get(nkey);
                        if (bb != null) {
                            if (nkey == null ? key != null : !nkey.equals(key)) {
                                values8.get(key).add(nkey);

                            }
                        }
                    }

                }
                //new
                for (char a = 'a'; a < 'z'; a++) {
                    StringBuilder sb = new StringBuilder();

                    String stringValueOf = String.valueOf(a);
                    if (ary[3] != stringValueOf) {
                        sb.append(ary[0]);
                        sb.append(ary[1]);
                        sb.append(ary[2]);
                        sb.append(a);
                        sb.append(ary[4]);
                        sb.append(ary[5]);
                        sb.append(ary[6]);
                        sb.append(ary[7]);
                        String nkey = sb.toString();
                        List<String> bb;
                        bb = values8.get(nkey);
                        if (bb != null) {
                            if (nkey == null ? key != null : !nkey.equals(key)) {
                                values8.get(key).add(nkey);
                                // System.out.println(key+" "+nkey);
                            }
                        }
                    }

                }
                //new
                for (char a = 'a'; a < 'z'; a++) {
                    StringBuilder sb = new StringBuilder();

                    String stringValueOf = String.valueOf(a);
                    if (ary[4] != stringValueOf) {
                        sb.append(ary[0]);
                        sb.append(ary[1]);
                        sb.append(ary[2]);
                        sb.append(ary[3]);
                        sb.append(a);
                        sb.append(ary[5]);
                        sb.append(ary[6]);
                        sb.append(ary[7]);
                        String nkey = sb.toString();
                        List<String> bb;
                        bb = values8.get(nkey);
                        if (bb != null) {
                            if (nkey == null ? key != null : !nkey.equals(key)) {
                                values8.get(key).add(nkey);
                                // System.out.println(key+" "+nkey);
                            }
                        }
                    }

                }
                //new
                for (char a = 'a'; a < 'z'; a++) {
                    StringBuilder sb = new StringBuilder();

                    String stringValueOf = String.valueOf(a);
                    if (ary[5] != stringValueOf) {
                        sb.append(ary[0]);
                        sb.append(ary[1]);
                        sb.append(ary[2]);
                        sb.append(ary[3]);
                        sb.append(ary[4]);
                        sb.append(a);
                        sb.append(ary[6]);
                        sb.append(ary[7]);

                        String nkey = sb.toString();
                        List<String> bb;
                        bb = values8.get(nkey);
                        if (bb != null) {
                            if (nkey == null ? key != null : !nkey.equals(key)) {
                                values8.get(key).add(nkey);
                                // System.out.println(key+" "+nkey);
                            }
                        }
                    }

                }
                //new
                for (char a = 'a'; a < 'z'; a++) {
                    StringBuilder sb = new StringBuilder();

                    String stringValueOf = String.valueOf(a);
                    if (ary[6] != stringValueOf) {
                        sb.append(ary[0]);
                        sb.append(ary[1]);
                        sb.append(ary[2]);
                        sb.append(ary[3]);
                        sb.append(ary[4]);
                        sb.append(ary[5]);
                        sb.append(a);
                        sb.append(ary[7]);

                        String nkey = sb.toString();
                        List<String> bb;
                        bb = values8.get(nkey);
                        if (bb != null) {
                            if (nkey == null ? key != null : !nkey.equals(key)) {
                                values8.get(key).add(nkey);
                                // System.out.println(key+" "+nkey);
                            }
                        }
                    }

                }
                //new
                for (char a = 'a'; a < 'z'; a++) {
                    StringBuilder sb = new StringBuilder();

                    String stringValueOf = String.valueOf(a);
                    if (ary[7] != stringValueOf) {
                        sb.append(ary[0]);
                        sb.append(ary[1]);
                        sb.append(ary[2]);
                        sb.append(ary[3]);
                        sb.append(ary[4]);
                        sb.append(ary[5]);
                        sb.append(ary[6]);
                        sb.append(a);

                        String nkey = sb.toString();
                        List<String> bb;
                        bb = values8.get(nkey);
                        if (bb != null) {
                            if (nkey == null ? key != null : !nkey.equals(key)) {
                                values8.get(key).add(nkey);
                                // System.out.println(key+" "+nkey);
                            }
                        }
                    }

                }
                // String value = values5.get(name).toString();  
                // System.out.println(value);

            }
             String  cc4_File = "C:/Users/Salman/Documents/NetBeansProjects/eightletterword.csv";
              myapaas.file(values8,cc4_File);
            //user input    //user input    //user input    //user input    //user input
            
            //user input

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
