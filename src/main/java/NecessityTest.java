
import com.ads.projetoIntegrador.dao.NecessityDAO;
import com.ads.projetoIntegrador.dto.NecessityDTO;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author arthur.hage
 */
public class NecessityTest {
    public static void main(String[] args) {
        NecessityDAO dao = new NecessityDAO();
        NecessityDTO necessity = new NecessityDTO();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        
        necessity.setDescription("ong necessity");
        necessity.setTitle("necessity");
        necessity.setPriority("max");
        necessity.setDate(dateFormat.format(date));
        dao.save(necessity);
        System.out.println(dao.find());
        
        NecessityDAO dao2 = new NecessityDAO();
        NecessityDTO necessity2 = new NecessityDTO();
        necessity2.setDescription("ong necessity2");
        necessity2.setTitle("necessity2");
        necessity2.setPriority("min");
        necessity2.setDate(dateFormat.format(date));
        dao2.save(necessity2);
    }
}
