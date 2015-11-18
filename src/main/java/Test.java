
import com.ads.projetoIntegrador.dao.EnderecoDAO;
import com.ads.projetoIntegrador.dto.EnderecoDTO;
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
        
        EnderecoDAO end = new EnderecoDAO();
        EnderecoDTO endereco = new EnderecoDTO();
        endereco.setCidade("Salvador");
        endereco.setEstado("Bahia");
        endereco.setBairro("Imbui");
        endereco.setRua("A");
        endereco.setCep("123456");
        endereco.setTelefone_primario("12345689");
        end.save(endereco);
        System.out.println(end.find());
        
        EnderecoDAO end2 = new EnderecoDAO();
        EnderecoDTO endereco2 = new EnderecoDTO();
        endereco2.setCidade("Salvador");
        endereco2.setEstado("Bahia");
        endereco2.setBairro("Imbui");
        endereco2.setRua("A");
        endereco2.setCep("123456");
        endereco2.setTelefone_primario("12345689");
        end2.save(endereco2);
    }
}
