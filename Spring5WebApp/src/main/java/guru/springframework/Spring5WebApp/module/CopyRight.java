package guru.springframework.Spring5WebApp.module;

public class CopyRight {

    final String COPYRIGHT_SYMBOL = "\u00a9";
    final int YEAR = 2021;
    final String SEPARATOR = " ";
    final String OWNER = "by Mr. Csaba Vadasz - Csaba79-coder";
    final String NEW_LINE = "\n";

    public CopyRight() {
    }

    public String addingCopyright() {
        return getCopyright() + getSEPARATOR() + getYear() + getSEPARATOR() + getOWNER() + getNEW_LINE();
    }

    private String getCopyright() {
        return COPYRIGHT_SYMBOL;
    }

    private String getYear() {
        return String.valueOf(YEAR);
    }

    private String getSEPARATOR() {
        return SEPARATOR;
    }

    private String getOWNER() {
        return OWNER;
    }

    private String getNEW_LINE() {
        return NEW_LINE;
    }
}
