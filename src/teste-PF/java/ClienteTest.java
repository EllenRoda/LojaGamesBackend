import org.example.dto.ClienteDTO;
import org.example.entities.Cliente;
import org.example.entities.Contato;
import org.example.entities.Endereco;
import org.example.repositories.ClienteRepository;
import org.example.repositories.EnderecoRepository;
import org.example.services.ClienteService;
import org.example.services.exeptions.ResourceNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    /*when(clienteRepository.save(any(Cliente.class))).thenReturn(cliente);

    Cliente resultado = clienteService.insert(cliente);

    assertNotNull(resultado);
    assertEquals("Maria Silva", resultado.getCliNome());
    verify(clienteRepository, times(1)).save(any(Cliente.class));
    verify(enderecoRepository, times(1)).saveAll(cliente.getEnderecos());*/
}