package com.codecrafterswebshop.Service;

import com.codecrafterswebshop.Model.Jatek;
import java.util.Map;
import org.json.JSONObject;

/**
 *
 * @author tothm23
 */
public class JatekService {

    public static JSONObject jatek(Integer idBe) {
        Map<String, Object> jatek = Jatek.jatek(idBe);
        JSONObject obj = new JSONObject();

        for (Map.Entry<String, Object> set : jatek.entrySet()) {
            obj.put(set.getKey(), set.getValue());
        }

        return obj;
    }

    public static String ujJatek(String nevBE, Integer arBE, String leirasBE,
            String kepBE, Integer korhatarBE, Integer akcioBE, Integer mennyisegraktaronBE, Integer kategoriaIdBE, Integer eszkozIdBE, Integer platformIdBE) {
        try {
            if (Jatek.ujJatek(nevBE, arBE, leirasBE, kepBE, korhatarBE, akcioBE,
                    mennyisegraktaronBE, kategoriaIdBE, eszkozIdBE, platformIdBE)) {
                return "Játék hozzáadva!";
            } else {
                return "Hiba a Játék hozzáadásánál!";
            }
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public static String frissitesJatek(Integer idBE, String nevBE, Integer arBE, String leirasBE,
            String kepBE, Integer korhatarBE, Integer akcioBE, Integer mennyisegraktaronBE, Integer kategoriaIdBE, Integer eszkozIdBE, Integer platformIdBE) {
        try {
            if (jatek(idBE).length() == 0) {
                return "Hiba a Játék frissítésénél!";
            }
            if (Jatek.frissitesJatek(idBE, nevBE, arBE, leirasBE, kepBE, korhatarBE, akcioBE,
                    mennyisegraktaronBE, kategoriaIdBE, eszkozIdBE, platformIdBE)) {
                return "Játék frissítve!";
            } else {
                return "Hiba a Játék frissítésénél!";
            }
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public static String torlesJatek(Integer idBE) {
        try {
            if (Jatek.torlesJatek(idBE)) {
                return "Játék törölve!";
            } else {
                return "Hiba a Játék törlésénél!";
            }
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
}
