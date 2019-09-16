public class PalindromFinder {

    public static void main(String[] args) {
        if (args.length == 0 || args[0] == null || args[0].isEmpty()){
            System.out.println("no string provided");
            return;
        }
        String input = args[0];
        PalindromData biggestPalindrom = new PalindromData(1,0);

        for (int positionInString = 0; positionInString < input.length(); positionInString++){
            PalindromData currentPalindromData = getBiggestPalindromForPosition(input,positionInString);
            biggestPalindrom = biggestPalindrom.getBiggest(currentPalindromData);
        }

        System.out.println("Input: " + input);
        System.out.println("Länge: " + biggestPalindrom.palindromLength );
        System.out.println("Position: " + biggestPalindrom.palindromPosition );
        System.out.println("palindrom: " + input.substring(biggestPalindrom.palindromPosition,biggestPalindrom.palindromPosition + biggestPalindrom.palindromLength));
    }

    private static PalindromData getBiggestPalindromForPosition(String input,int startPosition){
        PalindromData oddPalindrom = getPalindrom(input,startPosition,1);
        PalindromData evenPalindrom = getPalindrom(input,startPosition,0);
        return oddPalindrom.getBiggest(evenPalindrom);
    }

    private static PalindromData getPalindrom(String input,int startPosition, int currentLength){
        int stepCount = 1;
        int startingLength = currentLength;
        while (
                startPosition - stepCount >= 0 &&
                startPosition + stepCount - 1 + startingLength < input.length() &&
                input.charAt(startPosition - stepCount) == input.charAt(startPosition + stepCount -1 + startingLength)
        ){
            stepCount++;
            currentLength += 2;
        }
        return new PalindromData(currentLength,startPosition - stepCount + 1 );
    }

    static class PalindromData{
        private int palindromLength;
        private int palindromPosition;

        PalindromData(int palindromLength, int palindromPosition){
            this.palindromLength = palindromLength;
            this.palindromPosition = palindromPosition;
        }

        PalindromData getBiggest(PalindromData otherPalindrom){
            return otherPalindrom.palindromLength > this.palindromLength ? otherPalindrom : this;
        }
    }
}
