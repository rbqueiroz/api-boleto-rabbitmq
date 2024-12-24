package br.com.renequeiroz.api.pedidos.utils;

import br.com.renequeiroz.api.pedidos.dto.ClienteDTO;
import br.com.renequeiroz.api.pedidos.entity.Cliente;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.record.RecordModule;

import java.util.ArrayList;
import java.util.List;

public class MapperUtils {

    private static ModelMapper modelMapper;

    static {
        iniciarModelMapper();
    }

    private static void iniciarModelMapper() {
        modelMapper = new ModelMapper().registerModule(new RecordModule());
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        modelMapper.getConfiguration().setFieldMatchingEnabled(true);
        modelMapper.getConfiguration().setFullTypeMatchingRequired(true);
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    /**
     * Método responsável por converter um objeto em outro tipo.
     *
     * @param object objeto original
     * @param classe classe para qual objeto será convertido
     * @return novo objeto do tipo T
     * @param <T> tipo genérico
     */
    public static <T> T converter(Object object, Class<T> classe) {
        if (object == null)
            return null;

        return modelMapper.map(object, classe);
    }

    /**
     * Método responsável por converter uma lista em uma nova lista do tipo informado.
     *
     * @param lista Lista original.
     * @param classe Classe usada para criar a nova lista.
     * @return nova lista do tipo Class<T>
     * @param <T> tipo genérico
     */
    public static <T> List<T> converter(List<Object> lista, Class<T> classe) {
        List<T> newList = new ArrayList<>();

        lista.forEach(o -> newList.add(modelMapper.map(o, classe)));

        return newList;
    }

    public static <T> T converterParaEntidade(Object dto, Class<T> entidadeClass) {
        if (dto == null) {
            return null;
        }
        return modelMapper.map(dto, entidadeClass);
    }

    public static ClienteDTO converterClienteParaDTO(Cliente cliente) {
        if (cliente == null) {
            return null;
        }
        return new ClienteDTO(cliente.getId(), cliente.getNome(), cliente.getEmail());
    }

}
