package br.com.renequeiroz.api.pedidos.entity;

import br.com.renequeiroz.api.pedidos.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pedido {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        @JoinColumn(name = "id_cliente")
        private Cliente cliente;

        @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
        private List<ItemPedido> itensPedido = new ArrayList<>();

        @Column(name = "valor_total")
        private Double valorTotal;

        @Enumerated(EnumType.STRING)
        private Status status = Status.EM_PROCESSAMENTO;

        @Column(name = "data_pedido")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime dataPedido;


        public Pedido() {
        }

        public Pedido(Long id, Cliente cliente, List<ItemPedido> itensPedido, Double valorTotal, Status status, LocalDateTime dataPedido) {
                this.id = id;
                this.cliente = cliente;
                this.itensPedido = itensPedido;
                this.valorTotal = valorTotal;
                this.status = status;
                this.dataPedido = dataPedido;
        }

        public Long getId() {
                return id;
        }

        public Cliente getCliente() {
                return cliente;
        }

        public List<ItemPedido> getItensPedido() {
                return itensPedido;
        }

        public Double getValorTotal() {
                return valorTotal;
        }

        public Status getStatus() {
                return status;
        }

        public LocalDateTime getDataPedido() {
                return dataPedido;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public void setCliente(Cliente cliente) {
                this.cliente = cliente;
        }

        public void setStatus(Status status) {
                this.status = status;
        }

        public void setValorTotal(Double valorTotal) {
                this.valorTotal = valorTotal;
        }

        public void setItensPedido(List<ItemPedido> itensPedido) {
                this.itensPedido = itensPedido;
        }

        public void setDataPedido(LocalDateTime dataPedido) {
                this.dataPedido = dataPedido;
        }
}
