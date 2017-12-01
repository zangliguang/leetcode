package uncomplete.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zangliguang on 2017/7/6.
 */
public class Test {
    public static void main(String[] args) {
        long time = 1499065568000l;
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        String url="https://qa-tokenstorage.xingshulin.com/redirectTokenUrl?sessionKey=7B663431633861363534643233343331636133653330333835643033336662613750717037465A567947746D2A48244D743279466532502A633141624C4663596E7D2C7B61336437326664352D616162332D333762342D383463662D3731363662316234383837357D2C7B747275657D2C7B3230307D2C7B323031303034377D2C7B31656434326631366464666634353063383665313063643632306663313063325232745371666D4556716A444650536E66376C4439485F4D4268555F686E77727D2C7B34616132366638386464313766313763336162366536343761386163343633387D2C7B323031372D31312D30392031373A32373A35377D2C7B352E312E302D64656275677D2C7B6D6564636C6970735F706C75737D2C7B6D6564636C6970735F706C75735F352E312E302D64656275672D616E64726F69645F32337D&url=http%3A%2F%2Fmedical.qa.xingshulinimg.com%2F305d8334-1919-446f-836c-119a8304cd87.PCM";
        System.out.println(url.substring(url.lastIndexOf("%2F") + 3, url.length()));
    }

    public static int countSegments(String s) {
        if (s.trim().isEmpty()) {
            return 0;
        }
        String[] split = s.split(" ");
        int length = split.length;
        for (String s1 : split) {
            if (s1.trim().isEmpty()) {
                length--;
            }
        }
        return length;
    }
}
