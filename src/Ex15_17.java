import java.io.*;

public class Ex15_17 {
    static int deletedFiles = 0;

    public static void main(String[] args) {
        if(args.length != 1){
            System.out.println("USAGE : java Ex15_17 Extention");
            System.exit(0);
        }

        String currDir = System.getProperty("user.dir");

        File dir = new File(currDir);

        String ext = "." + args[0];
        delete(dir,ext);
        System.out.println(deletedFiles + "개의 파일이 삭제 되었습니다.");

    }

    public static void delete(File dir, String ext){
        File[] files = dir.listFiles();

        for(int i=0; i<files.length;i++){
            if(files[i].isDirectory()){
                delete(files[1],ext);
            }else{
                String fileName = files[i].getAbsolutePath();

                if(fileName.endsWith(ext)){
                    System.out.print(fileName);

                    if(files[i].delete()){
                        System.out.println(" - 삭제 성공");
                        deletedFiles++;
                    }else {
                        System.out.println(" - 삭제 실패 ");
                    }

                }

            }
        }

    }

}
