
import com.ads.projetoIntegrador.dao.AddressDAO;
import com.ads.projetoIntegrador.dto.AddressDTO;
import com.ads.projetoIntegrador.test.PersonDAO;
import com.ads.projetoIntegrador.test.PersonTestDTO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Yago Ferreira
 */
public class Test {

    public static void main(String[] args) {
        PersonDAO dao = new PersonDAO();
        PersonTestDTO person = new PersonTestDTO();
        person.setName("TestName");
        dao.save(person);
        System.out.println(dao.find());
    }
}
