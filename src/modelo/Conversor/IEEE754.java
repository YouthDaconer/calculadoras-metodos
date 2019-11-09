package modelo.Conversor;

/**
 *
 * @author JSRA
 */
public class IEEE754 {

    private String cadenaBinaria;
    private String signo;
    private int exp32, exp64;
    private char[] binario, mantisa32, mantisa64;

    public IEEE754(String cadenaBinaria) {
        this.cadenaBinaria = cadenaBinaria;
        if (cadenaBinaria.contains("-")) {
            signo = "1";
            this.cadenaBinaria = cadenaBinaria.replace("-", "");
        } else {
            signo = "0";
        }
        normalizar(this.cadenaBinaria);
    }

    public IEEE754() {
        this.cadenaBinaria = "";
        inicializarMantizas(cadenaBinaria);
    }

    public String getSigno() {
        return signo;
    }

    public void setCadenaBinaria(String cadenaBinaria) {
        this.cadenaBinaria = cadenaBinaria;
    }

    public void setSigno(String signo) {
        this.signo = signo;
    }

    public void setExp32(int exp32) {
        this.exp32 = exp32;
    }

    public void setExp64(int exp64) {
        this.exp64 = exp64;
    }

    public void setBinario(char[] binario) {
        this.binario = binario;
    }

    public void setMantisa32(char[] mantisa32) {
        this.mantisa32 = mantisa32;
    }

    public void setMantisa64(char[] mantisa64) {
        this.mantisa64 = mantisa64;
    }

    private void normalizar(String bin) {
        int result = 0;

        if (!bin.contains(".")) {
            bin = bin + ".0";
        }
        inicializarMantizas(bin);

        for (int i = 0; i < bin.length(); i++) {
            binario[i] = bin.charAt(i);
        }

        int indiceComa = getIndiceComa(binario);
        int indicePrimer1 = getIndicePrimer1(binario);
        int exp = (indiceComa - indicePrimer1) - 1;
        exp32 = exp + 127;
        exp64 = exp + 1023;
        boolean normalizado = false;
        int i = indicePrimer1 + 1;
        int j = 0;

        while (!normalizado && i< binario.length ) {
            if (binario[i] != '.' && j < mantisa32.length) {
                mantisa32[j] = binario[i];
                j++;
            }
            if (i >= binario.length || j > mantisa32.length) {
                normalizado = true;
            }
            i++;
        }

        i = indicePrimer1 + 1;
        j = 0;
        normalizado= false;
        while (!normalizado && i< binario.length) {
            if (binario[i] != '.' && j < mantisa64.length) {
                mantisa64[j] = binario[i];
                j++;
            }
            if (i >= binario.length || j > mantisa64.length) {
                normalizado = true;
            }
            i++;
        }
        
    }

    public String exponente32() {
        return new Decimal().cambiarABase(Integer.toString(exp32), 2, 0);
    }

    public String exponente64() {
        return new Decimal().cambiarABase(Integer.toString(exp64), 2, 0);
    }

    public String getMantisa32() {
        String str = "";
        for (char c : mantisa32) {
            str += c;
        }
        return str;
    }

    public String getMantisa64() {
        String str = "";
        for (char c : mantisa64) {
            str += c;
        }
        return str;
    }

    private int getIndiceComa(char[] bin) {

        int i = 0;
        while (i < bin.length) {
            if (bin[i] == '.') {
                return i;
            }
            i++;
        }
        return i;
    }

    private int getIndicePrimer1(char[] bin) {
        for (int i = 0; i < bin.length; i++) {
            if (bin[i] == '1') {
                return i;
            }
        }
        return -1;
    }

    private void inicializarMantizas(String bin) {
        if (bin == "") {
            binario = new char[1000];
        } else {
            binario = new char[bin.length()];
        }

        mantisa32 = new char[23];
        mantisa64 = new char[52];
        for (int i = 0; i < binario.length; i++) {
            binario[i] = '0';
        }
        for (int i = 0; i < mantisa32.length; i++) {
            mantisa32[i] = '0';
        }
        for (int i = 0; i < mantisa64.length; i++) {
            mantisa64[i] = '0';
        }

    }

    public String getNumeroDecimal(String exponente, String mantisa) {
        Decimal d = new Decimal();
        return d.aDecimal(getBinario(exponente, mantisa), 2);
    }

    public String getBinario(String exponente, String mantisa) {
        Decimal d = new Decimal();
        StringBuilder cadenaBin = new StringBuilder();

        int exp = 0;

        if (exponente.length() == 8) {
            exp = Integer.parseInt(d.aDecimal(exponente, 2));
            exp -= 127;
            if (exp != -127) {
                cadenaBin.append('1');
            } else {
                return "0";
            }
        } else {
            exp = Integer.parseInt(d.aDecimal(exponente, 2));
            exp -= 1023;
            if (exp != -1023) {
                cadenaBin.append('1');
            } else {
                return "0";
            }
        }

        for (int i = 0; i < mantisa.length(); i++) {
            if (i == exp) {
                cadenaBin.append('.');
            }
            cadenaBin.append(mantisa.charAt(i));

        }
        return cadenaBin.toString();
    }

//    public static void main(String[] args) {
//        Decimal d = new Decimal();
//
//        IEEE754 i = new IEEE754(d.cambiarABase("-6755399441055744", 2, 100));
//        System.out.println(i.cadenaBinaria);
//        System.out.println(i.exponente32() + "-" + i.getMantisa32());
//        System.out.println(i.exponente64() + "-" + i.getMantisa64());
//        System.out.println("Decimal: "+i.getNumeroDecimal(i.exponente32(), i.getMantisa32()));
//        System.out.println("binario: " +i.getBinario(i.exponente32(), i.getMantisa32()));
//        
//
//    }

}
