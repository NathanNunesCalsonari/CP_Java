package br.com.lojadebrinquedo.service;

import br.com.lojadebrinquedo.dto.BrinquedoDTO;
import br.com.lojadebrinquedo.entity.Brinquedo;
import br.com.lojadebrinquedo.repository.BrinquedoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BrinquedoService {

    @Autowired
    private BrinquedoRepository brinquedoRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<BrinquedoDTO> listarTodosBrinquedos() {
        List<Brinquedo> brinquedos = brinquedoRepository.findAll();
        return brinquedos.stream()
                .map(brinquedo -> modelMapper.map(brinquedo, BrinquedoDTO.class))
                .collect(Collectors.toList());
    }

    public Optional<BrinquedoDTO> encontrarBrinquedoPorId(Long brinquedoId) {
        Optional<Brinquedo> brinquedo = brinquedoRepository.findById(brinquedoId);
        return brinquedo.map(value -> modelMapper.map(value, BrinquedoDTO.class));
    }

    public BrinquedoDTO salvarBrinquedo(BrinquedoDTO brinquedoDTO) {
        Brinquedo brinquedo = modelMapper.map(brinquedoDTO, Brinquedo.class);
        brinquedo = brinquedoRepository.save(brinquedo);
        return modelMapper.map(brinquedo, BrinquedoDTO.class);
    }

    public void deletarBrinquedo(Long brinquedoId) {
        brinquedoRepository.deleteById(brinquedoId);
    }
}
