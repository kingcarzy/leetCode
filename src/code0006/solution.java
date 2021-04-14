package code0006;

public class solution {
    public static void main(String[] args) {

        String s = "PAYPALISHIRING";
        int num = 3;
        String convert = convert(s, num);
        System.out.println(convert);
    }

    public static String convert(String s, int numRows) {
        if(s==null||s.length()==0||numRows==1||numRows>=s.length()) {
            return s;
        }
        StringBuilder sb = new StringBuilder();

        for(int i=1;i<s.length()+1;i+=2*(numRows-1)) {
            sb.append(s.charAt(i-1));
        }
        for(int i=2;i<numRows;i++) {
            boolean k = true;
            for(int j=i;j<s.length()+1;j+=(k)?2*(numRows-i):2*(i-1),k=!k) {
                sb.append(s.charAt(j-1));
            }
        }
        for(int i=numRows;i<s.length()+1;i+=2*(numRows-1)) {
            sb.append(s.charAt(i-1));
        }
        return sb.toString();
    }

}
