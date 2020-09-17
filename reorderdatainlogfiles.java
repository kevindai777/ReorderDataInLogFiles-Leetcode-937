//Java Solution

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        
        Comparator<String> logComp = new Comparator<String>() {
            public int compare(String a, String b) {
                
                //Split it into two parts based on first space
                String[] aCut = a.split(" ", 2);
                String[] bCut = b.split(" ", 2);
                
                boolean isDigitA = Character.isDigit(aCut[1].charAt(0));
                boolean isDigitB = Character.isDigit(bCut[1].charAt(0));
                
                if (!isDigitA && !isDigitB) {
                    int compare = aCut[1].compareTo(bCut[1]);
                    
                    if (compare != 0) {
                        return compare;
                    }
                    
                    return aCut[0].compareTo(bCut[0]);
                }
                
                if (isDigitA && !isDigitB) {
                    return 1;
                } else if (!isDigitA && isDigitB) {
                    return -1;
                } else {
                    return 0;
                }
            }
        };
        
        Arrays.sort(logs, logComp);
        return logs;
    }
}