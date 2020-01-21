package utils;

public final class Converter {

    private static final String[] romeNumbers = {"I", "V", "X", "L", "C"};

    public static int convertToInt(String s) {
        switch (s) {
            case "I":
                return 1;
            case "II":
                return 2;
            case "III":
                return 3;
            case "IV":
                return 4;
            case "V":
                return 5;
            case "VI":
                return 6;
            case "VII":
                return 7;
            case "VIII":
                return 8;
            case "IX":
                return 9;
            case "X":
                return 10;
        }
        throw new IllegalArgumentException("Try Rome notation I..X");
    }

    private static String get(int i) throws RomeNumberException {
        if (i < romeNumbers.length) {
            return romeNumbers[i];
        }
        throw new RomeNumberException("Not supported Rome number");
    }

    public static String convertToRome(int n) throws RomeNumberException {
        StringBuilder sb = new StringBuilder();
        String res;
        for (int i = 0; n > 0; i += 2, n /= 10) {
            switch (n % 10) {
                case 1: {
                    sb.append(get(i));
                    break;
                }
                case 2: {
                    sb.append(get(i)).append(get(i));
                    break;
                }
                case 3: {
                    sb.append(get(i)).append(get(i)).append(get(i));
                    break;
                }
                case 4: {
                    sb.append(get(i + 1)).append(get(i));
                    break;
                }
                case 5: {
                    sb.append(get(i + 1));
                    break;
                }
                case 6: {
                    sb.append(get(i)).append(get(i + 1));
                    break;
                }
                case 7: {
                    sb.append(get(i)).append(get(i)).append(get(i + 1));
                    break;
                }
                case 8: {
                    sb.append(get(i)).append(get(i)).append(i).append(get(i + 1));
                    break;
                }
                case 9: {
                    sb.append(get(i + 2)).append(get(i));
                    break;
                }
                default:
                    break;
            }
        }
        return sb.reverse().toString();
    }
}
