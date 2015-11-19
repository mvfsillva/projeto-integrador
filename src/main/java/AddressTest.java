
import com.ads.projetoIntegrador.dao.AddressDAO;
import com.ads.projetoIntegrador.dto.AddressDTO;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author arthur.hage
 */
public class AddressTest {
    public static void main(String[] args) {
        AddressDAO end = new AddressDAO();
        AddressDTO endereco = new AddressDTO();
        endereco.setCity("Salvador");
        endereco.setState("Bahia");
        endereco.setNeighborhood("Imbui");
        endereco.setStreet("A");
        endereco.setPostal_code("123456");
        endereco.setPrimary_phone("12345689");
        endereco.setSecondary_phone("12345689");
        end.save(endereco);
        System.out.println(end.find());
        
        AddressDAO end2 = new AddressDAO();
        AddressDTO endereco2 = new AddressDTO();
        endereco2.setCity("Salvador");
        endereco2.setState("Bahia");
        endereco2.setNeighborhood("Imbui");
        endereco2.setStreet("A");
        endereco2.setPostal_code("123456");
        endereco2.setPrimary_phone("12345689");
        end2.save(endereco2);
    }
}
