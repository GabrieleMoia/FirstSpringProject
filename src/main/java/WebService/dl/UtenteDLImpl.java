package WebService.dl;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Named("utenteDL")
public class UtenteDLImpl implements IUtenteDL {

    private HashMap<Integer, UtenteDL> utenti = new HashMap<Integer, UtenteDL>();
    private Integer maxId=0;

    @Override
    public List<UtenteDL> getAll() {
        return new ArrayList<UtenteDL>(utenti.values());
    }

    @Override
    public UtenteDL addUtente(UtenteDL utente) {
        utenti.put(utente.getId(), utente);
        return utente;
    }

    @Override
    public UtenteDL getUtenteByID(int id) {
       if(!utenti.containsKey(id)){
           return null;
       }
       return utenti.get(id);
    }

    @Override
    public boolean deleteUtente(int id) {
        if(!utenti.containsKey(id)){
            return false;
        }
        utenti.remove(id);
        return true;
    }

    @Override
    public void update(UtenteDL utenteDL) throws Exception {
        if(!utenti.containsKey(utenteDL.getId())){
            throw new Exception("Utente non trovato");
        }
        utenti.put(utenteDL.getId(), utenteDL);
    }


}
