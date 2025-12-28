package lab6_part_2;

public class ProcessStrings implements IStringProcessor {

    @Override
    public int countChars(String s) {
        return s.length();
    }

    @Override
    public String oddPositions(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i += 2) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    @Override
    public String invert(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}

