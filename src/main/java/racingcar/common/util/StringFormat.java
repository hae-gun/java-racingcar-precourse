package racingcar.common.util;

public class StringFormat {
    public static String positionToDash(int position){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<position; i++){
            sb.append("-");
        }
        return sb.toString();
    }
}
