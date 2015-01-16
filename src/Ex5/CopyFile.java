package Ex5;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by Святослав on 16.01.2015.
 */
public class CopyFile {
    public static void copyFile(int size, String src, String dest) throws Exception {
        FileInputStream in = new FileInputStream(src);
        try {
            FileOutputStream out = new FileOutputStream(dest);
            try {
                byte[] buf = new byte[1024]; // 1 KB
                int r;
                int per = 0;
                final int percent = size/100;
                int per_count = percent;
                int buf_count = 0;
                int mult = 2;
                System.out.print("0% ");
                do {
                    r = in.read(buf, 0, buf.length);
                    if (r > 0)
                        out.write(buf, 0, r);
                    //Thread.sleep(1);
                    if(buf_count == per_count) {

                        per++;
                        System.out.print(per+"%  ");
                        per_count = mult*percent;
                        mult++;
                    }
                    buf_count++;
                } while (r > 0);
            } finally {
                out.close();
            }
        } finally {
            in.close();
        }
    }
}
