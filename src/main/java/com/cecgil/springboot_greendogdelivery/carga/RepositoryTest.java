package com.cecgil.springboot_greendogdelivery.carga;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.cecgil.springboot_greendogdelivery.entities.Client;
import com.cecgil.springboot_greendogdelivery.entities.ItemOrder;
import com.cecgil.springboot_greendogdelivery.entities.Order;
import com.cecgil.springboot_greendogdelivery.repositories.ClientRepository;

@Component
public class RepositoryTest implements ApplicationRunner {

    Logger logger = LoggerFactory.getLogger(ApplicationRunner.class);
    private final ClientRepository clientRepository;

    public RepositoryTest(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public void run(ApplicationArguments args) {
        logger.info(">>> Iniciando carga de dados...");

        var fernando = clientRepository.findById(11L)
                .orElse(new Client(null, "Carlos", "Caxias"));

        var zePequeno = clientRepository.findById(22L)
                .orElse(new Client(null, "Teste", "Cidade de Deus"));

        // Pedido do Fernando
        var pedidoDoFernando = new Order();
        pedidoDoFernando.setCliente(fernando);

        var dog1 = new ItemOrder(null, "Green Dog tradicional", 25d);
        pedidoDoFernando.setItens(new ArrayList<>());
        pedidoDoFernando.getItens().add(dog1);

        fernando.newOrder(pedidoDoFernando);
        clientRepository.saveAndFlush(fernando);
        logger.info(">>> Pedido 1 - Fernando: " + pedidoDoFernando);

        // Pedido do Ze Pequeno
        var pedidoDoZePequeno = new Order();
        pedidoDoZePequeno.setCliente(zePequeno);

        var dog2 = new ItemOrder(null, "Green Dog tradicional picante", 27d);
        var dog3 = new ItemOrder(null, "Green Dog max salada", 30d);

        pedidoDoZePequeno.setItens(new ArrayList<>());
        pedidoDoZePequeno.getItens().add(dog2);
        pedidoDoZePequeno.getItens().add(dog3);

        zePequeno.newOrder(pedidoDoZePequeno);
        clientRepository.saveAndFlush(zePequeno);
        logger.info(">>> Pedido 2 - Ze Pequeno: " + pedidoDoZePequeno);

        // Segundo pedido do Fernando
        var pedido2DoFernando = new Order();
        pedido2DoFernando.setCliente(fernando);

        var dog4 = new ItemOrder(null, "Green Dog tradicional picante", 27d);

        pedido2DoFernando.setItens(new ArrayList<>());
        pedido2DoFernando.getItens().add(dog4);

        fernando.newOrder(pedido2DoFernando);
        clientRepository.saveAndFlush(fernando);
        logger.info(">>> Pedido 2 - Fernando: " + pedido2DoFernando);
    }
}
