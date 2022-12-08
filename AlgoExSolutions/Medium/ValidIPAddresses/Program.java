package AlgoExSolutions.Medium.ValidIPAddresses;

import java.util.ArrayList;

/**
 * * Valid IP Addresses
 */
class Program {
    public ArrayList<String> validIPAddresses(String string) { // Write your code here.
        ArrayList<String> result = new ArrayList<String>();
        for (int i = 0; i < string.length() - 3; i++) {

            for (int j = i + 1; j < string.length() - 2; j++) {
                for (int k = j + 1; k < string.length() - 1; k++) {

                    String p1 = string.substring(0, i + 1);
                    String p2 = string.substring(i + 1, j + 1);
                    String p3 = string.substring(j + 1, k + 1);
                    String p4 = string.substring(k + 1);
                    if (validIPPart(p1) && validIPPart(p2) && validIPPart(p3) && validIPPart(p4)) {
                        result.add(new String(p1 + "." + p2 + "." + p3 + "." + p4));
                        System.out.println(new String(p1 + "." + p2 + "." + p3 + "." + p4));
                    }
                }
            }
        }
        return result;
    }

    public boolean validIPPart(String part) {
        return Integer.parseInt(part) < 256 && (part.length() > 1 && part.charAt(0) != '0' || part.length() == 1);

    }
}
