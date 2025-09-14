import java.util.ArrayList;

interface NumberValidate {
    boolean validate(String s);
}

abstract class NumberValidateTemplate implements NumberValidate {

    public boolean validate(String s) {
        if (checkStringEmpty(s)) {
            return false;
        }

        s = checkAndProcessHeader(s);

        if (s.length() == 0) {
            return false;
        }

        return doValidate(s);
    }

    private boolean checkStringEmpty(String s) {
        return s.equals("");
    }

    private String checkAndProcessHeader(String value) {
        value = value.trim();

        // Reject double signs at the beginning like "++", "--", "+-", "-+"
        if (value.length() >= 2 && (value.charAt(0) == '+' || value.charAt(0) == '-') &&
                (value.charAt(1) == '+' || value.charAt(1) == '-')) {
            return "";
        }

        if (value.startsWith("+") || value.startsWith("-")) {
            value = value.substring(1);
        }

        return value;
    }

    protected abstract boolean doValidate(String s);
}

class NumberValidator implements NumberValidate {

    private ArrayList<NumberValidate> validators = new ArrayList<>();

    public NumberValidator() {
        addValidators();
    }

    private void addValidators() {
        validators.add(new IntegerValidate());
        validators.add(new FloatValidate());
        validators.add(new HexValidate());
        validators.add(new SienceFormatValidate()); // Typo retained as per original structure
    }

    @Override
    public boolean validate(String s) {
        for (NumberValidate nv : validators) {
            if (nv.validate(s)) {
                return true;
            }
        }
        return false;
    }
}

class IntegerValidate extends NumberValidateTemplate {
    protected boolean doValidate(String integer) {
        if (integer.length() == 0) return false;
        for (int i = 0; i < integer.length(); i++) {
            if (!Character.isDigit(integer.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}

class FloatValidate extends NumberValidateTemplate {
    protected boolean doValidate(String floatVal) {
        int pos = floatVal.indexOf(".");
        if (pos == -1 || floatVal.length() == 1) {
            return false;
        }

        String first = floatVal.substring(0, pos);
        String second = floatVal.substring(pos + 1);

        return checkPart(first) && checkPart(second);
    }

    private boolean checkPart(String part) {
        if (part.isEmpty()) return true; // allow empty part (like ".5" or "5.")
        for (int i = 0; i < part.length(); i++) {
            if (!Character.isDigit(part.charAt(i))) return false;
        }
        return true;
    }
}

class HexValidate extends NumberValidateTemplate {
    private final char[] valids = new char[]{'a', 'b', 'c', 'd', 'e', 'f'};

    protected boolean doValidate(String hex) {
        hex = hex.toLowerCase();
        if (!hex.startsWith("0x") || hex.length() <= 2) return false;

        hex = hex.substring(2);
        for (int i = 0; i < hex.length(); i++) {
            char c = hex.charAt(i);
            if (!Character.isDigit(c) && !isValidChar(c)) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidChar(char c) {
        for (char v : valids) {
            if (c == v) return true;
        }
        return false;
    }
}

class SienceFormatValidate extends NumberValidateTemplate {
    protected boolean doValidate(String s) {
        s = s.toLowerCase();
        int pos = s.indexOf("e");
        if (pos == -1 || s.length() == 1) return false;

        String first = s.substring(0, pos);
        String second = s.substring(pos + 1);

        return validatePartBeforeE(first) && validatePartAfterE(second);
    }

    private boolean validatePartBeforeE(String first) {
        if (first.isEmpty() || first.startsWith(" ") || first.endsWith(" ")) return false;

        NumberValidate intValidator = new IntegerValidate();
        NumberValidate floatValidator = new FloatValidate();

        return intValidator.validate(first) || floatValidator.validate(first);
    }

    private boolean validatePartAfterE(String second) {
        if (second.isEmpty() || second.startsWith(" ") || second.endsWith(" ")) return false;

        // Reject double signs in exponent
        if (second.length() >= 2 && (second.charAt(0) == '+' || second.charAt(0) == '-') &&
                (second.charAt(1) == '+' || second.charAt(1) == '-')) {
            return false;
        }

        // Remove optional single leading sign
        if (second.startsWith("+") || second.startsWith("-")) {
            second = second.substring(1);
        }

        if (second.isEmpty()) return false;

        // Must be all digits
        for (int i = 0; i < second.length(); i++) {
            if (!Character.isDigit(second.charAt(i))) return false;
        }

        return true;
    }
}

public class Solution {
    public boolean isNumber(String s) {
        NumberValidate nv = new NumberValidator();
        return nv.validate(s);
    }

    // Optional main method for local testing
    public static void main(String[] args) {
        Solution sol = new Solution();

        // ✅ Valid cases
        System.out.println(sol.isNumber("5e1"));          // true
        System.out.println(sol.isNumber("-1.23e+10"));    // true
        System.out.println(sol.isNumber("0x1A"));         // true
        System.out.println(sol.isNumber(".5"));           // true

        // ❌ Invalid cases
        System.out.println(sol.isNumber("++5e1"));         // false
        System.out.println(sol.isNumber("-.7e+-0435"));    // false
        System.out.println(sol.isNumber("e3"));            // false
        System.out.println(sol.isNumber("."));             // false
    }
}

