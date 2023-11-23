package com.codecrafterswebshop.Service;

import com.codecrafterswebshop.Exception.AjandekkartyaException;
import com.codecrafterswebshop.Model.Ajandekkartya;
import java.util.Map;
import org.json.JSONObject;

/**
 *
 * @author tothm23
 */
public class AjandekkartyaService {

    public static JSONObject ajandekKartya(Integer ajandekKartyaIdBE) {

        Map<String, Object> ajandekKartya = Ajandekkartya.ajandekKartya(ajandekKartyaIdBE);
        JSONObject obj = new JSONObject();

        for (Map.Entry<String, Object> set : ajandekKartya.entrySet()) {
            obj.put(set.getKey(), set.getValue());
        }

        return obj;
    }

    public static String ujAjandekKartya(String nevBE, Integer arBE, String leirasBE,
            String kepBE, Integer akcioBE, Integer mennyisegraktaronBE, Integer eszkozIdBE, Integer platformIdBE) {
        try {
            if (!Ajandekkartya.nevEllenorzes(nevBE)) {
                return "Hibás név!";
            } else if (!Ajandekkartya.arEllenorzes(arBE)) {
                return "Hibás ár!";
            } else if (!Ajandekkartya.leirasEllenorzes(leirasBE)) {
                return "Hibás leírás!";
            } else if (!Ajandekkartya.kepEllenorzes(kepBE)) {
                return "Hibás kép!";
            } else if (!Ajandekkartya.akcioEllenorzes(akcioBE)) {
                return "Hibás akció!";
            } else if (!Ajandekkartya.mennyisegraktaronEllenorzes(mennyisegraktaronBE)) {
                return "Hibás mennyiségraktáron!";
            } else if (Ajandekkartya.ujAjandekKartya(nevBE, arBE, leirasBE, kepBE, akcioBE, mennyisegraktaronBE, eszkozIdBE, platformIdBE)) {
                return "Ajándék kártya hozzáadva!";
            } else {
                return "Hiba az ajándék kártya hozzáadásánál!";
            }
        } catch (AjandekkartyaException ex) {
            return ex.getMessage();
        }
    }

    public static String frissitesAjandekKartya(Integer idBE, String nevBE, Integer arBE, String leirasBE,
            String kepBE, Integer akcioBE, Integer mennyisegraktaronBE, Integer eszkozIdBE, Integer platformIdBE) {
        try {
            if (ajandekKartya(idBE).length() == 0) {
                return "Hiba az ajándék kártya frissítésénél!";
            }
            if (Ajandekkartya.frissitesAjandekKartya(idBE, nevBE, arBE, leirasBE, kepBE, akcioBE, mennyisegraktaronBE, eszkozIdBE, platformIdBE)) {
                return "Ajándék kártya frissítve!";
            } else {
                return "Hiba az ajándék kártya frissítésénél!";
            }
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public static String torlesAjandekKartya(Integer idBE) {
        try {
            if (ajandekKartya(idBE).length() == 0) {
                return "Hiba az ajándék kártya törlésénél!";
            }
            if (Ajandekkartya.torlesAjandekKartya(idBE)) {
                return "Ajándék kártya törölve!";
            } else {
                return "Hiba az ajándék kártya törlésénél!";
            }
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
}