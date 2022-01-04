public class ComplementOfBase10Integer {
    public int bitwiseComplement_(int n) {
        StringBuilder binN = new StringBuilder(Integer.toBinaryString(n));
        for (int i = 0; i < binN.length(); i++) {
            binN.setCharAt(i, binN.charAt(i) == '0' ? '1' : '0');
        }
        return Integer.parseInt(binN.toString(), 2);
    }
    
    public int bitwiseComplement(int n) {
        if (n == 1) {
            return 0;
        }
        int x = 2;
        while (n >= x) {
            x *= 2;
        }
        x -= 1;
        return x - n;
    }
}
