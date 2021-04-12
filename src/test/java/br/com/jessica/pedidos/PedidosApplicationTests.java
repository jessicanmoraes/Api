package br.com.jessica.pedidos;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.jessica.pedidos.controller.PedidosController;
import br.com.jessica.pedidos.modelo.Pedido;
import br.com.jessica.pedidos.repository.PedidoRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
    PedidosController.class
})	
public class PedidosApplicationTests {

    //URL base para acesso desse controlador
    private final String BASE_URL = "/pedidos";

    //Instância do ObjectMapper para trabalhar com JSON
    private ObjectMapper objectMapper;

    //Controlador REST tratado por meio de injeção de dependências
    @Autowired
    private PedidosController restController;

    //Instância do MockMVC
    private MockMvc mockMvc;

    //Instância do mock repository
    @MockBean
    private PedidoRepository mockRepository;

    @Before
    public void setUp() {
        objectMapper = new ObjectMapper();
        mockMvc = MockMvcBuilders
                .standaloneSetup(restController)
                .build();
    }

    @Test
    public void buscar_id_200() throws Exception {

        Pedido pedido = new Pedido();
        pedido.setId(1L);
        pedido.setTitulo("Teste");
        pedido.setDescricao("teste3");

        when(mockRepository.findById(1L)).thenReturn(Optional.of(pedido));

        mockMvc.perform(get(BASE_URL + "/1"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.nome", is("Teste")))
                .andExpect(jsonPath("$.valor", is(10.0)));

        verify(mockRepository, times(1)).findById(1L);
    }

    @Test
    public void buscar_id_404() throws Exception {
        mockMvc.perform(get(BASE_URL + "/2")).andExpect(status().isNotFound());
    }

    @Test
    public void criar_200() throws Exception {

 
    	
    }

    @Test
    public void atualizar_200() throws Exception {

    }

    @Test
    public void deletar_200() throws Exception {
    	Pedido pedido = new Pedido();
    	pedido.setId(1L);

        when(mockRepository.findById(1L)).thenReturn(Optional.of(pedido));

        mockMvc.perform(delete(BASE_URL + "/1"))
                .andExpect(status().isOk());

        verify(mockRepository, times(1)).deleteById(1L);
    }

}
