package Ex5;

import java.io.File;
import java.io.IOException;

/**
 * Created by Святослав on 16.01.2015.
 */
public class CopyByBlock {
    File src;
    private int length;// in Kb
    public static void main(String[] args) {

        CopyFile copyFile = new CopyFile();
        File file = new File("D:\\Guide.avi");
        File file_src = new File("D:\\The.Hitchhiker's.Guide.to.the.Galaxy.2005.BDRip.Dub.ALLFILMS.RG.avi");
        int length = 0;
        try {
             length = (int) file_src.length() / 1024;
        } catch (Exception e){
            System.out.println("to big size!!!");}
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            copyFile.copyFile(length ,file_src.getAbsolutePath(),file.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
