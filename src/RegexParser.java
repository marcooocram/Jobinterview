import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RegexParser {

    public static void main(String[] args) {
        String regex = "a..b";
        String text = "acabb accb"; //acb adb aa


        List<String> results = applyBracketRulesToResult(parse(cleanRegexFromBreaks(regex), text),regex);
        for (String string : results) {
            System.out.println(string);
        }
    }

    private static List<String> parse(String regex, String text) {
        int leadingDots = getLeadingDots(regex);
        List<RegexPart> regexParts = splitRegexOnDots(regex.substring(leadingDots));
        List<String> results = new ArrayList<>();
        List<Integer> finds = findAllOccurencesOfStringInOtherstring(regexParts.get(0).regex, text, leadingDots);
        for (Integer position : finds) {
            for (int regexOrdinal = 1; regexOrdinal < regexParts.size(); regexOrdinal++) {
                int positionIncrement = regexParts.get(regexOrdinal - 1).trailingDots + 1;
                if (!isMatch(text, regexParts.get(regexOrdinal).regex, position + positionIncrement)) {
                    break;
                }
                int lastIndexOfRegex = position + regex.length() - leadingDots;
                if (regexOrdinal >= regexParts.size() - 1 && text.length() >= lastIndexOfRegex && position >= leadingDots) {
                    results.add(text.substring(position - leadingDots, lastIndexOfRegex));
                }
            }
        }
        return results;
    }

    private static int getLeadingDots(String regex) {
        int leadingDots = 0;
        while (regex.charAt(leadingDots) == '.') {
            leadingDots++;
        }
        return leadingDots;
    }

    private static List<Integer> findAllOccurencesOfStringInOtherstring(String string, String otherString, int startPosition) {
        if (string == null || otherString == null || otherString.isEmpty()) {
            return Collections.emptyList();
        }
        String copyText = otherString.substring(startPosition);
        List<Integer> results = new ArrayList<>();
        int position = 0;
        while (copyText.contains(string)) {
            position += copyText.indexOf(string);
            results.add(position);
            copyText = otherString.substring(position + string.length());
            position += string.length();
        }
        return results;
    }

    private static boolean isMatch(String text, String regexPart, int position) {
        if (text == null || text.length() < position || text.substring(position).length() < regexPart.length()) {
            return false;
        }
        return text.substring(position, position + regexPart.length()).equals(regexPart);
    }

    private static List<RegexPart> splitRegexOnDots(String regex) {
        List<RegexPart> result = new ArrayList<>();
        StringBuilder value = new StringBuilder();
        for (int position = 0; position < regex.length(); position++) {
            int dotCount = 0;
            while (regex.length() > position && regex.charAt(position) == '.') {
                dotCount++;
                position++;
            }
            if (dotCount > 0) {
                result.add(new RegexPart(dotCount, value.toString()));
                value.setLength(0);
            }
            if (regex.length() > position) {
                value.append(regex.charAt(position));
            }
        }
        if (value.toString().length() > 0) {
            result.add(new RegexPart(0, value.toString()));
        }
        return result;
    }

    private static class RegexPart {
        private int trailingDots;
        private String regex;

        RegexPart(int leadingDots, String regex) {
            this.trailingDots = leadingDots;
            this.regex = regex;
        }
    }

    private static List<String> applyBracketRulesToResult(List<String> results, String regex){
        List<BracketsSet> bracketsList = getBracketsSets(regex);
        List<String> cleanResults = new ArrayList<>();
        for (String result : results) {
            int bracketsSetOffset = 0;
            StringBuilder cleanResultBuilder = new StringBuilder();
            for (BracketsSet bracketsSet : bracketsList) {
                cleanResultBuilder.append(result, bracketsSet.startPosition - bracketsSetOffset, bracketsSet.endPosition - 1 - bracketsSetOffset).append(";");
                bracketsSetOffset += 2;
            }
            cleanResults.add(cleanResultBuilder.toString());
        }
        return cleanResults;
    }

    private static String cleanRegexFromBreaks(String regex){
        return regex == null ? "" : regex.replace("(","").replace(")","");
    }

    private static List<BracketsSet> getBracketsSets(String regex){
        List<BracketsSet> bracketsSetList = new ArrayList<>();
        int startPosition = 0;
        for (int i = 0; i < regex.length(); i++){
            if (regex.charAt(i) == '('){
                startPosition = i;
            }
            if (regex.charAt(i) == ')'){
                bracketsSetList.add(new BracketsSet(startPosition, i));
            }
        }
        return bracketsSetList;
    }


    private static class BracketsSet{
        private int startPosition;
        private int endPosition;

        BracketsSet(int startPosition, int endPosition){
            this.startPosition = startPosition;
            this.endPosition = endPosition;
        }
    }
}
