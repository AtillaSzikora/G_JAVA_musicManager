package main;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class FileMover {

    /*athelyezzuk a szamokat az almappakba  a kiválasztott kategória szerint
    + amelyiknek nincsen tag-e akkor nem csinálunk semmit
     */


    public static String returnChoosenCategory(String categoryName, ID3Tag mp3Tag){
        String retName = "";
        if (categoryName == "album"){
            retName = mp3Tag.getAlbum();
        }
        else if (categoryName == "artist"){
            retName = mp3Tag.getArtist();
        }
        else if (categoryName == "title"){
            retName = mp3Tag.getTitle();
        }
        else if (categoryName == "year"){
            retName = String.valueOf(mp3Tag.getYear());
        }
        else if (categoryName == "genre"){
            retName = String.valueOf(mp3Tag.getGenre());
        }
        return retName;

    }

    public static void moveFileIntoFolder(List<File> mp3files, String path,String categoryName){
        for (File file : mp3files){
            ID3Tag tag = ID3Tag.parse(file);
            String destination = path + "\\" + returnChoosenCategory(categoryName,tag) + "\\" + file.getName();
            System.out.println(destination);
            file.renameTo(new File(destination));
        }


    }


}
