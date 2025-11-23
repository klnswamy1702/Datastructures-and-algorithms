
import java.util.regex.Pattern;
public class StringIterator {
    int ptr = 0;
    String[] chars;int[] nums;
    public StringIterator(String compressedString) {
        nums = Arrays.stream(compressedString.substring(1).split("[a-zA-Z]+")).mapToInt(Integer::parseInt).toArray();;
        chars = compressedString.split("[0-9]+");
    }
    public char next() {
        if (!hasNext())
            return ' ';
        nums[ptr]--;
        char res=chars[ptr].charAt(0);
        if(nums[ptr]==0)
            ptr++;
        return res;
    }
    public boolean hasNext() {
        return ptr != chars.length;
    }
}
/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */