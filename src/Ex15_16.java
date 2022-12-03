import java.io.File;

public class Ex15_16 {

    public static void main(String[] args) {
        if(args.length != 1){
            System.out.println("USAGE : java Ex15_16 DIRECTORY");
            System.exit(0);
        }

        File f = new File("/Users/seongeun/Documents/Dev/JavaBasicStudy/src/pk2");

        if(!f.exists() || !f.isDirectory()){
            System.out.println("유효하지 않은 디렉토리입니다.");
            System.exit(0);
        }

        File[] files = f.listFiles();

        for(int i=0; i <files.length; i++){
            String fileName = files[1].getName();
            System.out.println(
                    files[i].isDirectory() ? "[" + fileName + "]" : fileName
            );
        }


    }

}
